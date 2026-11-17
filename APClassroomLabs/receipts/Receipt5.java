package APClassroomLabs.receipts;

import java.text.DecimalFormat;
import java.util.Scanner;
//this feels very stupid. 
public class Receipt5 {
    public static void main(String[] args) {
        {
            Scanner scanner = new Scanner(System.in);
            DecimalFormat df = new DecimalFormat("0.00");
            int orderNumber = (int) (Math.random() * 100 + 1);
            System.out.println("Welcome to this totally real shop where you can buy anything and gamble for price: ");
            System.out.println("What you want." );
            String item1 =  scanner.nextLine();
            int item1price = (int) (Math.random() * 10000);
            System.out.println("ok you need more stuff: ");
            String item2 = scanner.nextLine();
            int item2price = (int) (Math.random() * 3000000);
            System.out.println("gimme more of your money.");
            String item3= scanner.nextLine();
            int item3price = (int) (Math.random() * 999);
            System.out.println("i think you need more items");
            String item4= scanner.nextLine();
            int item4price = (int) (Math.random() * 173);
            System.out.println("ok let's see who goes in debt today: ");
            int totalDebt = item1price + item2price + item3price + item4price;
            System.out.println("Number " + orderNumber + " , your order is ready at the counter.");
            System.out.println(" here is ye orders: ");
            System.out.println("item1, " + item1 + " which costed $" + item1price);
            System.out.println("item2, " + item2 + " which costed $" + item2price);
            System.out.println("item3, " + item3 + " which costed $" + item3price);
            System.out.println("item4, " + item4 + " which costed $" + item4price);
            System.out.println("your total debt is: $" + totalDebt);

            
        }
    }
}
