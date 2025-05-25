package Guia8.Actividad.bstreeInterface;


public class Queue<E> {
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public Queue() {
        front = rear = null;
        size = 0;
    }

    // agregar al final
    public void enqueue(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // sacar del frente
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }
        E data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // Ver frente sin eliminar
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Tamaño actual
    public int size() {
        return size;
    }


}
