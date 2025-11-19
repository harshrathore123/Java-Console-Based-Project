import java.util.*;
class CRUD{
	
	private String name;
	private String city;
	private int age;
	private String address;
	
	public CRUD(String Name,String City,String Address,int Age){
		this.name = Name;
		this.city = City;
		this.address = Address;
		this.age = Age;
	}
	
	public void display(){
		System.out.println("***************** PERSONAL DETAIL ***************");
		System.out.println();
		
		System.out.println("---------------------------------------------------");
		System.out.println("Full Name: "+name);
		System.out.println("City: "+city);
		System.out.println("Age: "+age);
		System.out.println("Address: "+address);
		System.out.println("----------------------------------------------------");
		System.out.println();
	}
	
	public void add(String Name,String City,String Address,int Age){
		this.name = Name;
		this.city = City;
		this.address = Address;
		this.age = Age;
		
		System.out.println("***************** Updated Display ***************");
		System.out.println();
		display();
		System.out.println("--------------------------------------------------");
	}
	
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		CRUD crud = new CRUD("Harsh Rathore","Indore","A288 Abhinandan Nagar",20);
		
		int choice;
		String personname;
		String personcity;
		String personaddress;
		int personage;
		
		do{
			System.out.println("************* CRUD OPERATION **************");
			System.out.println();
			System.out.println("--------------------------------------------");
			
			System.out.println("Press 1 for display");
			System.out.println("Press 2 for add data");
			System.out.println("Press 3 for exit");
			
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();
			
			switch(choice){
				case 1:
					crud.display();
					break;
					
				case 2:
					System.out.println("************* Add Detail ************");
					System.out.println();
					
					//Clean Buffer
					sc.nextLine();
					
					System.out.println("Enter your fullname: ");
					personname = sc.nextLine();
					
					System.out.println("Enter your city: ");
					personcity = sc.nextLine();
					
					System.out.println("Enter address: ");
					personaddress = sc.nextLine();
					
					System.out.println("Enter age: ");
					personage = sc.nextInt();
					
					crud.add(personname,personcity,personaddress,personage);
					
					break;	

				case 3:
					System.out.println("Exiting Project......");
					System.exit(0);
					break;
				
				default:
					System.out.println("Invalid Number");
			}
		}while(choice!=3);
		
	}
}