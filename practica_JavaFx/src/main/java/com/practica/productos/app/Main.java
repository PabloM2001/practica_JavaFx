package com.practica.productos.app;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        ProductoService servicio = new ProductoService();

        TextField campo = new TextField();
        TextArea area = new TextArea();
        area.setEditable(false);

        Button agregar = new Button("Agregar");
        Button eliminar = new Button("Eliminar");
        Button buscar = new Button("Buscar");

        agregar.setOnAction(e -> {
            servicio.agregar(new Producto(campo.getText()));

            String texto = "";
            for (Producto p : servicio.listar()) {
                texto += p.getNombre() + "\n";
            }
            area.setText(texto);
        });

        eliminar.setOnAction(e -> {
            servicio.eliminar(campo.getText());

            String texto = "";
            for (Producto p : servicio.listar()) {
                texto += p.getNombre() + "\n";
            }
            area.setText(texto);
        });

        buscar.setOnAction(e -> {
            Producto p = servicio.buscar(campo.getText());

            if (p != null) {
                area.setText("Encontrado: " + p.getNombre());
            } else {
                area.setText("Producto no encontrado");
            }
        });

        HBox botones = new HBox(10, agregar, eliminar, buscar);

        VBox layout = new VBox(10, campo, botones, area);

        Scene scene = new Scene(layout, 300, 200);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}