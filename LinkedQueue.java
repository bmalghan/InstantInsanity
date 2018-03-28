/*Name: Bhalachandra Malghan -- Shriya Gundala -- Marcel Turcotte
* Student Number: 300034277 -- 300011246
* ITI 1121 - C4
*/
public class LinkedQueue<E> implements Queue<E> {
    @SuppressWarnings("unchecked")
    private static class Elem<T> {

        private T value;
        private Elem<T> next;

        private Elem( T value, Elem<T> next ) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    public E peek() {
        return front.value;
    }

    public void enqueue( E o ) {
        Elem<E> newElem;
        newElem = new Elem<E>( o, null );

        if ( rear == null ) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
    }

    public E dequeue() {
        E result = front.value;
        if ( front != null & front.next == null ) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return result;
    }

    public boolean isEmpty() {
        return front == null;
    }

}