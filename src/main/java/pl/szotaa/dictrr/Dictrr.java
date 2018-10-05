package pl.szotaa.dictrr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Dictrr {

    private static final String HTTP_SERVER_BEAN_NAME = "httpServer";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DictrrConfig.class);
        HttpServer httpServer = ctx.getBean(HTTP_SERVER_BEAN_NAME, HttpServer.class);
        httpServer.start();
        ctx.close();
    }
}
