/*
 * CarRentalService
 * v0.1
 * public interface for the car rental service
 * */
package au.carrental;
import au.carrental.crm.Customer;
import java.time.*;
import au.carrental.assets.Site;
import au.carrental.crm.Customer;
import au.carrental.oms.Order;

public interface CarRentalService {

	public void printWelcomeMessage();
	
	public void printLocations();
	
	public void printServices();
	
	public void offerLiquid( Site site );
	
	public Customer addCustomer( String firstName, String lastName, int age, String eMail, String passw  );
	
	public void printVehicles( Site location );
	
	public void printMyOrders( Customer customer );
	
	public void logout( Order inProcessOrder );
	
	public Customer login( String username, String password );
	
	public Order placeAnOrder(java.util.Scanner sc,  Customer customer, Site site );
		
	public void revokeOrder (Order order);
	
	public void checkOutVehicle( Order order, Site site );
	
	public Site driveToNextDst( Order order );
	
	public Order returnVehicle(java.util.Scanner sc, Order order, Site site );
}
