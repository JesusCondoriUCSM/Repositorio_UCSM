public class Moda2 {
	
	public static int moda2(int array[]) {
		int first = 1;
		int p=0;
		int end=array.length-1;
		int moda=array[0];
		int frec = 1;
		int maxfrec =0;
		while(first<=end) {
			if(array[p]==array[first]) {
				frec++;
				first++;
			}
			else {
				if(frec>maxfrec) {
					maxfrec=frec;
					moda=array[p];
				}
				p=first;
				first=p+1;
				frec=1;
			}
		}
		return moda;
	}
	public static void main(String []args) {
		Moda2 moda = new Moda2();
		int lista[]= {1,3,3,4,4,4,5,6};
		int m=moda.moda2(lista);
		System.out.println("La moda es: "+m);
	}
}
