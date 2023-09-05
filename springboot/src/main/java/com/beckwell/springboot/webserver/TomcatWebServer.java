package com.beckwell.springboot.webserver;

public class TomcatWebServer implements WebServer{
    @Override
    public void startWeb() {
        System.out.println("启动tomcat");
    }
}
