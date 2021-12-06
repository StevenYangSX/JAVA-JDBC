package com.atguigu.connection;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ConnectionTest test1 = new ConnectionTest();
        Connection conn1 = test1.testConnection1();
        System.out.println("connection 1  ==>"+conn1);

        Connection conn2 = test1.testConnection2();
        System.out.println("connection 2  ==>"+conn2);


    }


    //java mysql database connection
    public  Connection   testConnection1() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user","steven");
        info.setProperty("password","123456");
        Connection conn = driver.connect(url,info);
        return conn;
    }

    //链接数据库 方式二
    public Connection testConnection2() throws ClassNotFoundException, NoSuchMethodException,
                                        IllegalAccessException, InvocationTargetException,
                                            InstantiationException, SQLException {
        //1. 获取driver实现类对象，利用反射
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        //2. connection info
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user","steven");
        info.setProperty("password","123456");

        Connection conn = driver.connect(url,info);
        System.out.println(conn);
        return conn;
    }

}
