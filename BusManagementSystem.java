
//First Time - 52 Without Compiled -- This is 52 bcoz some mistakes (public void constructorname, system.out.printnl() spelling mistake, logic fully not correct, printline in case without using get(i))
//Second Time - Cross 75 Becouse compiled and taking feedback from ai


//import java.util.*; package for accessing scanner class and collection framework
import java.util.*;
class BusManagementSystem{
	
	//Create variable globally
	private String BusName;
	private String BusTime;
	private int BusTicketPrice;
	private String BusBordingPoint;
	private String BusDeparturePoint;
	private String BusBordingCity;
	private String BusDepartureCity;
	private String BusType;
	private int BusBooking = 0;
	private int BusTotalSeat;
	private int BusTotalTicketPrice = 0;
	
	//Parameterized Constructor
	public BusManagementSystem(String busname,String bustime,int busticketprice,String busbordingpoint,String busdeparturepoint,String busbordingcity,String busdeparturecity,int bustotalseat,String bustype){
		this.BusName = busname;
		this.BusTime = bustime;
		this.BusTicketPrice = busticketprice;
		this.BusBordingPoint = busbordingpoint;
		this.BusDeparturePoint = busdeparturepoint;
		this.BusBordingCity = busbordingcity;
		this.BusDepartureCity = busdeparturecity;
		this.BusTotalSeat = bustotalseat;
		this.BusType = bustype;
	}
	
	//Method 1. BusDetail
	public void busDetail(){
		System.out.println("---------------- BUS DETAIL --------------------");
		System.out.println("Bus Name: "+BusName);
		System.out.println("Bus Time: "+BusTime);
		System.out.println("Bus Ticket Price: "+BusTicketPrice);
		System.out.println("Bus Type AC/NON-AC: "+BusType);
		System.out.println("Bus Boarding City: "+BusBordingCity);
		System.out.println("Bus Departure City: "+BusDepartureCity);
		System.out.println("Bus Boarding Point: "+BusBordingPoint);
		System.out.println("Bus Departure Point: "+BusDeparturePoint);
		System.out.println("Bus Total Seat: "+BusTotalSeat);
		System.out.println("Bus Total Booking: "+BusBooking);
		System.out.println("Bus Ticket Available: "+(BusTotalSeat - BusBooking));
		BusTotalTicketPrice = BusBooking * BusTicketPrice;
		System.out.println("Bus Total Ticket Price: "+BusTotalTicketPrice);
		System.out.println("-----------------------------------------------------");
		System.out.println();
	}
	
	//Method 2. BusSeatBooking
	public void busSeatBooking(int numofseat){
		try{
			//Check condition if number is negative or zero
			if(numofseat <= 0){
				System.out.println("Not taken negative or zero number");
			}
			else if((numofseat + BusBooking)>BusTotalSeat){
				System.out.println("Seat is Fully Occupied");
			}
			else{
				BusBooking += numofseat;
				
				// UPDATED BUS DETAIL FOR PARTICULAR BUS
				System.out.println("-----------------------------------------");
				System.out.println();
				System.out.println("********** UPDATE BUS DETAIL *************");
				busDetail();
				System.out.println("-------------------------------------------");
			}
		}catch(Exception e){
			System.out.println("Exception Occur at Seat Booking Time: "+e);
		}
	}
	
	//Method 3. BusSeatCancellation
	public void busSeatCancellation(int numofseat){
		try{
			//Check condition if number is negative or zero
			if(numofseat <= 0){
				System.out.println("Not taken negative or zero number");
			}
			else if(numofseat > BusBooking){
				System.out.println("You cannot cancel more seats than booked!");
				System.out.println();
			}
			else{
				BusBooking -= numofseat;
				
				// UPDATED BUS DETAIL FOR PARTICULAR BUS
				System.out.println("-----------------------------------------");
				System.out.println();
				System.out.println("********** UPDATE BUS DETAIL *************");
				busDetail();
				System.out.println("-------------------------------------------");
			}
		}catch(Exception e){
			System.out.println("Exception Occur at Seat Cancellation Time: "+e);
		}
	}
	
