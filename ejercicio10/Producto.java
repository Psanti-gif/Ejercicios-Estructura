

public class Producto {
    
        String nombre;
        boolean oferta;
        Producto(String nombre, boolean oferta) {
            this.nombre = nombre;
            this.oferta = oferta;
        }
    

    public static void main(String[] args) {
        // Ejemplo: matriz 3x3
        Producto[][] productos = {
            { new Producto("P1", true), new Producto("P2", false), new Producto("P3", true) },
            { new Producto("P4", false), new Producto("P5", true), new Producto("P6", false) },
            { new Producto("P7", true), new Producto("P8", false), new Producto("P9", true) }
        };

        int contadorOfertas = 0;
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos[i].length; j++) {
                if (productos[i][j].oferta) contadorOfertas++;
            }
        }

        System.out.println("Total de productos en oferta: " + contadorOfertas);
    }
}
