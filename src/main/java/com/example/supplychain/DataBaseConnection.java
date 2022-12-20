package com.example.supplychain;

import java.sql.*;
import java.util.Queue;
import java.util.SortedMap;

public class DataBaseConnection {

    public static final String databaseUrl = "jdbc:mysql://localhost:3306/supply_chain";  //schema name
    public static final String userName = "root";
    public static final String password = "Pranay@123";

    public Statement getStatement(){

        Statement statement = null;

        Connection conn;
        try{
            conn = DriverManager.getConnection(databaseUrl,userName,password);
            statement = conn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return statement;
    }

    public ResultSet getQueryTable(String query){
        Statement statement = getStatement();
        try {
            return statement.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//
//        DataBaseConnection dataBaseConnection = new DataBaseConnection();
//
//        ResultSet rs = dataBaseConnection.getQueryTable("SELECT email, first_name, last_name, city, mobile_no FROM CUSTOMER");
//
//        try {
//            while (rs.next()){
//                System.out.println(rs.getString("email")+" "+rs.getString("first_name")+" "+rs.getString("last_name")+" "+rs.getString("city")+" "+rs.getString("mobile_no"));
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
