package com.example.ecommerce;

import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class order {

    public static boolean placeOrder(Customer customer,Product product)
    {
        String groupOrderId = "select max(group_order_id)+1 id from orders";
        dBConnection dBConnection = new dBConnection();
        try
        {
            ResultSet rs = dBConnection.getQueryTable(groupOrderId);
            if(rs.next())
            {
                String placeOrder = "insert into orders(group_order_id, customer_id, product_id) values("+ rs.getInt("id")+","+customer.getId()+"," + product.getId()+ ")";
                return dBConnection.updateDatabase(placeOrder) != 0;
            }
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        return false;
    }

    public static int placeMultipleOrder(Customer customer, ObservableList<Product> productList)
    {
        String groupOrderId = "select max(group_order_id)+1 id from orders";
        dBConnection dBConnection = new dBConnection();
        try
        {
            ResultSet rs = dBConnection.getQueryTable(groupOrderId);
            int count = 0;
            if(rs.next())
            {
                for(Product product: productList)
                {
                    String placeOrder = "insert into orders(group_order_id, customer_id, product_id) values("+ rs.getInt("id")+","+customer.getId()+"," + product.getId()+ ")";
                    count += dBConnection.updateDatabase(placeOrder);
                }

                return count;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}
