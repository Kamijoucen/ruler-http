package com.kamijoucen.ruler.std.http.function;

import java.util.Map;
import com.kamijoucen.ruler.function.RulerFunction;
import com.kamijoucen.ruler.runtime.RuntimeContext;
import com.kamijoucen.ruler.runtime.Scope;
import com.kamijoucen.ruler.std.http.HttpClient;
import com.kamijoucen.ruler.util.CollectionUtil;
import com.kamijoucen.ruler.value.BaseValue;

public class GetFunction implements RulerFunction {

    @Override
    public Object call(RuntimeContext context, Scope scope, BaseValue self, Object... params) {
        if (params == null || params.length == 0) {
            return null;
        }
        if (!(params[0] instanceof String)) {
            throw new RuntimeException("Get function need a string param.");
        }
        String url = params[0].toString();
        if (params.length == 2) {
            url += buildUrlParams(params[1]);
        }
        return HttpClient.get(url);
    }

    @Override
    public String getName() {
        return "Get";
    }

    private String buildUrlParams(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return obj.toString().startsWith("?") ? obj.toString() : "?" + obj.toString();
        }
        if (!(obj instanceof Map<?, ?>)) {
            return "";
        }
        Map<?, ?> map = (Map<?, ?>) obj;
        if (CollectionUtil.isEmpty(map)) {
            return "";
        }
        StringBuilder sb = new StringBuilder("?");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
