package com.example.supplychain;

public class SignUp {

    public static boolean customerSignUp(String first_name, String last_name, String city, String mobile_no, String email, String password)
    {
        if (first_name.equals("") || last_name.equals("") || city.equals("") || mobile_no.equals("") || email.equals("") || password.equals(""))
        {
            return false;
        }

        String query = "INSERT INTO customer (first_name,last_name,city,mobile_no,email,password) VALUES (' " + first_name + "','" + last_name + "','" + city + "','" + mobile_no + "','" + email + "','" + password + "')";

        try
        {
            DataBaseConnection dbCon = new DataBaseConnection();

            int i = dbCon.executeUpdateQuery(query);
            if (i > 0) {
                return true;
            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
        return false;

    }
}

