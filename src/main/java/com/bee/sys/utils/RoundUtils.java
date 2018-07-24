package com.bee.sys.utils;

import java.math.BigDecimal;

import com.bee.framework.i.bp.core.CoreException;

/**
 * 
 * //TODO 对金额个位十位的四舍五入
 * @author fengjianjun
 * 时间：2016年3月11日9:35:27
 */
public class RoundUtils {

    /**
     * 
     * //TODO 对金额的四舍五入操作
     * @author fengjianjun
     * 2016年3月11日
     * @param formula 1顺加  2 倒扣
     * @param beforeAmt  金额
     * @param serviceFee 费率
     * @param roundFlag 0：小数 1：个位  2：十位   3.
     * @return
     * @throws CoreException 
     */
    public static BigDecimal roundAmount(String formula,BigDecimal beforeAmt,BigDecimal serviceFee,String roundFlag){
        BigDecimal fee = null;
        BigDecimal b = null;
        try {
            if("1".equals(formula)){//顺加
                fee = DecimalUtil.add(new BigDecimal(1),serviceFee,4);//顺加的话，费率加1
                if("0".equals(roundFlag)){//抹除小数
                    int val =  Integer.valueOf(DecimalUtil.multiply(beforeAmt,fee).toString().split("\\.")[0]);//与费率相乘的结果整数部分
                    if(val>0){
                        b = DecimalUtil.multiply(beforeAmt,fee).setScale(0,BigDecimal.ROUND_HALF_UP);
                    }else{
                        b = DecimalUtil.multiply(beforeAmt,fee);
                    }
                }else if("1".equals(roundFlag)){//对个位进行四舍五入
                    int len =  DecimalUtil.multiply(beforeAmt,fee).toString().split("\\.")[0].length();//与费率相乘的结果整数部分的位数
                    if(len>1){//如果整数部分位数长度大于1
                      b = DecimalUtil.multiply(DecimalUtil.divide(DecimalUtil.multiply(beforeAmt,fee),new BigDecimal(10),0),new BigDecimal(10),0);
                    }else{
                      b = DecimalUtil.multiply(beforeAmt,fee);
                    }
                }else if("2".equals(roundFlag)){//对十位进行四舍五入
                    int len =  DecimalUtil.multiply(beforeAmt,fee).toString().split("\\.")[0].length();
                    if(len>2){
                          b = DecimalUtil.multiply(DecimalUtil.divide(DecimalUtil.multiply(beforeAmt,fee),new BigDecimal(100),0),new BigDecimal(100),0);
                        }else{
                            b = DecimalUtil.multiply(beforeAmt,fee);
                        }
                }else{//不抹除
                    b = DecimalUtil.multiply(beforeAmt,fee);
                }
            }else if("2".equals(formula)){//倒扣
                fee = DecimalUtil.subtract(new BigDecimal(1), serviceFee,4);//倒扣的话，1-费率
                if("0".equals(roundFlag)){//抹除小数
                    int val =  Integer.valueOf(DecimalUtil.divide(beforeAmt,fee).toString().split("\\.")[0]);//与费率相乘的结果整数部分
                    if(val>0){
                        b = DecimalUtil.divide(beforeAmt,fee).setScale(0,BigDecimal.ROUND_HALF_UP);
                    }else{
                        b = DecimalUtil.divide(beforeAmt,fee);
                    }
                 }else if("1".equals(roundFlag)){//对个位进行四舍五入
                    int len =  DecimalUtil.divide(beforeAmt,fee).toString().split("\\.")[0].length();//除以费率的结果整数部分的位数
                    if(len>1){
                      b = DecimalUtil.multiply(DecimalUtil.divide(DecimalUtil.divide(beforeAmt,fee,0),new BigDecimal(10)),new BigDecimal(10),0);
                    }else{
                      b = DecimalUtil.divide(beforeAmt,fee);
                    }
                }else if("2".equals(roundFlag)){//对十位进行四舍五入
                    int len =  DecimalUtil.divide(beforeAmt,fee).toString().split("\\.")[0].length();
                    if(len>2){
                          b = DecimalUtil.multiply(DecimalUtil.divide(DecimalUtil.divide(beforeAmt,fee,0),new BigDecimal(100)),new BigDecimal(100),0);
                        }else{
                          b = DecimalUtil.divide(beforeAmt,fee);
                        }
                }else{//不抹除
                    b = DecimalUtil.divide(beforeAmt,fee);
                }
            }else{
                throw new CoreException("请设置倒扣或顺加");
            }
            } catch (CoreException e) {
                
                e.printStackTrace();
            }
        return b;
    }
    
    /**
     * 
     * //TODO 倒推对金额的四舍五入操作
     * @author fengjianjun
     * 2016年3月11日
     * @param formula 1顺加  2 倒扣
     * @param beforeAmt  金额
     * @param serviceFee 费率
     * @param roundFlag 0：小数 1：个位  2：十位   3.
     * @return
     * @throws CoreException 
     */
    public static BigDecimal reRoundAmount(String formula,BigDecimal afterAmt,BigDecimal serviceFee){
        BigDecimal fee = null;
        BigDecimal b = null;
        try {
        	if("1".equals(formula)){//顺加
                fee = DecimalUtil.add(new BigDecimal(1),serviceFee,5);//顺加的话，费率加1
                b = DecimalUtil.divide(afterAmt,fee,2);
            }else if("2".equals(formula)){//倒扣
                fee = DecimalUtil.subtract(new BigDecimal(1), serviceFee,5);//倒扣的话，1-费率
                b = DecimalUtil.multiply(afterAmt,fee,2);
            }else{
                throw new CoreException("请设置倒扣或顺加");
            }
            } catch (CoreException e) {
                
                e.printStackTrace();
            }
        return b;
    }
    
    public static void main(String[] args) {
       System.out.println(RoundUtils.roundAmount("2", new BigDecimal(0.5),new BigDecimal(0.001),"0"));
       System.out.println(RoundUtils.roundAmount("1", new BigDecimal(1000),new BigDecimal(0.2),"0"));
       System.out.println(RoundUtils.roundAmount("2", new BigDecimal(1000),new BigDecimal(0.2),"0"));
       System.out.println(RoundUtils.reRoundAmount("1", new BigDecimal(1000),new BigDecimal(0.2)));
       System.out.println(RoundUtils.reRoundAmount("2", new BigDecimal(1000),new BigDecimal(0.2)));
//       System.out.println(DecimalUtil.multiply(new BigDecimal(1256),new BigDecimal(1.001)));
//       System.out.println(DecimalUtil.divide(DecimalUtil.multiply(new BigDecimal(1256),new BigDecimal(1.001)),new BigDecimal(10),0));
       
//     /  System.out.println(DecimalUtil.divide(DecimalUtil.multiply(new BigDecimal(125),new BigDecimal(1.001)),new BigDecimal(10),0));
       
//     /  System.out.println(DecimalUtil.divide(new BigDecimal(155),new BigDecimal(0.999),0).divide(new BigDecimal(10),0));
         //  System.out.println(DecimalUtil.divide(new BigDecimal(154),new BigDecimal(0.999),0).divide(new BigDecimal(10),0));
//        System.out.println(DecimalUtil.divide(new BigDecimal(155),new BigDecimal(0.999),0));
//        System.out.println(DecimalUtil.divide(DecimalUtil.divide(new BigDecimal(155),new BigDecimal(0.999),0),new BigDecimal(10)));
    }
}
