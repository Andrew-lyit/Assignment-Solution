package ie.lyit.serialize;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


import ie.lyit.hotel.Customer;
import ie.lyit.hotel.CustomerDAO;

public class CustomerSerializer implements CustomerDAO {
	// Constant FILENAME for the file to be created
		final String FILENAME = "customer.bin";

		// Declare ArrayList called customer - for storing a list of customers
		private ArrayList<Customer> customer;
		
		// Default Constructor
		public CustomerSerializer(){
			// Construct books ArrayList
			customer = new ArrayList<Customer>();
		}

		//////////////////////////////////////////////////////////
		// Method Name : add()									//
		// Return Type : void								    //
		// Parameters : None								    //
		// Purpose : Reads one Customer record from the user    //
		//           and adds it to the ArrayList customer      //
		//////////////////////////////////////////////////////////	
		public void add(){
			// Create a Customer object
			Customer customer1 = new Customer();
			// Read its details
			customer1.read();	
			// And add it to the customer ArrayList
			customer.add(customer1);
		}

		////////////////////////////////////////////////////////////
		// Method Name : list()							          //
		// Return Type : void			  				          //
		// Parameters : None						 	      	  //
		// Purpose : Lists all Customer records in the ArrayList  //
		////////////////////////////////////////////////////////////	
		public void list(){
			// for every Customer object in customer
	      for(Customer tmpCustomer:customer)
				// display it
				System.out.println(tmpCustomer);
		}
		
		////////////////////////////////////////////////////////////////
		// Method Name : view()									  	  //
		// Return Type : void								          //
		// Parameters : None								          //
		// Purpose : Displays the required Customer record on screen  //
		//         : And returns it, or null if not found        	  //   
		////////////////////////////////////////////////////////////////	
		public Customer view(){
			Scanner keyboard = new Scanner(System.in);		

			// Read the number of the customer to be viewed from the user
			System.out.println("Enter Customer Number: ");
			int CustomerToView=keyboard.nextInt();
			
			// for every Customer object in customer
		    for(Customer tmpCustomer:customer){
			   // if it's number equals the number of the CustomerToView
			   if(tmpCustomer.getNumber() == CustomerToView){
			      // display it
				  System.out.println(tmpCustomer);
				  return tmpCustomer;
			   }
			}
		    // if we reach this code the customer was not found so return null
		    return null;		
		}

		////////////////////////////////////////////////////////////////// 
		// Method Name : delete()								 	    //
		// Return Type : void									    	//
		// Parameters : None											//
		// Purpose : Deletes the required Customer record from customer //
		//////////////////////////////////////////////////////////////////	
		public void delete(){	
			// Call view() to find, display, & return the customer to delete
			Customer tempCustomer = view();
			// If the customer != null, i.e. it was found then...
		    if(tempCustomer != null)
			   // ...remove it from customer
		       customer.remove(tempCustomer);
		}
		
		//////////////////////////////////////////////////////////////
		// Method Name : edit()			  					        //
		// Return Type : void									    //
		// Parameters : None									    //
		// Purpose : Edits the required Customer record in customer //
		//////////////////////////////////////////////////////////////	
		public void edit(){	
			// Call view() to find, display, & return the customer to edit
			Customer tempCustomer = view();
			// If the customer != null, i.e. it was found then...
		    if(tempCustomer != null){
			   // get it's index
			   int index=customer.indexOf(tempCustomer);
			   // read in a new customer and...
			   tempCustomer.read();
			   // reset the object in customer
			   customer.set(index, tempCustomer);
		    }
		}
		
		///////////////////////////////////////////////////////
		// Method Name : writeRecordsToFile()    			 //
		// Return Type : void								 //
		// Parameters : None								 //
		// Purpose : Writes the ArrayList customer to the       //
		//		     File customer.bin before closing the File  //
		///////////////////////////////////////////////////////	
		@Override
		public void writeRecordsToFile(){
			try{
				//Serialize the ArrayList...
				FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
				ObjectOutputStream os = new ObjectOutputStream(fileStream);
		
				os.writeObject(customer);
		
				os.close();
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store customers.");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

		///////////////////////////////////////////////////////
		// Method Name : readRecordsFromFile()    			 //
		// Return Type : void								 //
		// Parameters : None								 //
		// Purpose : Reads the ArrayList from the File back  //
		//		     into customer before closing the File      //
		///////////////////////////////////////////////////////	
		@Override
		public void readRecordsFromFile(){
			try{
				//Deserialize the ArrayList...
				FileInputStream fis = new FileInputStream(FILENAME);
				
				ObjectInputStream is = new ObjectInputStream(fis);

				// COULD use code below to ensure it is an ArrayList
				// BUT no need-we are confident file contains an ArrayList
				// Object o = is.readObject(); 	// READ an object from the file
				// if(o instanceof ArrayList)  	// IF object is an ArrayList
				//    books=(ArrayList<Book>)o;//    ASSIGN object to books			
				customer = (ArrayList<Customer>)is.readObject();

				is.close();
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot find customers file.");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}				
		}	

	}

