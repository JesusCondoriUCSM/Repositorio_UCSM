package Guia5.Ejercicio;

    public class ListaEnlazada{
        public static <T> Node<T> insertarAlFinal(Node<T> head,T valor){

            Node<T> nuevo = new Node<>(valor);
            if(estaVacio(head)){
                head=nuevo;
                return head;
            }else{
                Node<T> aux = head;
                while(aux.getSiguiente()!=null){
                    aux=aux.getSiguiente();
                }
                aux.setSiguiente(nuevo);
            }
            return head;
        }
        //Contar nodos
        public static <T> int contarNodos(Node<T> head){
            if(estaVacio(head)){
                return 0;
            }else{
                int contador=0;
                Node<T> aux=head;
                while(aux!=null){
                    contador++;
                    aux=aux.getSiguiente();
                }
                return contador;
            }
        }
        //Verificar si dos listas son iguales
        public static <T > boolean sonIguales(Node<T> lista1, Node<T> lista2){

            Node<T> aux1=lista1;
            Node<T> aux2=lista2;

            while(aux1!=null && aux2!=null){
                if(!(aux1.getValor().equals(aux2.getValor()))){
                    return false;
                }
                aux1=aux1.getSiguiente();
                aux2=aux2.getSiguiente();
            }
            return true;
        }
        //Concatenar listas
        public static <T> Node<T> concatenarListas(Node<T> lista1,Node<T> lista2){

            if(estaVacio(lista1)) {
                return lista2;
            }if(estaVacio(lista2)) {
                return lista1;
            }
            else{
                Node<T> aux1=lista1;
                while(aux1.getSiguiente()!=null){
                    aux1=aux1.getSiguiente();
                }
                aux1.setSiguiente(lista2);
                return lista1;
            }

        }

        public static <T> void verLista(Node<T> head){
            if(estaVacio(head)){
                return;
            }else{
                Node<T> aux=head;
                while(aux!=null){
                    System.out.println(aux);
                    aux=aux.getSiguiente();
                }
            }
        }

        public static <T> boolean estaVacio(Node <T > cabeza){
            if(cabeza==null){

                return true;
            }else{
                return false;
            }
        }

    }
