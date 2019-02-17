/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

/**
 *
 * @author PIRUZ
 */
public class Method {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int firstValue = 1;
        int secondValue = 2;
        int thirdValue = 3;

        int maxValue = max(firstValue, secondValue, thirdValue);
        System.out.println("The maximum between " + firstValue + "," + secondValue + "," + thirdValue + " is " + maxValue);
    }

    public static int max(int num1, int num2, int num3) {
        int result;

        if (num1 > num2) {
            return num1;

        }

        if (num2 > num3) {
            return num2;

        }

        return num3;

    }

}
