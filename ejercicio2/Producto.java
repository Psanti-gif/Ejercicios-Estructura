import java.util.Scanner;

public class Producto {
    
        String nombre;
        double precio;
        int cantidad;
        Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }
    

    public static void main(String[] args) {
        // Ejemplo: matriz 3x4 de productos con cantidades
        Producto[][] tienda = {
            { new Producto("A", 1.0, 5), new Producto("B", 2.0, 3), new Producto("C", 1.5, 7), new Producto("D", 3.0, 0) },
            { new Producto("E", 2.5, 10), new Producto("F", 0.9, 2), new Producto("G", 4.0, 1), new Producto("H", 1.1, 4) },
            { new Producto("I", 3.3, 6), new Producto("J", 2.2, 8), new Producto("K", 5.0, 0), new Producto("L", 1.8, 9) }
        };

        int total = 0;
        for (int i = 0; i < tienda.length; i++) {
            for (int j = 0; j < tienda[i].length; j++) {
                total += tienda[i][j].cantidad;
            }
        }

        System.out.println("Inventario total (suma de cantidades): " + total);
    }
}
