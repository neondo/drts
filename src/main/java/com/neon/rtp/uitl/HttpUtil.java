package com.neon.rtp.uitl;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtil{

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static RequestConfig requestConfig = null;

    static {
        requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000 * 10)
                .setConnectionRequestTimeout(1000 * 30)
                .setSocketTimeout(1000 * 10).build();
    }

    public static String fetch(String url, Map<String, String> header, String content, Method method) {
      /*  header.put("Accept", "application/json;charset=utf-8");
        header.put("Content-Type", "application/json;charset=utf-8");*/
        logger.info("url:{},header:{},content:{}", url, header, content);
        try {
            switch(method) {
                case GET:
                    return HttpUtil.get(url, header, content);
                case PUT:
                    return HttpUtil.put(url, header, content);
                case POST:
                    return HttpUtil.post(url, header, content);
                case DELETE:
                    return HttpUtil.delete(url, header);
                default:
                    return null;
            }
        } catch(Exception e) {
            logger.error("", e);
        }
        return null;
    }

    private static void setRequestConfig(RequestConfig conf) {
        requestConfig = conf;
    }

    private static String cookieToString(List<Cookie> cookies) {
        if(cookies == null || cookies.size() == 0) {
            return "";
        }
        String value = "";
        for(Cookie c : cookies) {
            if(value.length() > 0) {
                value += "; ";
            }
            value += c.getName() + "=" + c.getValue();
        }
        return value;
    }

    public static String post(String url, String content) throws Exception {
        return post(url, null, content, "utf-8");
    }

    public static String post(String url, JSONObject content) throws Exception {
        String param = getParamString(content);
        return post(url, null, param, "utf-8");
    }

    private static String getParamString(JSONObject content) {
        String param = "";
        if(content != null && content.size() > 0) {
            StringBuilder builder = new StringBuilder();
            content.forEach((k, v)->builder.append("&").append(k).append("=").append(v));
            param = builder.toString().replaceFirst("&", "");
        }
        return param;
    }

    public static String post(String url, Map<String, String> header, String content) throws Exception {
        return post(url, header, content, "utf-8");
    }

    public static String post(String url, Map<String, String> header, JSONObject content) throws Exception {
        String param = getParamString(content);
        return post(url, header, param, "utf-8");
    }

    private static String post(String url,
                               Map<String, String> header,
                               String content,
                               String enconding) throws Exception {
        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity responseEntity = null;
        try {
            httpClient = url.startsWith("https://") ? getSSLClient() :
                    HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            HttpPost post = new HttpPost(url);
            post.setConfig(requestConfig);
            if(header == null) { //默认ContentType.URLEncoded编码
                header = new HashMap<>();
                header.put("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
            }
            if(header.size() > 0) {
                header.forEach(post::setHeader);
            }
            StringEntity entity = new StringEntity(content, enconding);
            post.setEntity(entity);
            response = httpClient.execute(post);
            responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity, enconding);
        } catch(Exception e) {
            throw e;
        } finally {
            if(responseEntity != null) {
                EntityUtils.consume(responseEntity);
            }
            if(response != null) {
                response.close();
            }
            if(httpClient != null) {
                httpClient.close();
            }
        }
    }

    public static String put(String url, String content) throws Exception {
        return put(url, null, content, "utf-8");
    }

    public static String put(String url, Map<String, String> header, String content) throws Exception {
        return put(url, header, content, "utf-8");
    }

    private static String put(String url,
                              Map<String, String> header,
                              String content,
                              String enconding) throws Exception {
        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity responseEntity = null;
        try {
            if(url.startsWith("https://")) {
                httpClient = getSSLClient();
            } else {
                httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            }
            HttpPut post = new HttpPut(url);
            post.setConfig(requestConfig);
            if(header == null) { //默认ContentType.URLEncoded编码
                header = new HashMap<String, String>();
                header.put("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
            }
            if(header.size() > 0) {
                Iterator<Entry<String, String>> itr = header.entrySet().iterator();
                while(itr.hasNext()) {
                    Entry<String, String> ent = itr.next();
                    post.setHeader(ent.getKey(), ent.getValue());
                }
            }
            StringEntity entity = new StringEntity(content, enconding);
            post.setEntity(entity);
            response = httpClient.execute(post);
            responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity, enconding);
        } catch(Exception e) {
            throw e;
        } finally {
            if(responseEntity != null) {
                EntityUtils.consume(responseEntity);
            }
            if(response != null) {
                response.close();
            }
            if(httpClient != null) {
                httpClient.close();
            }
        }
    }

    public static String delete(String url) throws Exception {
        return delete(url, null, "utf-8");
    }

    public static String delete(String url, Map<String, String> header) throws Exception {
        return delete(url, header, "utf-8");
    }

    private static String delete(String url,
                                 Map<String, String> header,
                                 String enconding) throws Exception {
        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity responseEntity = null;
        try {
            if(url.startsWith("https://")) {
                httpClient = getSSLClient();
            } else {
                httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            }
            HttpDelete post = new HttpDelete(url);
            post.setConfig(requestConfig);
            if(header == null) { //默认ContentType.URLEncoded编码
                header = new HashMap<String, String>();
                header.put("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
            }
            if(header.size() > 0) {
                Iterator<Entry<String, String>> itr = header.entrySet().iterator();
                while(itr.hasNext()) {
                    Entry<String, String> ent = itr.next();
                    post.setHeader(ent.getKey(), ent.getValue());
                }
            }
            response = httpClient.execute(post);
            responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity, enconding);
        } catch(Exception e) {
            throw e;
        } finally {
            if(responseEntity != null) {
                EntityUtils.consume(responseEntity);
            }
            if(response != null) {
                response.close();
            }
            if(httpClient != null) {
                httpClient.close();
            }
        }
    }

    public static String get(String url) throws Exception {
        return get(url, null, "utf-8");
    }

    public static String get(String url, String encoding) throws Exception {
        return get(url, null, encoding);
    }

    private static String get(String url,
                              Map<String, String> header,
                              String encoding) throws Exception {
        return getEntity(url, header, encoding, String.class);
    }

    private static byte[] getByte(String url,
                                  Map<String, String> header
    ) throws Exception {
        return getEntity(url, header, null, byte[].class);
    }

    @SuppressWarnings("unchecked")
    private static <T> T getEntity(String url,
                                   Map<String, String> header,
                                   String encoding,
                                   Class<T> cls) throws Exception {
        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity responseEntity = null;
        try {
            if(url.startsWith("https://")) {
                httpClient = getSSLClient();
            } else {
                httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            }
            HttpGet get = new HttpGet(url);
            get.setConfig(requestConfig);
            if(header != null && header.size() > 0) {
                Iterator<Entry<String, String>> itr = header.entrySet().iterator();
                while(itr.hasNext()) {
                    Entry<String, String> ent = itr.next();
                    get.setHeader(ent.getKey(), ent.getValue());
                }
            }
            response = httpClient.execute(get);
            responseEntity = response.getEntity();
            if(cls.equals(String.class)) {
                return (T) EntityUtils.toString(responseEntity, encoding);
            } else if(cls.equals(byte[].class)) {
                return (T) EntityUtils.toByteArray(responseEntity);
            } else {
                return null;
            }
        } catch(Exception e) {
            throw e;
        } finally {
            if(responseEntity != null) {
                EntityUtils.consume(responseEntity);
            }
            if(response != null) {
                response.close();
            }
            if(httpClient != null) {
                httpClient.close();
            }
        }
    }

    private static CloseableHttpClient getSSLClient() {
        try {
            SSLContext sslContet = new org.apache.http.ssl.SSLContextBuilder()
                    .loadTrustMaterial(null, new TrustStrategy(){

                        @Override
                        public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                            return true;
                        }
                    }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContet);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public enum Method{
        GET, POST, PUT, DELETE
    }
}