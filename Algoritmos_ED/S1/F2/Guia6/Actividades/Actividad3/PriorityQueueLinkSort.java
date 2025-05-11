package Guia6.Actividad.Actividad3;
import Guia6.Actividad.Ejercicio1.Node;
import Guia6.Actividad.Actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E,N extends Comparable<N>> implements PriorityQueue<E,N> {
    class EntryNode{
        E data;
        N priority;
        EntryNode(E data, N priority){
            this.data = data;
            this.priority = priority;
        }
    }
    private Node<EntryNode> first;
    private Node<EntryNode> last;
    public PriorityQueueLinkSort (){
        this.first = null;
        this.last = null;
    }
    public void enqueue(E x, N pr){
        Node<EntryNode> nuevo=new Node<>(new EntryNode(x,pr));
        if(isEmpty()){
            this.first=nuevo;
            this.last=nuevo;

        }else{
            Node<EntryNode> aux=first;
            if(first.getData().priority.compareTo(pr)>0){
                nuevo.setNext(first);
                first=nuevo;
                return;
            }
            while(aux.getNext()!=null){
                if(aux.getNext().getData().priority.compareTo(pr)>0){
                    break;
                }
                aux=aux.getNext();
            }
            nuevo.setNext(aux.getNext());
            aux.setNext(nuevo);

            if(nuevo.getNext()==null){
                this.last=nuevo;
            }

        }
    }
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Lista vacia");
        E elemento = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null)
            this.last = null;
        return elemento;
    }
    public E back() throws ExceptionIsEmpty {
        if(isEmpty()){
            new ExceptionIsEmpty("Lista vacia");
        }
        E dato=last.getData().data;
        return dato;
// include here your code
    }
    public E front() throws ExceptionIsEmpty {
        if(isEmpty()){
            new ExceptionIsEmpty("Lista vacia");
        }
        E dato=first.getData().data;
        return dato;
    }
    public boolean isEmpty() {
        if(this.first==null){
            return true;
        }
        return false;
    }

    public String toString(){
        String retor="";
        Node<EntryNode> aux=first;
        while(aux!=null) {
            retor+=aux.getData().data;
            retor+=" ";
            aux=aux.getNext();
        }
        return retor;
    }
}
