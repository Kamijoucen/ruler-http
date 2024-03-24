package com.kamijoucen.ruler.std.http.function;

import com.kamijoucen.ruler.function.RulerFunction;
import com.kamijoucen.ruler.runtime.RuntimeContext;
import com.kamijoucen.ruler.runtime.Scope;
import com.kamijoucen.ruler.std.http.HttpClient;
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
        return HttpClient.get(params[0].toString());
    }

    @Override
    public String getName() {
        return "Get";
    }

}
