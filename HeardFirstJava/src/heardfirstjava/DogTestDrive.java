/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heardfirstjava;

class Dogy {
 
    String name;
    
    void bark(){
        System.out.println(name + " says Ruff ");
    }
}

public class DogTestDrive {
    
    public static void main(String[] args) {
      
        Dogy dog1 = new Dogy();
                
        dog1.bark();
        dog1.name = "Bart";
        
        Dogy[] myDogs = new Dogy[3];
        myDogs[0] = new Dogy();
        myDogs[1] = new Dogy();
        myDogs[2] = dog1;
                
        myDogs[0].name = "Dessy";
        myDogs[1].name = "Dingo";
        
        System.out.print("Last dog's name is ");
        System.out.println(myDogs[2].name);
        
        int x = 0;
        while(x < myDogs.length){
            myDogs[x].bark();
            x = x + 1;
        }
                
        
    }
    
}
