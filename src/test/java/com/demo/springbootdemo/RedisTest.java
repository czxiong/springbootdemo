package com.demo.springbootdemo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.springbootdemo.util.HttpAPIService;
import com.demo.springbootdemo.util.HttpResult;
import com.demo.springbootdemo.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private HttpAPIService httpAPIService;

    @Resource
    private RedisUtils redisUtils;

    @Test
    public void test() throws Exception{
        String url = "http://10.8.46.62/httpapi/services.ashx";
        String param1 = "{\n" +
                "    \"requestId\": \"685D3014C59A6172E053BF0012AC85F4\",\n" +
                "    \"securityToken\": \"\",\n" +
                "    \"modularCode\": \"\",\n" +
                "    \"interfaceType\": \"JC3_JK01\",\n" +
                "    \"actionCode\": \"JC3_JK01_A01\",\n" +
                "    \"requestTime\": \"2018-06-13 09:02:03\",\n" +
                "    \"verifyCode\": \"\",\n" +
                "\t\"requestParams\":{\n" +
                "\t\t\n" +
                "\t}\n" +
                "}";
        Map<String,Object> map1 = new HashMap<>();
        map1.put("data",param1);
        HttpResult httpResult1 = httpAPIService.doPost(url,map1);
        redisUtils.set("addressArea", JSONObject.parseObject(httpResult1.getBody()).getJSONArray("responseContent").toString());

        String param2 = "{\n" +
                "    \"requestId\": \"685D3014C59A6172E053BF0012AC85F4\",\n" +
                "    \"securityToken\": \"\",\n" +
                "    \"modularCode\": \"\",\n" +
                "    \"interfaceType\": \"JC3_JK01\",\n" +
                "    \"actionCode\": \"JC3_JK01_B01\",\n" +
                "    \"requestTime\": \"2018-06-13 09:02:03\",\n" +
                "    \"verifyCode\": \"\",\n" +
                "    \"requestParams\": {\n" +
                "        \"areaCode\": \"430000000000\"\n" +
                "    }\n" +
                "}";
        Map<String,Object> map2 = new HashMap<>();
        map2.put("data",param2);
        HttpResult httpResult2 = httpAPIService.doPost(url,map2);
        redisUtils.set("drugOrg",JSONObject.parseObject(httpResult2.getBody()).getJSONArray("responseContent").toString());

        String param3 = "{\n" +
                "    \"requestId\": \"685D3014C59A6172E053BF0012AC85F4\",\n" +
                "    \"securityToken\": \"\",\n" +
                "    \"modularCode\": \"\",\n" +
                "    \"interfaceType\": \"JC3_JK01\",\n" +
                "    \"actionCode\": \"JC3_JK01_D06\",\n" +
                "    \"requestTime\": \"2018-06-13 09:02:03\",\n" +
                "    \"verifyCode\": \"\",\n" +
                "    \"requestParams\": {\n" +
                "\t\t\n" +
                "    }\n" +
                "}";
        Map<String,Object> map3 = new HashMap<>();
        map3.put("data",param3);
        HttpResult httpResult3 = httpAPIService.doPost(url,map3);
        redisUtils.set("basicData",JSONObject.parseObject(httpResult3.getBody()).getJSONArray("responseContent").toString());
    }

    @Test
    public void test1(){
        if(redisUtils.exists("basicData")){
            String basicData = redisUtils.get("basicData").toString();
            JSONArray basicDataArr = JSONArray.parseArray(basicData);
            String classKey = "DIC_ZZLBM";
            for(int i =0;i<basicDataArr.size();i++){
                if(classKey.equals(basicDataArr.getJSONObject(i).getString("classValue"))){
                    System.out.println(basicDataArr.getJSONObject(i).getJSONArray("items"));
                }
            }

        }else{
            System.out.println("redis中不存在该key");
        }


    }



}
