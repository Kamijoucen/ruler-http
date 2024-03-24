package com.kamijoucen.ruler.std.http;

import java.util.ArrayList;
import java.util.List;
import com.kamijoucen.ruler.config.RulerConfiguration;
import com.kamijoucen.ruler.config.option.ConfigModule;
import com.kamijoucen.ruler.function.RulerFunction;
import com.kamijoucen.ruler.plugin.spi.ConfigurationHook;
import com.kamijoucen.ruler.std.http.function.GetFunction;

public class RulerHttpHook implements ConfigurationHook {

    public static final String STD_HTTP = "http";

    @Override
    public void hook(RulerConfiguration config) {
        List<RulerFunction> functions = new ArrayList<>();
        functions.add(new GetFunction());

        config.getConfigModuleManager().registerModule(ConfigModule.createFunctionModule(STD_HTTP, functions));
    }

}