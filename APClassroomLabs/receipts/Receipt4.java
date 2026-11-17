package APClassroomLabs.receipts;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Receipt4 {
    public static void main(String[] args) {
        {
            Scanner scanner = new Scanner(System.in);
            DecimalFormat df = new DecimalFormat("0.00");
            int orderNumber = (int) (Math.random() * 100 + 1);
            System.out.println("what your highschool name");
            String hsName = scanner.nextLine();
            String hsShort = "";
            while (hsName.indexOf(" ") != -1){
                String nextLetter = hsName.substring(0,1);
                hsShort = hsShort + nextLetter;
                hsName= hsName.substring(hsName.indexOf(" ") + 1);
            }
            hsShort = hsShort + hsName.substring(0,1);
            double drinkCost = 1.50;
            System.out.println("How many drinks");
            int numDrinks = scanner.nextInt();
            double candyCost = 1.25;
            System.out.println("how much candy");  
            int numCandy = scanner.nextInt();
            double hotDogCost = 2.75;
            System.out.println("how much hotdog");
            int numHotDog = scanner.nextInt();
            double hamburgerCost = 3.50;
            System.out.println("how much hamburger");
            int numHamburger = scanner.nextInt();
            double totalDrink = numDrinks * drinkCost;
            double totalCandy = numCandy * candyCost;
            double totalHotdog = numHotDog * hotDogCost;
            double totalHamburger = numHamburger * hamburgerCost;
            double subTotal = totalDrink + totalHamburger + totalHotdog + totalCandy;
            double tax = 0.1;
            double total = subTotal * tax + subTotal;
            System.out.println("**************************************");
            System.out.println("*     Welcome                       *");
            System.out.println("*     " + hsShort + " Snack Bar           *");
            System.out.println("*                                    *");
            System.out.println("*     Drink ..........$" + df.format(drinkCost) + "          *");
            System.out.println("*     Candy ..........$" + df.format(candyCost) + "          *");
            System.out.println("*     Hot Dog ........$" + df.format(hotDogCost) + "          *");
            System.out.println("*     Hamburger ......$" + df.format(hamburgerCost) + "          *");
            System.out.println("*                                    *");
            System.out.println("**************************************");
            System.out.println("Order number: " + orderNumber);
            System.out.println("Qty   Item        Total");
            System.out.println(numDrinks + "     Drinks" + "      $" + df.format(totalDrink));
            System.out.println(numCandy + "     Candies" + "     $" + df.format(totalCandy));
            System.out.println(numHotDog + "     Hotdogs" + "     $" + df.format(totalHotdog));
            System.out.println(numHamburger + "     Hamburgers" + "  $" + df.format(totalHamburger));
            System.out.println("Subtotal: $" + subTotal);
            System.out.println("Tax: $" + df.format(subTotal * tax));
            System.out.println("Total: $" + df.format(total));
        }
    }
}
