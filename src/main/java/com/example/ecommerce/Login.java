package com.example.ecommerce;

import java.sql.ResultSet;
import java.sql.SQLOutput;

public class Login {
    public Customer customerLogin(String userName,String password)
    {
        String query = "Select * from customer where email = '" + userName + "' and password = '" + password + "'";
        dBConnection connection = new dBConnection();
        try {
            ResultSet rs = connection.getQueryTable(query);
            if(rs.next())
            {
                return new Customer(rs.getInt("id"),
                        rs.getString("name"),rs.getString("email"),
                        rs.getString("mobile"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
     Login login = new Login();
     Customer customer = login.customerLogin("RIHABHJADON@GMAIL.COM","RISHABH10");
        System.out.println("welcome :" + customer.getName());
        //System.out.println(login.customerLogin("RIHABHJADON@GMAIL.COM","RISHABH10"));
    }
}
