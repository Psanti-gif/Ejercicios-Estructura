
public class Producto {
    
        String nombre;
        double precio;
        int stock;
        Producto(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }
    

    public static void main(String[] args) {
        // Matriz tienda A (2x2 ejemplo)
        Producto[][] tiendaA = {
            { new Producto("Leche", 1.5, 10), new Producto("Pan", 0.8, 5) },
            { new Producto("Azucar", 2.0, 3), new Producto("Cafe", 5.0, 4) }
        };
        // Matriz tienda B (2x2 ejemplo)
        Producto[][] tiendaB = {
            { new Producto("Pan", 0.8, 7), new Producto("Huevos", 0.2, 20) },
            { new Producto("Leche", 1.6, 6), new Producto("Mantequilla", 3.0, 2) }
        };

        // Aplanar ambas matrices a arrays temporales
        int tamañoMax = tiendaA.length * tiendaA[0].length + tiendaB.length * tiendaB[0].length;
        Producto[] temp = new Producto[tamañoMax];
        int cont = 0;
        // Copiar A
        for (int i = 0; i < tiendaA.length; i++) {
            for (int j = 0; j < tiendaA[i].length; j++) {
                temp[cont++] = new Producto(tiendaA[i][j].nombre, tiendaA[i][j].precio, tiendaA[i][j].stock);
            }
        }
        // Procesar B: si nombre existe en temp -> sumar stock, si no -> agregar
        for (int i = 0; i < tiendaB.length; i++) {
            for (int j = 0; j < tiendaB[i].length; j++) {
                Producto pB = tiendaB[i][j];
                int idxEncontrado = -1;
                for (int x = 0; x < cont; x++) {
                    if (temp[x].nombre.equalsIgnoreCase(pB.nombre)) {
                        idxEncontrado = x;
                        break;
                    }
                }
                if (idxEncontrado >= 0) {
                    // Sumar stock (mantenemos el precio de temp, si hay diferencia de precio se ignora en este ejemplo)
                    temp[idxEncontrado].stock += pB.stock;
                } else {
                    temp[cont++] = new Producto(pB.nombre, pB.precio, pB.stock);
                }
            }
        }

        // Resultado: temp[0..cont-1]
        System.out.println("Productos fusionados (nombre - precio - stock):");
        for (int i = 0; i < cont; i++) {
            System.out.println(temp[i].nombre + " - " + temp[i].precio + " - " + temp[i].stock);
        }
    }
}
