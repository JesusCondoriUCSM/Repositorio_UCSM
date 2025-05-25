package Guia8.Actividad.Exceptions;

public class ItemNoFound extends Exception {

    public ItemNoFound(String msg) {
        super(msg);
    }

    public ItemNoFound() {
        super();
    }
}
