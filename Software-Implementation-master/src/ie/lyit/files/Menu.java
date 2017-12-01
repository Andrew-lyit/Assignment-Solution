package ie.lyit.files;

import java.util.Scanner;

public class Menu {
   private int option;
   
   public void display(){
	 System.out.println("\n\tCustomer Menu");  
     System.out.println("\n\t1. Add a Customer");
	 System.out.println("\t2. List all Customers");
	 System.out.println("\t3. View a Customer");
	 System.out.println("\t4. Edit a Customer");
	 System.out.println("\t5. Delete a Customer");
	 System.out.println("\t6. Quit");		
   }
	
   public void readOption(){
      Scanner kbInt = new Scanner(System.in);
  	  System.out.println("\n\tEnter Option [1|2|3|4|5|6]");
   	  option=kbInt.nextInt();
   }
					
	public int getOption(){
	   return option;
	}	
}