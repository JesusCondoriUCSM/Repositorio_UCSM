public class Moda1 {
	public static int moda1(int array[]) {
		
		int first=0;
		int end=array.length-1;
		
		if(first == end)
			return array[first];
		int moda = array[first];
		int maxfrec = frecuencia(array, first, end, moda);
		
		for(int i= first+1;i<end;i++) {
			int frec=frecuencia(array,i,end,array[i]);
			if(frec>maxfrec) {
				maxfrec=frec;
				moda=array[i];
			}
		}
		return moda;
	}
	private static int frecuencia(int []array, int first, int end, int ele) {
		if(first > end) return 0;
		int suma=0;
		for(int i=first; i<=end;i++) 
			if(array[i]==ele)
				suma++;
		return suma;
		
	}
	
	public static void main(String []args) {
		Moda1 moda = new Moda1();
		int lista[]= {1,3,3,4,5,6};
		int m=moda.moda1(lista);
		System.out.println("La moda es: "+m);
	}
}
