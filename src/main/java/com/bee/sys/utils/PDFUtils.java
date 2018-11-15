package com.bee.sys.utils;

import com.bee.framework.i.bp.core.CoreException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class PDFUtils {

    public static Font setChineseFont() {
        BaseFont bf = null;
        Font fontChinese = null;
        try {
            bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            fontChinese = new Font(bf, 12, Font.NORMAL);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fontChinese;
    }

    /**
     *
     *********************************************************.<br>
     * @method createPDF <br>
     * @return void <br>
     * @author fengjianjun <br>
     * @created 2016年10月19日 下午2:01:37 <br>
     *********************************************************.<br>
     */
    public static byte[] createPDF(String baseImgMy,String baseImgOther,String otherCompanyName,String agreement) throws CoreException{
        XMLWorkerHelper worker = null;
        PdfWriter pdfWriter = null;
        String date = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());//签章日期
        try {
            Document document = new Document();
            document.setPageSize(PageSize.A4);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(document,byteArray);
            document.open();
            worker = XMLWorkerHelper.getInstance();
            worker.parseXHtml(pdfWriter, document, new ByteArrayInputStream(agreement.getBytes()),Charset.forName("UTF-8"), new AsianFontProvider());// (pdfWriter,
            byte[] buffer = Base64.getDecoder().decode(baseImgMy.getBytes());
            if(baseImgOther == null){
                throw new CoreException("领签失败，请检查授权书图片是否含有公章");
            }
            byte[] buffers = Base64.getDecoder().decode(baseImgOther.getBytes());
            Image image = Image.getInstance(buffer);
            Image images = Image.getInstance(buffers);
            image.setAlignment(Image.LEFT | Image.UNDERLYING);
            image.scaleAbsolute(100, 100);
            Chunk cks = new Chunk(image, 0, -80);
            Paragraph paragraph = new Paragraph("",setChineseFont());
            paragraph.setKeepTogether(true);
            paragraph.add(cks);
            images.setAlignment(Image.LEFT | Image.UNDERLYING);
            images.scaleAbsolute(100, 100);
            Chunk ck = new Chunk(images, 300, -80);
            paragraph.add(ck);
            String name = "北京云网四方信息技术有限公司";
            String name1 = otherCompanyName;
            String blank="";
            for(int i = 0;i<111-name.getBytes().length-name1.getBytes().length;i++){
                blank+=" ";
            }
            paragraph.add(new Paragraph("甲方：" + name +blank
                    + "乙方："+name1,setChineseFont()));
            paragraph.add(new Paragraph("  "+date +"                                                                                                                                "
                    + date,new Font(setChineseFont())));
            document.add(paragraph);
            document.close();
            return byteArray.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CoreException("领签失败",e);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new CoreException("领签失败",e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CoreException("领签失败",e);
        }
    }

    /**
     * @description: 徽商电子盖章
     * @auther: feng
     * @date: 2018/11/13 13:56
     * @param: [baseImgMy, baseImgOther, otherCompanyName, agreement]
     * @return: byte[]
     * @throws:
     **/
    public static byte[] pdfForhuishang(String baseImgMy,String agreement) throws CoreException{
        XMLWorkerHelper worker = null;
        PdfWriter pdfWriter = null;
        String date = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());//签章日期
        try {
            Document document = new Document();
            document.setPageSize(PageSize.A4);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(document,byteArray);
            document.open();
            worker = XMLWorkerHelper.getInstance();
            worker.parseXHtml(pdfWriter, document, new ByteArrayInputStream(agreement.getBytes()),Charset.forName("UTF-8"), new AsianFontProvider());// (pdfWriter,
            byte[] buffer = Base64.getDecoder().decode(baseImgMy.getBytes());
            Image image = Image.getInstance(buffer);

            image.setAlignment(Image.LEFT | Image.UNDERLYING);
            image.scaleAbsolute(100, 100);
            Chunk cks = new Chunk(image, 430, -80);
            Paragraph paragraph = new Paragraph("",setChineseFont());
            paragraph.setKeepTogether(true);
            paragraph.add(cks);

            String name = "北京云网四方信息技术有限公司";
            Paragraph p1 = new Paragraph(date,new Font(setChineseFont()));
            p1.setAlignment(Element.ALIGN_RIGHT);
            Paragraph p2 = new Paragraph(name,new Font(setChineseFont()));
            p2.setAlignment(Element.ALIGN_RIGHT);

            Paragraph p3 = new Paragraph("",new Font(setChineseFont()));
            p2.setAlignment(Element.ALIGN_RIGHT);

            paragraph.add(p1);
            paragraph.add("\n");
            paragraph.add(p2);
            document.add(paragraph);
            document.close();
            FileOutputStream ff = new FileOutputStream(new File("D:\\mypdf.pdf"));
            ff.write(byteArray.toByteArray());
            ff.flush();
            ff.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @description: 图片转pdf
     * @auther: feng
     * @date: 2018/11/14 13:44
     * @param: [baseImgMy]
     * @return: byte[]
     * @throws: 
     **/
    public static byte[] imgtopdf(String baseImgMy) throws CoreException{
        XMLWorkerHelper worker = null;
        PdfWriter pdfWriter = null;
        try {
            Document document = new Document();
            document.setPageSize(PageSize.A5);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(document,byteArray);
            document.open();
            byte[] buffer = Base64.getDecoder().decode(baseImgMy.getBytes());
            Image image = Image.getInstance(buffer);

            image.setAlignment(Image.LEFT | Image.UNDERLYING);
            image.scaleAbsolute(300, 300);
            Chunk cks = new Chunk(image, 100, -200);
            Paragraph paragraph = new Paragraph("",setChineseFont());
            paragraph.setKeepTogether(true);
            paragraph.add(cks);
            document.add(paragraph);
            document.close();
            FileOutputStream ff = new FileOutputStream(new File("D:\\myimg.pdf"));
            ff.write(byteArray.toByteArray());
            ff.flush();
            ff.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        File file = null;
        try {
            file = new File("C:\\Users\\feng\\Desktop\\jianjun\\jianjun\\index.html");
            FileInputStream fi = new FileInputStream(file);
            byte b[] = new byte[fi.available()];
            fi.read(b);
            fi.close();
            String str = new String(b,"utf-8");
            File image = new File("D:\\11.jpg");
            FileInputStream fis = new FileInputStream(image);
            byte[] imgbyte = new byte[fis.available()];
            int len = 0;
            while((len=fis.read(imgbyte))!= -1){
                fis.read(imgbyte);
            }

            fis.close();
            String baseimg = Base64.getEncoder().encodeToString(imgbyte);
            //pdfForhuishang(baseimg,str);
            imgtopdf(baseimg);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
class AsianFontProvider extends XMLWorkerFontProvider {
    public Font getFont(final String fontname, final String encoding,
            final boolean embedded, final float size, final int style,
            final BaseColor color) {
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Font font = new Font(bf, size, style, color);
        font.setColor(color);
        return font;
    }
}
