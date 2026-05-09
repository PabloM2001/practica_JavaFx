
package com.practica.productos.app;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label label = new Label("Hola JavaFX");

        VBox root = new VBox(label);

        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Mi primera app JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}