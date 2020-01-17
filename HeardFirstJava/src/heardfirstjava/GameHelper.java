/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heardfirstjava;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class DotCom {

    private ArrayList<String> locationCells;
    private String name;

    public String checkYourSelf(String userInput) {
        String result = "miss";

        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println(" Ouch! You sunk " + name + " :( " );
            } else {
                result = "hit";
            }
        }
        return result;

    }

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }
    
    public void setName(String n){
        name=n;
    }

}

class DotComBust {

    private Scanner guess = new Scanner(System.in);
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Ship1");
        DotCom two = new DotCom();
        two.setName("Ship2");
        DotCom three = new DotCom();
        three.setName("Ship3");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink three ships ");
        System.out.println("Ship1, Ship2, Ship3 ");
        System.out.println("Try to sink them in the fewest number of guesses ");

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);

        }

    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) {
            System.out.println(" Enter a guess ");
            String userGuess = guess.nextLine();
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    
    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        
        String result = "miss";
        for(DotCom dotComToTest:dotComsList){
            result = dotComToTest.checkYourSelf(userGuess);
            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                dotComsList.remove(dotComToTest);
                break;
            }
                
        }
        System.out.println(result);
    }
    
    private void finishGame(){
        System.out.println("All Ships are Dead!!!");
        if(numOfGuesses<=18){
            System.out.println("It only took you " + numOfGuesses + " guesses ");
            
        }else{
            System.out.println("Took you long enough " + numOfGuesses + " guesses ");
            System.out.println("Finish ");
        }
    }

    public static void main(String[] args) {
        
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();

    }

}

public class GameHelper {

  private static final String alphabet = "abcdefg";
  private int gridLength = 7;
  private int gridSize = 49;
  private int [] grid = new int[gridSize];
  private int comCount = 0;
  
  
  public ArrayList<String> placeDotCom(int comSize) {                 // line 19
    ArrayList<String> alphaCells = new ArrayList<String>();
    String [] alphacoords = new String [comSize];      // holds 'f6' type coords
    String temp = null;                                // temporary String for concat
    int [] coords = new int[comSize];                  // current candidate coords
    int attempts = 0;                                  // current attempts counter
    boolean success = false;                           // flag = found a good location ?
    int location = 0;                                  // current starting location
    
    comCount++;                                        // nth dot com to place
    int incr = 1;                                      // set horizontal increment
    if ((comCount % 2) == 1) {                         // if odd dot com  (place vertically)
      incr = gridLength;                               // set vertical increment
    }

    while ( !success & attempts++ < 200 ) {             // main search loop  (32)
	location = (int) (Math.random() * gridSize);      // get random starting point
        //System.out.print(" try " + location);
	int x = 0;                                        // nth position in dotcom to place
        success = true;                                 // assume success
        while (success && x < comSize) {                // look for adjacent unused spots
          if (grid[location] == 0) {                    // if not already used
             coords[x++] = location;                    // save location
             location += incr;                          // try 'next' adjacent
             if (location >= gridSize){                 // out of bounds - 'bottom'
               success = false;                         // failure
             }
             if (x>0 & (location % gridLength == 0)) {  // out of bounds - right edge
               success = false;                         // failure
             }
          } else {                                      // found already used location
              // System.out.print(" used " + location);  
              success = false;                          // failure
          }
        }
    }                                                   // end while

    int x = 0;                                          // turn good location into alpha coords
    int row = 0;
    int column = 0;
    // System.out.println("\n");
    while (x < comSize) {
      grid[coords[x]] = 1;                              // mark master grid pts. as 'used'
      row = (int) (coords[x] / gridLength);             // get row value
      column = coords[x] % gridLength;                  // get numeric column value
      temp = String.valueOf(alphabet.charAt(column));   // convert to alpha
      
      alphaCells.add(temp.concat(Integer.toString(row)));
      x++;

      // System.out.print("  coord "+x+" = " + alphaCells.get(x-1));
      
    }
    // System.out.println("\n");
    
    return alphaCells;
   }

}