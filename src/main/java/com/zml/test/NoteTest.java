package com.zml.test;

import java.util.HashMap;
import java.util.Map;
import com.aliyuncs.http.HttpResponse;

public class NoteTest {
public static void main(String[] args) {
    String host = "https://aliyun.chanyoo.net";
    String path = "/sendsms";
    String method = "GET";
    String appcode = "你自己的AppCode";
    Map<String, String> headers = new HashMap<String, String>();
    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
    headers.put("Authorization", "APPCODE " + appcode);
    Map<String, String> querys = new HashMap<String, String>();
    querys.put("mobile", "13333333333");
    querys.put("content", "您的手机号：13333333333，验证码：110426，请及时完成验证，如不是本人操作请忽略。【阿里云市场】");


    try {
    	/**
    	* 重要提示如下:
    	* HttpUtils请从
    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
    	* 下载
    	*
    	* 相应的依赖请参照
    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
    	*/
    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
    	System.out.println(response.toString());
    	//获取response的body
    	//System.out.println(EntityUtils.toString(response.getEntity()));
    } catch (Exception e) {
    	e.printStackTrace();
    }
}
}
