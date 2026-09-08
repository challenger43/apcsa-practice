//predictions before running: 
//a1: 3
//a2: 3.5
//a3: 3.0
//B1: 8
//B2: -8
//B3:9
//B4:-8
//C1: 6.5
//D1: 2147483647
//D2:-2147483648

public class CastingAndRange{
    public static void main(String[] args) {
        //a
        int total =7;
        int count = 2;
        double division = total/count; //just regular
        double beforeDivision = (double) total / count; //convert total to double first, then divide by count, since double "overrides" int it will turn the whole data type into a double
        double afterDivision = (double) (total/count); //divide, then convert the answer to double, meaning that during division it "throws away" all the stuff behind decimal point
        System.out.println("A1 integer division stored as double: " + division); //print stuff
        System.out.println("A2 cast before division: " + beforeDivision);
        System.out.println("A3 cast after division: " + afterDivision);

        //b:
        double positiveValue = 8.9;
        double negativeValue = -8.9;
        //c: 
        int value = 6; 
        double doubleVal = 0.5;
        double result = value + doubleVal;
        
       //d: 
       int maxInt = Integer.MAX_VALUE;
        System.out.println("B1 positive truncation: " + (int) positiveValue);
        System.out.println("B2 negative truncation: " + (int) negativeValue);
        System.out.println("B3 positive rounding: " + (int) (positiveValue + 0.5));
        System.out.println("B4 negative rounding: " + (int) (negativeValue + 0.5));
        System.out.println("C1 automatic widening: " + result);
        System.out.println("D1 maximum int: " + maxInt);
        System.out.println("D2 maximum int plus one: " + (int)(maxInt+1));
    }
}
//explanations after testing:
//casting before division works because by setting one value to a double it will "overide" the integer of the other value and make the whole value a double
//casting -8.9 makes -8 because it simply gets rid of the entire decimal point, not necessarily rounding to the nearest integer
//the integer to double conversion (so the integer gets widened)
// Because there are only 31 bits to store values, adding one gets 100....000 as bits, but that ends up equalling the smallest negative number rather than another increase in positive, as it has ran out of storage to hold any bigger numbers