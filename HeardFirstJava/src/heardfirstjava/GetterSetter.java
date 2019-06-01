/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heardfirstjava;

class GoodDog{
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
       size = s;
    }
       void bark(){
      if (size > 60){
          System.out.println(" Woof! Woof! ");
     }else if(size > 14){
          System.out.println(" Ruff! Ruff! ");
     }else {
          System.out.println(" Yip! Yip! ");
     }
  }
    
    
}


public class GetterSetter {

    
    public static void main(String[] args) {
        GoodDog one = new GoodDog();
        one.setSize(70);
        GoodDog two = new GoodDog();
        two.setSize(8);
        System.out.println("Dog one: " + one.getSize());
        System.out.println("Dog two:" + two.getSize());
        one.bark();
        two.bark();
        

    }
    
}
