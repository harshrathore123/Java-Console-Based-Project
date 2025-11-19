import java.util.*;
class ArithOperation{
	
	//Creating variable
	private int a;
	private int b;
	private int c;
	
	//Constructor
	/*public ArithOperation(int n1,int n2){
		this.a = n1;
		this.b = n2;
		//this.c = c;
	}*/
	
	//Making method for addition
	public void add(int x,int y){
		System.out.println("Addition of two number is: ");
		c = x+y;
		System.out.println("Sum of "+ x + " + " + y + " is: " +c);
	}
	
	//Making method for subtraction
	public void sub(int x,int y){
		System.out.println("Subtraction of two number is: ");
		c = x-y;
		System.out.println("Subtraction of "+ x + " - " + y + " is: "+c);
	}
	
	//Making method for multiplication
	public void mul(int x,int y){
		System.out.println("Multiplication of two number is: ");
		c = x*y;
		System.out.println("Multiplication of "+ x + " * " + y + " is: "+c);
	}
	
	//Making method for division
	public void divide(int x,int y){
		System.out.println("Division of two number is: ");
		c = x/y;
		System.out.println("Division of "+ x + " / " + y + " is: "+c);
	}
	
	//Making method for remainder
	public void remainder(int x,int y){
		System.out.println("Remainder of two number is: ");
		c = x%y;
		System.out.println("Remainder of "+ x + " % " + y + " is: "+c);
	}
	
	public static void main(String args[]){
		ArithOperation ao = new ArithOperation();
		Scanner sc = new Scanner(System.in);
		
		int choice;
		int a;
		int b;
				
		do{
			System.out.println("ARITHMETIC OPERATION");
			System.out.println("Press 1 for addition");
			System.out.println("Press 2 for subtraction");
			System.out.println("Press 3 for multiplication");
			System.out.println("Press 4 for division");
			System.out.println("Press 5 for remainder");
			System.out.println("Press 6 for exit");
			
			System.out.print("Please select any one option: ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("Provide value of a:  ");
					a = sc.nextInt();
					System.out.println("Provide value of b: ");
					b = sc.nextInt();
					ao.add(a,b);
					break;
				
				case 2:
					System.out.println("Provide value of a:  ");
					a = sc.nextInt();
					System.out.println("Provide value of b: ");
					b = sc.nextInt();
					ao.sub(a,b);
					break;
				
				case 3:
					System.out.println("Provide value of a:  ");
					a = sc.nextInt();
					System.out.println("Provide value of b: ");
					b = sc.nextInt();
					ao.mul(a,b);
					break;
				
				case 4:
					System.out.println("Provide value of a:  ");
					a = sc.nextInt();
					System.out.println("Provide value of b: ");
					b = sc.nextInt();
					ao.divide(a,b);
					break;
				
				case 5:
					System.out.println("Provide value of a:  ");
					a = sc.nextInt();
					System.out.println("Provide value of b: ");
					b = sc.nextInt();
					ao.remainder(a,b);
					break;
					
				case 6:
					System.out.println("Exiting Program...");
					System.exit(0);
				
				default:
					System.out.println("Given choice is not valid");
			}
		}while(choice!=6);
		
		
/*		ao.add(10,30);
		ao.sub(30,10);
		ao.mul(10,10);
		ao.divide(20,2);
		ao.remainder(10,4);
*/
	}
}