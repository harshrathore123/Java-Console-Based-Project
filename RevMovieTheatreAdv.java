import java.util.*;
class RevMovieTheatreAdv{
	
	//Creating Variable globally
	private String name;
	private String time;
	private int price;
	private int totalSeat;
	private int bookedSeat = 0;
	private int totalPrice = 0;
	
	//Creating Parameter Constructor
	public RevMovieTheatreAdv(String movie_name,String movie_time,int movie_price,int movie_totalSeat){
		this.name = movie_name;
		this.time = movie_time;
		this.price = movie_price;
		this.totalSeat = movie_totalSeat;
	} 
	
	//Creating MovieTitle Method
	public void movieTitle(){
		System.out.println("Movie Name: "+name); 
		System.out.println("Movie Time: "+time);
		System.out.println("Movie Price: "+price);
		System.out.println("Total Seat for this " + name + " is: "+totalSeat);
		System.out.println("Available Seat for this " + name + " is: "+(totalSeat-bookedSeat));	
		totalPrice = bookedSeat*price;
		System.out.println("Total Price: "+totalPrice);
	}
	
	//Creating SeatBooking Method
	public void movieSeatBooking(int numofseat){
		try{
			//Checking condition if user take negative number
			if(numofseat <= 0){
				System.out.println("Taking Correct Number not negative");
			}
			//Checking condition if user booked seat but seat is full
			else if((numofseat+bookedSeat)>totalSeat){
				System.out.println("Seat is fully occupied");
			}
			//Else Booked Successfully
			else{
				bookedSeat += numofseat;
				System.out.println("Seat is booking successfully");
			}
		}catch(Exception e){
			System.out.println("Something went wrong at the time of SeatBooking: "+e);
		}
	}
	
	//Creating SeatCancellation Method
	public void movieSeatCancellation(int numofseat){
		try{
			if(numofseat <= 0){
				System.out.println("Number is invalid!");
			}
			else if(numofseat > bookedSeat){ // (1 > 100)
				System.out.println("Cancellation is not possible because no seat is occupied");
			}
			else{
				bookedSeat -=  numofseat;
				System.out.println("Seat is cancel successfully");
			}
		}catch(Exception e){
			System.out.println("There is no any seat for cancellation");
		}
	}
	
	//Creating seatAvailability Method
	public void seatAvailability(){
		if(bookedSeat == totalSeat){
			System.out.println("Seat is not available (HOUSEFULL)");
		}
		else{
			System.out.println("Seat is available You can booked sheet");
		}
	}
	
	
	
