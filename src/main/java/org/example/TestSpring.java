package org.example;

import config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ConnectToDB connection = context.getBean("connectToDB", ConnectToDB.class);
        ConnectToDB connection2 = context.getBean("connectToDB", ConnectToDB.class);

        System.out.println(connection == connection2);

        context.close();

    }
}
