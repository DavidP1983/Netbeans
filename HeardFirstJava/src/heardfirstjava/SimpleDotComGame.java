/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heardfirstjava;

import java.io.*;
import java.util.Scanner;

class SimpleDotCom {

    int[] locationCells;
    int numOfHits = 0;

    public String checkYourself(String stirngGuess) {
        int guess = Integer.parseInt(stirngGuess);
        String result = "miss";

        for (int cell : locationCells) {
            if (guess == cell) {
                result = "Hit";
                numOfHits++;
                break;
            }

        }
        if (numOfHits == locationCells.length) {
            result = "Kill";
        }
        System.out.println(result);
        return result;
    }

    void setLocationCells(int[] loc) {
        locationCells = loc;

    }
}

public class SimpleDotComGame {

    public static void main(String[] args) {

        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2, 3, 4};
        dot.setLocationCells(locations);

        Scanner s = new Scanner(System.in);

        int numOfMiss = 0;
        int x = 0;
        while (x < 7) {
            String userGuess = s.next();
            String result = dot.checkYourself(userGuess);
            x += 1;
            if (result.equals("miss")) {
                numOfMiss++;
            }
//   test code goes here
            String testResult = "Failed";
            if (result.equals("Hit")) {
                testResult = "Passed";
            }
            if (result.equals("Kill")) {
                break;
            }
            System.out.println(testResult);

        }
        int testNumOfHits = dot.numOfHits;
        System.out.println("Number of Hits " + testNumOfHits);
        System.out.println("Number of Miss " + numOfMiss);
    }

}
