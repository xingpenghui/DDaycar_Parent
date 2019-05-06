package com.ttesc.common.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.json.JSONObject;
import java.util.Objects;

/**
 *@Author feri
 *@Date Created in 2019/4/29 09:56
 */
public class AliyunSmsUtil {
    //发送验证码
    public static boolean sendSms(String phone, int code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIhTvqTSmlmjeQ", "X7X9w0Ck5GEIWgP9tl0Q6sgmFjQuMv");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "来自邢朋辉的短信");
        request.putQueryParameter("TemplateCode", "SMS_114390520");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
           String json=response.getData();
            System.out.println(json);
           JSONObject jsonObject=new JSONObject(json);

           if(Objects.equals(jsonObject.getString("Code"),"OK")){
               return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //发送预约信息 type 1验证码 2预约信息 3成交信息
    public static boolean sendSms(String phone,String tem,int type,Object obj) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "来自邢朋辉的短信");
        request.putQueryParameter("TemplateCode", tem);
        switch (type){
            case 1:
                request.putQueryParameter("TemplateParam", "{\"code\":\"" + obj + "\"}");
                break;
            case 2:
                request.putQueryParameter("TemplateParam", "{\"name\":\"" + obj + "\"}");
                break;
        }

        try {
            CommonResponse response = client.getCommonResponse(request);
            String json=response.getData();
            JSONObject jsonObject=new JSONObject(json);
            if(Objects.equals(jsonObject.getString("code"),"OK")){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
