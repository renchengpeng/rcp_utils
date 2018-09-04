package com.bee.sys.utils;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.util.Formatter;

public class APIUtils {
    
    private static final Logger log = LoggerFactory.getLogger(APIUtils.class);
    
    /**
     * 将一个文件转为16进制字符串
     * @author zhangli
     * @date 2016年11月15日
     * @param path 文件路径
     * @return
     */
    public static String encodeHexLocalFile(String path)   {
        FileInputStream inputFile = null;
        try{  
             inputFile = new FileInputStream(path);
             BufferedImage bi = ImageIO.read(inputFile);
             ByteArrayOutputStream bos = new ByteArrayOutputStream();  
             ImageIO.write(bi, "jpg", bos);
             bos.flush();
             byte[] data = bos.toByteArray();  
             String res = byte2hex(data);  
             bos.close(); 
             inputFile.close();
             return res;    
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            if(inputFile!=null)
                try {
                    inputFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
        }
    }
    /**
     * 上传图片转为16进制字符串
     * @author zhangli
     * @date 2016年12月15日
     * @param multipartFile
     * @return
     * @throws Exception
     */
    public static String encodeImageToHex(MultipartFile multipartFile) throws Exception {
        InputStream in = multipartFile.getInputStream();
        BufferedImage bi = ImageIO.read(in);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ImageIO.write(bi, "jpg", bos);
        bos.flush();
        byte[] data = bos.toByteArray();  
        
        String res = byte2hex(data);  
        bos.close(); 
        in.close();
        return res;
    }
    /**
     * 面向第三方系统签名方法
     * @author zhangli
     * @date 2016年9月29日
     * @param 
     * @return
     */
    public static String sign(String key,String value){
        String signature = "";
        value = key+value;
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(value.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (Exception e){
            return "error";
        }
        return signature;
    }
    /**
     * 签名规则
     * @author zhangli
     * @date 2016年9月29日
     * @param hash
     * @return
     */
    private static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    /**
     * 保存16进制字符串为图片
     * @author zhangli
     * @date 2016年12月15日
     * @param data 16进制的字符串
     * @param fileName 完整保存路径
     * @throws IOException 
     */
    public static void saveImage(String data, String fileName) throws IOException {  
        RandomAccessFile file = null;
        try {  
            byte[] bytes = hex2byte(data);  
            log.debug("path:==" + fileName);  
            file = new RandomAccessFile(fileName, "rw");  
            file.write(bytes);  
            file.close();  
        } catch (IOException e) {  
            throw e;
        } finally{
            if(file!=null){
                try {
                    file.close();
                } catch (IOException e) {
                    
                }
            }
        }
    }  
    
    /**
     * 16进制字符串转byte数组
     * @author zhangli
     * @date 2016年12月15日
     * @param s
     * @return
     */
    public static byte[] hex2byte(String s) {  
        byte[] src = s.toLowerCase().getBytes();  
        byte[] ret = new byte[src.length / 2];  
        for (int i = 0; i < src.length; i += 2) {  
            byte hi = src[i];  
            byte low = src[i + 1];  
            hi = (byte) ((hi >= 'a' && hi <= 'f') ? 0x0a + (hi - 'a')  
                    : hi - '0');  
            low = (byte) ((low >= 'a' && low <= 'f') ? 0x0a + (low - 'a')  
                    : low - '0');  
            ret[i / 2] = (byte) (hi << 4 | low);  
        }  
        return ret;  
    }
    public static String byte2hex(byte[] b) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',  
                'B', 'C', 'D', 'E', 'F' };  
        char[] out = new char[b.length * 2];  
        for (int i = 0; i < b.length; i++) {  
            byte c = b[i];  
            out[i * 2] = Digit[(c >>> 4) & 0X0F];  
            out[i * 2 + 1] = Digit[c & 0X0F];  
        }  
      
        return new String(out);  
    }
}
