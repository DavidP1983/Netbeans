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

import java.util.Scanner;
public class SubscriptionPlan {
 
    Scanner sc = new Scanner(System.in);

    private String subPackage = "";
    private int numberOfHours;
    private int includedHours;
    private double plan;

    //Setters
    public void setSubPackage() {
        try {
            System.out.println("Enter Your Subscription Package:");
            subPackage = sc.next();
            this.subPackage = subPackage.toUpperCase();
        } catch (Exception e) {
            System.out.println("Subscription Packages must be letter A or B or C.");
        }
    }

    public void setNumberOfHours() {
        try {
            System.out.println("Enter how many hours your used internet this month:");
            this.numberOfHours = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Enter number between 0 and 744.");
        }
    }

    public void setPlan(double plan) {
        this.plan = plan;
    }

    //Getters
    public String getSubPackage() {
        return subPackage;
    }

    public int getIncludedHours() {
        return includedHours;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public double getPlan() {
        return plan;
    }

    //Method to calculate the regular monthly charge
    public void calculateRMC() {
        if (subPackage.equals("A") && (numberOfHours < 744 && numberOfHours > 0)) {
            includedHours = 10;

            if (numberOfHours <= 10) {
                setPlan(9.95);
                displayTheResult();

            } else {
                int payHours = numberOfHours - includedHours;
                setPlan((payHours * 2) + 9.95);
                displayTheResult();
            }
        } else if (subPackage.equals("B") && (numberOfHours < 744 && numberOfHours > 0)) {
            includedHours = 20;
            if (numberOfHours <= 10) {
                setPlan(14.95);
                displayTheResult();
            } else {
                int payHours = numberOfHours - includedHours;
                setPlan(payHours + 14.95);
                displayTheResult();
            }
        } else if (subPackage.equals("C") && (numberOfHours < 744 && numberOfHours > 0)) {
            setPlan(19.95);
            displayTheResult();
        } else if (!subPackage.equals("A") && !subPackage.equals("B") && !subPackage.equals("C") && (numberOfHours < 744 && numberOfHours >= 0)) {
            System.out.println(subPackage + " is invalid subscription plan");
            System.out.println("Please try again.");
            setSubPackage();
            setNumberOfHours();
            calculateRMC();
        } else if ((numberOfHours >= 744 || numberOfHours < 0)) {
            System.out.println("Your subscription plan is " + getSubPackage());
            System.out.println("You have been entered invalid number of hours:" + numberOfHours);
            System.out.println("Please try again.");
            setSubPackage();
            setNumberOfHours();
            calculateRMC();
        } else {
            System.out.println("Your Need to enter a valid subscription plan(A, B or C) and hours can't exceed 744 of be less than 0.");
            System.out.println("Please try again.");
            setSubPackage();
            setNumberOfHours();
            calculateRMC();
        }
    }

    //Method to display the results
    public void displayTheResult() {
        System.out.println("Your subscription plan is " + getSubPackage());
        System.out.println("You have been used internet for " + getNumberOfHours() + " hours this month.");
        System.out.println("Your bill this month is $" + getPlan());
        System.out.println("\nThank you for using our services.");
    }
}
