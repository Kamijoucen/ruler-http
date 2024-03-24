package com.kamijoucen.ruler.std.http.function;

import com.kamijoucen.ruler.function.RulerFunction;
import com.kamijoucen.ruler.runtime.RuntimeContext;
import com.kamijoucen.ruler.runtime.Scope;
import com.kamijoucen.ruler.value.BaseValue;

public class GetRsonFunction implements RulerFunction {

    @Override
    public Object call(RuntimeContext context, Scope scope, BaseValue self, Object... params) {
        return "GetJson";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

}
