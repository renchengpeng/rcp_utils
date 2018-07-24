
package com.bee.utils.common;

import java.util.ArrayList;
import java.util.List;


/*
 *********************************************************.<br>
 * @classname ProductTypeEnums <br>
 * @description 产品类型枚举 <br>
 * @author cws <br>
 * @created 2016年9月20日 下午7:09:47 <br>
 *********************************************************.<br>
 */
 
public enum ProductTypeEnums {
    
    PRODUCT_TYPE_FPAY("00"),
    PRODUCT_TYPE_DZBXK("01"),
    PRODUCT_TYPE_FTK("04"),
    PRODUCT_TYPE_FEG("05"),
    PRODUCT_TYPE_FXK("06"),
    PRODUCT_TYPE_DZQ("07"),
    PRODUCT_TYPE_ZFB("08"),
    PRODUCT_TYPE_FQB("09");
    
    
    private String value;

    private ProductTypeEnums(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
    
        this.value = value;
    }
    
    
    public static String getProductType(String name) {
        
        ProductTypeEnums productTypeEnums = null;
        switch (name) {
        case "FPAY":
            productTypeEnums = PRODUCT_TYPE_FPAY;
            break;
        case "DZBXK":
            productTypeEnums = PRODUCT_TYPE_DZBXK;
            break;
        case "FTK":
            productTypeEnums = PRODUCT_TYPE_FTK;
            break;
        case "FEG":
            productTypeEnums = PRODUCT_TYPE_FEG;
            break;
        case "FXK":
            productTypeEnums = PRODUCT_TYPE_FXK;
            break;
        case "DZQ":
            productTypeEnums = PRODUCT_TYPE_DZQ;
            break;
        case "FQB":
            productTypeEnums = PRODUCT_TYPE_FQB;
            break;
        }
        return productTypeEnums.getValue();
    }
    
    public static List<String> getProductTypeList() {
        
        List<String> list = new ArrayList<String>();
        ProductTypeEnums[] pte = ProductTypeEnums.class.getEnumConstants();
        for (ProductTypeEnums p : pte) {
            list.add(p.getValue());
        }
        return list;
    }
}

	