/*Name: Bhalachandra Malghan -- Shriya Gundala
* Student Number: 300034277 -- 300011246
* ITI 1121 - C4
*/

public class Cube{
  private Color [] faces = new Color [6];
  //copy of cube, that cannot be changed
  private final Color [] original  = new Color [6];
  //keeps track of how many times next() has been called
  private int count;
  
  public Cube (Color[]faces) {
    count = -1;
    //initialize original and faces
    for (int i = 0; i<6 ; i++){
      this.original [i] = faces [i];
      this.faces [i] = faces [i];
    }
    //set count to 0
    count = 0;
  }
  public Color getUp () {
    return faces[0];
  }
  
  public Color getFront () {
    return faces[1];
  }
  
  public Color getRight () {
    return faces[2];
  }
  
  public Color getBack () {
    return faces[3];
  }
  
  public Color getLeft () {
    return faces[4];
  }
  
  public Color getDown () {
    return faces[5];
  }
  
  public String toString () {
    return ("["+faces[0]+", "+faces[1]+", "+faces[2]+", "+faces[3]+", "+faces[4]+", "+faces[5]+"]");
  }
  //24 possible orientation, count must be less that equal to 24
  public Boolean hasNext () {
    if (count < 24){
      return true;
    }
    else {
      return false;
    }

  }
  public void next () {
    
    count++;
   
    if (hasNext()){ 
      if (count == 0){
        Identity ();
      }
      else if (count != 0 & count!= 4 & count != 8 & count != 20 & count != 12 & count != 16 ){
        Rotate();
      }
      else if (count == 4 || count == 8 || count == 20){
       RightRoll();
      }
      else if (count == 12 || count == 16){
       LeftRoll();
      }
    else {
     
        throw new IllegalStateException();
        
      
    }     
      
    }
    
  }
  
  public void reset () {
    
      for (int i = 0; i < 6; i++){
        faces [i] = original [i];
    
      count = -1;
      
    }
    
    
  }
  
  public void Rotate () {
    Color temp = getFront();
    faces [1] = getLeft();
    faces [4] = getBack();
    faces [3] = getRight();
    faces [2] = temp;
  }
  
  public void RightRoll () {
    Color temp = getUp();
    faces [0] = getLeft();
    faces [4] = getDown();
    faces [5] = getRight();
    faces [2] = temp;
  }
  
  public void LeftRoll () {
    Color temp = getUp();
    faces [0] = getRight();
    faces [2] = getDown();
    faces [5] = getLeft();
    faces [4] = temp;
  }
  
  public void Identity () {
    for (int i = 0; i<6 ; i++){
      this.faces [i] = this.original [i];
    }
  }
  
  public void Cube(Cube other){
    faces [0] = other.getUp();
    faces [1] = other.getFront();
    faces [2] = other.getRight();
    faces [3] = other.getBack();
    faces [4] = other.getLeft();
    faces [5] = other.getDown();
  }

  public Cube copy (){
    Cube newCube = new Cube (faces);
    return newCube;
  }
  
}