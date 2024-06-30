package com.kamijoucen.ruler.std.http.function;

import java.util.Map;
import com.kamijoucen.ruler.function.RulerFunction;
import com.kamijoucen.ruler.runtime.RuntimeContext;
import com.kamijoucen.ruler.runtime.Scope;
import com.kamijoucen.ruler.std.http.HttpClient;
import com.kamijoucen.ruler.std.http.model.RequestC;
import com.kamijoucen.ruler.std.http.model.ResponseC;
import com.kamijoucen.ruler.std.http.util.Util;
import com.kamijoucen.ruler.value.BaseValue;

public class CustomPostFunction implements RulerFunction {

    @Override
    public Object call(RuntimeContext ctx, Scope scope, BaseValue self, Object... param) {
        if (param == null || param.length == 0) {
            return null;
        }
        Map<?, ?> paramMap = (Map<?, ?>) param[0];
        if (paramMap == null) {
            return null;
        }
        // url
        String url = paramMap.get("url").toString();
        // request header
        Map<?, ?> header = (Map<?, ?>) paramMap.get("header");
        // body
        String body = paramMap.get("body").toString();
        // 发送请求
        ResponseC resp = HttpClient.post(new RequestC(url, header, body));
        if (resp == null) {
            return null;
        }

        return Util.buildResponseMap(resp);
    }

    @Override
    public String getName() {
        return "PostC";
    }
}
