package Guia6.Actividad.Actividad1;

class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;
    public StackArray(int n){
        this.array = (E[])new Object[n];
        tope = -1;
    }
    public void push(E x){
        if(isFull()) {
            System.out.println("Stack full");
        }
        array[++tope]=x;
    }
    public E pop() throws ExceptionIsEmpty {
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Lista vacia");
        }
        else {
            E ele=array[tope];
            array[tope]=null;
            tope--;
            return ele;
        }
    }
    public E top() throws ExceptionIsEmpty {
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Lista vacia");

        }
        return array[tope];
    }
    public boolean isEmpty () {
        return this.tope == -1;
    }
    public boolean isFull (){
        return tope==array.length-1;
    }
    public String toString(){
        String retor="";
        for(int i=0;i<=tope;i++){
            retor+=array[i];
            retor+=" ";
        }

        return retor;
    }
}
