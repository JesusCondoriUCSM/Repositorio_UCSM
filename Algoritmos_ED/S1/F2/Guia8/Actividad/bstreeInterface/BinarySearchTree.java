package Guia8.Actividad.bstreeInterface;
import Guia8.Actividad.Exceptions.*;

public interface BinarySearchTree<E> {
    void insert(E data) throws ItemDuplicated;
    E search (E data) throws ItemNoFound;
    void delete (E data) throws ExceptionIsEmpty;
    boolean isEmpty();
}
