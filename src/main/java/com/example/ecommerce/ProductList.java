package com.example.ecommerce;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ProductList {

    private static TableView<Product> productTable;

    public static VBox createTable(ObservableList<Product> data){
        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price = new TableColumn("PRICE");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        productTable = new TableView<>();
        productTable.setItems(data);
        productTable.getColumns().addAll(id,name,price);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(50));
        vBox.getChildren().addAll(productTable);
        return vBox;
    }

    public static VBox getDummyTable()
    {
        ObservableList<Product> data = FXCollections.observableArrayList();
        data.add(new Product(2,"IPhone",44546));
        data.add(new Product(5,"Laptoop",34353));
        return createTable(data);
    }

    public static VBox getAllProducts(){
        ObservableList<Product> data = Product.getAllProduct();
        return createTable(data);
    }

    public Product getSelectedProduct(){
        return productTable.getSelectionModel().getSelectedItem();
    }

    public VBox getProductsInCart(ObservableList<Product> data)
    {
        return createTable(data);
    }
}
