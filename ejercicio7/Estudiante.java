
public  class Estudiante {
    
        String nombre;
        double calificacion; // asumimos escala 0-100
        Estudiante(String nombre, double calificacion) {
            this.nombre = nombre;
            this.calificacion = calificacion;
        }
        public String toString() {
            return nombre + " (" + calificacion + ")";
        }
    

    // convierte calificación numérica a letra
    static char letra(double nota) {
        if (nota >= 90) return 'A';
        if (nota >= 80) return 'B';
        if (nota >= 70) return 'C';
        if (nota >= 60) return 'D';
        return 'F';
    }

    public static void main(String[] args) {
        // Ejemplo: matriz 2x3 de estudiantes
        Estudiante[][] salon = {
            { new Estudiante("Ana", 95), new Estudiante("Luis", 82), new Estudiante("Marta", 76) },
            { new Estudiante("Pedro", 65), new Estudiante("Carla", 58), new Estudiante("Jose", 88) }
        };

        // Agrupar en arrays temporales (máx = total estudiantes)
        int total = salon.length * salon[0].length;
        Estudiante[] A = new Estudiante[total];
        Estudiante[] B = new Estudiante[total];
        Estudiante[] C = new Estudiante[total];
        Estudiante[] D = new Estudiante[total];
        Estudiante[] F = new Estudiante[total];
        int a=0,b=0,c=0,d=0,f=0;

        for (int i = 0; i < salon.length; i++) {
            for (int j = 0; j < salon[i].length; j++) {
                Estudiante e = salon[i][j];
                char L = letra(e.calificacion);
                if (L == 'A') A[a++] = e;
                else if (L == 'B') B[b++] = e;
                else if (L == 'C') C[c++] = e;
                else if (L == 'D') D[d++] = e;
                else F[f++] = e;
            }
        }

        // Imprimir grupos (solo los llenos)
        imprimirGrupo('A', A, a);
        imprimirGrupo('B', B, b);
        imprimirGrupo('C', C, c);
        imprimirGrupo('D', D, d);
        imprimirGrupo('F', F, f);
    }

    static void imprimirGrupo(char letra, Estudiante[] grupo, int cantidad) {
        System.out.println("Grupo " + letra + " (" + cantidad + "):");
        for (int i = 0; i < cantidad; i++) {
            System.out.println(" - " + grupo[i]);
        }
    }
}
