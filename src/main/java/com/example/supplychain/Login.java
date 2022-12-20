package com.example.supplychain;

import java.sql.ResultSet;

public class Login {

    public boolean customerLogin(String email, String password){
        String query = String.format("SELECT * FROM customer WHERE email = '%s' AND password = '%s' ",email,password);

        try{
            DataBaseConnection dataBaseConnection = new DataBaseConnection();

            ResultSet rs = dataBaseConnection.getQueryTable(query);

            if(rs !=null && rs.next()){
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
//    public static void main(String[] args) {
//
//        Login login = new Login();
//        System.out.println(login.customerLogin("pranayrayke@gmail.com", "Pranay@123"));
//
//    }
}
