/*Name: Bhalachandra Malghan -- Shriya Gundala
* Student Number: 300034277 -- 300011246
* ITI 1121 - C4
*/

public class solve {
  private static Cube c1 = new Cube (new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});
  private static Cube c2 = new Cube (new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED});
  private static Cube c3 = new Cube (new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED});
  private static Cube c4 = new Cube (new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE});
  
  
  public static void main(String[] args) {
    
    long start , stop;
    
    System.out.println("generateAndTest:");
    start = System.currentTimeMillis(); // could also use nanoTime
    
    generateAndTest();
    
    stop = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (stop-start) + " milliseconds");
    
    System.out.println("\nbreadthFirstSearch:");
    start = System.currentTimeMillis();
    
    breadthFirstSearch();
    
    stop = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (stop-start) + " milliseconds"); 
  }  
  public static LinkedQueue<Solution> generateAndTest(){
    c1.reset();
    c2.reset();
    c3.reset();
    c4.reset();
    LinkedQueue<Solution> queue = new LinkedQueue<Solution>();
    Solution sol = new Solution (new Cube [] {c1,c2,c3,c4});
    for (int i = 0; i < 24; i++){
      if (c1.hasNext()){
        c1.next();
      }
      else{
        c1.reset();
        c1.next();
      }
      for (int j = 0; j < 24; j++){
        if (c2.hasNext()){
          c2.next();
        }
        else{
          c2.reset();
          c2.next();
        }
        for (int k = 0; k< 24; k++){
          if (c3.hasNext()){
            c3.next();
          }
          else{
            c3.reset();
            c3.next();
          }
          for (int h = 0; h < 24; h++){
            if (c4.hasNext()){
              c4.next();
            }
            else{
              c4.reset();
              c4.next();
            }
            
            sol = new Solution (new Cube [] {c1,c2,c3,c4});
            if (sol.isValid()) {
              queue.enqueue(sol);
            }
          }
        }
      }
    }
    System.out.println(sol.getNumberOfCalls());
    
    return queue;
    
  }
  public static Queue<Solution>breadthFirstSearch(){
    c1.reset();
    c2.reset();
    c3.reset();
    c4.reset();
    Queue<Solution> solutions = new LinkedQueue<Solution>();
    Queue<Solution> open = new LinkedQueue<Solution>();
    Solution sol = new Solution (new Cube [] {c1,c2,c3,c4});

    for (int i = 0; i<24; i++){
        Solution temp = new Solution(new Cube[] {c1.copy()});
        open.enqueue(temp);
    }

  
    Solution current;
    Cube tmpCube;
    Solution tmpsoln;


    while(!open.isEmpty()){
      current = open.dequeue();
      if (current.size()==1)
        tmpCube=cubes[1].copy();
      else if (current.size()==2)
        tmpCube=cubes[2].copy();
      else if (current.size()==3)
        tmpCube=cubes[2].copy();
      else 
        throw new IllegalStateException();
      while (tmpCube.hasNext()){
        tmpCube.next();
        if (current.isValid(tmpCube)){
          Solution tmpSoln = new Solution(current,tmpCube);
          solutions.enqueue(tmpSoln);
        }
        else 
            open.enqueue(tmpSoln);
        }
    }
    tmpCube.reset();
}
    
    return solutions;
  }
  
 
}