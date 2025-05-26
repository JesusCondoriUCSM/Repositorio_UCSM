public void preOrder()  throws ExceptionIsEmpty{
        Node aux=root;
        this.preOrderRecursivo(aux);
    }
    //PreOrder Recursivo

    private void preOrderRecursivo(Node aux) throws ExceptionIsEmpty{
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Arbol vacio");
        }
        else {

            if( aux==null) {
                return;
            }else {
                System.out.print(" "+aux.data);
                preOrderRecursivo(aux.left);
                preOrderRecursivo(aux.right);
            }
        }
    }
