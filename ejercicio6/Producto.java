
public class Producto {
    
        String nombre;
        double precio;
        boolean disponible;
        Producto(String nombre, double precio, boolean disponible) {
            this.nombre = nombre;
            this.precio = precio;
            this.disponible = disponible;
        }
        public String toString() {
            return nombre + "($" + precio + ") disp=" + disponible;
        }
    

    public static void main(String[] args) {
        Producto[][] estanterias = {
            { new Producto("A", 1.0, true), new Producto("B", 2.0, false), new Producto("C", 1.5, true) },
            { new Producto("D", 2.5, true), new Producto("E", 1.2, false), new Producto("F", 3.0, true) },
            { new Producto("G", 0.9, false), new Producto("H", 4.5, true), new Producto("I", 2.2, true) }
        };

        // Queremos devolver una nueva matriz (jagged) por fila con solo productos disponibles
        Producto[][] filtradoPorFila = new Producto[estanterias.length][];
        for (int i = 0; i < estanterias.length; i++) {
            // contar disponibles en la fila i
            int cuenta = 0;
            for (int j = 0; j < estanterias[i].length; j++) {
                if (estanterias[i][j].disponible) cuenta++;
            }
            // crear sub-array con tamaño exacto
            filtradoPorFila[i] = new Producto[cuenta];
            int p = 0;
            for (int j = 0; j < estanterias[i].length; j++) {
                if (estanterias[i][j].disponible) {
                    filtradoPorFila[i][p++] = estanterias[i][j];
                }
            }
        }

        // Imprimir resultado
        System.out.println("Productos disponibles por fila (nueva matriz jagged):");
        for (int i = 0; i < filtradoPorFila.length; i++) {
            System.out.print("Fila " + i + ": ");
            for (int j = 0; j < filtradoPorFila[i].length; j++) {
                System.out.print(filtradoPorFila[i][j].nombre + " ");
            }
            System.out.println();
        }
    }
}
