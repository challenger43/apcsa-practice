public class IterationDay16 {
    public static void main(String[] args) {
        int remaining = 1;
        System.out.println("basic version");
        while (remaining > 0) {
            System.out.println(remaining);
            remaining = remaining - 1;
        }
        System.out.println("Done");
       // while loop version
        int max = 8;
        int numToPrint = 2;
        System.out.println("while loop version: ");
        while (numToPrint<=max){  //10 is greater than 8 
            System.out.println(numToPrint);
            numToPrint +=2;
        }
        System.out.println("Done");
        //for loop version -
        System.out.println("for loop version: ");
        for (int i = 2; i <= 8;i+=2){ // 10 is greater than 8
            System.out.println(i);
        }
          System.out.println("Done");
    }
}

//3, 2, 1, done
//5, 4, 3, 2, 1, done
//1, done
// done. --this case only prints done as it skips the loop(the initial condition immediately fails) but since printing Done is outside of the loop regardless of whether or not the loop runs it will run.