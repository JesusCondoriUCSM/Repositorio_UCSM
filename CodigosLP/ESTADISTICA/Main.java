public class Main {
    public static void main(String[] args) {
        double rpta;
        int lista[] = {1,4,1,1,2,3,5};
        rpta = mediana(lista);
        System.out.println("La mediana es: " + rpta);
        rpta=moda(lista);
        System.out.println("La moda es: " + rpta);
        rpta=media_aritmetica(lista);
        System.out.println("La media es: " + rpta);

    }

    static int[] BubbleSort(int myArray[]) {
        int temp;
        boolean swapped;
        int contador = 0;
        for (int i = 0; i < myArray.length - 1; i++) {
            contador = i + 1;
            swapped = false;
            for (int j = 0; j < myArray.length - i - 1; j++) {

                if (myArray[j] > myArray[j + 1]) {

                    temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                    swapped = true;

                }
            }
            if (swapped == false) {

                break;

            }
        }
        return myArray;
    }

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

    public static double media_aritmetica(int l[]) {
        double acum=0;
        double conteo=0;
        for(int x:l){
            conteo++;
            acum+=x;
        }
        return acum/conteo;
    }

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
}
