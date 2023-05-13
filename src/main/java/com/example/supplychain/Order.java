package com.example.supplychain;

public class Order {
    public static boolean placeOrder(String customerEmail, Product product){

        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        String query = String.format("INSERT INTO orders (customer_id, product_id) VALUES ((SELECT customer_id FROM customer WHERE email = '%s'),%s)", customerEmail,product.getId());
        int rowCount = 0;
        try{
            rowCount = dataBaseConnection.executeUpdateQuery(query);
        }
        catch (Exception e){
          e.printStackTrace();
        }
        return rowCount!=0;
    }
}
