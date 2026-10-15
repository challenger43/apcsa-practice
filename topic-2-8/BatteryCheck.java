public class BatteryCheck {
    public static void main(String[] args) {
        int[] charges = {80, 30, 95};
        // Build and print your three results here.
        int min = charges[0];
        int chargesBelow30 = 0;
        boolean above80 = false;
        for (int i = 0; i<charges.length; i++){
            if(charges[i]<min){
                min = charges[i];
            }
            if(charges[i]< 30){
                chargesBelow30++;
            }
            if (charges[i]>= 80){
                above80=true;
            }
        }
        System.out.println("Current Lowest Charge: " + min + ". Below 30: " + chargesBelow30 + ". Anything above 80? " + above80);
    }
}