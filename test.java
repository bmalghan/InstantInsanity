/*Name: Bhalachandra Malghan -- Shriya Gundala
* Student Number: 300034277 -- 300011246
* ITI 1121 - C4
*/

public class test {
  public static void main (String[] args){
    Cube c;
    c = new Cube (new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});
    c.reset();
    while (c.hasNext()){
      c.next();
      System.out.println(c);
    }
    System.out.println ("reset:");
    c.reset();
    
    while (c.hasNext()){
      c.next();
      System.out.println(c);
    }
  }
  
}