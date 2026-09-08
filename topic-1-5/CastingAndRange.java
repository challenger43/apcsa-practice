//predictions before running: 
//a1: 3
//a2: 3.5
//a3: 3.0
//B1: 8
//B2: -8
//B3:
//B4:
//C1: 
//D1: 
//D2:

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
        
       
        System.out.println("B1 positive truncation: " + (int) positiveValue);
        System.out.println("B2 negative truncation: " + (int) negativeValue);
        System.out.println("B3 positive rounding: " + (int) (positiveValue + 0.5));
        System.out.println("B4 negative rounding: " + (int) (negativeValue + 0.5));
    }
}
//explanations after testing