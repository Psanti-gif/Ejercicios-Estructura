public class Producto {
    
        String nombre;
        double peso;
        String categoria;
        Producto(String nombre, double peso, String categoria) {
            this.nombre = nombre;
            this.peso = peso;
            this.categoria = categoria;
        }
        public String toString() {
            return nombre + "(" + categoria + ")";
        }

    public static void main(String[] args) {
        // Lista simple de productos con categorías
        Producto[] lista = {
            new Producto("Arroz", 1.0, "Alimentos"),
            new Producto("Atun", 0.2, "Alimentos"),
            new Producto("Jabon", 0.3, "Limpieza"),
            new Producto("Shampoo", 0.5, "Limpieza"),
            new Producto("Camiseta", 0.2, "Ropa"),
            new Producto("Pantalon", 0.7, "Ropa"),
            new Producto("Leche", 1.0, "Alimentos")
        };

        // Encontrar categorías únicas (array temporal)
        String[] categorias = new String[lista.length];
        int catCount = 0;
        for (int i = 0; i < lista.length; i++) {
            String cat = lista[i].categoria;
            int idx = -1;
            for (int j = 0; j < catCount; j++) if (categorias[j].equals(cat)) { idx = j; break; }
            if (idx == -1) categorias[catCount++] = cat;
        }

        // Crear matriz jagged: una fila por categoría
        Producto[][] estanterias = new Producto[catCount][];
        // Contar por categoría y luego llenar
        for (int ci = 0; ci < catCount; ci++) {
            String cat = categorias[ci];
            int cuenta = 0;
            for (int i = 0; i < lista.length; i++) if (lista[i].categoria.equals(cat)) cuenta++;
            estanterias[ci] = new Producto[cuenta];
            int p = 0;
            for (int i = 0; i < lista.length; i++) {
                if (lista[i].categoria.equals(cat)) {
                    estanterias[ci][p++] = lista[i];
                }
            }
        }

        // Imprimir estanterías por categoría
        for (int i = 0; i < catCount; i++) {
            System.out.print("Categoria: " + categorias[i] + " -> ");
            for (int j = 0; j < estanterias[i].length; j++) {
                System.out.print(estanterias[i][j].nombre + " ");
            }
            System.out.println();
        }
    }
}
