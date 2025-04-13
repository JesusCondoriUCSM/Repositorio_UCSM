public class ViajeBarato {

    public static int[][] calcularCostosMinimos(int[][] tarifas) {
        int n = tarifas.length;
        int[][] costos = new int[n][n];

        // Inicializamos la matriz de costos con los costos directos (o infinito si no hay ruta)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) costos[i][j] = 0;
                else if (i < j) costos[i][j] = tarifas[i][j];
                else costos[i][j] = Integer.MAX_VALUE; // No se puede ir hacia atrás
            }
        }

        // Programación dinámica para calcular el menor costo entre cada par (i, j)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (costos[i][k] != Integer.MAX_VALUE && costos[k][j] != Integer.MAX_VALUE) {
                        costos[i][j] = Math.min(costos[i][j], costos[i][k] + costos[k][j]);
                    }
                }
            }
        }

        return costos;
    }

    public static void main(String[] args) {
        int[][] tarifas = {
            {0, 2, 9, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {0, 0, 6, 4, Integer.MAX_VALUE},
            {0, 0, 0, 3, 1},
            {0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0}
        };

        int[][] costos = calcularCostosMinimos(tarifas);

        // Mostrar la matriz de costos mínimos
        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < costos.length; i++) {
            for (int j = 0; j < costos.length; j++) {
                if (costos[i][j] == Integer.MAX_VALUE) System.out.print("∞\t");
                else System.out.print(costos[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
