import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import com.bee.sys.utils.DecimalUtil;

/**
 * 
 */

/**
 * @author "john.lh"
 * @Date 2014-11-12 下午4:23:34
 */
public class Test {

	/**
	 * @author "john.lh"
	 * @Date 2014-11-12 下午4:23:34
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Pattern pattern =
		// Pattern.compile("^(13[0-9]|15[01]|153|15[6-9]|180|18[23]|18[5-9])\\d{8}$");
		// Pattern pattern1 =
		// Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
		//
		// Matcher matcher = pattern.matcher("1852123565");
		// Matcher matcher1 = pattern1.matcher("18521231565@qq.com");
		// System.out.println(matcher.matches());
		// System.out.println(matcher1.matches());
		// if (matcher.matches()) {
		// System.out.println("验证通过");
		// }
		// Map<String,Object> map = (Map<String, Object>)
		// JSON.parse("{'张利':'123456'}");
		// System.out.println(map);
		// String s = "dsafaef.xls";
		// String[] s1 = s.split("\\.");
		// System.out.println(s1[1]);
		// for(int i = 0 ; i<10;i++){
		// System.out.println(generateShortUuid());
		//
		// }
//		for (int i = 0; i < 20; i++) {
//			System.out.println(ValidUtils.getVipDiscountCode());
//		}
//		System.out.println(new BigDecimal(30*0.98));
//		System.out.println(DecimalUtil.eq(new BigDecimal(30*0.98), DecimalUtil.multiply(new BigDecimal(30),new BigDecimal(0.98))));
		System.out.println(DecimalUtil.multiply(new BigDecimal(0.05), new BigDecimal(147270)));
	    
	    System.out.println(new BigDecimal(0.12));
	    System.out.println(new BigDecimal(1));
	    System.out.println(DecimalUtil.divide(new BigDecimal(1), new BigDecimal(0.12),2));
	}

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };

	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			System.out.println("-------------" + str + "-----------");
			int x = Integer.parseInt(str, 16);
			System.out.println("-------------" + x + "-----------");
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();

	}

	public static String gets() {
//		StringBuilder b = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			Random r = new Random(62);
			System.out.println(r);
			// b.append(chars[]);
		}
		return "";
	}
}
