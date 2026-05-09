
package com.practica.productos.app;



import java.util.ArrayList; 
import java.util.List;

public class ProductoService {

    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto p) {
        productos.add(p);
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }
}