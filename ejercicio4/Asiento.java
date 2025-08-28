
public class Asiento {
   
        int numero;
        String fila;
        double precio;
        Asiento(int numero, String fila, double precio) {
            this.numero = numero;
            this.fila = fila;
            this.precio = precio;
        }
        public String toString() {
            return "[" + fila + numero + " $" + precio + "]";
        }

    public static void main(String[] args) {
        // Ejemplo: 4 filas x 5 asientos por fila
        Asiento[][] teatro = new Asiento[4][5];
        // Llenar con precios desordenados por fila
        double[][] precios = {
            {20, 15, 25, 10, 18},
            {30, 28, 35, 29, 31},
            {12, 10, 14, 11, 13},
            {50, 45, 60, 55, 48}
        };
        for (int i = 0; i < teatro.length; i++) {
            for (int j = 0; j < teatro[i].length; j++) {
                teatro[i][j] = new Asiento(j + 1, "" + (char)('A' + i), precios[i][j]);
            }
        }

        System.out.println("Antes de ordenar (por fila):");
        imprimirTeatro(teatro);

        // Ordenar cada fila por precio ascendente usando bubble sort simple
        for (int i = 0; i < teatro.length; i++) {
            int n = teatro[i].length;
            for (int pass = 0; pass < n - 1; pass++) {
                for (int j = 0; j < n - 1 - pass; j++) {
                    if (teatro[i][j].precio > teatro[i][j + 1].precio) {
                        Asiento tmp = teatro[i][j];
                        teatro[i][j] = teatro[i][j + 1];
                        teatro[i][j + 1] = tmp;
                    }
                }
            }
        }

        System.out.println("\nDespués de ordenar (por fila, precio ascendente):");
        imprimirTeatro(teatro);
    }

    static void imprimirTeatro(Asiento[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}
