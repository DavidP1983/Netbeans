/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heardfirstjava;

class Hobbits {
    String name;
}

public class HobbitsTestDrive {

    
    public static void main(String[] args) {
        
        Hobbits[] h = new Hobbits[3];
        int z = -1; //because an array strats with element "0"
        while(z < 2){
            z = z + 1;
            h[z] = new Hobbits();
            h[z].name = "Bilbo";
            if(z==1){
                h[z].name = "Frodo";
            }
            if(z==2){
                h[z].name = "sam";
            }
            System.out.print(h[z].name + " is a ");
            System.out.println(" good Hobbit name ");
        }
    }
    
}
