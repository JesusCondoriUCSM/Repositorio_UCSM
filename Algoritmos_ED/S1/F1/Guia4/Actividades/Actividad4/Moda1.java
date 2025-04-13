public class Moda1 {
	public static int moda1(int array[]) {
		
		int first=0;                                            O(1)
		int end=array.length-1;                 O(1)
		
		if(first == end)                                    O(1)
			return array[first];           O(1)
		int moda = array[first];                  O(1)
		int maxfrec = frecuencia(array, first, end, moda);      O(n)
		
		for(int i= first+1;i<end;i++) {                 O(n)
			int frec=frecuencia(array,i,end,array[i]);      O(n)
			if(frec>maxfrec) {                  O(1)
				maxfrec=frec;         O(1)
				moda=array[i];       O(1)
			}
		}
		return moda;                                  O(1)
	}

	private static int frecuencia(int []array, int first, int end, int ele) {
		if(first > end) return 0;             O(1)
		int suma=0;                                  O(1)
		for(int i=first; i<=end;i++)       O(n)
			if(array[i]==ele)           O(1)
				suma++;        O(1)
		return suma;                               O(1)
		
	}
                 public static void main(String []args) {
		Moda1 moda = new Moda1();
		int lista[]= {1,3,3,4,5,6};
		int m=moda.moda1(lista);
		System.out.println("La moda es: "+m);
	  }

}
