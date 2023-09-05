package com.beckwell.test;

import com.beckwell.springboot.annotation.HuawuqueSpringBootApplication;
import com.beckwell.springboot.configuration.HuawuqueSpringApplication;

@HuawuqueSpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        HuawuqueSpringApplication.run(TestApplication.class);
    }
}
