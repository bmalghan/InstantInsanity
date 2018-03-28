/*Name: Bhalachandra Malghan -- Shriya Gundala
* Student Number: 300034277 -- 300011246
* ITI 1121 - C4
*/

public class Solution {
  
  private static int numberOfCalls = 0;
  private Cube [] cubes;
  
  public Solution (Cube[] cubes){
    
    this.cubes = new Cube [cubes.length];
    for (int i = 0; i < cubes.length ; i++){
      this.cubes [i] = cubes [i];
    }
  }
  
  public Solution (Solution other, Cube c){
    
    if (c == null){
      throw new NullPointerException("null");
    }
    else {
      if (other.size()>=4){
        throw new ArrayIndexOutOfBoundsException("More than 4 blocks");
      }
      else {
        cubes = new Cube[1 + other.size ()];
        cubes[other.size()]=c;
        for (int i=0;i<other.size();i++){
          cubes [i] = other.getCube(i+1);
        }
      }
    }
  }
  
  public int size (){
    return cubes.length;
  }
  
  public Cube getCube (int pos){
    return cubes [pos];
  }
  
  public Boolean isValid () {
    numberOfCalls++;
    for (int i=0; i<cubes.length; i++) {
      
        for (int j=0; j<cubes.length ; j++) {
          
          if (i!=j) {
            
            if (cubes[i].getFront()==cubes[j].getFront() || cubes[i].getRight()==cubes[j].getRight() || 
                cubes[i].getBack()==cubes[j].getBack() || cubes[i].getLeft()==cubes[j].getLeft()) {
              return false; 
            }
          }
        }   
      }
    return true;
  }
   
  public Boolean isValid (Cube next) {
    numberOfCalls++;
    
    Cube [] tempCubes = new Cube [cubes.length+1];
    tempCubes [tempCubes.length-1] = next;
    for (int i=0; i<cubes.length; i++) {
      
      tempCubes[i] = cubes[i];
    }
    
    for (int i=0; i<tempCubes.length; i++) {
      
      for (int j=0; j<tempCubes.length ; j++) {
        
        if (i!=j) {
          
          if (tempCubes[i].getFront()==tempCubes[j].getFront() || tempCubes[i].getRight()==tempCubes[j].getRight() || 
              tempCubes[i].getBack()==tempCubes[j].getBack() || tempCubes[i].getLeft()==tempCubes[j].getLeft()) {
            return false; 
          }
        }
      }   
    }
    return true;
  }
  
  public String toString (){
    StringBuffer s = new StringBuffer("[ ");
    
    s.append(cubes[0].toString());
    for (int i = 1; i < cubes.length; i++){
      s.append(", "+cubes [i].toString());
    }
    s.append ("]");
    
    return s.toString();
  }
  
  public int getNumberOfCalls (){
    return numberOfCalls;
  }
  public void resetNumberOfCalls (){
    numberOfCalls = 0;
  }
}