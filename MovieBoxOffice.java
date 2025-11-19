import java.util.*;
class MovieBoxOffice{
	
	// Create Variable Globally
	private String movieName;
	private int moviePrice;
	private String movieTime;
	private int totalSeat;
	private int bookedSeat = 0;
	
	// Parameterized Constructor
	public MovieBoxOffice(String name,int price,String time,int totalseat){
		this.movieName = name;
		this.moviePrice = price;
		this.movieTime = time;
		this.totalSeat = totalseat;
	}
	
	// Method 1: Movie Title
	public void movieTitle(){
	
		//Display all the movie detail
		System.out.println("**************** Movie Title ***************");
		System.out.println();
		
		//Print all the movie detail
		System.out.println("Movie Name: "+movieName);
		System.out.println("Movie Price: "+moviePrice);
		System.out.println("Movie Time: "+movieTime);
		System.out.println("Total Seat: "+totalSeat);
		System.out.println("Booked Seat: "+bookedSeat);
		System.out.println("Available Seat: "+(totalSeat-bookedSeat));
		System.out.println("----------------------------------------------");
	}
	
	// Method 2: Seat Booking
	public void seatBooking(int numofseat){
		//Using try-catch exception handling to validation
		try{
			//Checking condition if number is negative or zero
			if(numofseat <= 0){
				System.out.println("Not taking 0 or negative number");
			}
			
			//Checking if numofseat + bookedseat is greater then totalseat
			else if((numofseat+bookedSeat) > totalSeat){
				System.out.println("Seat is not available (SHOW HOUSEFULL)");
			}
			
			//if all condition is true then booked seat
			else{
				bookedSeat += numofseat;
				
				System.out.println("---------------------------------");
				System.out.println();
				System.out.println("********** UPDATED MOVIE DATA ***********");
				System.out.println();
				movieTitle();
				System.out.println("-----------------------------------------");
				
			}
		}
		catch(Exception e){
			System.out.println("Exception occur at Seat Booking "+e);
		}
	}
	
	// Method 3: Cancel Booking
	public void cancelBooking(int numofseat){
		//Handling exception to validate
		try{
			if(numofseat <= 0){
				System.out.println("Not taking 0 or negative number");
			}
			
			//Checking condition if numofseat is less than bookedSeat
			else if(numofseat > bookedSeat){
				System.out.println("No seat is occupied");
			}
			
			//If all condition is true then cancel bookedseat
			else{
				bookedSeat -= numofseat;
				
				System.out.println("---------------------------------------");
				System.out.println();
				System.out.println("************* UPDATED MOVIE DATA **************");
				System.out.println();
				movieTitle();
				System.out.println("---------------------------------------");
			}
		}catch(Exception e){
			System.out.println("Exception occur at cancelBooking time: "+e);
		}
	}
	
	// Method 4: Check Availability
	public void checkAvailability(){
		if(bookedSeat == totalSeat){
			System.out.println("Seat is not available, Show fully housefull");
		}
		else{
			System.out.println("Seat is available you can booked show");
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		ArrayList<MovieBoxOffice> movie = new ArrayList<>();
		
		movie.add(new MovieBoxOffice("Jai Ho",230,"10:00 AM",100));
		movie.add(new MovieBoxOffice("Pathaan",320,"01:00 PM",120));
		movie.add(new MovieBoxOffice("Pushpa 2",40,"02:30 PM",100));
		
		int choice,seat;
		int movieSelection;
		
		do{
			System.out.println("************** MOVIE TICKET BOOKING **************");
			System.out.println();
			
			System.out.println("Press 1 for show movie detail");
			System.out.println("Press 2 for seat booking");
			System.out.println("Press 3 for seat cancellation");
			System.out.println("Press 4 for checking seat availability");
			System.out.println("Press 5 for exit");
			System.out.println("---------------------------------------------------");
			
			System.out.println("Enter choice: ");
			choice = sc.nextInt();
			
			switch(choice){
				case 1:
					for(int i=0;i<movie.size();i++){
						System.out.println("------------------------");
						System.out.println();
						System.out.println("Movie Number: "+(i+1));
						System.out.println("------------------------------");
						movie.get(i).movieTitle();
						System.out.println("--------------------------");
					}
					break;
					
				case 2:
					System.out.println("---------- SEAT BOOKING -------------");
					System.out.println();
					
					//Display all movie detail
					for(int i=0;i<movie.size();i++){
						System.out.println("--------------------------");
						System.out.println();
						System.out.println("Movie Number: "+(i+1));
						System.out.println("---------------------------");
						movie.get(i).movieTitle();
						System.out.println("---------------------------");
					}					
					
					System.out.println("Select any movie: ");
					movieSelection = sc.nextInt();
					
					if(movieSelection <= 0 || movieSelection > movie.size()){
						System.out.println("Invalid Number");
					}
					
					MovieBoxOffice selectedbooking = movie.get(movieSelection-1);
					System.out.println("---------------------------------");
					
					System.out.println("How much seat do you want to booked");
					seat = sc.nextInt();
					System.out.println("------------------------------------");
					selectedbooking.seatBooking(seat);
					
					break;
					
				case 3:
					System.out.println("------------------ SEAT CANCELLATION ----------------");
					System.out.println();
					
					//Display all movie detail
					for(int i=0;i<movie.size();i++){
						System.out.println("-------------------------------");
						System.out.println();
						System.out.println("Movie Number: "+(i+1));
						System.out.println("--------------------------------");
						movie.get(i).movieTitle();
						System.out.println("---------------------------------");
					}
					
					System.out.println("Select any movie:  ");
					movieSelection = sc.nextInt();
					
					if(movieSelection <= 0 || movieSelection > movie.size()){
						System.out.println("Invalid Number");
					}
					
					MovieBoxOffice selectedcanellation = movie.get(movieSelection-1);
					System.out.println("-------------------------------");
					
					System.out.println("How much seat do you want to cancel");
					seat = sc.nextInt();
					System.out.println("-----------------------------------");
					selectedcanellation.cancelBooking(seat);
					
					break;
					
				case 4:
					System.out.println("------------- CHECKING AVAILABILITY -------------");
					System.out.println();
					
					//Display all movie detail
					for(int i=0;i<movie.size();i++){
						System.out.println("--------------------------------");
						System.out.println();
						System.out.println("Movie Number: "+(i+1));
						System.out.println("----------------------------------");
						movie.get(i).movieTitle();
						System.out.println("----------------------------------");
					}
					
					System.out.println();
					
					System.out.println("Select any movie: ");
					movieSelection = sc.nextInt();
					
					if(movieSelection <= 0 || movieSelection >  movie.size()){
						System.out.println("Invalid Number");
					}
					
					MovieBoxOffice selectedAvailability = movie.get(movieSelection-1);
					
					System.out.println("-------------------------------");
					selectedAvailability.checkAvailability();
					System.out.println("--------------------------------");
					
					break;
				
				case 5:
					System.out.println("Exiting Project.....");
					System.exit(0);
					break;
					
				default:
					System.out.println("Please select valid number");
			}
		}while(choice!=5);
	}
}