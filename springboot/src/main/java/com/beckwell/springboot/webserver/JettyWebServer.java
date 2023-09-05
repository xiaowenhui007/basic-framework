package com.beckwell.springboot.webserver;

public class JettyWebServer implements WebServer{
    @Override
    public void startWeb() {
        System.out.println("启动jetty");
    }
}
