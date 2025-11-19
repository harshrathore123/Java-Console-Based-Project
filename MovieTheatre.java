import java.util.*;
class MovieTheatre{
	
	//Creating variable with private access modifier for using getter setter method which is the part of encapsulation
	private String MovieTitle;
	private String MovieTime;
	private int MoviePrice;
	private int SeatBooking = 0;
	private int TotalSeat;
	
	//Making constructor and passing parameter and then use this keyword to access our variable
	public MovieTheatre(String movietitle,String time,int price,int totalSeat){
		this.MovieTitle = movietitle;
		this.MovieTime = time;
		this.MoviePrice = price;
		this.TotalSeat = totalSeat;
	}
	
	//Making display method
	public void display(){
		System.out.println("Movie Name: "+MovieTitle);
		System.out.println("Movie Time: "+MovieTime);
		System.out.println("Movie Price: "+MoviePrice);
		System.out.println("Total Seat: "+TotalSeat);
		System.out.println("Booked Seat: "+SeatBooking);
		System.out.println("Available Seat: "+(TotalSeat-SeatBooking));
		System.out.println("-----------------------------------------------");
	}

	//Making seat booking method
	public void seatbooking(int numofseat){
		System.out.println("-----------------------------");
		try{
			if(numofseat <= 0){
				System.out.println("Select correct number of seat");
			}
			else if((numofseat+SeatBooking)>TotalSeat){
				System.out.println("All Seat is full");
			}
			else{
				SeatBooking += numofseat;
				display();
			}
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	
	//Making cancel booking method
	public void cancelBooking(int numofseat){
		try{
			if(numofseat <= 0){
				System.out.println("Please select at least one sheet");
			}
			else if(SeatBooking == 0){
				System.out.println("No seat is available to delete");
			}
			else{
				SeatBooking -= numofseat;
				display();
			}
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	
	//Making seatavailable method
	public void seatavailable(){
		System.out.println("-----------------------------");
		if(SeatBooking>=TotalSeat){
			System.out.println("Seats not available");
		}
		else{
			System.out.println("Seats available you can booked seats");
		}
		System.out.println("-----------------------------");
	}	
	

	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		//Create object for MovieTheatre
		MovieTheatre movie = new MovieTheatre("Jai Ho","03:00 PM",100,50);
		
		ArrayList<MovieTheatre> list = new ArrayList<>();
		list.add(new MovieTheatre("Jai Ho","10:00 AM",200,50));
		list.add(new MovieTheatre("Main Tera Hero","2:00 PM",230,70));
		
		int choice;
		int seat;
		
		do{
			System.out.println("**** MOVIE THEATRE ****");
			System.out.println("Press 1 for display");
			System.out.println("Press 2 for seatbooking");
			System.out.println("Press 3 for seatavailable");
			System.out.println("Press 4 for cancelbooking");
			System.out.println("Press 5 for movietitle");
			System.out.println("Press 6 for exit");
			System.out.println("-----------------------------");
			System.out.println("Enter choice:");
			choice = sc.nextInt();
			System.out.println("-----------------------------");
			switch(choice){
				case 1:
					System.out.println("Display Movies Detail");
					movie.display();
					break;
			
				case 2:
					System.out.println("Seat Booking");
					System.out.println("How much seat do you want to booked");
					seat = sc.nextInt();
					movie.seatbooking(seat);
					break;
				
				case 3:
					System.out.println("Checking Seat Availability");
					movie.seatavailable();
					break;
				
				case 4:
					System.out.println("Cancellation Booked Seat");
					System.out.println("How much seat do you want to delete");
					seat = sc.nextInt();
					movie.cancelBooking(seat);
					break;
				
				case 5:
					System.out.println("See Movies Title");
					for(int i=0;i<list.size();i++){
						System.out.println("Movie Number: "+(i+1));
						list.get(i).display();
					}
					
					break;
					
				case 6:
					System.out.println("Exiting Project....");
					System.exit(0);
					break;
				
				default:
					System.out.println("Please Select valid number");
			}
		}while(choice!=6);
		
		
	}
}