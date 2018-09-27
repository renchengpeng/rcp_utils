package com.bee.utils.common;

public enum MerFlag {
    MERCHANT("MER","商户平台"),
    ADVANCE("ADV","预付商户"),
    JD("JD","京东商城"),
    SN("SN","苏宁商城"),
    YX("YX","网易严选"),
    YJYP("YJYP","优加优品");
    private String flag;
    private String name;
    private MerFlag(String flag,String name) {
        this.flag = flag;
        this.name = name;
        
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
