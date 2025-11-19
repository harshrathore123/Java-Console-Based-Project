import java.util.*;
class RevMovieTheatre{
	
	//Creating Variable Globally
	private String movieTitle;
	private String movieTime;
	private int moviePrice;
	private int TotalSeat;
	private int BookedSeat = 0;
	
	//Making Constructor
	public RevMovieTheatre(String moviename,String movietime, int movieprice, int totalSeat){
		this.movieTitle = moviename;
		this.movieTime = movietime;
		this.moviePrice = movieprice;
		this.TotalSeat = totalSeat;
	}
	
	//Making Display Function or Method
	public void display(){
		System.out.println("******* Movie Theatre Detail Display ***********");
		System.out.println("Movie Name: "+movieTitle);
		System.out.println("Moive Time: "+movieTime);
		System.out.println("Movie Price: "+moviePrice);
		System.out.println("Total Seats: "+TotalSeat);	
		System.out.println("Booked Seats: "+BookedSeat);
		System.out.println("Remaining Seats: "+(TotalSeat-BookedSeat));
	}
	
	//Making SeatAvailability Function or Method
	public void seatAvailability(){
		try{
			if(BookedSeat >= TotalSeat){
				System.out.println("Seat is not available");
			}
			else{
				System.out.println("Seat is available you can booked seat");
			}
		}catch(Exception e){
			System.out.println("Something went wrong: "+e);
		}
	}
	
	//Making BookingSeat Function or Method
	public void seatBooking(int numofseat){
		try{
			if(numofseat <= 0){
				System.out.println("Seat number is not valid");
			}
			else if((numofseat+BookedSeat)>TotalSeat){
				System.out.println("Seat is not available");
			}
			else{
				BookedSeat += numofseat;
				display();
			}
		}
		catch(Exception e){
			System.out.println("Error Occur at seatbooking: "+e);
		}
	}
	
	//Making CancelBooking Function or Method
	public void cancelBooking(int numofseat){
		try{
			if(numofseat<=0){
				System.out.println("Seat number is not valid");
			}
			else if((numofseat > BookedSeat)){
				System.out.println("Seat is not available");
			}
			else{
				BookedSeat -= numofseat;
				display();
			}
		}catch(Exception e){
			System.out.println("Exception occur at the time of CancelBooking: "+e);
		}
	}

	
	//Making Movie Title Function or Method
	//In this we will have to stored name,price,totalseat
	public void movieTitleDetail(ArrayList<RevMovieTheatre> list){
		System.out.println("------------ Movie Title Detail ---------------");
		
		for(int i=0;i<list.size();i++){
			System.out.println("------------- Movie Number "+ (i+1) + " -------------");
			System.out.println("Movie Number: "+(i+1));
			System.out.println("Movie Name: "+list.get(i).movieTitle);
			System.out.println("Movie Time: "+list.get(i).movieTime);
			System.out.println("Movie Price: "+list.get(i).moviePrice);
			System.out.println("Total Seat: "+list.get(i).TotalSeat);
			
		}
		
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		RevMovieTheatre revmovie = new RevMovieTheatre("Jai Ho","10:00 AM",200,100);
		
		int choice,seat;
		
		do{
			System.out.println("---------------------------------");
			System.out.println("Press 1 to display movie detail");
			System.out.println("Press 2 to check seat availablility");
			System.out.println("Press 3 to booked seat");
			System.out.println("Press 4 to cancel booking");
			System.out.println("Press 5 to show movie title detail");
			System.out.println("Press 6 to exit");
			System.out.println("-----------------------------------");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice){
				case 1:
					revmovie.display();
					break;
				
				case 2:
					revmovie.seatAvailability();
					break;
				
				case 3:
					System.out.println("How much seat do you want to booked");
					seat = sc.nextInt();
					revmovie.seatBooking(seat);
					break;
					
				case 4:
					System.out.println("How much seat do you want to cancel");
					seat = sc.nextInt();
					revmovie.cancelBooking(seat);
					break;
					
				case 5:
					ArrayList<RevMovieTheatre> list = new ArrayList<>();
					list.add(new RevMovieTheatre("Avenger","03:00 PM",230,100));
					list.add(new RevMovieTheatre("Fast and Furious","01:00 PM",320,200));
					revmovie.movieTitleDetail(list);
					break;
				
				case 6:
					System.out.println("Exiting Process....");
					System.exit(0);
					break;
				
				default:
					System.out.println("Please select valid number");	
			}
		}while(choice!=6);
	}
}