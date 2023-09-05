package com.beckwell.springboot.configuration;

import com.beckwell.springboot.annotation.HuawuqueConditionalOnClass;
import com.beckwell.springboot.webserver.JettyWebServer;
import com.beckwell.springboot.webserver.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceAutoConfiguration implements AutoConfiguration{

    @Bean
    @HuawuqueConditionalOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer(){
        return new TomcatWebServer();
    }

    @Bean
    @HuawuqueConditionalOnClass("org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer(){
        return new JettyWebServer();
    }
}
