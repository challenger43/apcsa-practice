import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
//todo list
//add a temporary skip comparison if it's too hard
//allow people to edit songs after made- e.g. they typoed a song or wrote wrong artist, at the end of song submission, have an opportunity to edit the array and replace/delete/add values if you accidentally type "n" before you done
//check if a song has already been added-- however need to be careful, e.g. the song Stay has been written by the Kid Laroi, Rihanna, among others, so need to work around that somehow
public class ChoiceBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> songs = new ArrayList<>();
        ArrayList<String> artists = new ArrayList<>();
        System.out.println("First, enter what you think might be your favorite song. Don't overthink.");
        String initSong = scanner.nextLine();
        songs.add(initSong);
        System.out.println("And who wrote this song?");
        artists.add(scanner.nextLine());
        System.out.println(
                "If you found it hard to pick, this will help you pick your favorite song amongst some songs you like.");
        System.out.println("Please enter a song that you like:");
        songs.add(scanner.nextLine());
        System.out.println("And who wrote this song?");
        artists.add(scanner.nextLine());
        while (songs.size() < 3) {
            System.out.println("Please enter another song:");
            songs.add(scanner.nextLine());
            System.out.println("And who wrote this song?");
            artists.add(scanner.nextLine());
        }
        System.out.println(
                "Would you like to continue adding songs? You can keep entering songs until you type n and press enter.");
        String input;
        while (scanner.hasNextLine() && !(input = scanner.nextLine()).equals("n")) {
            System.out.println("Enter a song:");
            songs.add(input);
            System.out.println("Who wrote this song");
            artists.add(scanner.nextLine());
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
        finalSongs.add(0, songs.get(0));
        // find second and 3rd favorite songs:
        while (finalSongs.size() < 3 & runnerUps.size() > 0) {
            // If there's only 1 song left, it automatically advances
            if (runnerUps.size() == 1) {
                finalSongs.add(runnerUps.get(0));
                runnerUps.remove(0);
                break;
            }
            ArrayList<String> tempArray = new ArrayList<>(runnerUps);
            while (tempArray.size() > 1) {
                String song1 = tempArray.get(0);
                String song2 = tempArray.get(1);
                System.out.println("Now let's find your runner ups. Between these two songs, which do you like more? "
                        + song1 + " or "
                        + song2 + "?");
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
                //
                tempArray.remove(2 - preferredSong); // preferredSong is 1 or 2, so this maps them to 1 and 0
                                                     // respectively
            }
            finalSongs.add(tempArray.get(0));
            System.out.println("The next runner up is: " + tempArray.get(0));
            runnerUps.remove(tempArray.get(0));
        }
        System.out.println("Your top 3 favorite songs are, in order: " + finalSongs);
        for (int i = 0; i < finalSongs.size(); i++) {
            if (finalSongs.get(i).equals(initSong)) { // find if.
                System.out.println("Your favorite is in the final 3.");
            } 
            //could've just used .contains but ig the intention was to write a for loop to find it so yeah. 
        }
        //technically no explicit else case but it's just not printing anything. 

        // planning:
        // condense entire array into one with only one instance.
        // for loop
        // check value:
        // find match of value, store count in temp count
        // delete occurences
        // if temp count > currentMax, set currentMax to temp count
        // repeat for each value
        ArrayList<String> tempArray2 = new ArrayList<>(artists);
        // create simplified array:
        ArrayList<String> condensed = new ArrayList<>();
        for (int i = 0; i < artists.size(); i++) {
            if (condensed.contains(artists.get(i))) {
                tempArray2.remove(artists.get(i));
            } else {
                condensed.add(artists.get(i));
                tempArray2.remove(artists.get(i));
            }
        }
        int max = 0;
        String mostListenedArtist = "";
        for (int i = 0; i < condensed.size(); i++) {
            int tempMax = 0;
            for (int j = 0; j < artists.size(); j++) {
                if (condensed.get(i).equals(artists.get(j))) { // count-if
                    tempMax++;
                }
            }
            if (tempMax > max) { // max
                max = tempMax;
                mostListenedArtist = condensed.get(i);
            }
        }
        System.out.println("Your most repeated artist is " + mostListenedArtist + ", with " + max + " songs");
    }
}
