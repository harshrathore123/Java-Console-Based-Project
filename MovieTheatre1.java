import java.util.*;

class MovieTheatre1 {
    public String movieTitle;
    public String showTime;
    public int totalSeat;
    public int seatBooking = 0;

    // Constructor
    public MovieTheatre1(String movieTitle, String showTime, int totalSeat) {
        this.movieTitle = movieTitle;
        this.showTime = showTime;
        this.totalSeat = totalSeat;
    }

    // Display method
    public void display() {
        System.out.println("Movie Title: " + movieTitle);
        System.out.println("Show Time: " + showTime);
        System.out.println("Total Seats: " + totalSeat);
        System.out.println("Booked Seats: " + seatBooking);
        System.out.println("Available Seats: " + (totalSeat - seatBooking));
        System.out.println("-----------------------------------------------");
    }

    // Seat booking method
    public void seatbooking(int numofseat) {
        System.out.println("-----------------------------");
        try {
            if (numofseat <= 0) {
                System.out.println("Select correct number of seats");
            } else if ((numofseat + seatBooking) > totalSeat) {
                System.out.println("All Seats are full or insufficient seats available");
            } else {
                seatBooking += numofseat;
                display();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Cancel booking method
    public void cancelBooking(int numofseat) {
        try {
            if (numofseat <= 0) {
                System.out.println("Please select at least one seat");
            } else if (numofseat > seatBooking) {
                System.out.println("You cannot cancel more seats than booked!");
            } else {
                seatBooking -= numofseat;
                display();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Seat available check
    public void seatavailable() {
        System.out.println("-----------------------------");
        if (seatBooking >= totalSeat) {
            System.out.println("Seats not available");
        } else {
            System.out.println("Seats available, you can book seats");
        }
        System.out.println("-----------------------------");
    }

    // Main function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        ArrayList<MovieTheatre1> list = new ArrayList<>();
        list.add(new MovieTheatre1("Jai Ho", "10:00 AM", 200));
        list.add(new MovieTheatre1("Main Tera Hero", "2:00 PM", 230));
        list.add(new MovieTheatre1("Tiger Zinda Hai", "6:00 PM", 250));

        int choice;
        int seat;

        do {
            System.out.println("**** MOVIE THEATRE ****");
            System.out.println("Press 1 for Display");
            System.out.println("Press 2 for Seat Booking");
            System.out.println("Press 3 for Seat Availability");
            System.out.println("Press 4 for Cancel Booking");
            System.out.println("Press 5 for Movie Titles");
            System.out.println("Press 6 for Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            System.out.println("-----------------------------");

            switch (choice) {
                case 1:
                    System.out.println("Display Movie Details");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("Movie Number: " + (i + 1));
                        list.get(i).display();
                    }
                    break;

                case 2:
                    System.out.println("Which movie number do you want to book?");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i).movieTitle + " (" + list.get(i).showTime + ")");
                    }
                    System.out.print("Enter movie number: ");
                    int movieNumber = sc.nextInt();

                    if (movieNumber > 0 && movieNumber <= list.size()) {
                        MovieTheatre1 selectedMovie = list.get(movieNumber - 1);
                        System.out.print("How many seats do you want to book? ");
                        seat = sc.nextInt();
                        selectedMovie.seatbooking(seat);
                    } else {
                        System.out.println("Invalid movie number selected.");
                    }
                    break;

                case 3:
                    System.out.println("Checking Seat Availability");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i).movieTitle);
                    }
                    System.out.print("Enter movie number to check: ");
                    int movieCheck = sc.nextInt();

                    if (movieCheck > 0 && movieCheck <= list.size()) {
                        list.get(movieCheck - 1).seatavailable();
                    } else {
                        System.out.println("Invalid movie number.");
                    }
                    break;

                case 4:
                    System.out.println("Which movie booking do you want to cancel?");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i).movieTitle);
                    }
                    System.out.print("Enter movie number: ");
                    int movieCancel = sc.nextInt();

                    if (movieCancel > 0 && movieCancel <= list.size()) {
                        System.out.print("How many seats do you want to cancel? ");
                        seat = sc.nextInt();
                        list.get(movieCancel - 1).cancelBooking(seat);
                    } else {
                        System.out.println("Invalid movie number.");
                    }
                    break;

                case 5:
                    System.out.println("Available Movies:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("Movie Number: " + (i + 1));
                        list.get(i).display();
                    }
                    break;

                case 6:
                    System.out.println("Exiting Project....");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please select a valid number");
            }
        } while (choice != 6);
    }
}
