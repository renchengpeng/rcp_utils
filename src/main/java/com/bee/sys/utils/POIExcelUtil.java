package com.bee.sys.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.bee.framework.date.util.DateUtils;
import com.bee.utils.common.TemplateAttribute;

/**
 * *
 *
 * @version 1.0
 * @description {类描述}
 * @author zheng.shk
 * @created 2014-5-26 下午4:44:00
 */

public class POIExcelUtil {
    
    protected transient final Logger log = LoggerFactory.getLogger(getClass());

	/** 总行数 */
	private int totalRows = 0;

	/** 总列数 */
	private int totalCells = 0;

	/** 构造方法 */
	public POIExcelUtil() {
	}

	/**
	 * <ul>
	 * <li>Description:[根据文件名读取excel文件]</li>
	 * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public List<ArrayList<String>> read(String fileName) {
		List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();

		/** 检查文件名是否为空或者是否是Excel格式的文件 */
		if (fileName == null || !fileName.matches("^.+\\.(?i)((xls)|(xlsx))$")) {
			return dataLst;
		}

		boolean isExcel2003 = true;
		/** 对文件的合法性进行验证 */
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			isExcel2003 = false;
		}

		/** 检查文件是否存在 */
		File file = new File(fileName);
		if (file == null || !file.exists()) {
			return dataLst;
		}

		try {
			/** 调用本类提供的根据流读取的方法 */
			dataLst = read(new FileInputStream(file), isExcel2003);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		/** 返回最后读取的结果 */
		return dataLst;
	}

	/**
	 * <ul>
	 * <li>Description:[根据流读取Excel文件]</li>
	 * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param inputStream
	 * @param isExcel2003
	 * @return
	 */
	public List<ArrayList<String>> read(InputStream inputStream,
			boolean isExcel2003) {
		List<ArrayList<String>> dataLst = null;
		try {
			/** 根据版本选择创建Workbook的方式 */
			Workbook wb = isExcel2003 ? new HSSFWorkbook(inputStream)
					: new XSSFWorkbook(inputStream);
			dataLst = read(wb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataLst;
	}
	
	public List<ArrayList<String>> readNoDecimalDeal(InputStream inputStream,
	        boolean isExcel2003) {
	    List<ArrayList<String>> dataLst = null;
	    try {
	        /** 根据版本选择创建Workbook的方式 */
	        Workbook wb = isExcel2003 ? new HSSFWorkbook(inputStream)
	        : new XSSFWorkbook(inputStream);
	        dataLst = readNoDecimalDeal(wb);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return dataLst;
	}

	//读取excel不去掉空格
	public List<ArrayList<String>> read1(InputStream inputStream,
            boolean isExcel2003) {
        List<ArrayList<String>> dataLst = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = isExcel2003 ? new HSSFWorkbook(inputStream)
                    : new XSSFWorkbook(inputStream);
            dataLst = read1(wb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataLst;
    }
	/**
	 * <ul>
	 * <li>Description:[得到总行数]</li>
	 * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @return
	 */
	public int getTotalRows() {
		return totalRows;
	}

	/**
	 * <ul>
	 * <li>Description:[得到总列数]</li>
	 * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @return
	 */
	public int getTotalCells() {
		return totalCells;
	}

	/**
	 * <ul>
	 * <li>Description:[读取数据]</li>
	 * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param wb
	 * @return
	 */
	private List<ArrayList<String>> read(Workbook wb) {
		List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();

		    /** 得到第一个shell */
		    Sheet sheet = wb.getSheetAt(0);
		    this.totalRows = sheet.getPhysicalNumberOfRows();
		    log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>【总行数totalRows】:"+totalRows);
		    if (this.totalRows >= 1 && sheet.getRow(0) != null) {
		        this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>【总单元格数totalCells】:"+totalCells);
		    }
		    
		    /** 循环Excel的行 zheng.sk,如果去掉第一行，则从1开始循环 */
		    for (int r = 1; r < this.totalRows; r++) {
		        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>【检查总行数totalRows】:"+totalRows);
		        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>【检查读取次数，当前是第:"+r+"次】");
		        Row row = sheet.getRow(r);
		        if (row == null) {
		            //timing-优化 当中间存在空行时，向下多检查一行
		            this.totalRows+=1;
		            continue;
		        }
		        
		        List<String> nullList = new ArrayList<String>(); // 空列集合：用于验证获取的行信息是否为空
		        ArrayList<String> rowLst = new ArrayList<String>();
		        /** 循环Excel的列 */
		        for (short c = 0; c < this.getTotalCells(); c++) {
		            Cell cell = row.getCell(c);
		            String cellValue = "";
		            nullList.add(cellValue);
		            if (cell == null) {
		                rowLst.add(cellValue);
		                continue;
		            }
		            // zheng.sk 对于数字的类型转换
		            if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
		                BigDecimal db = new BigDecimal(String.valueOf(cell
		                        .getNumericCellValue()));
		                rowLst.add(db.toPlainString());
		            } else {
		                rowLst.add(cell.getStringCellValue().trim().replace(" ",""));
		            }
		        }
		        if (null != rowLst && !rowLst.equals(nullList)) { // 验证单行列集合是非为空：如果整行都为空，则舍弃该行不添加到集合
		            dataLst.add(rowLst);
		        }
		    }
		return dataLst;
	}
	
	private List<ArrayList<String>> readNoDecimalDeal(Workbook wb) {
	    List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();
	    
	    /** 得到第一个shell */
	    Sheet sheet = wb.getSheetAt(0);
	    this.totalRows = sheet.getPhysicalNumberOfRows();
	    log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>【总行数totalRows】:"+totalRows);
	    if (this.totalRows >= 1 && sheet.getRow(0) != null) {
	        this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
	        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>【总单元格数totalCells】:"+totalCells);
	    }
	    
	    /** 循环Excel的行 zheng.sk,如果去掉第一行，则从1开始循环 */
	    for (int r = 1; r < this.totalRows; r++) {
	        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>【检查总行数totalRows】:"+totalRows);
	        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>【检查读取次数，当前是第:"+r+"次】");
	        Row row = sheet.getRow(r);
	        if (row == null) {
	            //timing-优化 当中间存在空行时，向下多检查一行
	            this.totalRows+=1;
	            continue;
	        }
	        
	        List<String> nullList = new ArrayList<String>(); // 空列集合：用于验证获取的行信息是否为空
	        ArrayList<String> rowLst = new ArrayList<String>();
	        /** 循环Excel的列 */
	        for (short c = 0; c < this.getTotalCells(); c++) {
	            Cell cell = row.getCell(c);
	            String cellValue = "";
	            nullList.add(cellValue);
	            if (cell == null) {
	                rowLst.add(cellValue);
	                continue;
	            }
	            // zheng.sk 对于数字的类型转换
	            if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
	                 rowLst.add(String.valueOf(cell.getNumericCellValue()));
	            } else {
	                rowLst.add(cell.getStringCellValue().trim().replace(" ",""));
	            }
	        }
	        if (null != rowLst && !rowLst.equals(nullList)) { // 验证单行列集合是非为空：如果整行都为空，则舍弃该行不添加到集合
	            dataLst.add(rowLst);
	        }
	    }
	    return dataLst;
	}

	//读取excel不去掉空格
	private List<ArrayList<String>> read1(Workbook wb) {
        List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();

            /** 得到第一个shell */
            Sheet sheet = wb.getSheetAt(0);
            this.totalRows = sheet.getPhysicalNumberOfRows();
            if (this.totalRows >= 1 && sheet.getRow(0) != null) {
                this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            }
            
            /** 循环Excel的行 zheng.sk,如果去掉第一行，则从1开始循环 */
            for (int r = 1; r < this.totalRows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) {
                    continue;
                }
                
                List<String> nullList = new ArrayList<String>(); // 空列集合：用于验证获取的行信息是否为空
                ArrayList<String> rowLst = new ArrayList<String>();
                /** 循环Excel的列 */
                for (short c = 0; c < this.getTotalCells(); c++) {
                    Cell cell = row.getCell(c);
                    String cellValue = "";
                    nullList.add(cellValue);
                    if (cell == null) {
                        rowLst.add(cellValue);
                        continue;
                    }
                    // zheng.sk 对于数字的类型转换
                    if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                        BigDecimal db = new BigDecimal(String.valueOf(cell
                                .getNumericCellValue()));
                        rowLst.add(db.toPlainString());
                    } else {
                        rowLst.add(cell.getStringCellValue());
                    }
                }
                if (null != rowLst && !rowLst.equals(nullList)) { // 验证单行列集合是非为空：如果整行都为空，则舍弃该行不添加到集合
                    dataLst.add(rowLst);
                }
            }
        return dataLst;
    }
	/**
	 * <ul>
	 * <li>Description:[测试main方法]</li>
	 * <li>Created by [Huyvanpull] [Jan 20, 2010]</li>
	 * <li>Midified by [modifier] [modified time]</li>
	 * <ul>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		List<ArrayList<String>> dataLst = new POIExcelUtil()
				.read("D:\\openAccount_00000001.xlsx");
		System.out.println("rowSize:" + dataLst.size());
		for (int i = 0; i < dataLst.size(); i++) {
			ArrayList<String> cellLst = dataLst.get(i);
			System.out.println("cellSize:" + cellLst.size());
			for (int j = 0; j < cellLst.size(); j++) {
				System.out.print(cellLst.get(j) + "|");
			}
		}
		System.out.println("OK");
	}
	
	//创建单个excel ，记录数不超过60000条
	@SuppressWarnings("deprecation")
    public static <T> void createExcel(String fileName,List<T> list, HttpServletResponse response,String headers[],String columns[]){
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 声明一个工作薄
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(fileName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 30);
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
             
        }
         int index = 0;
         Iterator<T> it = list.iterator();
          while (it.hasNext()) {
             index++;
             row = sheet.createRow(index);
             T t = (T) it.next();

             for (short i = 0; i < columns.length; i++) {
                String columnName = columns[i];
                String getMethodName = "get"
                       + columnName.substring(0, 1).toUpperCase()
                       + columnName.substring(1);
               HSSFCell cell = row.createCell(i);
                try {
                    Class<? extends Object> tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    //判断值的类型后进行强制类型转换
                    String textValue = null;
                   if (value instanceof Date) {
                       Date date = (Date) value;
                       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        textValue = sdf.format(date);
                    }else if(value instanceof Timestamp) {
                    	Timestamp date = (Timestamp) value;
         	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
                         textValue = sdf.format(date);
                    }else{
                       //其它数据类型都当作字符串简单处理
                        if(value==null || "".equals(value))
                            value = "";
                       textValue = value.toString();
                    }
                   
                   
                    //如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if(textValue!=null){
                       Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
                       Matcher matcher = p.matcher(textValue);
                       if(matcher.matches()){
                          //是数字当作double处理
                          cell.setCellValue(Double.parseDouble(textValue));
                       }else{
                          cell.setCellValue(textValue);
                       }

                    }
                   
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
             }
          }
          try {
              response.setContentType("APPLICATION/vnd.ms-excel");
              response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
                OutputStream out = response.getOutputStream();
                workbook.write(out);
                out.flush();
          } catch (IOException e) {
             e.printStackTrace();
          }
    }
	
	
	//创建大于60000条以上的导出
	@SuppressWarnings("deprecation")
    public static <T> void createExcels(String fileName ,HttpServletResponse response,String headers[],List<T> list,String columns[]){
        HSSFWorkbook workbook = new HSSFWorkbook();
        int k = 0;
        if(list.size()%60000 !=0){
            k = list.size()/60000;
        }
        if(list.size()<=60000){
            k = 0;
        }
        for(int x=0;x<=k;x++){
        HSSFSheet sheet = workbook.createSheet(fileName+"_"+x);
        // 设置表格默认列宽度为30个字节
        sheet.setDefaultColumnWidth((short) 30);
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
             
        }
         Iterator<T> it = null;
         int index = 0;
         if(x==k){
            it = list.subList(x*60000,list.size()).iterator();
         }else{
            it = list.subList(x*60000,(x+1)*60000).iterator();
         }
        
          while (it.hasNext()) {
             index++;
             row = sheet.createRow(index);
             T t = (T) it.next();
             for (short i = 0; i < columns.length; i++) {
                 String columnName = columns[i];
                 String getMethodName = "get"
                        + columnName.substring(0, 1).toUpperCase()
                        + columnName.substring(1);
                HSSFCell cell = row.createCell(i);
                try {
                    Class<? extends Object> tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    //判断值的类型后进行强制类型转换
                    String textValue = null;
                  if (value instanceof Date) {
                       Date date = (Date) value;
                       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        textValue = sdf.format(date);
                    } else{
                       //其它数据类型都当作字符串简单处理
                        if(value==null || "".equals(value))
                            value = "";
                       textValue = value.toString();
                    }
                    //如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if(textValue!=null){
                       Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
                       Matcher matcher = p.matcher(textValue);
                       if(matcher.matches()){
                          //是数字当作double处理
                          cell.setCellValue(Double.parseDouble(textValue));
                       }else{
                          cell.setCellValue(textValue);
                       }

                    }
                   
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
             }
          }
        }
        OutputStream out = null;
          try {
              response.setContentType("APPLICATION/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
              out = response.getOutputStream();
                workbook.write(out);
                out.flush();
          } catch (IOException e) {
             e.printStackTrace();
          }finally{
              if(out != null){
                  try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
              }
          }
    }
	
	  /**
     * TODO ：北京京东世纪信息技术有限公司普通发票销货清单(模板)
     * @author wangjiucheng 2016年4月28日
     * @param title      模板标题头内容(可以显示你想显示的内容)
     * @param payment       付款单位(可以设置你想显示的内容)
     * @param columnName      列头
     * @param combined       合计(可以自己设置想要显示内容)
     * @param note        备注
     * @param sheetName     sheet的名称
     * @param fileName      导出文件的名称
     */
    public static void excelTemplateOne(String fileName, String title, String payment, String paymentName, String[] columnName, String combined,
            String[] note, String sheetName, List<TemplateAttribute> list, HttpServletResponse response,BigDecimal replaceAmtLimit,BigDecimal replaceAmt)  {
        /************************************************** 模板头标题 开始 ****************************************************************/
        // 创建工作薄对象
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = createSheet(wb, sheetName);
        // 创建一行用于模板的标题
        Row row = sheet.createRow(0);
        // 创建一个单元格,将值放进去
        row.createCell(0).setCellValue(title);
        // 设置单元格样式
        row.getCell(0).setCellStyle(verticalCenterAndAlignCenter(wb, row, 24));
        // 合并单元格
        cellRangeAddress(0, 0, 0, columnName.length - 1, sheet);
        /************************************************** 模板头标题 结束 ****************************************************************/

        /**************************************************** 设置付款单位 开始 ***************************************************************************/
        Row paymentRow = sheet.createRow(1);// 付款行
        // 创建单元格并放值
        paymentRow.createCell(0).setCellValue(payment + paymentName);
        // 单元格设置样式
        paymentRow.getCell(0).setCellStyle(verticalCenterAndAlignLeft(wb, paymentRow));
        // 进行单元格合并
        cellRangeAddress(1, 1, 0, columnName.length - 1, sheet);
        /***************************************************** 设置付款单位 结束 **************************************************************************/

        /***************************************************** 设置列头 开始 **************************************************************************/
        Row columnHeader = sheet.createRow(2);
        for (int i = 0; i < columnName.length; i++) {
            // 设置单元格的宽度
            sheet.setColumnWidth(i, (int)10 * 256);
            //商品名称列
               if (i == 1) {
                   sheet.setColumnWidth(i, (int) 30 * 256);
               } 
            Cell cell = columnHeader.createCell(i);
            cell.setCellValue(columnName[i]);
            // 设置样式
            columnHeader.getCell(i).setCellStyle(verticalCenterAndAlignCenter(wb, columnHeader, 24));
        }
        /***************************************************** 设置列头 结束 **************************************************************************/

        /***************************************************** 数据内容 开始 **************************************************************************/
        // 序号
        int rowNo = 1;
        // 将数据放入到单元格中
        for (int i = 0; i < list.size(); i++) {
            // 单元格下标
            int cellOn = 0;
            Row dataRow = sheet.createRow(3 + i);
            dataRow.createCell(cellOn).setCellValue(rowNo);
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getProductName());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getUnit());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNumber());
            dataRow.createCell(++cellOn).setCellValue( list.get(i).getPrice().doubleValue());
            // 金额=数量*单价
            dataRow.createCell(++cellOn).setCellValue(dataRow.getCell(3).getNumericCellValue() * dataRow.getCell(4).getNumericCellValue());
            //付款金额
            dataRow.createCell(++cellOn).setCellValue("");
            //差补
            dataRow.createCell(++cellOn).setCellValue("");
            // 进行样式设置
            for (int j = 0; j < columnName.length; j++) {
                dataRow.getCell(j).setCellStyle(verticalCenterAndAlignCenter(wb, dataRow, 24));
            }
            // 序号
            rowNo++;
        }

        /***************************************************** 数据内容 结束 **************************************************************************/
        // 创建行对象
        Row combinedRow = sheet.createRow(sheet.getLastRowNum() + 1);
        // 遍历有多少列
        for (int i = 0; i < columnName.length; i++) {
            // 创建单元格
            combinedRow.createCell(i);
            // 设置要显示"合计"的文字
            if (i == 1) {
                // 将”合计“放入,最后一行的第二列
                combinedRow.createCell(i).setCellValue(combined);
            }
        }
        /***************************************************** 金额求和 开始 **************************************************************************/
        // 用于存放金额的总计
        double total = 0.0d;
        // 金额求和
        for (int i = 0; i < list.size(); i++) {
            // 进行求和
            total += Double.valueOf(sheet.getRow(3 + i).getCell(sheet.getRow(3 + i).getLastCellNum() - 3).getNumericCellValue());
        }

        // 获取"合计"行的最后一列,并进行设置值
        Row amountRows = sheet.getRow(sheet.getLastRowNum());
        // 设置计算后的金额总额
        amountRows.getCell(amountRows.getLastCellNum() - 3).setCellValue(total);
        // ”合计“单元格设置样式
        amountRows.getCell(1).setCellStyle(verticalCenterAndAlignCenter(wb, amountRows, 24));
        // 总计值单元格的样式
        amountRows.getCell(amountRows.getLastCellNum() - 3).setCellStyle(verticalCenterAndAlignCenter(wb, amountRows, 24));
        
        //付款金额
        amountRows.getCell(amountRows.getLastCellNum() - 2).setCellValue(replaceAmt.doubleValue());
        amountRows.getCell(amountRows.getLastCellNum() - 2).setCellStyle(verticalCenterAndAlignCenter(wb, amountRows, 24));
        //差补
        amountRows.getCell(amountRows.getLastCellNum() - 1).setCellValue(replaceAmtLimit.doubleValue());
        amountRows.getCell(amountRows.getLastCellNum() - 1).setCellStyle(verticalCenterAndAlignCenter(wb, amountRows, 24));
        /***************************************************** 金额求和 结束 **************************************************************************/

        
        /***************************************************** 备注 开始 **************************************************************************/
        Row noteRow = sheet.createRow(sheet.getLastRowNum() + 1);
        for (int i = 0; i < columnName.length; i++) {
            // 创建单元格
            Cell cell = noteRow.createCell(i);
            // 先为第一个单元格设置值,合并后还会取这个值
            if (i == 0) {
                // 设置"备注"文字显示
                cell.setCellValue(note[0]);
            }
            // 用于存放"备注"内容
            StringBuilder str = new StringBuilder();
            // 遍历note的个数,从下标1开始取,下标0为"备注"
            for (int j = 1; j < note.length; j++) {
                // 备注中要显示的内容进行拼接
                str.append(j + "." + note[j] + ";").append("\n");
                // 将"备注"文字，放在当前行的第一个单元格中
                if (i == 1) {
                    cell.setCellValue(str.toString());
                }
            }
            // 判断当前列数是否等于列头的总数
            if (i == (columnName.length - 1)) {
                // 进行合并单元格
                cellRangeAddress(sheet.getLastRowNum(), sheet.getLastRowNum(), 1, columnName.length - 1, sheet);
                // 设置“备注”样式
                noteRow.getCell(1).setCellStyle(verticalCenterAndAlignLeft(wb, noteRow));
                // 合并后的单元格下标为0,获取合并后的单元格,并设置样式
                noteRow.getCell(0).setCellStyle(verticalCenterAndAlignCenter(wb, noteRow, 100));
            }
        }

        /***************************************************** 备注 结束 **************************************************************************/
        OutputStream out = null;
        try {
            response.setContentType("APPLICATION/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
            out = response.getOutputStream();
            wb.write(out);
        } catch (IOException e) {
           e.printStackTrace();
        }finally{
            if(out != null){
               try {
                  out.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
            }
        }
    }
    
    

    /**
     * //TODO百盛模板
     * 
     * @author wangjiucheng 2016年4月29日
     */
    public static void excelTemplateTwo(String fileName, String[] columnName, String combined, String sheetName, List<TemplateAttribute> list,HttpServletResponse response,BigDecimal replaceAmtLimit,BigDecimal replaceAmt){
        // 创建工作薄对象
        Workbook wb = new HSSFWorkbook();
        // 创建sheet页对象
        Sheet sheet = createSheet(wb, sheetName);
        // 创建行对象
        Row columnHeader = sheet.createRow(2);
        for (int i = 0; i < columnName.length; i++) {
            Cell cell = columnHeader.createCell(i);
            cell.setCellValue(columnName[i]);
            // 设置样式
            columnHeader.getCell(i).setCellStyle(verticalCenterAndAlignCenter(wb, columnHeader, 21));
            // 设置不同列的宽度
            if (i == 0) {
                sheet.setColumnWidth(i, (int) 10 * 256);
            } else if (i == 1) {
                sheet.setColumnWidth(i, (int) 24 * 256);
            } else if (i == 2) {
                sheet.setColumnWidth(i, (int) 9 * 256);
            } else if (i == 3) {
                sheet.setColumnWidth(i, (int) 11 * 256);
            } else if (i == 4) {
                sheet.setColumnWidth(i, (int) 14 * 256);
            } else {
                sheet.setColumnWidth(i, (int) 15 * 256);
            }
        }

        //序号
        int rowNo = 1;
        for (int i = 0; i < list.size(); i++) {
            // 单元格下标
            int cellOn = 0;
            Row dataRow = sheet.createRow(5 + i);
            dataRow.createCell(cellOn).setCellValue(rowNo);
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getProductName());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNumber());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getPrice().doubleValue());
            // 金额=数量*单价
            dataRow.createCell(++cellOn).setCellValue(dataRow.getCell(2).getNumericCellValue() * dataRow.getCell(3).getNumericCellValue());
            // 设置备注
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNote().toString());
            //付款金额
            dataRow.createCell(++cellOn).setCellValue("");
            //差补列创建单元格
            dataRow.createCell(++cellOn).setCellValue("");
            // 设置第单元格的样式
            for (int j = 0; j <columnName.length; j++) {
                dataRow.getCell(j).setCellStyle(verticalCenterAndAlignCenter(wb, dataRow, 21));
            }
            rowNo++;
        }
        
        //设置差补和金额
        Row noteRow = sheet.getRow(sheet.getLastRowNum());
        //付款金额值
        noteRow.getCell(noteRow.getLastCellNum()-2).setCellValue(replaceAmt.doubleValue());
        //差补金额值
        noteRow.getCell(noteRow.getLastCellNum()-1).setCellValue(replaceAmtLimit.doubleValue());
       
        
        OutputStream out = null;
        try {
            response.setContentType("APPLICATION/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
            out = response.getOutputStream();
            wb.write(out);
        } catch (IOException e) {
           e.printStackTrace();
        }finally{
            if(out != null){
                try {
                  out.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
            }
        }

    }
    
    /**
     * TODO 京客隆(横版)
     * @author wangjiucheng 2016年5月3日
     * @throws IOException
     */
    public static void excelTemplateThree(String fileName, String[] columnName, String sheetName, List<TemplateAttribute> list, HttpServletResponse response,BigDecimal replaceAmtLimit,BigDecimal replaceAmt) {

        /************************************************************************** 创建工作薄对象 开始 *************************************************************************/
        // 创建工作薄对象
        Workbook wb = new HSSFWorkbook();
        // 创建sheet页对象
        Sheet sheet = createSheet(wb, sheetName);

        /************************************************************************** 创建工作薄对象 结束 *************************************************************************/

        /************************************************************************** 创建列头 开始 *************************************************************************/
        Row columnHeader = sheet.createRow(6);
        // 遍历列头
        for (int i = 0; i < columnName.length; i++) {
            Cell cell = columnHeader.createCell(i);
            cell.setCellValue(columnName[i]);
            // 设置样式
            columnHeader.getCell(i).setCellStyle(verticalCenterAndAlignCenter(wb, columnHeader, 22));
            // 设置不同列的宽度
            if (i == 0) {
                sheet.setColumnWidth(i, (int) 27 * 256);
            } else if (i == 1) {
                sheet.setColumnWidth(i, (int) 11 * 256);
            } else if (i == 2) {
                sheet.setColumnWidth(i, (int) 12 * 256);
            } else if (i == 3) {
                sheet.setColumnWidth(i, (int) 12 * 256);
            } else {
                sheet.setColumnWidth(i, (int) 12 * 256);
            }
        }
        /************************************************************************** 创建列头 结束 *************************************************************************/

        /************************************************************************** 遍历数据 开始 *************************************************************************/
        for (int i = 0; i < list.size(); i++) {
            // 单元格下标
            int cellOn = 0;
            Row dataRow = sheet.createRow(7 + i);
            dataRow.createCell(cellOn).setCellValue(list.get(i).getProductName());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getUnit());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNumber());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getPrice().doubleValue());
            // 金额=数量*单价
            dataRow.createCell(++cellOn).setCellValue(dataRow.getCell(2).getNumericCellValue() * dataRow.getCell(3).getNumericCellValue());
            //付款金额
            dataRow.createCell(++cellOn).setCellValue("");
            //差补
            dataRow.createCell(++cellOn).setCellValue("");
            // 设置每个单元格的样式
            for (int j = 0; j < columnName.length; j++) {
                dataRow.getCell(j).setCellStyle(verticalCenterAndAlignCenter(wb, dataRow, 21));
            }
        }
        /************************************************************************** 遍历数据 开始 *************************************************************************/
        /************************************************************************** 计算总金额 结束 *************************************************************************/

        // 计算出金额列的总和
        double total = 0.0d;
        // 金额部分进行求和
        for (int i = 0; i < list.size(); i++) {
            total += Double.valueOf(sheet.getRow(7 + i).getCell(sheet.getRow(7 + i).getLastCellNum() - 3).getNumericCellValue());
        }

        // 添加金额总数行
        Row amountRows = sheet.createRow(sheet.getLastRowNum() + 1);
        // 创建单元格
        for (int i = 0; i < columnName.length; i++) {
            // 创建与列同等数量的单元格
            amountRows.createCell(i);
        }

        // 设置计算后的金额总额
        amountRows.getCell(amountRows.getLastCellNum() - 3).setCellValue(total);
        // 设置样式
        amountRows.getCell(amountRows.getLastCellNum() - 3).setCellStyle(verticalCenterAndAlignCenter(wb, amountRows, 22));

        /************************************************************************** 计算总金额结束 *************************************************************************/

        /************************************************************************** 计算总金额 开始*************************************************************************/
        Row poorRepairRow = sheet.getRow(sheet.getLastRowNum());
        poorRepairRow.getCell(poorRepairRow.getLastCellNum()-2).setCellValue(replaceAmt.doubleValue());
        poorRepairRow.getCell(poorRepairRow.getLastCellNum() - 2).setCellStyle(verticalCenterAndAlignCenter(wb, amountRows, 22));
        
        poorRepairRow.getCell(poorRepairRow.getLastCellNum()-1).setCellValue(replaceAmtLimit.doubleValue());
        poorRepairRow.getCell(poorRepairRow.getLastCellNum() - 1).setCellStyle(verticalCenterAndAlignCenter(wb, amountRows, 22));
        /************************************************************************** 计算总金额结束 *************************************************************************/
        
        
        /************************************************************************** 创建最后一行空白行 开始 *************************************************************************/
        Row lastNullRow = sheet.createRow(sheet.getLastRowNum() + 1);
        amountRows.setRowStyle(verticalCenterAndAlignCenter(wb, lastNullRow, 22));
        /************************************************************************** 创建最后一行空白行 结束 *************************************************************************/

        OutputStream out = null;
        try {
            response.setContentType("APPLICATION/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
            out = response.getOutputStream();
            wb.write(out);
        } catch (IOException e) {
           e.printStackTrace();
        }finally{
            if(out != null){
                try {
                  out.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
            }
        }
    }

    /**
     * TODO 京客隆(竖版)
     * 
     * @author wangjiucheng 2016年5月3日
     * @param fileName
     * @param columnName
     * @param combined
     * @param note
     * @param sheetName
     * @param list
     * @param response
     * @throws IOException
     */
    public static  void excelTemplateFour(String fileName, String[] columnName, String sheetName,List<TemplateAttribute> list,HttpServletResponse response,BigDecimal replaceAmtLimit,BigDecimal replaceAmt) {

        /************************************************************************** 创建工作薄对象 开始 *************************************************************************/
        // 创建工作薄对象
        Workbook wb = new HSSFWorkbook();

        Sheet sheet = createSheet(wb, sheetName);

        /************************************************************************** 创建工作薄对象 结束 *************************************************************************/

        /************************************************************************** 创建空白行 开始 *************************************************************************/
        for (int i = 0; i < 3; i++) {
            Row columnHeader = sheet.createRow(i);
            columnHeader.setRowStyle(verticalCenterAndAlignCenter(wb, columnHeader, 22));
        }
        /************************************************************************** 创建空白行 结束 *************************************************************************/

        Row columnHeaderRow = sheet.createRow(3);
        // 遍历列头
        for (int i = 0; i < columnName.length + 1; i++) {
            // 设置样式
            columnHeaderRow.getCell(i).setCellStyle(verticalCenterAndAlignCenter(wb, columnHeaderRow, 22));
            // 设置不同列的宽度
            if (i == 0) {
                sheet.setColumnWidth(i, (int) 1 * 256);
            } else if (i == 1) {
                sheet.setColumnWidth(i, (int) 18 * 256);
                columnHeaderRow.getCell(i).setCellValue(columnName[i - 1]);
            } else if (i == 2) {
                sheet.setColumnWidth(i, (int) 4 * 256);
                columnHeaderRow.getCell(i).setCellValue(columnName[i - 1]);
            } else if (i == 3) {
                sheet.setColumnWidth(i, (int) 7 * 256);
                columnHeaderRow.getCell(i).setCellValue(columnName[i - 1]);
            } else if (i == 4) {
                sheet.setColumnWidth(i, (int) 7 * 256);
                columnHeaderRow.getCell(i).setCellValue(columnName[i - 1]);
            } else {
                sheet.setColumnWidth(i, (int) 10 * 256);
                columnHeaderRow.getCell(i).setCellValue(columnName[i - 1]);
            }
        }
        /************************************************************************** 创建列头 结束 *************************************************************************/

        /************************************************************************** 遍历数据 开始 *************************************************************************/
        for (int i = 0; i < list.size(); i++) {
            // 单元格下标
            int cellOn = 1;
            Row dataRow = sheet.createRow(4 + i);
            dataRow.createCell(cellOn).setCellValue(list.get(i).getProductName());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getUnit());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNumber());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getPrice().doubleValue());
            // 金额=数量*单价
            dataRow.createCell(++cellOn).setCellValue(dataRow.getCell(3).getNumericCellValue() * dataRow.getCell(4).getNumericCellValue());
            //付款金额
            dataRow.createCell(++cellOn).setCellValue("");
            //差补
            dataRow.createCell(++cellOn).setCellValue("");
            // 设置每个单元格的样式
            // 当前行的第一行第一个单元格的下标
            for (int j = 1; j <= columnName.length; j++) {
                dataRow.getCell(j).setCellStyle(verticalCenterAndAlignCenter(wb, dataRow, 21));
            }
        }
        /************************************************************************** 遍历数据 开始 *************************************************************************/
        /************************************************************************** 计算总金额 开始 *************************************************************************/
        // 计算出金额列的总和
        double total = 0.0d;
        // 金额部分进行求和
        for (int i = 0; i < list.size(); i++) {
            total += Double.valueOf(sheet.getRow(4 + i).getCell(sheet.getRow(4 + i).getLastCellNum() - 3).getNumericCellValue());
        }

        // 添加金额总数行
        Row amountRows = sheet.createRow(sheet.getLastRowNum() + 1);
        // 创建单元格
        for (int i = 0; i <= columnName.length; i++) {
            // 创建与列同等数量的单元格
            amountRows.createCell(i);
        }
        // 设置计算后的金额总额
        amountRows.getCell(amountRows.getLastCellNum() - 3).setCellValue(total);
        // 设置样式
        amountRows.getCell(amountRows.getLastCellNum() - 3).setCellStyle(verticalCenterAndAlignCenter(wb, amountRows, 22));

        /************************************************************************** 计算总金额结束 *************************************************************************/
        /************************************************************************** 差补 开始*************************************************************************/
        Row poorRepairRow = sheet.getRow(sheet.getLastRowNum());
        poorRepairRow.getCell(poorRepairRow.getLastCellNum()-2).setCellValue(replaceAmt.doubleValue());
        poorRepairRow.getCell(poorRepairRow.getLastCellNum() - 2).setCellStyle(verticalCenterAndAlignCenter(wb, poorRepairRow, 22));
        
        poorRepairRow.getCell(poorRepairRow.getLastCellNum()-1).setCellValue(replaceAmtLimit.doubleValue());
        poorRepairRow.getCell(poorRepairRow.getLastCellNum() - 1).setCellStyle(verticalCenterAndAlignCenter(wb, poorRepairRow, 22));
        /************************************************************************** 差补 结束 *************************************************************************/
        // 输出文件
        
        
        OutputStream out = null;
        try {
            response.setContentType("APPLICATION/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
            out = response.getOutputStream();
            wb.write(out);
        } catch (IOException e) {
           e.printStackTrace();
        }finally{
            if(out != null){
                try {
                  out.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
            }
        }

    }

    /**
     * TODO 西单模板
     * 
     * @author wangjiucheng 2016年5月3日
     * @param fileName
     * @param columnName
     * @param combined
     * @param note
     * @param sheetName
     * @param list
     * @param response
     * @throws IOException
     */
    public static void excelTemplateFive(String fileName, String[] columnName,String sheetName, List<TemplateAttribute> list,
            HttpServletResponse response,BigDecimal replaceAmtLimit,BigDecimal replaceAmt) {
        // 创建工作薄对象
        Workbook wb = new HSSFWorkbook();
        // 创建sheet页对象
        Sheet sheet = createSheet(wb, sheetName);

        for (int i = 0; i < 3; i++) {
            Row row = sheet.createRow(i);
            // 设置行高
            row.setRowStyle(verticalCenterAndAlignCenter(wb, row, 13.5f));
            // 设置每列的宽度
            if (i == 0) {
                // 设置每一列的宽度
                sheet.setColumnWidth(0, 5 * 256);
                sheet.setColumnWidth(1, 23 * 256);
                sheet.setColumnWidth(2, 8 * 256);
                sheet.setColumnWidth(3, 8 * 256);
                sheet.setColumnWidth(4, 8 * 256);
                sheet.setColumnWidth(5, 8 * 256);
            }
            // 设置第三行的行高
            if (i == 2) {
                row.setRowStyle(verticalCenterAndAlignCenter(wb, row, 38.25f));
            }
        }
        // 设置列头
        Row columnHeader = sheet.createRow(sheet.getLastRowNum() + 1);
        for (int i = 0; i < columnName.length; i++) {
            Cell cell = columnHeader.createCell(i);
            cell.setCellValue(columnName[i]);
            // 设置样式
            columnHeader.getCell(i).setCellStyle(verticalCenterAndAlignCenter(wb, columnHeader, 38.25f));
        }

        // 遍历数据
        for (int i = 0; i < list.size(); i++) {
            // 单元格下标
            int cellOn = 1;
            Row dataRow = sheet.createRow(4 + i);
            dataRow.createCell(cellOn).setCellValue(list.get(i).getProductName());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getUnit());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNumber());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getPrice().doubleValue());
            // 金额=数量*单价
            dataRow.createCell(++cellOn).setCellValue(dataRow.getCell(3).getNumericCellValue() * dataRow.getCell(4).getNumericCellValue());
            // 设置备注
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNote());
            //付款金额
            dataRow.createCell(++cellOn).setCellValue("");
            //差补
            dataRow.createCell(++cellOn).setCellValue("");
            // 当前行的第一行第一个单元格的下标
            for (int j = 1; j < columnName.length; j++) {
                System.out.println(j);
                dataRow.getCell(j).setCellStyle(verticalCenterAndAlignCenter(wb, dataRow, 38.5f));
            }
        }

        double total = 0.0d;
        // 金额部分进行求和
        for (int i = 0; i < list.size(); i++) {
            total += Double.valueOf(sheet.getRow(4 + i).getCell(sheet.getRow(4 + i).getLastCellNum() - 4).getNumericCellValue());
        }

        // 合计行
        Row combined = sheet.createRow(sheet.getLastRowNum() + 1);
        // 创建单元格
        for (int i = 0; i <= columnName.length; i++) {
            // 创建与列同等数量的单元格
            combined.createCell(i);
        }
        // 设置计算后的金额总额
        combined.getCell(combined.getLastCellNum() - 5).setCellValue(total);
        // 设置样式
        combined.getCell(combined.getLastCellNum() - 5).setCellStyle(verticalCenterAndAlignCenter(wb, combined, 38.5f));
        
        /************************************************************************** 付款金额 开始*************************************************************************/
        combined.getCell(combined.getLastCellNum()-3).setCellValue(replaceAmt.doubleValue());
        combined.getCell(combined.getLastCellNum()-3).setCellStyle(verticalCenterAndAlignCenter(wb, combined, 22));
        /************************************************************************** 付款金额 开始*************************************************************************/
        
        /************************************************************************** 差补 开始*************************************************************************/
        combined.getCell(combined.getLastCellNum()-2).setCellValue(replaceAmtLimit.doubleValue());
        combined.getCell(combined.getLastCellNum()-2).setCellStyle(verticalCenterAndAlignCenter(wb, combined, 22));
        /************************************************************************** 差补 结束 *************************************************************************/
        
        OutputStream out = null;
        try {
            response.setContentType("APPLICATION/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
            out = response.getOutputStream();
            wb.write(out);
        } catch (IOException e) {
           e.printStackTrace();
        }finally{
            if(out != null){
                try {
                  out.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
            }
        }

    }

    /**
     * TODO 物美模板
     * 
     * @author wangjiucheng 2016年5月3日
     * @param fileName
     * @param columnName
     * @param note
     * @param sheetName
     * @param list
     * @param response
     * @throws IOException
     */
    public static void excelTemplateSix(String fileName, String[] columnName, String sheetName, List<TemplateAttribute> list, HttpServletResponse response,BigDecimal replaceAmtLimit,BigDecimal replaceAmt) {
        // 创建工作薄对象
        Workbook wb = new HSSFWorkbook();
        // 创建sheet页对象
        Sheet sheet = createSheet(wb, sheetName);
        // 创建前4行
        for (int i = 0; i < 4; i++) {
            Row row = sheet.createRow(i);
            // 判断是否是第一行
            if (i == 0) {
                // 设置行高
                row.setRowStyle(verticalCenterAndAlignCenter(wb, row, 52.25f));
                // 设置合并单元格
                cellRangeAddress(0, 0, 0, columnName.length + 3, sheet);
            }
            // 判断是否是第二行开始
            if (i == 1 || i == 2) {
                // 设置行高
                row.setRowStyle(verticalCenterAndAlignCenter(wb, row, 24.75f));
                sheet.setColumnWidth(0, 6 * 256);
                sheet.setColumnWidth(1, 6 * 256);
                sheet.setColumnWidth(2, 5 * 256);
                sheet.setColumnWidth(3, 9 * 256);
                sheet.setColumnWidth(4, 22 * 256);
                sheet.setColumnWidth(5, 10 * 256);
                sheet.setColumnWidth(6, 14 * 256);
                sheet.setColumnWidth(7, 10 * 256);
            }
        }

        // 获取第三行
        Row columnHeader = sheet.getRow(3);
        for (int i = 0; i < columnName.length; i++) {
            Cell cell = columnHeader.createCell(4 + i);
            cell.setCellValue(columnName[i]);
            // 设置样式
            columnHeader.getCell(4 + i).setCellStyle(verticalCenterAndAlignCenter(wb, columnHeader, 38.25f));
        }

        // 遍历数据
        for (int i = 0; i < list.size(); i++) {

            // 单元格下标
            int cellOn = 4;
            Row dataRow = sheet.createRow(4 + i);
            // 合并单元格
            cellRangeAddress(4 + i, 4 + i, 2, 3, sheet);

            dataRow.createCell(cellOn).setCellValue(list.get(i).getProductName());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getPrice().doubleValue());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNumber());
            // 金额=数量*单价
            dataRow.createCell(++cellOn).setCellValue(dataRow.getCell(5).getNumericCellValue() * dataRow.getCell(6).getNumericCellValue());
            // 设置备注
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNote());
            //付款金额
            dataRow.createCell(++cellOn).setCellValue("");
            //差补
            dataRow.createCell(++cellOn).setCellValue("");
            //设置数据部分的每一个单元格的样式
            for (int j = 0; j <= columnName.length; j++) {
                dataRow.getCell(4 + j).setCellStyle(verticalCenterAndAlignCenter(wb, dataRow, 15.75f));
            }
        }

        double total = 0.0d;
        // 金额部分进行求和
        for (int i = 0; i < list.size(); i++) {
            total += Double.valueOf(sheet.getRow(4 + i).getCell(sheet.getRow(4 + i).getLastCellNum() - 4).getNumericCellValue());
        }
        // 合计行
        Row combined = sheet.createRow(sheet.getLastRowNum() + 1);
        // 设置计算后的金额总额
        combined.createCell(2).setCellValue(total);
        // 设置样式
        combined.getCell(2).setCellStyle(verticalCenterAndAlignCenter(wb, combined, 18.75f));
        // 合并单元格
        cellRangeAddress(sheet.getLastRowNum(), sheet.getLastRowNum(), 2, 4, sheet);

        combined.createCell(8).setCellValue(replaceAmt.doubleValue());
        combined.getCell(8).setCellStyle(verticalCenterAndAlignCenter(wb, combined, 22));
        
        combined.createCell(9).setCellValue(replaceAmtLimit.doubleValue());
        combined.getCell(9).setCellStyle(verticalCenterAndAlignCenter(wb, combined, 22));        
        OutputStream out = null;
        try {
            response.setContentType("APPLICATION/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
            out = response.getOutputStream();
            wb.write(out);
        } catch (IOException e) {
           e.printStackTrace();
        }finally{
            if(out != null){
                try {
                  out.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
            }
        }
    }
    
    /**
     * 
     * //TODO 双安模板
     * @author wangjiucheng
     * 2016年5月9日
     * @param fileName
     * @param columnName
     * @param sheetName
     * @param list
     * @param response
     * @throws IOException
     */
    public static void excelTemplateSeven(String fileName, String[] columnName, String sheetName, List<TemplateAttribute> list, HttpServletResponse response,BigDecimal replaceAmtLimit,BigDecimal replaceAmt){
        // 创建工作薄对象
        Workbook wb = new HSSFWorkbook();
        // 创建sheet页对象
        Sheet sheet = createSheet(wb, sheetName);
        //空行
        Row headerNullRow = sheet.createRow(0);
       //设置行样式
        headerNullRow.setRowStyle(verticalCenterAndAlignCenter(wb, headerNullRow, 10.5f));
        // 创建行对象
        Row columnHeader = sheet.createRow(1);
        for (int i = 0; i < columnName.length; i++) {
            Cell cell = columnHeader.createCell(i);
            cell.setCellValue(columnName[i]);
            // 设置样式
            columnHeader.getCell(i).setCellStyle(verticalCenterAndAlignCenter(wb, columnHeader, 22.5f));
            // 设置不同列的宽度
            if (i == 0) {
                sheet.setColumnWidth(i, (int) 6* 256);
            } else if (i == 1) {
                sheet.setColumnWidth(i, (int) 21 * 256);
            } else if (i == 2) {
                sheet.setColumnWidth(i, (int) 6* 256);
            } else if (i == 3) {
                sheet.setColumnWidth(i, (int) 5 * 256);
            } else if (i == 4) {
                sheet.setColumnWidth(i, (int) 10 * 256);
            } else {
                sheet.setColumnWidth(i, (int) 16 * 256);
            }
        }
        //空两行
        for (int i = 2; i < 4; i++) {
            Row newNullRow=sheet.createRow(i);
            if (i==2) {
                //设置空行1的样式
                newNullRow.setRowStyle(verticalCenterAndAlignCenter(wb, newNullRow, 21));
            }else{
                //设置空行2的样式
                newNullRow.setRowStyle(verticalCenterAndAlignCenter(wb, newNullRow, 27));
            }
        }
        
        int rowNo = 1;
        for (int i = 0; i < list.size(); i++) {
            // 单元格下标
            int cellOn = 0;
            Row dataRow = sheet.createRow(4+ i);
            dataRow.createCell(cellOn).setCellValue(rowNo);
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getProductName());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getUnit());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getNumber());
            dataRow.createCell(++cellOn).setCellValue(list.get(i).getPrice().doubleValue());
            // 金额=数量*单价
            dataRow.createCell(++cellOn).setCellValue(dataRow.getCell(3).getNumericCellValue() * dataRow.getCell(4).getNumericCellValue());
            //付款金额
            dataRow.createCell(++cellOn).setCellValue("");
            //差补
            dataRow.createCell(++cellOn).setCellValue("");
            // 设置第一个单元格的
            for (int j = 0; j < columnName.length; j++) {
                dataRow.getCell(j).setCellStyle(verticalCenterAndAlignCenter(wb, dataRow, 22));
            }
            rowNo++;
        }
        /************************************************************************** 差补 开始*************************************************************************/
        Row poorRepairRow = sheet.getRow(sheet.getLastRowNum());
        poorRepairRow.getCell(poorRepairRow.getLastCellNum()-2).setCellValue(replaceAmt.doubleValue());
        poorRepairRow.getCell(poorRepairRow.getLastCellNum()-2).setCellStyle(verticalCenterAndAlignCenter(wb, poorRepairRow, 22));
        
        poorRepairRow.getCell(poorRepairRow.getLastCellNum()-1).setCellValue(replaceAmtLimit.doubleValue());
        poorRepairRow.getCell(poorRepairRow.getLastCellNum()-1).setCellStyle(verticalCenterAndAlignCenter(wb, poorRepairRow, 22));
        /************************************************************************** 差补 结束 *************************************************************************/
        OutputStream out = null;
        try {
            response.setContentType("APPLICATION/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
            out = response.getOutputStream();
            wb.write(out);
        } catch (IOException e) {
           e.printStackTrace();
        }finally{
            if(out != null){
                try {
                  out.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
            }
        }
    }
    
    /**
     * //TODO POI单元格内容水平左对齐与垂直居中
     * 
     * @author wangjiucheng 2016年4月29日
     */
    public static CellStyle verticalCenterAndAlignLeft(Workbook wb, Row row) {
        row.setHeightInPoints(24);
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("宋体");

        CellStyle style = wb.createCellStyle();
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
        style.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 水平左对齐
        style.setFont(font);// 将设置的字体放入到样式对象中
        return style;
    }

    /**
     * //TODO POI单元格内容水平与垂直居中
     * 
     * @author wangjiucheng 2016年4月29日
     * @param wb
     * @param row
     * @return
     */
    public static CellStyle verticalCenterAndAlignCenter(Workbook wb, Row row, float height) {
        row.setHeightInPoints(height);
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("宋体");

        CellStyle noteTitleStyle = wb.createCellStyle();
        noteTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        noteTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
        noteTitleStyle.setFont(font);
        return noteTitleStyle;
    }

    /**
     * //TODO 合并单元格
     * 
     * @author wangjiucheng 2016年4月29日
     * @param firstRow
     *            起始行
     * @param lastRow
     *            终止行
     * @param firstCol
     *            起始列
     * @param lastCol
     *            终止列
     * @param sheet
     *            sheet页
     */
    public static void cellRangeAddress(int firstRow, int lastRow, int firstCol, int lastCol, Sheet sheet) {
        // 有多少个列就合并多少个单元格
        CellRangeAddress cra = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
        // 进行合并
        sheet.addMergedRegion(cra);

    }

    public static Sheet createSheet(Workbook wb, String sheetName) {
        Sheet sheet = null;
        // 判断是否手动设置的sheet的名称
        if (sheetName != null && !"".equals(sheetName)) {
            // 创建一个sheet页并设置名称
            sheet = wb.createSheet(sheetName);
        } else {
            // 没有手动设置sheet名称使用其默认的名称
            sheet = wb.createSheet();
        }
        return sheet;
    }
	
    
    
    
    
    
    /**
     * 
     *********************************************************.<br>
     * @method createExcelScan <br>
     * @description 订单任务 结算时生成excel 字节流<br>
     * @return byte[] <br>
     * @author fengjianjun <br>
     * @created 2017年4月14日 上午10:13:04 <br>
     *********************************************************.<br>
     */
    @SuppressWarnings("deprecation")
    public static <T> byte[]  createExcelScan(String fileName,List<T> list,String headers[],String columns[]){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(fileName);
        sheet.setDefaultColumnWidth((short) 30);
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
        }
         int index = 0;
         Iterator<T> it = list.iterator();
          while (it.hasNext()) {
             index++;
             row = sheet.createRow(index);
             T t = (T) it.next();

             for (short i = 0; i < columns.length; i++) {
                String columnName = columns[i];
                String getMethodName = "get"
                       + columnName.substring(0, 1).toUpperCase()
                       + columnName.substring(1);
               HSSFCell cell = row.createCell(i);
                try {
                    Class<? extends Object> tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    //判断值的类型后进行强制类型转换
                    String textValue = null;
                   if (value instanceof Date) {
                       Date date = (Date) value;
                       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        textValue = sdf.format(date);
                    }else if(value instanceof Timestamp) {
                    	//不展示毫秒
                    	java.util.Date date = (java.util.Date) value;
                        textValue = DateUtils.getDateString(date, "yyyy-MM-dd HH:mm:ss");
                    } else{
                        if(value==null || "".equals(value))
                            value = "";
                       textValue = value.toString();
                    }
                    if(textValue!=null){
                       Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
                       Matcher matcher = p.matcher(textValue);
                       if(matcher.matches()){
                          cell.setCellValue(Double.parseDouble(textValue));
                       }else{
                          cell.setCellValue(textValue);
                       }
                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
             }
          }ByteArrayOutputStream byout = new ByteArrayOutputStream();
          try {
            workbook.write(byout);
            
            } catch (IOException e) {
             e.printStackTrace();
            }
          return byout.toByteArray();
    }
    
    
    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    // @描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }



	/**
	 *
	 * 根据list<map>导出excel表
	 * @author lba
	 * 2018年3月7日
	 * @param fileName
	 * @param dataset
	 * @param response
	 * @param headers
	 * @param columNames
	 */
	@SuppressWarnings("all")
	public  static  void createExcelByMap(String fileName, List<Map<String,String>> dataset, HttpServletResponse response, String headers[], String columNames[]){
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 声明一个工作薄
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(fileName);
		// 设置表格默认列宽度为30个字节
		sheet.setDefaultColumnWidth((short) 30);
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		for (short i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headers[i]);
		}
		int index = 0;
		for(int ii = 0;ii<dataset.size();ii++){
			index++;
			row = sheet.createRow(index);
			Map<String,String> map = dataset.get(ii);
			for (short i = 0; i < columNames.length; i++){
				cell = row.createCell(i);
				cell.setCellValue(map.get(columNames[i]));
			}
		}
		OutputStream out = null;
		try {
			response.setContentType("APPLICATION/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("GB2312"), "ISO_8859_1")+ ".xls");
			out = response.getOutputStream();
			workbook.write(out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}



	/**
	 *
	 * 根据list<map>导出excel表
	 * @author lba
	 * 2018年3月7日
	 * @param fileName
	 * @param dataset
	 * @param headers
	 * @param columNames
	 */
	@SuppressWarnings("all")
	public static  byte[] createExcelByMapForByte(String fileName,List<Map<String,String>> dataset,String headers[],String columNames[]){
		HSSFWorkbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream byout = null;
		// 声明一个工作薄
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(fileName);
		// 设置表格默认列宽度为30个字节
		sheet.setDefaultColumnWidth((short) 30);
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		for (short i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headers[i]);
		}
		int index = 0;
		for(int ii = 0;ii<dataset.size();ii++){
			index++;
			row = sheet.createRow(index);
			Map<String,String> map = dataset.get(ii);
			for (short i = 0; i < columNames.length; i++){
				cell = row.createCell(i);
				cell.setCellValue(map.get(columNames[i]));
			}
		}
		try {
			byout = new ByteArrayOutputStream();
			workbook.write(byout);
			return byout.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return byout.toByteArray();
	}

}