	//Method 4. CheckBusAvailability
	public void busCheckAvailability(){
		try{
			if(BusBooking == BusTotalSeat){
				System.out.println("Seat is not available you can't booked seat");
			}else{
				System.out.println("Seat is available you can booked seat!");
			}
		}catch(Exception e){
			System.out.println("Exception Occru at Checking Availability Time: "+e);
		}
	}
	
	
	public static void main(String args[]){
		
		//For taking input using scanner class
		Scanner sc = new Scanner(System.in);
		
		//Making main class object using arraylist
		ArrayList<BusManagementSystem> bus = new ArrayList<>();
		
		//Add all bus detail which passes in constructor
		//Bus Detail from Indore -> Gwalior
		bus.add(new BusManagementSystem("Ashoka","09:30 PM",600,"Vijay Nagar","Gwalior Bypass","Indore","Gwalior",40,"AC"));
		bus.add(new BusManagementSystem("Hans","09:00 PM",1000,"Bombay Hospital","Kampoo","Indore","Gwalior",40,"Non-AC"));
		bus.add(new BusManagementSystem("Intercity","08:30 PM",800,"Arvindo","Gwalior Bus Stand","Indore","Gwalior",40,"AC"));
		bus.add(new BusManagementSystem("CityLink","10:00 PM",750,"Bombay Hospital","Chandrawali Naka","Indore","Gwalior",40,"Non-AC"));
		bus.add(new BusManagementSystem("Krishna","08:30 PM",850,"Teen Imli","Gwalior Bypass","Indore","Gwalior",40,"AC"));
		
		//Bus Detail from Indore -> Shivpuri
		bus.add(new BusManagementSystem("Ashoka","09:30 PM",600,"Vijay Nagar","Pohri Bypass","Indore","Shivpuri",40,"Non-AC"));
		bus.add(new BusManagementSystem("Hans","09:00 PM",1000,"Bombay Hospital","Guna Bypass","Indore","Shivpuri",40,"AC"));
		bus.add(new BusManagementSystem("Intercity","08:30 PM",800,"Arvindo","Pohri ByPass","Indore","Shivpuri",40,"Non-AC"));
		bus.add(new BusManagementSystem("CityLink","10:00 PM",750,"Bombay Hospital","Guna Bypass","Indore","Shivpuri",40,"AC"));
		bus.add(new BusManagementSystem("Krishna","08:30 PM",850,"Teen Imli","Krishna Travels Agency","Indore","Shivpuri",40,"AC"));
		
		
		//Taking variable for choice 
		int choice;
		//Taking Variable SelectBus
		int SelectBus;
		
		//Creating do-while loop for menu-driven
		do{
			System.out.println("**********************  BUS BOOKING **************************");
			System.out.println();
			
			System.out.println("Press 1 for Bus Detail");
			System.out.println("Press 2 for Bus Booking");
			System.out.println("Press 3 for Bus Cancellation");
			System.out.println("Press 4 for Check Availability");
			System.out.println("Press 5 for exit");
			System.out.println("-------------------------------------------------------------------");
			System.out.println();
			
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();
			
			//Switch Case
			switch(choice){
				case 1:
					// SHOW BUS DETAIL CASE
					System.out.println();
					
					//Loop for showing all the bus detail
					for(int i=0;i<bus.size();i++){
						System.out.println("--------------------------------");
						System.out.println("Bus Number: "+(i+1));
						System.out.println("--------------------------------");
						
						bus.get(i).busDetail();
						System.out.println("---------------------------------");
					}
				break;
				
				case 2:
					// BUS SEAT BOOKING CASE
					System.out.println("------------------------ BUS SEAT BOOKING -----------------------");
					System.out.println();
					
					//Display all bus detail
					for(int i=0;i<bus.size();i++){
						
						System.out.println("--------------------------------");
						System.out.println("Bus Number: "+(i+1));
						System.out.println("--------------------------------");
						
						bus.get(i).busDetail();
						System.out.println("---------------------------------");
						
						/*
						System.out.println((i+1) + ". " + bus.get(i).BusName + " " + bus.get(i).BusTime + " " + bus.get(i).BusTicketPrice + " " + bus.get(i).BusBordingCity + " " + bus.get(i).BusDepartureCity + " " + bus.get(i).BusBordingPoint + " " + bus.get(i).BusDeparturePoint + " " + bus.get(i).BusType + " " + bus.get(i).BusBooking + " " + bus.get(i).BusTotalSeat + " " + bus.get(i).BusTotalTicketPrice);
						System.out.println("-------------------------------------------------------------------------------------------");
						*/
					}
					
					System.out.println("Please Select Bus Number: ");
					SelectBus = sc.nextInt();
					
					//Now Check Bus Number is valid or not
					if(SelectBus <= 0 || SelectBus > bus.size()){
						System.out.println("Invalid Number");
					}
					else{
						BusManagementSystem selected = bus.get(SelectBus - 1);
						int numofseat;
						System.out.println("Enter How much seat do you want to booked!");
						numofseat = sc.nextInt();
						selected.busSeatBooking(numofseat);
					}
					break;
				
				case 3:
					// BUS SEAT CANCELLATION CASE
					System.out.println("------------------------ BUS SEAT CANCELLATION -----------------------");
					System.out.println();
					
					//Display all bus detail
					for(int i=0;i<bus.size();i++){
						System.out.println("--------------------------------");
						System.out.println("Bus Number: "+(i+1));
						System.out.println("--------------------------------");
						
						bus.get(i).busDetail();
						System.out.println("---------------------------------");
					}
					
					System.out.println("Please Select Bus Number: ");
					SelectBus = sc.nextInt();
					
					//Now Check Bus Number is valid or not
					if(SelectBus <= 0 || SelectBus > bus.size()){
						System.out.println("Invalid Number");
					}
					else{
						BusManagementSystem selected = bus.get(SelectBus - 1);
						int numofseat;
						System.out.println("Enter How much seat do you want to cancel!");
						numofseat = sc.nextInt();
						selected.busSeatCancellation(numofseat);
					}
					break;
			
				case 4:
					// CHECKING BUS SEAT AVAILABILITY CASE
					System.out.println("------------------------ BUS CHECK SEAT AVAILABILITY -----------------------");
					System.out.println();
					
					//Display all bus detail
					for(int i=0;i<bus.size();i++){
						System.out.println("--------------------------------");
						System.out.println("Bus Number: "+(i+1));
						System.out.println("--------------------------------");
						
						bus.get(i).busDetail();
						System.out.println("---------------------------------");
					}
					
					System.out.println("Please Select Bus Number: ");
					SelectBus = sc.nextInt();
					
					//Now Check Bus Number is valid or not
					if(SelectBus <= 0 || SelectBus > bus.size()){
						System.out.println("Invalid Number");
					}
					else{
						BusManagementSystem selected = bus.get(SelectBus - 1);
						selected.busCheckAvailability();
						System.out.println("-----------------------------------------");
					}
					break;
					
				case 5:
					System.out.println("Exiting Project....");
					System.exit(0);
					break;
					
				default:
					System.out.println("Number is invalid!");
			}
		}while(choice!=5);
		
	}
}