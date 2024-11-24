package moviebooking;

import com.sun.jdi.VMOutOfMemoryException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.DoubleToLongFunction;

public class Movie {
    static int MovieCount = 0;
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static  Movie[] movieList = new Movie[10];
    protected String movieName;
    private String genre;
    private int avaliableSeat;
    private double ticketPrice;

    public Movie(String movieName, String enre, int seat, double price){
        this.movieName = movieName;
        this.genre= enre;
        this.avaliableSeat = seat;
        this.ticketPrice = price;
    }
    public static void registerMovie() throws IOException {
        boolean flag = true;
        while (flag){
            Movie newMovie = getMovieInfo();
            System.out.println("Add more?? yes/no");
            String answer = bufferedReader.readLine();
            if(answer.equalsIgnoreCase("no")){
                flag = false;
            }

        }
    }
    public static Movie getMovieInfo() throws IOException {
        System.out.println("<<<<<<<<<<< Movie Registration >>>>>>>>>>>>");
        System.out.print("Enter Movie Name :");
        String movieName = bufferedReader.readLine();
        System.out.println("Enter Movie Genre :");
        String movieGenre = bufferedReader.readLine();
        System.out.println("Enter Avaliable Seat :");
        int avaliSeat = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter Price/Ticket : ");
        double price = Double.parseDouble(bufferedReader.readLine());

        Movie newMovie = new Movie(movieName,movieGenre,avaliSeat,price);
        movieList[MovieCount] = newMovie;
        MovieCount += 1;
        return newMovie;
    }

    public static void avaliableMovie(Movie[] avaliMovies){
        if (avaliMovies == null){
            System.out.println("No Movie was Found!!!!");
        }else{
            System.out.println("******* Avaliable Movie **********");
            int index = 1;
            for (Movie movie : avaliMovies){
                if(movie == null){
                    continue;
                }else{
                    System.out.println(index+" "+movie.movieName);
                    index ++;
                }
            }
        }
    }
    ////////////////////////////////// error buffer ////////////////////////
    public static void bookTicket(Movie[] movieList) throws IOException {
        if (movieList == null){
            System.out.println("No Movie is there in Cinema...");
        }else{
            System.out.println("************** Movie Booking **********");
            System.out.println("Movie Name: ");
            String name = bufferedReader.readLine();
            boolean movieFlag = false;
            for(Movie movie : movieList){
                if(name.equalsIgnoreCase(movie.movieName)){
                    System.out.println("There are "+movie.avaliableSeat+" left...");
                    movieFlag = true;
                    System.out.println("How many Seats???");
                    int seat = Integer.parseInt(bufferedReader.readLine());
                    if (seat > movie.avaliableSeat){
                        System.out.println("Not Enough Seat...");
                    }else{
                        double totalPrice = movie.ticketPrice * seat;
                        System.out.println("It will cost "+totalPrice+ " Baht");
                        System.out.print("Proceed??? yes/no");
                        String ans= bufferedReader.readLine();
                        if(ans.equalsIgnoreCase("no")){
                            System.out.print("You Broke................");
                        }else{
                            movie.avaliableSeat -= seat;
                            System.out.println("Purchased: "+seat+"\nEnjoy the movie...");
                            break;
                        }
                    }
                }
            }if(!movieFlag){
            System.out.println("Sorry, we don't have "+name+" movie:((");

            }
        }
    }

    public static void avaliableSeatPerMovie(Movie[] movieList){
        if(movieList == null || MovieCount  == 0){
            System.out.print("No Movie was Found!!!");
        }else{
            for(Movie movie : movieList){
                if(movie == null){
                    continue;
                }else{
                    System.out.println("Movie Name: "+movie.movieName+" | seat avaliable : "+movie.avaliableSeat);
                }
            }
        }
    }
    public static void displayEarnHighMovie(Movie[] movieList){
        if (movieList == null || MovieCount == 0){
            System.out.println("No Movie was Found!!!!");

        }else{
            System.out.println("******* The Highest Income Movie **********");
            int index = 1;
            Movie highest = movieList[0];
            for (int i = 1 ; i < MovieCount; i++){
                if(movieList[i].avaliableSeat < highest.avaliableSeat){
                    highest = movieList[i];
                }
            }
            System.out.println(highest.movieName+ " has the highest income...");
        }
    }

    @Override
    public String toString(){
        return "Registered Movie: "+"\n{Name: "+this.movieName+
                " Genre: "+this.genre+
                " Avaliable Seat: "+this.avaliableSeat+
                " Price per Ticket: "+this.ticketPrice+" }";
    }

}
