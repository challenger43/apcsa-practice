import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ChoiceBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This will help you pick your favorite song.");
        ArrayList<String> songs = new ArrayList<>();
        System.out.println("Please enter a song:");
        songs.add(scanner.nextLine());
        while (songs.size() < 3) {
            System.out.println("Please enter another song:");
            songs.add(scanner.nextLine());
        }
        System.out.println(
                "Would you like to continue adding songs? You can keep entering songs until you type n and press enter.");
        String input;
        while (scanner.hasNextLine() && !(input = scanner.nextLine()).equals("n")) {
            songs.add(input);
            System.out.println("registered");
        }
        System.out.println(
                "You have finished adding your songs. Now you will begin eliminating them to find your favorite song.");
        System.out.println(
                "For the following questions, type 1 for the first song, and 2 for the second song. Else it will mess up.");
        ArrayList<String> finalSongs = new ArrayList<>();
        ArrayList<String> runnerUps = new ArrayList<>();
        // find first favorite song
        while (songs.size() > 1) {
            System.out.println(
                    "Between these two songs, which do you like more? " + songs.get(0) + " or " + songs.get(1) + "?");
            int preferredSong = scanner.nextInt();
            while (preferredSong != 1 && preferredSong != 2) {
                System.out.println("Ensure you type a number, 0, or 1, or else we will be stuck here forever");
                scanner.nextLine();
                if (scanner.hasNextInt()) {
                    preferredSong = scanner.nextInt();
                } else {
                    scanner.nextLine();
                }
            }
            if (preferredSong == 1) {
                runnerUps.add(songs.get(1));
                songs.remove(1);
            } else {
                runnerUps.add(songs.get(0));
                songs.remove(0);
            }
        }
        System.out.println("Your favorite song is: " + songs.get(0));
    //     finalSongs.add(0, songs.get(0));
    //          // find second and 3rd favorite songs:
    //     while (finalSongs.size() <4 && runnerUps.size() >0) {
            
            
    //         // If there's only 1 song left, it automatically advances
    //         if (runnerUps.size() == 1) {
    //             finalSongs.add(runnerUps.get(0));
    //             runnerUps.remove(0);
    //             break;
    //         }
    //         ArrayList<String> tempArray = new ArrayList<>(runnerUps);
    //         while (tempArray.size() > 1) {
    //             String song1 = tempArray.get(0);
    //             String song2 = tempArray.get(1);
    //             System.out.println("Between these two songs, which do you like more? " + song1 + " or "
    //                     +song2+ "?");
    //             int preferredSong = scanner.nextInt();
    //             while (preferredSong != 1 && preferredSong != 2) {
    //                 System.out.println("Ensure you type a number, 0, or 1, or else we will be stuck here forever");
    //                 scanner.nextLine();
    //                 if (scanner.hasNextInt()) {
    //                     preferredSong = scanner.nextInt();
    //                 } else {
    //                     scanner.nextLine();
    //                 }
    //             }
    //             if (preferredSong == 1) {
    //                 // runnerUps.add(songs.get(1));
    //                 tempArray.remove(1);
    //             } else {
    //                 // runnerUps.add(songs.get(1));
    //                 tempArray.remove(0);
    //             }
    //         }
    //         finalSongs.add(tempArray.get(0));
    //         tempArray.remove(0);
    //     }
        
    //     System.out.println(finalSongs);
    }
}
