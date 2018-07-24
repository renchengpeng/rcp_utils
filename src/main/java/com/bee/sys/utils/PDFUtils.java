package com.bee.sys.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bee.framework.i.bp.core.CoreException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.migcomponents.migbase64.Base64;

public class PDFUtils {

    public static Font setChineseFont() {
        BaseFont bf = null;
        Font fontChinese = null;
        try {
            //bf = BaseFont.createFont("C:\\Windows\\Fonts\\msyh.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
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
     * @param pdf创建 <br>
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
            byte[] buffer = Base64.decode(baseImgMy.getBytes());
            if(baseImgOther == null){
                throw new CoreException("领签失败，请检查授权书图片是否含有公章");
            }
            byte[] buffers = Base64.decode(baseImgOther.getBytes());
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
	