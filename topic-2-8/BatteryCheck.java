public class BatteryCheck {
    public static void main(String[] args) {
        int[] charges = {62, 28, 85, 14, 47};
        // Build and print your three results here.
        // int min = charges[0];
        // int chargesBelow30 = 0;
        // boolean above80 = false;
        // for (int i = 0; i<charges.length; i++){
        // if(charges[i]<min){
        // min = charges[i];
        // }
        // if(charges[i]< 30){
        // chargesBelow30++;
        // }
        // if (charges[i]>= 80){
        // above80=true;
        // }
        // }
        //
        int below30 = 0;
        int min = charges[0];
        boolean above80 = false;
        int max = charges[0];
        int total = 0;
        int divisor =0;
        for (int charge : charges) {
            if (charge < 30) {
                below30++;
            }
            if (charge < min){
                min = charge;
            }
            if (charge > max){
                max = charge;
            }
            if (charge >= 80){
                above80 = true;
            }
            total += charge;
            divisor++;

        }
        double average = (double) total/charges.length;
     System.out.println("Current Lowest Charge: " + min + ". Current Max: " + max +  ". Below 30: " + below30 + ". Anything above 80? " + above80 + ". The average is " + average + ". The total is: " + total);
    }
}