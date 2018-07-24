package com.bee.utils.common;

import java.math.BigDecimal;

/**
 * //TODO:模板类
 * 
 * @author wangjiucheng
 */
public class TemplateAttribute {
    
    // 商品名称
    private String productName;
    // 单位
    private String unit;
    // 数量
    private Integer number;
    // 单价
    private BigDecimal price;
    // 金额
    private BigDecimal amount;
    // 备注
    private String note;
    
    private Integer prdId;
    
    public Integer getPrdId() {
        return prdId;
    }

    public void setPrdId(Integer prdId) {
        this.prdId = prdId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
