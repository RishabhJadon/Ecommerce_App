package com.example.ecommerce;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;

import javax.xml.transform.Result;
import java.sql.ResultSet;

public class Product {
    private SimpleIntegerProperty id;

    private SimpleStringProperty name;

    private SimpleDoubleProperty price;

    public Product(int id, String name, int price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
    }

    public static ObservableList<Product> getAllProduct(){
        String selectAllProducts = "select id,name,price from product";
        return fetchProductData(selectAllProducts);
    }

    public static ObservableList<Product> fetchProductData(String query){
        ObservableList<Product> data = FXCollections.observableArrayList();
        dBConnection dBConnection = new dBConnection();
        try
        {
            ResultSet rs = dBConnection.getQueryTable(query);
            while(rs.next())
            {
                Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getInt("price"));
                data.add(product);
            }
            return data;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public double getPrice() {
        return price.get();
    }

}
