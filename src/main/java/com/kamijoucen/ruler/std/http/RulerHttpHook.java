package com.kamijoucen.ruler.std.http;

import java.util.ArrayList;
import java.util.List;
import com.kamijoucen.ruler.config.RulerConfiguration;
import com.kamijoucen.ruler.config.option.ConfigModule;
import com.kamijoucen.ruler.function.RulerFunction;
import com.kamijoucen.ruler.plugin.spi.ConfigurationHook;
import com.kamijoucen.ruler.std.http.config.HttpImportLoader;
import com.kamijoucen.ruler.std.http.function.CustomGetFunction;
import com.kamijoucen.ruler.std.http.function.GetFunction;

public class RulerHttpHook implements ConfigurationHook {

    public static final String STD_HTTP = "http";

    @Override
    public void hook(RulerConfiguration config) {
        // 注册模块
        registerModule(config);
        // 注册http导入
        registerHttpImport(config);
    }

    private void registerModule(RulerConfiguration config) {
        List<RulerFunction> functions = new ArrayList<>();
        functions.add(new GetFunction());
        functions.add(new CustomGetFunction());
        config.getConfigModuleManager()
                .registerModule(ConfigModule.createFunctionModule(STD_HTTP, functions));
    }

    private void registerHttpImport(RulerConfiguration config) {
        config.getCustomImportLoadManager().registerCustomImportLoader(new HttpImportLoader());
    }

}
