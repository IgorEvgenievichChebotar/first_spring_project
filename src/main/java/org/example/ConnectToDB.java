package org.example;

import org.springframework.context.annotation.Scope;

import javax.annotation.PreDestroy;

/*@Component*/
public class ConnectToDB {
    private static final ConnectToDB connection = new ConnectToDB();

    private ConnectToDB() {
        System.out.println("the connection is established");
    }

    @PreDestroy
    private void closeConnection() {
        System.out.println("connection closed");
    }

    public static ConnectToDB getConnection(){
        return connection;
    }

}
/*
class Test{
    public static void main(String[] args) {
        ConnectToDB con = ConnectToDB2.getConnection();
        ConnectToDB con2 = ConnectToDB2.getConnection();
        System.out.println(con);
        System.out.println(con2);
    }
}*/
