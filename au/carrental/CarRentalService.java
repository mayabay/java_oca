/*
 * CarRentalService
 * v0.1
 * public interface for the car rental service
 * */
package au.carrental;
import java.time.*;
import au.carrental.assets.Site;

public interface CarRentalService {

	public void printWelcomeMessage();
	
	public void printLocations();
	
	public void printServices();
	
	public void rentVehicle();
	
	public void offerLiquid( Site site );
	
	public Customer addCustomer( String firstName, String lastName, int age, String eMail  );
	
	public void printVehicles( Site location );
	
	public void printMyOrders( Customer customer );
}
