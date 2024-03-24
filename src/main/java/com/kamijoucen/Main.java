package com.kamijoucen;

import com.kamijoucen.ruler.config.RulerConfiguration;
import com.kamijoucen.ruler.config.impl.RulerConfigurationImpl;
import com.kamijoucen.ruler.module.ShellRunner;

public class Main {
    public static void main(String[] args) {

        RulerConfiguration configuration = new RulerConfigurationImpl();

        ShellRunner runner = new ShellRunner(configuration);
        runner.run();

        System.out.println(configuration);
    }
}