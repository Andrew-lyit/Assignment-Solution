package ie.lyit.hotel;

public interface CustomerDAO {
	void add();
	void list();
	Customer view();
	void edit();
	void delete();
	void readRecordsFromFile();
	void writeRecordsToFile();
	
}
