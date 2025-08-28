import java.util.Scanner;

public class producto {
    
        String nombre;
        double precio;
        int cantidad;
        producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = 5;
        int cols = 6;
        producto[][] almacen = new producto[filas][cols];

        // Llenar la matriz con productos de ejemplo Prod1..Prod30
        int k = 1;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                almacen[i][j] = new producto("Prod" + k, k * 1.0, k + 2);
                k++;
            }
        }
        // Colocar un producto conocido para poder buscarlo (ejemplo)
        almacen[1][2] = new producto("Manzana", 3.5, 10);

        System.out.print("Ingrese el nombre del producto a buscar: ");
        String buscado = sc.nextLine().trim();

        boolean encontrado = false;
        for (int i = 0; i < filas && !encontrado; i++) {
            for (int j = 0; j < cols; j++) {
                if (almacen[i][j].nombre.equalsIgnoreCase(buscado)) {
                    System.out.println("Producto '" + buscado + "' encontrado en:");
                    System.out.println(" fila " + i + ", columna " + j);
                    System.out.println(" fila " + (i + 1) + ", columna " + (j + 1));
                    System.out.println("Datos: precio = " + almacen[i][j].precio + ", cantidad = " + almacen[i][j].cantidad);
                    encontrado = true;
                    break;
                }
            }
        }
        if (!encontrado) {
            System.out.println("Producto '" + buscado + "' no encontrado en el almacén.");
        }

        sc.close();
    }
}
