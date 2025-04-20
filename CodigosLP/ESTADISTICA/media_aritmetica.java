public static double media_aritmetica(int l[]) {
        double acum=0;
        double conteo=0;
        for(int x:l){
            conteo++;
            acum+=x;
        }
        return acum/conteo;
    }
