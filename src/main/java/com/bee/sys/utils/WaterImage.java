//package com.bee.sys.utils;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.File;
//
//import javax.imageio.ImageIO;
//
///**
// * 
// ********************************************************* .<br>
// * [类名] WaterImage <br>
// * [描述] 给图片添加水印 <br>
// * [作者] zj <br>
// * [时间] 2014-9-24 下午5:57:28 <br>
// ********************************************************* .<br>
// */
//public class WaterImage {
//
//	/**
//	 * 
//	 ********************************************************* .<br>
//	 * [方法] pressImage <br>
//	 * [描述] 给图片添加水印图片 <br>
//	 * [参数] String destDir 图片存放路径 ，String middlePath ：中间路径 ，String
//	 * file_ture_name ：图片上传后的图片名称<br>
//	 * [返回] void <br>
//	 * [作者] zj <br>
//	 * [时间] 2014-10-20 上午10:44:38 <br>
//	 ********************************************************* .<br>
//	 */
//	public static void pressImage(String pressImagePath, String filePath) {
//		try {
////			String pressImage = destDir + "\\icon.png"; // 水印图片路径
////			if (null == middlePath) {
////				middlePath = "";
////			}
////			String filePath = destDir + middlePath + File.separator
////					+ file_ture_name; // 水印图片的绝对路径
//			// 目标文件
//			File _file = new File(filePath);
//			Image src = ImageIO.read(_file);
//			int wideth = src.getWidth(null);
//			int height = src.getHeight(null);
//			BufferedImage image = new BufferedImage(wideth, height,
//					BufferedImage.TYPE_INT_RGB);
//			Graphics2D g = image.createGraphics();
//			g.drawImage(src, 0, 0, wideth, height, null);
//
//			// 水印文件
//			File _filebiao = new File(pressImagePath);
//			Image src_biao = ImageIO.read(_filebiao);
//			int wideth_biao = src_biao.getWidth(null);
//			int height_biao = src_biao.getHeight(null);
//			// 设置水印图片的透明度
//			// float alpha = 0.5f; // 透明度
//			// g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
//			// alpha));
//			g.drawImage(src_biao, (wideth - wideth_biao / 2),
//					(height - height_biao / 2), wideth_biao / 2,
//					height_biao / 2, null);
//			// 水印文件结束
//			g.dispose();
//			ImageIO.write(image, "jpg", _file);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 
//	 ********************************************************* .<br>
//	 * [方法] pressText <br>
//	 * [描述] 给图片添加水印文字 <br>
//	 * [参数] String destDir 图片存放路径 ，String middlePath ：中间路径 ，String
//	 * file_ture_name ：图片上传后的图片名称<br>
//	 * [返回] void <br>
//	 * [作者] zj <br>
//	 * [时间] 2014-10-20 上午10:49:09 <br>
//	 ********************************************************* .<br>
//	 */
//	public void pressText(String destDir, String middlePath,
//			String file_ture_name) {
//		// pressText :水印的文字 ，
//		// fontName -- 字体名：TimesRoman, Courier, Arial等
//		// fontStyle -- 字体样式:三个常量 Font.PLAIN, Font.BOLD, Font.ITALIC
//		// color -- 字体颜色
//		// fontSize-- 字体大小
//		try {
//			if (null == middlePath) {
//				middlePath = "";
//			}
//			String filePath = destDir + middlePath + File.separator
//					+ file_ture_name; // 水印图片的绝对路径
//			String pressText = "博雅智源";
//			String fontName = "宋体";
//			int fontSize = 14;
//			File _file = new File(filePath);
//			Image src = ImageIO.read(_file);
//			int wideth = src.getWidth(null);
//			int height = src.getHeight(null);
//			BufferedImage image = new BufferedImage(wideth, height,
//					BufferedImage.TYPE_INT_RGB);
//			Graphics g = image.createGraphics();
//			g.drawImage(src, 0, 0, wideth, height, Color.white, null);
//			g.setColor(Color.gray); // 设置字体颜色
//			g.setFont(new Font(fontName, Font.PLAIN, fontSize)); // 设置字体样式
//			g.drawString(pressText, wideth - fontSize, height - fontSize);
//			g.dispose();
//			ImageIO.write(image, "jpg", _file);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) {
//	    
//        WaterImage.pressImage("C:\\Users\\byzy\\Desktop\\waterImageM.png","d:\\img\\12345.jpg");
//    }
//}
