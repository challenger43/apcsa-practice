public class CountBelow {
    public static void main(String[] args){
       int charges[] = {62,28,85,14,47};
       int lowCount = lowest(charges);
       int atLeast = greaterThan(charges);
        System.out.println(lowCount);
        System.out.println(atLeast);
    }
    public static int lowest(int[] charges){
        int count = 0; 
        int threshold = 80;

        for (int value: charges){
            if (value<threshold){
                count++;
            }
        }
        return count;
    }
    public static int greaterThan(int[] charges){
        int count = 0;
        int threshold = 80;
        for (int value:charges){
            if (value >= threshold){
                count++;
            }
        }
        return count; 
    }
}
