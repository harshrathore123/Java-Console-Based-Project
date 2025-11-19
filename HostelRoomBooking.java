import java.util.*;
class HostelRoomBooking{
	
	//Declare Variable Globally
	private String HostelName;
	private String HostelCity;
	private String HostelAddress;
	private String HostelOwnerName;
	private int HostelRoomPrice;
	private int HostelTotalRoom;
	private int HostelRoomBooked = 0;
	private int HostelRoomTotalPrice = 0;
	
	// Constructor Parameterized
	public HostelRoomBooking(String hostelname,String hostelcity,String hosteladdress,String hostelownername,int hosteltotalroom,int hostelroomprice){
		this.HostelName = hostelname;
		this.HostelCity = hostelcity;
		this.HostelAddress = hosteladdress;
		this.HostelOwnerName = hostelownername;
		this.HostelTotalRoom = hosteltotalroom;
		this.HostelRoomPrice = hostelroomprice;
	}
	
	
	//Methods:
	//Method 1. hostelDetail()
	public void hostelDetail(){
		System.out.println("*************** HOSTEL DETAIL *********************");
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println();
		
		System.out.println("Hostel Name: "+HostelName);
		System.out.println("Hostel City: "+HostelCity);
		System.out.println("Hostel Address: "+HostelAddress);
		System.out.println("Hostel OwnerName: "+HostelOwnerName);
		System.out.println("Hostel Total Room: "+HostelTotalRoom);
		System.out.println("Hostel RoomPrice PerDay: "+HostelRoomPrice);
		System.out.println("Hostel Room Booked: "+HostelRoomBooked);
		System.out.println("Hostel Room Available: "+(HostelTotalRoom - HostelRoomBooked));
		roomTotalPrice();
		System.out.println();
	}
	
	//Method 2. roomBooking()
	public void roomBooking(){
		
	}
	
	//Method 3. roomAvailability()
	public void roomAvailability(){
		
	}
	
	//Method 4. roomCancellation()
	public void roomCancellation(){
		
	}
	
	//Method 5. roomTotalPrice()
	public void roomTotalPrice(){
		HostelRoomTotalPrice *= HostelRoomBooked;
		System.out.println("Hostel Room Total Price PerDay: "+HostelRoomTotalPrice);
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		ArrayList<HostelRoomBooking> hostel = new ArrayList<>();
		hostel.add(new HostelRoomBooking("Satya Sai Hostel","Indore","Lig Square","Mr. Sandeep Tomar",30,500));
		hostel.add(new HostelRoomBooking("Sapna Sangeet Hostel","Indore","Bhawarkua","Mrs. Karishma Sharma",50,1000));
		hostel.add(new HostelRoomBooking("Girls Hostel","Indore","Bhawarkua","Mr. Rahul Vedi",90,1100));
		hostel.add(new HostelRoomBooking("Boys Hostel","Indore","Bhawarkua","Mrs. Kesh Verma",20,800));
		hostel.add(new HostelRoomBooking("Jaydeep Hostel","Indore","Vijay Nagar","Mr. Pankaj Tripati",40,450));
		
		int choice,seat,selectedHostelRoom;
		
		do{
			System.out.println("****************** HOSTEL ROOM BOOKING **********************");
			System.out.println();
			System.out.println("--------------------------------------------------------------");
			System.out.println();
			
			System.out.println("Press 1 for hostel detail");
			System.out.println("Press 2 for hostel room booking");
			System.out.println("Press 3 for hostel room checking availability");
			System.out.println("Press 4 for hostel room cancellation");
			System.out.println("Press 5 for hostel room total price");
			System.out.println("Press 6 for exit");
			System.out.println("---------------------------------------------------------------");
			System.out.println();
			
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			switch(choice){
				case 1:
					// Display hostel detail
					for(int i=0;i<hostel.size();i++){
						System.out.println("********************");
						System.out.println();
						System.out.println("Hostel Number: "+(i+1));
						System.out.println("---------------------------");
						hostel.get(i).hostelDetail();
						System.out.println("----------------------------");
						System.out.println();
					}
					break;
					
				case 2:
					// Hostel room booking
					break;
					
				case 3:
					// Hostel room checking availability
					break;
				
				case 4:
					// Hostel room cancellation
					break;
					
				case 5:
					// Hostel room total price
					break;
					
				case 6:
					// Exit
					System.out.println("Exiting Process....");
					System.exit(0);
					break;
				
				default:
					System.out.println("Please select valid number");
			}
		}while(choice!=6);
	}
}