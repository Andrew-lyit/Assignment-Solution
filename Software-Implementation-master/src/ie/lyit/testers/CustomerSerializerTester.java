package ie.lyit.testers;

import ie.lyit.files.Menu;
import ie.lyit.serialize.CustomerSerializer;
import ie.lyit.hotel.CustomerDAO;
public class CustomerSerializerTester {
	
	public static void main(String args[]) {
		
		CustomerDAO customerDAO = new CustomerSerializer();

	//deserialize
	customerDAO.readRecordsFromFile();
	
	// Create a Menu Object
		Menu menuObj = new Menu();
		
		do {
				// Call its display() method
				menuObj.display();
				// Call its readOption() method
				menuObj.readOption();
				// Switch on the option an call the appropriate methods
				switch(menuObj.getOption()) {
				case 1: customerDAO.add();break;
				case 2: customerDAO.list();break;
				case 3: customerDAO.view();break;
				case 4: customerDAO.edit();break;
				case 5: customerDAO.delete();break;
				case 6: break;
				default:System.out.println("INVALID OPTION...");
				}
		}while(menuObj.getOption() != 6);
		
		//Serialize the ArrayList
		customerDAO.writeRecordsToFile();
		
		}
}
