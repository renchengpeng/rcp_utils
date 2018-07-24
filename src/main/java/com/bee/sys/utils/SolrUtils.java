package com.bee.sys.utils;

import org.apache.solr.client.solrj.impl.HttpSolrServer;

@SuppressWarnings("deprecation")
public class SolrUtils {
    private static final Integer connectionTimeout = 1000;
    private static final Integer defaultMaxConnectionsPerHost = 100;
    private static final Integer maxTotalConnections = 100;
    
    public void setSolrIp(String solrIp) {
        solrUrlInvoiceProduct = solrIp+"/invoiceProduct";
        solrUrlFeiyuInvoiceProduct = solrIp+"/feiyuInvoiceProduct";
        solrUrlProduct = solrIp+"/product";
        solrUrlMerPrdAttr = solrIp+"/merPrdAttr";
        solrUrlPrdInvoiceItem = solrIp+"/prdInvoiceItem";
    }
    private String solrUrlInvoiceProduct;//闪报预付商品
    private String solrUrlFeiyuInvoiceProduct;//费鱼预付商品
    private String solrUrlProduct;//商户和京东平台商品url
    private String solrUrlMerPrdAttr;
    private String solrUrlPrdInvoiceItem;//商品和科目关联关系
    /**
     *蜂采预付商品的solr服务
     */
    private HttpSolrServer invoiceProductServer;
    private HttpSolrServer feiyuInvoiceProductServer; //费鱼
    /**
     *商户平台商品属性的solr服务
     */
    private HttpSolrServer merPrdAttrServer;
    
    /**
     *蜂贝商品solr服务
     */
    private HttpSolrServer productServer;
    
    private HttpSolrServer prdInvoiceItemServer;
    
    public void initSolr(){
    	/*************闪报************/
        invoiceProductServer= new HttpSolrServer(solrUrlInvoiceProduct);
        invoiceProductServer.setConnectionTimeout(connectionTimeout);
        invoiceProductServer.setDefaultMaxConnectionsPerHost(defaultMaxConnectionsPerHost);
        invoiceProductServer.setMaxTotalConnections(maxTotalConnections); 
        /*************费鱼*************/
        feiyuInvoiceProductServer= new HttpSolrServer(solrUrlFeiyuInvoiceProduct);
        feiyuInvoiceProductServer.setConnectionTimeout(connectionTimeout);
        feiyuInvoiceProductServer.setDefaultMaxConnectionsPerHost(defaultMaxConnectionsPerHost);
        feiyuInvoiceProductServer.setMaxTotalConnections(maxTotalConnections); 
        /**************商品***************/
        productServer= new HttpSolrServer(solrUrlProduct);
        productServer.setConnectionTimeout(connectionTimeout);
        productServer.setDefaultMaxConnectionsPerHost(defaultMaxConnectionsPerHost);
        productServer.setMaxTotalConnections(maxTotalConnections); 
        merPrdAttrServer= new HttpSolrServer(
                solrUrlMerPrdAttr);
        merPrdAttrServer.setConnectionTimeout(connectionTimeout);
        merPrdAttrServer.setDefaultMaxConnectionsPerHost(defaultMaxConnectionsPerHost);
        merPrdAttrServer.setMaxTotalConnections(maxTotalConnections); 
        
        prdInvoiceItemServer = new HttpSolrServer(solrUrlPrdInvoiceItem);
        prdInvoiceItemServer.setConnectionTimeout(connectionTimeout);
        prdInvoiceItemServer.setDefaultMaxConnectionsPerHost(defaultMaxConnectionsPerHost);
        prdInvoiceItemServer.setMaxTotalConnections(maxTotalConnections);
        
    }


    public String getSolrUrlPrdInvoiceItem() {
    
        return solrUrlPrdInvoiceItem;
    }


    public void setSolrUrlPrdInvoiceItem(String solrUrlPrdInvoiceItem) {
    
        this.solrUrlPrdInvoiceItem = solrUrlPrdInvoiceItem;
    }


    public HttpSolrServer getPrdInvoiceItemServer() {
    
        return prdInvoiceItemServer;
    }


    public void setPrdInvoiceItemServer(HttpSolrServer prdInvoiceItemServer) {
    
        this.prdInvoiceItemServer = prdInvoiceItemServer;
    }


    public String getSolrUrlInvoiceProduct() {
        return solrUrlInvoiceProduct;
    }


    public void setSolrUrlInvoiceProduct(String solrUrlInvoiceProduct) {
        this.solrUrlInvoiceProduct = solrUrlInvoiceProduct;
    }

    public HttpSolrServer getInvoiceProductServer() {
        return invoiceProductServer;
    }

    public void setInvoiceProductServer(HttpSolrServer invoiceProductServer) {
        this.invoiceProductServer = invoiceProductServer;
    }
    public String getSolrUrlMerPrdAttr() {
        return solrUrlMerPrdAttr;
    }

    public void setSolrUrlMerPrdAttr(String solrUrlMerPrdAttr) {
        this.solrUrlMerPrdAttr = solrUrlMerPrdAttr;
    }


    public HttpSolrServer getMerPrdAttrServer() {
        return merPrdAttrServer;
    }


    public void setMerPrdAttrServer(HttpSolrServer merPrdAttrServer) {
        this.merPrdAttrServer = merPrdAttrServer;
    }


    public String getSolrUrlProduct() {
        return solrUrlProduct;
    }


    public void setSolrUrlProduct(String solrUrlProduct) {
        this.solrUrlProduct = solrUrlProduct;
    }


    public HttpSolrServer getProductServer() {
        return productServer;
    }


    public void setProductServer(HttpSolrServer productServer) {
        this.productServer = productServer;
    }


	public String getSolrUrlFeiyuInvoiceProduct() {
	
		return solrUrlFeiyuInvoiceProduct;
	}


	public void setSolrUrlFeiyuInvoiceProduct(String solrUrlFeiyuInvoiceProduct) {
	
		this.solrUrlFeiyuInvoiceProduct = solrUrlFeiyuInvoiceProduct;
	}


	public HttpSolrServer getFeiyuInvoiceProductServer() {
	
		return feiyuInvoiceProductServer;
	}


	public void setFeiyuInvoiceProductServer(HttpSolrServer feiyuInvoiceProductServer) {
	
		this.feiyuInvoiceProductServer = feiyuInvoiceProductServer;
	}
}
