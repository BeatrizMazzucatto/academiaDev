package com.academiadev.app;

import com.academiadev.config.AppConfig;
import com.academiadev.controller.CliController;
import com.academiadev.util.InitialData;

public class Main {
    public static void main(String[] args) {
        InitialData.populate();
        
        CliController controller = AppConfig.build();
        
        controller.start();
    }
}
