package com.bee.sys.utils;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.bee.framework.i.bp.core.CoreException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author feng
 * @description 文件的解压缩工具类
 * @date 2018/11/28 10:18
 */
public class ZipFileUtils {

    private final static Logger log = LoggerFactory.getLogger(ZipFileUtils.class);

    public static void main(String[] args) throws Exception {
        Map<String, byte[]> params = new HashMap<String, byte[]>();
        FileInputStream fis = new FileInputStream(new File("D:\\11.jpg"));
        byte b[] = new byte[fis.available()];
        fis.read(b);
        fis.close();

        FileInputStream fis3 = new FileInputStream(new File("D:\\1.png"));
        byte b3[] = new byte[fis3.available()];
        fis3.read(b3);
        fis3.close();
        FileInputStream fis4 = new FileInputStream(new File("D:\\12.jpg"));
        byte b4[] = new byte[fis4.available()];
        fis4.read(b4);
        fis4.close();


        FileInputStream fis1 = new FileInputStream(new File("D:\\11.mp4"));
        byte b1[] = new byte[fis1.available()];
        fis1.read(b1);
        fis1.close();




        FileInputStream fis2 = new FileInputStream(new File("D:\\ces.pdf"));
        byte b2[] = new byte[fis2.available()];
        fis2.read(b1);
        fis2.close();

        params.put("公章.jpg", b);
        params.put("公章2.jpg", b3);
        params.put("公章3.jpg", b4);

//        params.put("合同.pdf", b2);

//       packZipFile(params, "徽商.zip");
       packZipFile(params );



    }


    /**
     * @description: 把图片压缩在一个zip中。目前这个方法只支持图片。
     * 其他文件需要用FileInputStream,我们这个是基于byte的，目前和路径关联不大。
     * @auther: feng
     * @date: 2018/11/28 14:12
     * @param: [params 这个map中的key是文件名，value是文件的byte数组 ]
     * @return: byte[]
     * @throws: 
     **/
    public static byte[] packZipFile(Map<String, byte[]> params) throws CoreException {


        try {
            if (params == null || params.size() == 0) {
                throw new CoreException("打包文件参数异常");
            }
            byte [] buf = new byte[1024];
            //FileOutputStream bos = new FileOutputStream("D:\\abc.zip");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zot = new ZipOutputStream(bos);

            for (Map.Entry<String, byte[]> entry : params.entrySet()) {
                ZipEntry zipEntry = null;
                String fileName = entry.getKey();
                byte[] fileByte = entry.getValue();
                ByteArrayInputStream bai = new ByteArrayInputStream(fileByte);
                zipEntry = new ZipEntry(fileName);
                zot.putNextEntry(zipEntry);
                int len = 0;
                while((len = bai.read(buf, 0, 1024)) != -1){
                    zot.write(buf,0,len);
                }
                bai.close();
            }
            zot.close();
            byte bytearray[] = bos.toByteArray();
            bos.flush();
            bos.close();
            return bytearray;
        } catch (CoreException e) {
            log.error("打包zip失败", e);
            throw e;
        } catch (IOException e) {
            log.error("打包zip失败", e);
            throw new CoreException("打包zip失败", e);
        }
    }


}
