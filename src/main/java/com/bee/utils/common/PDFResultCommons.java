package com.bee.utils.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author feng
 * @description 生成的pdf返回结果，有章的坐标，和在第几页盖章
 * @date 2018/11/22 11:59
 */
public class PDFResultCommons implements Serializable {

    //章的坐标和在第几页的集合
    List<float []> postList ;
    private byte [] pdfbytes;

    public byte[] getPdfbytes() {
        return pdfbytes;
    }

    public void setPdfbytes(byte[] pdfbytes) {
        this.pdfbytes = pdfbytes;
    }

    public List<float[]> getPostList() {
        return postList;
    }

    public void setPostList(List<float[]> postList) {
        this.postList = postList;
    }
}
