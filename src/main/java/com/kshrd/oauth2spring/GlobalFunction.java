package com.kshrd.oauth2spring;

import java.util.HashMap;
import java.util.Map;

public class GlobalFunction 
{

    public static Map<String, Object> getResponseBody(String msg, Object data) 
    {
        Map<String, Object> response = new HashMap<>();
        response.put("MSG", msg);
        response.put("DATA", data);
     
        return response;
    }
   
    public static Map<String, Object> getResponseBody(String msg, Object data,Boolean status ) 
    {
        Map<String, Object> response = new HashMap<>();
        response.put("MSG", msg);
        response.put("DATA", data);
        response.put("STATUS",status);
        return response;
    }
   
    
}