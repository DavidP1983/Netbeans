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
public class InternetPlan {

    /**
     * @param args the command line arguments
     */
   

    public static void main(String[] args) {

        SubscriptionPlan plan = new SubscriptionPlan();

        plan.setSubPackage();
        plan.setNumberOfHours();
        plan.calculateRMC();
    }
}
    

