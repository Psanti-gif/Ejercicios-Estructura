
public class Libro {
     
        String titulo;
        String autor;
        double precio;
        Libro(String titulo, String autor, double precio) {
            this.titulo = titulo;
            this.autor = autor;
            this.precio = precio;
        }
    

    public static void main(String[] args) {
        Libro[][] biblioteca = {
            { new Libro("El A", "Autor1", 25.0), new Libro("El B", "Autor2", 40.5), new Libro("El C", "Autor3", 15.0) },
            { new Libro("El D", "Autor4", 60.0), new Libro("El E", "Autor5", 55.5), new Libro("El F", "Autor6", 60.0) },
            { new Libro("El G", "Autor7", 20.0), new Libro("El H", "Autor8", 75.0), new Libro("El I", "Autor9", 50.0) }
        };

        Libro masCaro = biblioteca[0][0];
        int fila = 0, col = 0;
        for (int i = 0; i < biblioteca.length; i++) {
            for (int j = 0; j < biblioteca[i].length; j++) {
                if (biblioteca[i][j].precio > masCaro.precio) {
                    masCaro = biblioteca[i][j];
                    fila = i;
                    col = j;
                }
            }
        }

        System.out.println("Libro más caro encontrado:");
        System.out.println("Título: " + masCaro.titulo);
        System.out.println("Autor: " + masCaro.autor);
        System.out.println("Precio: " + masCaro.precio);
        System.out.println("Posición (0-based): fila " + fila + ", columna " + col);
    }
}
