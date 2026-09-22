package APClassroomLabs;

import java.text.DecimalFormat;

public class Receipt3 {
    public static void main(String[] args) {
        {
            DecimalFormat df = new DecimalFormat("0.00");
            int orderNumber = (int) (Math.random() * 100 + 1);
            String hsName = "Redwood HS";
            double drinkCost = 1.50;
            int numDrinks = (int) (Math.random() * 3);
            System.out.println(numDrinks);
            double candyCost = 1.25;
            int numCandy = (int) (Math.random() * 3);
            double hotDogCost = 2.75;
            int numHotDog = (int) (Math.random() * 3);
            double hamburgerCost = 3.50;
            int numHamburger = (int) (Math.random() * 3);
            double totalDrink = numDrinks * drinkCost;
            double totalCandy = numCandy * candyCost;
            double totalHotdog = numHotDog * hotDogCost;
            double totalHamburger = numHamburger * hamburgerCost;
            double subTotal = totalDrink + totalHamburger + totalHotdog + totalCandy;
            double tax = 0.1;
            double total = subTotal * tax + subTotal;
            System.out.println("**************************************");
            System.out.println("*     Welcome                       *");
            System.out.println("*     " + hsName + " Snack Bar           *");
            System.out.println("*                                    *");
            System.out.println("*     Drink ..........$" + df.format(drinkCost) + "          *");
            System.out.println("*     Candy ..........$" + df.format(candyCost) + "          *");
            System.out.println("*     Hot Dog ........$" + df.format(hotDogCost) + "          *");
            System.out.println("*     Hamburger ......$" + df.format(hamburgerCost) + "          *");
            System.out.println("*                                    *");
            System.out.println("**************************************");
            System.out.println("Order number: " + orderNumber);
            System.out.println("Qty   Item        Total");
            System.out.println(numDrinks + "     Drinks" + "      " + totalDrink);
            System.out.println(numCandy + "     Candies" + "     " + totalCandy);
            System.out.println(numHotDog + "     Hotdogs" + "     " + totalHotdog);
            System.out.println(numHamburger + "     Hamburgers" + "  " + totalHamburger);
            System.out.println("Subtotal: " + subTotal);
            System.out.println("Tax: " + df.format(subTotal * tax));
            System.out.println("Total: " + df.format(total));
        }
    }
}
