// I wrote the program in the other file, binaryValue.java, not this file, so if you're looking for my day 7 assignment that's where it is, it is in the day 6 folder
public class BinaryClockMath {
    public static void main(String[] args) {
        int clockValue = 45; //thing you wanna calculate
        int remaining = clockValue; //set remaining to clockValue which is set above

        int bit1 = remaining % 2; //remainder of clockValue/remaining divided by 2 e.g. if 45 becomes 1
        remaining = remaining / 2;  //changing the value of remaining by setting it to itself divided by 2, e.g. if 45/2 = 22
        int bit2 = remaining % 2; //remainder of the current remainder (now 22)
        remaining = remaining / 2;
        int bit4 = remaining % 2;
        remaining = remaining / 2;
        int bit8 = remaining % 2;
        remaining = remaining / 2;
        int bit16 = remaining % 2;
        remaining = remaining / 2;
        int bit32 = remaining % 2;

        String bits = "" + bit32 + bit16 + bit8 + bit4 + bit2 + bit1; //put on backwards because the first value that is calculated is actually the smallest value, and it is reversed
        // I think you have to add the "" because it is a string type, and perhaps like double and int String overrides int?
        System.out.println(clockValue + " -> " + bits);
    }
}