	public static void main(String args[]){
		
		//Creating Scanner class object for taking input at the time of execution
		Scanner sc = new Scanner(System.in);
		
		//Creating Class Object using ArrayList
		ArrayList<RevMovieTheatreAdv> movie = new ArrayList<>();
		movie.add(new RevMovieTheatreAdv("Pathaan","09:00 AM",180,100));
		movie.add(new RevMovieTheatreAdv("Jai Ho","11:00 AM",200,90));
		movie.add(new RevMovieTheatreAdv("Chennai Express","01:00 PM",320,150));
		movie.add(new RevMovieTheatreAdv("Tiger Zinda Hai","03:00 PM",220,60));
		movie.add(new RevMovieTheatreAdv("War 2","06:00 PM",380,100));
		
		//Menu Driven
		int choice,numofseat;
		
		//Making do while loop becouse first time it always exceute and then check condition
		//This is menu-driven
		do{
			
			System.out.println("---------------------------------------");
			System.out.println("Press 1 for display movie title");
			System.out.println("Press 2 for Seat Booking");
			System.out.println("Press 3 for Cancellation Booking");
			System.out.println("Press 4 for Check Availability");
			System.out.println("Press 5 for exit");
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();
			System.out.println("-----------------------------------------");
			
			switch(choice){
				case 1:
					System.out.println("***********----Display Movies----**********");
					System.out.println();
					for(int i=0;i<movie.size();i++){
						System.out.println("Movie Number: "+(i+1));
						System.out.println("-------------------------");
						movie.get(i).movieTitle();
						System.out.println();
					}
					break;
					
				case 2:
					System.out.println("***************** Seat Booking ******************");
					System.out.println();
					
					try{
					
					//Display all movies
					for(int i=0;i<movie.size();i++){
						System.out.println((i+1) + ". " + movie.get(i).name + " ( " + movie.get(i).time + " ) " + " " + movie.get(i).price);
					}		
					
					//Here now first select which movie then according to this movie booked seat
					int movienumselect;
					System.out.println("Which movie do you want to watch?");
					movienumselect = sc.nextInt();
							
							
					//Validate the number
					if(movienumselect < 1 || movienumselect > movie.size()){
						System.out.println("Invalid movie number!");
						break;
					}
					else{
						//Selected Movie is used for select particular movie it means that it target only that movie and update record
						RevMovieTheatreAdv selectedMovie = movie.get(movienumselect-1);
						
						//Seat Booking
						System.out.println("How much seat do you want to booked");
						numofseat = sc.nextInt();
						selectedMovie.movieSeatBooking(numofseat);
						
						//Display that data
						System.out.println("--------------------------------------------");
						System.out.println("----- Updated Movie Details -----");
						selectedMovie.movieTitle();
						System.out.println("--------------------------------------------");
					}
						
					}catch(Exception e){
							System.out.println("Movie number is not valid Exception: "+e);
						}
					
					System.out.println("--------------------------------------------");
					break;
				
				case 3:
					System.out.println("**************Cancellation Seat*********************");
					System.out.println();
					
					try{
					//Display All Movies Detail
					for(int i=0;i<movie.size();i++){
						System.out.println((i+1) + ". " + movie.get(i).name + " ( " + movie.get(i).time + " ) " + " " + movie.get(i).price);
					}
				
					int movienumselect;
					System.out.println("In which movie do you want to cancel the ticket, Please select movie number");
					movienumselect = sc.nextInt();
					
					if(movienumselect < 0 || movienumselect > movie.size()){
						System.out.println("Please select valid movie number");
					}
					else{
						
						//Creating Main Class Object
						RevMovieTheatreAdv selectedMovie = movie.get(movienumselect-1);
						
						System.out.println("How much ticket do you want to cancel");
						numofseat = sc.nextInt();
						selectedMovie.movieSeatCancellation(numofseat);
						
						//Display Data
						System.out.println("-------------------------------------------");
						System.out.println("****************Updated Data**************");
						System.out.println();
						selectedMovie.movieTitle();
						System.out.println("--------------------------------------------");
					}
					
					}catch(Exception e){
						System.out.println("Exception occur at cancellation time: "+e);
					}
					break;
					
				case 4:
					System.out.println("**************Check Availability******************");
					System.out.println();
					
					try{
						
						//Display all movies
						for(int i=0;i<movie.size();i++){
							System.out.println((i+1) + ". " + movie.get(i).name + " ( " + movie.get(i).time + " ) " + " " + movie.get(i).price);
						}
						
						int checkAvailableMovie;
						System.out.println("Please select movie for checking availability");
						checkAvailableMovie = sc.nextInt();
						
						if(checkAvailableMovie < 0 || checkAvailableMovie > movie.size()){
							System.out.println("Please select valid number");
						}
						else{
							
							//Making Object for use method
							RevMovieTheatreAdv selected = movie.get(checkAvailableMovie-1);
							
							
							//Display Data
							System.out.println("-------------------------------------------");
							System.out.println();
							selected.seatAvailability();
							System.out.println("--------------------------------------------");					
							
						}
						
						
					}catch(Exception e){
						System.out.println("Exception at Check Availability: "+e);
					}
					break;
				
				case 5:
					System.out.println("Exiting Project....");
					System.exit(0);
					break;
					
				default:
					System.out.println("Please Select Correct Number");
			}
		}while(choice!=5);
	}
}
