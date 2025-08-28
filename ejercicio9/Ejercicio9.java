

public class Ejercicio9 {
    public static void main(String[] args) {
        // Nombres de vendedores
        String[] vendedores = { "Carlos", "María", "Juan", "Lucía", "Andrés" };

        // Matriz 5x12 con ventas por mes (ejemplo)
        double[][] ventas = {
            {120, 110, 130, 115, 140, 150, 160, 135, 145, 155, 165, 170}, // Carlos
            {100, 90, 95, 120, 110, 105, 115, 130, 125, 140, 150, 155},   // María
            {200, 180, 190, 210, 220, 205, 215, 225, 230, 240, 250, 260}, // Juan
            {80, 85, 90, 95, 100, 110, 120, 115, 105, 95, 100, 110},     // Lucía
            {150, 160, 155, 145, 148, 152, 158, 162, 168, 170, 175, 180} // Andrés
        };

        double maxVenta = -1;
        int idxMax = -1;

        for (int i = 0; i < ventas.length; i++) {
            double suma = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                suma += ventas[i][j];
            }
            System.out.println("Vendedor: " + vendedores[i] + " - Venta anual: " + suma);
            if (suma > maxVenta) {
                maxVenta = suma;
                idxMax = i;
            }
        }

        System.out.println("\nEl vendedor con mayor venta anual es: " + vendedores[idxMax] + " con " + maxVenta);
    }
}
