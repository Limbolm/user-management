package com.ray.userCenter.util;

import com.ray.userCenter.exception.ParameterException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Administrator on 2017/12/10 0010.
 */

@Component
public class TokenUtil {
    @Value("${token.salt}")
    private String tokenSalt;

    public String getLoginToken(String userId) throws Exception{
        String loginDate = String.valueOf(new Date().getTime());
        Map<String,Object> srcData = new HashMap<String, Object>();
        srcData.put("userId",userId);
        srcData.put("loginDate",loginDate);
        if(null == srcData){
             throw new ParameterException("传入参数为空");
        }
        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(srcData.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>(){
            //升序排序
            public int compare(Map.Entry<String,Object> o1, Map.Entry<String,Object> o2){
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        StringBuffer srcSb = new StringBuffer();
        for(Map.Entry<String , Object>srcAtom : list){
            srcSb.append(String.valueOf(srcAtom.getValue()));
        }
        System.out.println("身份验证加密前字符串："+srcSb.toString());
        //计算token
        String token = MD5Utils.MD5Encrypt(srcSb.toString(),tokenSalt);
//      System.out.println(cToken);//for test
        return token;
    }

    public StringBuffer getSumbitToken(String userId) throws Exception{
        String loginDate = String.valueOf(new Date().getTime());
        Map<String,Object> srcData = new HashMap<String, Object>();
        srcData.put("userId",userId);
        srcData.put("loginDate",loginDate);
        if(null == srcData){
            throw new ParameterException("传入参数为空");
        }
        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(srcData.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>(){
            //升序排序
            public int compare(Map.Entry<String,Object> o1, Map.Entry<String,Object> o2){
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        StringBuffer srcSb = new StringBuffer();
        for(Map.Entry<String , Object>srcAtom : list){
            srcSb.append(String.valueOf(srcAtom.getValue()));
        }
        System.out.println("身份验证加密前字符串："+srcSb.toString());
        //计算token
        String token = MD5Utils.MD5Encrypt(userId,tokenSalt);
        srcSb.append(token);
//      System.out.println(cToken);//for test
        return srcSb;
    }

}
