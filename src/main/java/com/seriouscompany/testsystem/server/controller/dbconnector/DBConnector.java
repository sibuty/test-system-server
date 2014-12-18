package com.seriouscompany.testsystem.server.controller.dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

    public static void ex() {

        String user = "MARKS";//Логин пользователя
        String password = "Qa123";//Пароль пользователя
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";//URL адрес
        String driver = "oracle.jdbc.driver.OracleDriver";//Имя драйвера
        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection c = null;//Соединение с БД
        try {
            c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
            Statement st = c.createStatement();//Готовим запрос
            ResultSet rs = st.executeQuery("select * from MARKS");//Выполняем запрос к БД, результат в переменной rs
            rs.next();
            System.out.println(rs.getString(5));
//               while(rs.next()){
//                    System.out.println(rs.getString("Login"));//Последовательно для каждой строки выводим значение из колонки ColumnName
//               }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Обязательно необходимо закрыть соединение
            try {
                if (c != null) {
                    c.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
