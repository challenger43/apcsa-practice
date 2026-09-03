import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double total = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("You like to eat rice. Type true or false.");
        boolean likesRice;
        while (!input.hasNextBoolean()) {
            System.out.println("You need to type true or false.");
            input.next(); 
        }
        likesRice = input.nextBoolean();
        if (!likesRice){
            System.out.println("Then this is useless to you. Go like rice.");
            return;
        }
        System.out.println("How many hungry people do you have?");
        int numHungryPeople;
        while (!input.hasNextInt()){
            System.out.println("Give a whole number of people. In number form, e.g. 5. Do not type 'five.'");
            input.next();
        }
        numHungryPeople = input.nextInt();
        input.nextLine();
        System.out.println("How many not too hungry people do you have?");
        int numLessHungryPeople;
        while (!input.hasNextInt()){
            System.out.println("A whole number of people is needed. In number form, e.g. 5. Do not type 'five.'");
            input.next();
        }
        numLessHungryPeople = input.nextInt();
        input.nextLine();
        double cupsOfRiceNotHungry = 0.5;
        int cupsOfRiceHungry = 1;

        for (int i = numHungryPeople; i>0; i--){
            total += cupsOfRiceHungry;
        }

        for (int i = numLessHungryPeople; i>0; i--){
            total+= cupsOfRiceNotHungry;
        }

        System.out.println("You should cook " + total + " cups of rice to feed " + numHungryPeople + (numHungryPeople == 1 ? " hungry person " : " hungry people ") + "and " + numLessHungryPeople + (numLessHungryPeople == 1 ? " less hungry person " : " less hungry people "));
    }
}