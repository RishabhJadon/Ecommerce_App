package com.example.ecommerce;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ECommerce extends Application {

    userInterface UI = new userInterface();
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(UI.createContent());
        stage.setTitle("ECommerce");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}