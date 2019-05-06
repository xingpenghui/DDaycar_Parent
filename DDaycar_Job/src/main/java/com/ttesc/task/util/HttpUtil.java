package com.ttesc.task.util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/5/6 15:53
 */
public class HttpUtil {
    public static final String HTTP_GET="GET";
    public static final String HTTP_POST="POST";
    public static final String HTTP_PUT="PUT";
    public static final String HTTP_DELETE="DELETE";
    public static String getStr(String url)  {
     return http(HTTP_GET,url,null);
    }
    public static String getStr(String url,Map<String,Object> param)  {
        return http(HTTP_GET,url,param);
    }
    public static String postStr(String url,Map<String,Object> param){
        return http(HTTP_POST,url,param);
    }

    private static String http(String method,String url,Map<String,Object> param){
        try {
            String param_kv=tranStr(param);

            if(method.equals("GET")){
                url=url+"?"+param_kv;
            }
            HttpURLConnection httpURLConnection=(HttpURLConnection)(new URL(url).openConnection());
            httpURLConnection.setConnectTimeout(5000);
            if(method.equals("POST")){
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(method);
                OutputStream os=httpURLConnection.getOutputStream();
                os.write(param_kv.getBytes());
                os.flush();
            }
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()==200){
                InputStream is=httpURLConnection.getInputStream();
                String r=IOUtils.toString(is,"UTF-8");
                return r;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static String tranStr(Map<String,Object> map){
        if(map!=null && map.size()>0) {
            StringBuffer buffer = new StringBuffer();
            for (String k : map.keySet()) {
                buffer.append(k + "=" + map.get(k) + "&");
            }
            if (buffer.length() > 0) {
                buffer.deleteCharAt(buffer.length() - 1);
            }

            return buffer.toString();
        }else {
            return null;
        }
    }
    public static String postJson(String url,String json){
        try {

            HttpURLConnection httpURLConnection=(HttpURLConnection)(new URL(url).openConnection());
            httpURLConnection.setConnectTimeout(5000);

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                OutputStream os=httpURLConnection.getOutputStream();
                os.write(json.getBytes());
                os.flush();

            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()==200){
                InputStream is=httpURLConnection.getInputStream();
                String r=IOUtils.toString(is,"UTF-8");
                return r;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
