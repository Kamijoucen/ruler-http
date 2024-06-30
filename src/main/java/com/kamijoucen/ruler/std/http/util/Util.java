package com.kamijoucen.ruler.std.http.util;

import java.util.HashMap;
import java.util.Map;
import com.kamijoucen.ruler.std.http.model.ResponseC;

public class Util {

    public static Map<String, Object> buildResponseMap(ResponseC response) {
        Map<String, String> header = new HashMap<>();
        response.header.forEach((k, v) -> header.put(k, v.toString()));

        Map<String, Object> result = new HashMap<>();
        result.put("code", response.code);
        result.put("message", response.message);
        result.put("header", header);
        result.put("body", response.body);
        return result;
    }
}


