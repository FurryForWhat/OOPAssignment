package moviebooking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class movieMain {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        boolean bigFlag = true;
        while (bigFlag){
            System.out.println("*********Register Movie Here************");
            System.out.println("Press 1 to Register Movie: ");
            System.out.println("Press 6 to Book Ticket: ");
            System.out.println("Press 2 to Display avaliable movies: ");
            System.out.println("Press 3 to display the highest earning movie:");
            System.out.println("Press 4 to display avaliable seat : ");
            System.out.println("Press 5 to Exit: ");
            System.out.print("-> ");
            int userInput = Integer.parseInt(bufferedReader.readLine());
            switch (userInput){
                case 1 -> Movie.registerMovie();
                case 2 -> Movie.avaliableMovie(Movie.movieList);
                case 3 -> Movie.displayEarnHighMovie(Movie.movieList);
                case 4 -> Movie.avaliableSeatPerMovie(Movie.movieList);
                case 5 -> {
                    System.out.println("Exiting the System...");
                    bigFlag = false;
                    break;
                }
                case 6 -> Movie.bookTicket(Movie.movieList);
                default -> System.out.println("Invalid Option, Try again!!!!!");
            }
        }



    }
}
