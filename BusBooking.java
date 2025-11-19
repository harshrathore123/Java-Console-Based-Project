//Starting BusBooking from 11:00 break 11:10 continue 11:23 break 11:24
//continue 11:45 complete 12:15

import java.util.*;
class BusBooking{
	
	// Global Variable
	private String busName;
	private String  busTime;
	private int busPrice;
	private int totalSeat;
	private int totalPrice = 0;
	private int busSeatBooked = 0;
	
	// Parameterized Constructor
	public BusBooking(String busname,String bustime,int busprice,int totalseat){
		this.busName = busname;
		this.busTime = bustime;
		this.busPrice = busprice;
		this.totalSeat = totalseat;
	}
	
	// Method 1. BusDetail
	public void BusDetail(){
		System.out.println("*********** BUS DETAIL **************");
		System.out.println();
		
		System.out.println("Bus Name: "+busName);
		System.out.println("Bus Time: "+busTime);
		System.out.println("Bus Price: "+busPrice);
		System.out.println("Total Seat: "+totalSeat);
		System.out.println("Booked Seat: "+busSeatBooked);
		totalPrice = busPrice * busSeatBooked;
		System.out.println("Total Price: "+totalPrice);
		System.out.println("--------------------------------------");
		System.out.println();
	}
	
	// Method 2. BusSeatBooking
	public void BusSeatBooking(int numofseat){
		try{
			if(numofseat <= 0){
				System.out.println("Not accept negative or zero number");
			}
			else if((numofseat+busSeatBooked) > totalSeat){
				System.out.println("Seat is fully occupied");
			}
			else{
				busSeatBooked += numofseat;
				
				System.out.println("*****************************");
				System.out.println();
				
				System.out.println("********** UPDATED BUS DETAIL *************");
				System.out.println();
				
				BusDetail();
				System.out.println("---------------------------------");
			}
		}catch(Exception e){
			System.out.println("Exception occur at seat booking time: "+e);
		}
	}
	
	// Method 3. BusSeatCancellation
	public void BusSeatCancellation(int numofseat){
		try{
			if(numofseat <= 0){
				System.out.println("Not accepting negative or zero number");
			}
			else if(numofseat > busSeatBooked){
				System.out.println("Seat is empty so you can not cancel any seat");
			}
			else{
				busSeatBooked -= numofseat;
				
				System.out.println("*********************************");
				System.out.println();
				
				System.out.println("********** UPDATE BUS DETAIL **********");
				System.out.println();
				
				BusDetail();
				System.out.println();
			}
		}catch(Exception e){
			System.out.println("Exception occur at cancellation time: "+e);
		}
	}
	
	// Method 4. BusSeatAvailability
	public void BusSeatAvailability(){
		try{
			if(busSeatBooked == totalSeat){
				System.out.println("Seat is fully occupied");
			}
			else{
				System.out.println("Seat is available you can booked ticket");
			}
		}catch(Exception e){
			System.out.println("Exception occur at checking availability time: "+e);
		}
	}
	
	public static void main(String args[]){
		
		// Creating Scanner class to take input
		Scanner sc = new Scanner(System.in);
		
		
		// Creating ArrayList class object to store multiple data
		ArrayList<BusBooking> bus = new ArrayList<>();
		
		
		// Add Data in bus object
		bus.add(new BusBooking("Ashoka","08:45 PM",750,40));
		bus.add(new BusBooking("CityLink","09:00 PM",1000,40));
		bus.add(new BusBooking("Intercity","10:00 PM",850,60));
		
		
		// Creating variable for choice, num of seat and selecteMovie
		int choice;
		int selectedbus;
		int seat;
		
		// Do-while loop for menu-driven		
		do{
			System.out.println("************* BUS BOOKING PROJECT *****************");
			System.out.println("----------------------------------------------------");
			System.out.println();
			
			System.out.println("Press 1 for display bus detail");
			System.out.println("Press 2 for bus seat booking");
			System.out.println("Press 3 for bus seat cancellation");
			System.out.println("Press 4 for checking seat availability");
			System.out.println("Press 5 for exit");
			System.out.println("-----------------------------------------------------");
			System.out.println();
			
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			System.out.println();
			
			// Switch case for multiple case with condition
			switch(choice){
				case 1:
					
					for(int i=0;i<bus.size();i++){
						System.out.println("******************");
						System.out.println();
						System.out.println("Bus Number: "+(i+1));
						System.out.println("--------------------");
						bus.get(i).BusDetail();
						System.out.println("---------------------");
					}
					
					break;
					
				case 2:
					System.out.println("************ BUS SEAT BOOKING *************");
					System.out.println();
					
					for(int i=0;i<bus.size();i++){
						System.out.println("*****************************");
						System.out.println();
						System.out.println("Bus Number: "+(i+1));
						System.out.println();
						bus.get(i).BusDetail();
						System.out.println("--------------------------------");
					}
					
					System.out.println("Enter selected bus number: ");
					selectedbus = sc.nextInt();
					
					if(selectedbus <= 0 ||selectedbus > bus.size()){
						System.out.println("Invalid Number");
					}
					
					BusBooking seatSelected = bus.get(selectedbus-1);
					System.out.println();
					
					System.out.println("Enter how much seat do you want to booked");
					seat = sc.nextInt();
					
					seatSelected.BusSeatBooking(seat);
					System.out.println();
					
					break;
			
			case 3:
				System.out.println("************ BUS SEAT CANCELLATION ***************");
				System.out.println();
				
				for(int i=0;i<bus.size();i++){
					System.out.println("***************************************");
					System.out.println();
					System.out.println("Bus Number: "+(i+1));
					System.out.println();
					bus.get(i).BusDetail();
					System.out.println("----------------------------------------");
				}
				
				System.out.println("Enter selected bus: ");
				selectedbus = sc.nextInt();
				
				if(selectedbus <= 0 || selectedbus > bus.size()){
					System.out.println("Invalid Number");
				}
				
				BusBooking seatCancel = bus.get(selectedbus-1);
				System.out.println();
				
				System.out.println("Enter how much seat do you want to cancel ticket");
				seat = sc.nextInt();
				
				seatCancel.BusSeatCancellation(seat);
				System.out.println();
				
				break;
			
			case 4:
				System.out.println("************ CHECKING AVAILABILITY ***************");
				System.out.println();
				
				for(int i=0;i<bus.size();i++){
					System.out.println("*************************************");
					System.out.println();
					
					System.out.println("Bus Number: "+(i+1));
					System.out.println("--------------------------------------");
					
					bus.get(i).BusDetail();
					System.out.println();
				}
				
				System.out.println("Enter selected bus number: ");
				selectedbus = sc.nextInt();
				
				if(selectedbus <=  0 || selectedbus > bus.size()){
					System.out.println("Invalid Number");
				}
				
				BusBooking seatAvailable = bus.get(selectedbus - 1);
				System.out.println();
				
				seatAvailable.BusSeatAvailability();
				System.out.println();
				
				break;
				
			case 5:
				System.out.println("Exiting Project...");
				System.exit(0);
				break;
				
			default:
				System.out.println("Please select valid number");
			}	
		}while(choice!=5);
	}
}