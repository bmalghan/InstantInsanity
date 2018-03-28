/*Name: Bhalachandra Malghan -- Shriya Gundala -- Marcel Turcotte
* Student Number: 300034277 -- 300011246
* ITI 1121 - C4
*/

public interface Queue<E> {
    
    public boolean isEmpty();

    public void enqueue( E o );

    public E dequeue();
}