package com.bee.sys.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bee.framework.i.bp.core.CoreException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    
    private final static Logger LOG = LoggerFactory.getLogger(HttpClientUtil.class);
    
    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 20000;

    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(100);

        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());


        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(10000);
        // 在提交请求之前 测试连接是否可用
        // configBuilder.setStaleConnectionCheckEnabled(true);
        
    }

    /**
     * 发送 GET 请求（HTTP），不带输入数据
     * 
     * @param url
     * @return
     */
    public static String doGet(String url) {
        return doGet(url, new HashMap<String, Object>());
    }

    /**
     * 发送 GET 请求（HTTP），K-V形式
     * 
     * @param url
     * @param params
     * @return
     */
    public static String doGet(String url, Map<String, Object> params) {
        return doGet(url, params, "UTF-8");
    }

    /**
     * 发送 GET 请求（HTTP），K-V形式
     * 
     * @param url
     * @param params
     * @return
     */
    public static String doGet(String url, Map<String, Object> params, String charset) {
        String apiUrl = url;
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()) {
            if (i == 0)
                param.append("?");
            else
                param.append("&");
            param.append(key).append("=").append(params.get(key));
            i++;
        }
        apiUrl += param;
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(apiUrl);
            HttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            LOG.info("status code : {}", statusCode);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                httpClient.close();
            } catch (IOException e) {
                LOG.info("IOException : {}", e);
                e.printStackTrace();
            }
        }
       
        return result;
    }

    /**
     * 发送 POST 请求（HTTP），不带输入数据
     * 
     * @param apiUrl
     * @return
     * @throws CoreException 
     */
    public static String doPost(String apiUrl) throws CoreException {
        return doPost(apiUrl, new HashMap<String, Object>());
    }

    public static String doPost(String apiUrl, Map<String, Object> params) throws CoreException {
        return doPost(apiUrl, params, "UTF-8");
    }

    /**
     * 发送 POST 请求（HTTP），K-V形式
     * 
     * @param apiUrl
     *            API接口URL
     * @param params
     *            参数map
     * @return
     * @throws CoreException 
     */
    public static String doPost(String apiUrl, Map<String, Object> params, String charset) throws CoreException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList<>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(charset)));
            response = httpClient.execute(httpPost);
            LOG.info("status code : {}", response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            LOG.error("请求失败", e);
            throw new CoreException("请求失败",e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }

    /**
     * 
     * @param apiUrl
     * @param json
     *            json对象
     * @return
     */
    public static String doPost(String apiUrl, Object json, String charset) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), charset);// 解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            LOG.info("status code : {}",response.getStatusLine().getStatusCode());
            httpStr = EntityUtils.toString(entity, charset);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }
    
    /**
     * 只适用于json对象
     * @author xyd
     * @date 2018年6月14日 下午6:18:28 
     * @param url
     * @param params
     * @return
     */
	public static String postHttps(String url, Object params) {
		HttpsURLConnection conn = null;
		try {
			SSLContext context = SSLContext.getInstance("SSL");
			context.init(null,
					new TrustManager[] { new TrustAnyTrustManager() },
					new SecureRandom());
			URL curl = new URL(url);
			conn = (HttpsURLConnection) curl.openConnection();
			conn.setSSLSocketFactory(context.getSocketFactory());
			conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.getOutputStream().write(params.toString().getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();
			conn.connect();
			int statusCode = conn.getResponseCode();
			if (HttpStatus.SC_OK == statusCode) {
				InputStream is = conn.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						bis,Charset.forName("utf-8")));
				StringBuffer buff = new StringBuffer();
				String line = null;
				while (null != (line = br.readLine())) {
					buff.append(line);
				}
				br.close();
				return buff.toString();
			} else {
				LOG.error("请求状态不为成功statusCode[{" + statusCode + "}]");
			}
		} catch (IOException e) {
			LOG.error("io异常", e);
		} catch (KeyManagementException e) {
			LOG.error("KeyManagementException异常", e);
		} catch (NoSuchAlgorithmException e) {
			LOG.error("算法不存在异常", e);
		} finally {
			if (null != conn) {
				conn.disconnect();
			}
		}
		return null;

	}

	private static class TrustAnyTrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}

	private static class TrustAnyHostnameVerifier implements HostnameVerifier {

		@Override
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}
	
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put("tagid",100);
		JSONArray array = new JSONArray();
		array.add("o42IOw883gWBta-bH485McWwZIi4");
		json.put("openid_list",array);
		
		
String postHttps2 = HttpClientUtil.postHttps("https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=10_-DumEKcEH15Avt60vf2dUnYvJ7OwPtc2vKB3Y8TrlOckmtqSZtXdaQPKyuL-pqHV--ca6L2wOM4eMStitXqRwLjLkccNYSEwFgP6dLf9T6F8XX9H64Ipgtk-hzxtmUhrXCHXfFQbpFMGS5gDVPLdADAPJF", json);
		System.out.println(postHttps2);
	}
	
	
	
	public static String httpPostForFyw(String fywUrl,Map<String,String>requestHeader) throws CoreException{
		String result=null;
		try {
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost(fywUrl);
	        
	        StringEntity entity = new StringEntity(JSONObject.toJSONString(requestHeader),"utf-8");//解决中文乱码问题    
	        System.out.println("entity==============="+entity);
	        entity.setContentEncoding("UTF-8");    
	        entity.setContentType("application/json");    
	        httpPost.setEntity(entity);
	        CloseableHttpResponse response = httpClient.execute(httpPost);
	        HttpEntity entityResult = response.getEntity();
	        // EntityUtils中的toString()方法转换服务器的响应数据
	        String res = EntityUtils.toString(entityResult, "utf-8");
	        result=res;
		}catch (Exception e) {
			LOG.error("请求失败", e);
            throw new CoreException("请求失败",e);
		}
		return result;
	}
}