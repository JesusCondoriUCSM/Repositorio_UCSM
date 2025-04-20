public static double mediana(int l[]) {
        int lista[] = BubbleSort(l);
        double valor;
        int tamano;
        if (lista.length % 2 == 0) {
            tamano = lista.length / 2 - 1;
            valor = (lista[lista.length / 2] + lista[tamano]) / 2.0;

            return valor;

        } else {
            tamano = (lista.length + 1) / 2 - 1;
            valor = lista[tamano];

            return valor;
        }
    }
