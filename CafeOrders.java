public class CafeOrders {
    int small = 3;
    int medium = 4;
    int large = 5;
    public static int drinkPrice(String size, String extra){
        int price = 0;
        if (size.equals("S")){
            price = 3;
        }
        else if (size.equals("M")){
            price = 4;
        }
        else{
            price = 5;
        }
        if (extra.equals("Y")){
            price +=1;
        }
        System.out.println(price);
        return price;
    }
}
