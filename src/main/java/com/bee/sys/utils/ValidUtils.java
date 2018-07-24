package com.bee.sys.utils;

import java.util.Random;

import com.bee.framework.ui.utils.GenerateRandomUtils;

public class ValidUtils {
    public static String[] chars = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z" };

    public static String[] numbers = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    public static String[] charAndNums = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    /**
     * @Description 获取8位邀请码，3位数字
     * @author zhangli
     * @Date 2015年12月10日上午10:26:52
     * @return
     */
    public static String getInvitationCode() {
        StringBuilder b = new StringBuilder();
        Random ran = new Random();
        int n1 = ran.nextInt(8);
        int n2 = ran.nextInt(8);
        while (n1 == n2) {
            n2 = ran.nextInt(8);
        }
        int n3 = ran.nextInt(8);
        while (n3 == n1 || n3 == n2) {
            n3 = ran.nextInt(8);
        }
        for (int i = 0; i < 8; i++) {
            Random r = new Random();
            if (i == n1 || i == n2 || i == n3) {
                b.append(chars[r.nextInt(26)]);
                continue;
            }
            b.append(numbers[r.nextInt(10)]);
        }
        return b.toString();
    }

    /**
     * @Description 获取18位优惠码
     * @author zhangli
     * @Date 2015年12月22日下午1:42:45
     * @return
     */
    public static String getVipDiscountCode() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 18; i++) {
            Random r = new Random();
            b.append(charAndNums[r.nextInt(36)]);
        }
        return b.toString();
    }

    /**
     * 生成E卡密码
     * 
     * @return
     */
    public static String createEcardPwd() {
        /*
         * List<String> list = new ArrayList<String>(); Set<Integer> set = new HashSet<Integer>(); boolean flag = true; for(String str : chars){
         * if(str.equals("O")||str.equals("L")||str.equals("I"))//排除掉不易识别的字母 continue; list.add(str); } Random random = new Random();
         * while(flag){//随机取3个不同的字符 set.add(random.nextInt(23)); if(set.size()==3){ flag = false; } } List<String> strList = new ArrayList<String>();
         * Iterator<Integer> iterator = set.iterator(); while(iterator.hasNext()){ int count = iterator.next(); for (int i = 0; i < list.size(); i++)
         * { if(count == i){ strList.add(list.get(i)); } } }
         */

        String pwd = GenerateRandomUtils.generateRandomCharAndNumber(16);
        StringBuilder srb = new StringBuilder();
        srb.append(pwd.substring(0, 4).toUpperCase()).append("-").append(pwd.substring(4, 8).toUpperCase()).append("-")
                .append(pwd.substring(8, 12).toUpperCase()).append("-").append(pwd.substring(12).toUpperCase());

        return srb.toString();
    }
    public static void main(String[] args) {
    	for(int i = 0;i<39675;i++) {
    		System.out.println(GenerateRandomUtils.generateRandomCharAndNumber(16));
    	}
	}
}
