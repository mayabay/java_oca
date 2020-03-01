/*
 * Office
 * v0.1
 * public interface to the car rental service
 * */
package au.carrental;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

import au.carrental.assets.CoffeeMachine;
import au.carrental.assets.Site;
import au.carrental.assets.VehiclePool;
import au.carrental.crm.Account;
import au.carrental.crm.Customer;
import au.carrental.oms.IdDocument;
import au.carrental.oms.Order;
import au.carrental.oms.OrderItem;
import au.carrental.test.Test;
import au.carrental.assets.Vehicle;

public class Office implements CarRentalService, CarRentalAdminService {

	private 	final 	static 		int 	MINIMUM_AGE_YEARS = 26;
	
	private 	String 	welcomeMessage;
	

	
	@Override
	public void printServices() {
		System.out.println( "[01] print services" );
		System.out.println( "[02] set location" );
		
		System.out.println( "[05] print my orders" );
		System.out.println( "[06] print vehicles" );
		System.out.println( "[07] add customer account" );
		System.out.println( "[71] logout" );
		System.out.println( "[72] login" );
		System.out.println( "[08] list locations" );
		System.out.println( "[09] drink coffee" );
		System.out.println( "[10] place an order" );
		System.out.println( "[81] print all customers" );
		System.out.println( "[99] exit the office" );
	}	
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	@Override
	public void printWelcomeMessage() {
		System.out.println( welcomeMessage );
		
	}

	@Override
	public void printLocations() {
		CarRental cr = CarRental.getInstance();
		System.out.println("We can be found at these locations: ");
		List<Site> locations = cr.getLocations();
		for( int i = 0; i < locations.size(); i++) {
			System.out.println("[" + i + "] " + locations.get(i).getName() + ", " + locations.get(i).getAddress() + " vehicles = " + locations.get(i).getVehiclePool().size() );
		}
	}

	@Override
	public void rentVehicle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void offerLiquid( Site site ) {
		CoffeeMachine cm = site.getCoffeeMachine();
		System.out.println(cm + " => " +  cm.getLiquid() ); 
	}

	@Override
	public Customer addCustomer(String firstName, String lastName, int age, String eMail, String passw) {
		
		// 1) create account 
		//Account account = new Account( (firstName + "_" + lastName), eMail, passw );
		Account account = new Account( (firstName + "_" + lastName), passw, eMail  );
		
		// 2) create customer
		Customer c = new Customer( 	firstName,
									lastName, (LocalDate.now()).minusYears(age) ,
									eMail,
									new IdDocument( (firstName + lastName), ("sn" + (age * 7)) ) ,
									new Address( lastName, "Paris", "France" ) ,
									account
									); 
		
		// 3) add customer to our list of customers
		CarRental cr = CarRental.getInstance();
		cr.addCustomer(c);
		return c;
	}

	@Override
	public void printVehicles(Site location) {
		if ( location == null ) { System.out.println("location?"); return; }
		VehiclePool vp = location.getVehiclePool();

		List<Vehicle> list = vp.getVehicleList();

		for ( int i = 0; i < list.size(); i++ ) {
			System.out.println( "["+ i +"] " + list.get(i) );
		}
	}

	@Override
	public void printMyOrders(Customer customer) {
		
		if ( customer == null) {
			System.out.println(" pls login, or create account. ");
			return;
		}
		
		for ( Order order : customer.getOrders() ) {
			System.out.println( "\t " + order );
			for( OrderItem oi : order.getItems() ) {
				System.out.println( "\t\\t " + oi );	
			}
		}
		
		if ( customer.getOrders().size() == 0 ) {
			System.out.println("No orders for this customer!");
		}
		
	}

	@Override
	public void logout() {
		// remove session data
		
	}

	@Override
	public Customer login(String username, String password) {
		
		// 1) check for existing account
		Account account = Account.validateCredentials(username, password);
		if ( Test.debug ) 
			System.out.println("Test.login() ->  " + account);		
		if ( account == null ) { return null; }
		
		// 2) get customer and retrieve name
		String user = account.getUser();
		String[] splits = username.split("[_]");
		String firstName = splits[0], lastName = splits[1];
		if ( Test.debug )
			System.out.println("Office.login()  firstName =  " + firstName + ", lastName = " + lastName);
		
		// 3)
		return Customer.findCustomerByNames(firstName, lastName);

	}
	
	@Override
	public void printAllCustomers() {
		CarRental cr = CarRental.getInstance();
		List<Customer> customers =  cr.getCustomers();
		for( Customer c : customers ) {
			System.out.println("\t\t " + c );
		}
	}

	@Override
	public Order placeAnOrder(java.util.Scanner sc , Customer customer) {
		
		CarRental cr = CarRental.getInstance();
		
		System.out.println("---------- rent a vehicle  ----------");
		
		if ( customer == null ) {
			System.out.println("[canceled] pls login first or create an account!");
			return null;
		}
		
		// 1) Order we return
		Order order = null;
		
		// 1.1)
		java.time.Period period = Period.between(customer.getBirthDate(), LocalDate.now()  );
		//System.out.println("years = " + period.getYears());
		if ( period.getYears() < Office.MINIMUM_AGE_YEARS ) {
			System.out.println("[canceled] minimum age is " + Office.MINIMUM_AGE_YEARS + " years for using our service.");
			return null;
		}
		
		// 2) pickup
		System.out.println("List of all our locations:   ");
		this.printLocations();
		System.out.println("Choose a pickup location and date  -->2,2020-05-15T15:30<--:");
		
		String inPickup = sc.nextLine();
		// 2,2020-05-15
		Site pickupSite = getSiteFromInput(cr,  inPickup );
		LocalDateTime pickupLDT = getDTFromInput( cr, inPickup );
		
		if (Test.debug)
			System.out.println("pickup -->" + pickupSite + " " + pickupLDT );
		
		// 3) return
		System.out.println("Choose a return location and date  -->2,2020-05-15T15:30<--:");
		String inReturn = sc.nextLine();
		Site returnSite = getSiteFromInput(cr,  inReturn );
		LocalDateTime returnLDT = getDTFromInput( cr, inReturn );		
		
		if (Test.debug)
			System.out.println("return --> " +  returnSite + " " + returnLDT );		
		
		return order;
	}

	private static Site getSiteFromInput(CarRental cr,  String input ) {
		// 2,2020-05-15T15:30
		String splits[] = input.split(",");
		Integer SiteIdx = new Integer( splits[0] );	
		return cr.getSite(SiteIdx);
	}
	
	private static LocalDateTime getDTFromInput(CarRental cr, String input ) {
		// 2,2020-05-15T15:30
		String splits[] = input.split(",");
		String ldtStr = splits[1];	// 2020-05-15T15:30
		String[] ldtSplits = ldtStr.split("T");
		String[] ld = ldtSplits[0].split("-"); // 2020-05-15
		String[] lt = ldtSplits[1].split(":"); // 15:30
		int year = Integer.parseInt(ld[0]), month = Integer.parseInt(ld[1]), day = Integer.parseInt(ld[2]);
		int hour = Integer.parseInt(lt[0]), min = Integer.parseInt(lt[1]);
		return LocalDateTime.of(year, month, day, hour, min);
	}	
	
}
