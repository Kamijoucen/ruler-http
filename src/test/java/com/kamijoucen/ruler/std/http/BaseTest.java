package com.kamijoucen.ruler.std.http;

import com.kamijoucen.ruler.config.RulerConfiguration;
import com.kamijoucen.ruler.config.impl.RulerConfigurationImpl;
import com.kamijoucen.ruler.module.ShellRunner;

public class BaseTest {

    private static final RulerConfiguration configuration = new RulerConfigurationImpl();


    public static void main(String[] args) {
        ShellRunner runner = new ShellRunner(configuration);
        runner.run();
    }

}
