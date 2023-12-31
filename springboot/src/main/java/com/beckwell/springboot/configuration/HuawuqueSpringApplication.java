package com.beckwell.springboot.configuration;

import com.beckwell.springboot.webserver.WebServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;

public class HuawuqueSpringApplication {

    //创建一个Spring容器
    //创建Tomcat对象
    //生成DispatcherServlet对象，并且和前面创建出来的Spring容器进行绑定
    //将DispatcherServlet添加到Tomcat中
    //启动Tomcat
    public static void run(Class clazz){

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(clazz);
        applicationContext.refresh();

//        startTomcat(applicationContext);
        WebServer webServer = getWebServer(applicationContext);
        webServer.startWeb();
    }

    /**
     * 通过getWebServer方法从Spring容器中获取WebServer类型的Bean
     * 调用WebServer对象的start方法
     * @param applicationContext
     * @return
     */
    private static WebServer getWebServer(WebApplicationContext applicationContext) {
        Map<String, WebServer> beansOfType = applicationContext.getBeansOfType(WebServer.class);
        if(beansOfType.isEmpty()){
            throw new NullPointerException();
        }
        if(beansOfType.size()>1){
            throw new IllegalStateException();
        }
        return beansOfType.values().stream().findFirst().get();
    }

//    public static void startTomcat(WebApplicationContext applicationContext){
//
//        Tomcat tomcat = new Tomcat();
//
//        Server server = tomcat.getServer();
//        Service service = server.findService("Tomcat");
//
//        Connector connector = new Connector();
//        connector.setPort(8081);
//
//        Engine engine = new StandardEngine();
//        engine.setDefaultHost("localhost");
//
//        Host host = new StandardHost();
//        host.setName("localhost");
//
//        String contextPath = "";
//        Context context = new StandardContext();
//        context.setPath(contextPath);
//        context.addLifecycleListener(new Tomcat.FixContextListener());
//
//        host.addChild(context);
//        engine.addChild(host);
//
//        service.setContainer(engine);
//        service.addConnector(connector);
//
//        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(applicationContext));
//        context.addServletMappingDecoded("/*", "dispatcher");
//
//        try {
//            tomcat.start();
//        } catch (LifecycleException e) {
//            e.printStackTrace();
//        }
//
//    }
}
