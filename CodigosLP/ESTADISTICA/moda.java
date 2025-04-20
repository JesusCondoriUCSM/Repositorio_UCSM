public static int moda(int l[]) {
        int conteo = 0;
        int mayor = 0;
        int moda=0;
        for (int i = 0; i < l.length; i++) {

            for (int j = 0; j < l.length; j++) {
                if (l[i] == l[j]) {
                    conteo++;

                }
            }
            if (conteo > mayor) {
                mayor = conteo;
                moda=l[i];
            }
            conteo=0;
        }
        return moda;
    }
