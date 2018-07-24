package com.bee.sys.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.bee.framework.date.util.DateUtils;

public class FileUpload {

	public static String openAccountFileDir;

	protected static final Logger log = LoggerFactory
			.getLogger(FileUpload.class);

	public static String getOpenAccountFileDir() {
		return openAccountFileDir;
	}

	public static void setOpenAccountFileDir(String openAccountFileDir) {
		FileUpload.openAccountFileDir = openAccountFileDir;
	}

	public static String fileUpload(String destDir, MultipartFile file)
			throws IllegalStateException, IOException {
		log.info("------------" + file.getOriginalFilename() + "-------------");
		String filePath = destDir + file.getOriginalFilename();
		File destFile = new File(filePath);
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
		log.info("-------------ready transfer file---------");
		file.transferTo(new File(filePath));
		log.info("-------------transfer file success---------");
		return filePath;
	}

	/**
	 * @Description 文件上传之后文件名前带时间戳以防被覆盖
	 * @author zhangli
	 * @Date 2015年11月19日下午4:58:24
	 * @param destDir
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String fileUploadWithTimestamp(String destDir,
			MultipartFile file,String fileName) throws IllegalStateException, IOException {
		log.info("------------" + file.getOriginalFilename() + "-------------");
		String originalFilename = file.getOriginalFilename();
		String[] s = originalFilename.split("\\.");
		String filePath = fileName + "-" + DateUtils.getDateString(DateUtils.currentTime(),"yyyyMMddHHmmss")+"."+s[s.length-1];
		
		return filePath;
	}

	public static void deleteFile(String destDir, String imageid,
			String middlePath) {
		log.info("删除文件-------------------" + imageid);
		String filePath = destDir + File.separator + imageid;
		File destFile = new File(filePath);
		destFile.delete();
	}
	
	/**
	 * 
	 * 删除某文件夹下所有文件
	 * @author zjk
	 * 2016年7月4日
	 * @param destDir
	 */
	public static void deleteFile(File file){
    	     if(file.isDirectory()){
                    File[] files = file.listFiles();
                    for(int i=0; i<files.length; i++){
                         deleteFile(files[i]);
                    }
    	     }
    	      file.delete();
    	      log.info("删除文件夹-------------------" + file.getAbsolutePath()+"下所有文件");
	   }

	/**
	 * 
	 ********************************************************* .<br>
	 * [方法] imageUpload <br>
	 * [描述] TODO(这里用一句话描述这个方法的作用) <br>
	 * [参数] String destDir, MultipartFile file,String middlePath, String type
	 * 值：product/enterprise<br>
	 * [返回] String <br>
	 * [作者] zj <br>
	 * [时间] 2015-1-6 下午1:46:32 <br>
	 ********************************************************* .<br>
	 */
	public static String imageUpload(String destDir, MultipartFile file,
			String middlePath, String type, String file_ture_name)
			throws IllegalStateException, IOException {
		log.info("------------" + file.getOriginalFilename() + "-------------");
		String pic_type = file.getContentType();
		if (pic_type.equals("image/jpeg")) {
			file_ture_name = file_ture_name.concat(".jpg");
		} else if (pic_type.equals("image/pjpeg")) {
            file_ture_name = file_ture_name.concat(".jpg");
        } else  if (pic_type.equals("image/x-png")) {
            file_ture_name = file_ture_name.concat(".png");
        } else  if (pic_type.equals("image/png")) {
			file_ture_name = file_ture_name.concat(".png");
		} else if (pic_type.equals("image/bmp")) {
			file_ture_name = file_ture_name.concat(".bmp");
		} else if (pic_type.equals("image/gif")) {
			file_ture_name = file_ture_name.concat(".gif");
		} else
			file_ture_name = file_ture_name.concat(".jpg");
		if (null != type && !type.equals("")) {
			file_ture_name = type.concat("-" + file_ture_name);
		}

		if (null == middlePath) {
			middlePath = "";
		}
		String filePath = destDir + middlePath + File.separator
				+ file_ture_name;
		File destFile = new File(filePath);
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
		log.info("-------------ready transfer file---------");
		file.transferTo(new File(filePath));
		log.info("-------------transfer file success---------");
		// // 图片添加水印
		// WaterImage.pressImage(destDir, null, file_ture_name);
		return file_ture_name;
	}

	/**
	 * 
	 * TODO 图片文件重命名
	 * @author fengjianjun
	 * 2016年6月3日
	 * @param file
	 * @param file_ture_name
	 * @return
	 */
	public static String fileReName(MultipartFile file,String file_ture_name){
	    String pic_type = file.getContentType();
        if (pic_type.equals("image/jpeg")) {
            file_ture_name = file_ture_name.concat(".jpg");
        } else if (pic_type.equals("image/pjpeg")) {
            file_ture_name = file_ture_name.concat(".jpg");
        } else  if (pic_type.equals("image/x-png")) {
            file_ture_name = file_ture_name.concat(".png");
        } else  if (pic_type.equals("image/png")) {
            file_ture_name = file_ture_name.concat(".png");
        } else if (pic_type.equals("image/bmp")) {
            file_ture_name = file_ture_name.concat(".bmp");
        } else if (pic_type.equals("image/gif")) {
            file_ture_name = file_ture_name.concat(".gif");
        } else if (pic_type.equals("application/pdf")) {
            file_ture_name = file_ture_name.concat(".pdf");
        } else if (pic_type.equals("application/msword")) {
            file_ture_name = file_ture_name.concat(".doc");//cws 20171109
        } else if (pic_type.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            file_ture_name = file_ture_name.concat(".docx");//cws 20171109
        } else
            file_ture_name = file_ture_name.concat(".jpg");
        return file_ture_name;
	}
	
	/**
	 * 文件重命名，只传contentType
	 * @author cws
	 * 2017年11月9日
	 * @param pic_type
	 * @param file_ture_name
	 * @return
	 */
	public static String fileReNameByContentType(String pic_type,String file_ture_name){
        if (pic_type.equals("image/jpeg")) {
            file_ture_name = file_ture_name.concat(".jpg");
        } else if (pic_type.equals("image/pjpeg")) {
            file_ture_name = file_ture_name.concat(".jpg");
        } else  if (pic_type.equals("image/x-png")) {
            file_ture_name = file_ture_name.concat(".png");
        } else  if (pic_type.equals("image/png")) {
            file_ture_name = file_ture_name.concat(".png");
        } else if (pic_type.equals("image/bmp")) {
            file_ture_name = file_ture_name.concat(".bmp");
        } else if (pic_type.equals("image/gif")) {
            file_ture_name = file_ture_name.concat(".gif");
        } else if (pic_type.equals("application/pdf")) {
            file_ture_name = file_ture_name.concat(".pdf");
        } else if (pic_type.equals("application/msword")) {
            file_ture_name = file_ture_name.concat(".doc");//cws 20171109
        } else if (pic_type.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            file_ture_name = file_ture_name.concat(".docx");//cws 20171109
        } else if (pic_type.equals("application/pdf")) {
            file_ture_name = file_ture_name.concat(".pdf");//cws 20171129
        } else
            file_ture_name = file_ture_name.concat(".jpg");
        return file_ture_name;
    }
	
	/**
	 * 判断上传文件类型
	 * 
	 * @param fileName
	 * @return
	 */
	public static Boolean checkFileTypeExcel(String fileName) {
		/** 检查文件名是否为空或者是否是Excel格式的文件 */
		if (fileName == null || !fileName.matches("^.+\\.(?i)((xls)|(xlsx))$")) {
			return false;
		}
		return true;
	}
}
