/*
 * Office
 * v0.1
 * public interface to the car rental service
 * */
package au.carrental;
import java.time.LocalDate;
import java.util.*;

import au.carrental.assets.CoffeeMachine;
import au.carrental.assets.Site;
import au.carrental.assets.VehiclePool;
import au.carrental.assets.Vehicle;

public class Office implements CarRentalService {

	private 	String 	welcomeMessage;
	
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
			System.out.println("[" + i + "] " + locations.get(i).getAddress() + " vehicles = " + locations.get(i).getVehiclePool().size() );
		}
		
		
	}

	@Override
	public void printServices() {
		System.out.println( "[1] print services" );
		System.out.println( "[2] set location" );
		
		System.out.println( "[5] print my orders" );
		System.out.println( "[6] print vehicles" );
		System.out.println( "[7] add customer account" );
		System.out.println( "[8] list locations" );
		System.out.println( "[9] drink coffee" );
		System.out.println( "[x] exit the office" );
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
	public Customer addCustomer(String firstName, String lastName, int age, String eMail) {
		Customer c = new Customer( 	firstName,
									lastName, (LocalDate.now()).minusYears(age) ,
									eMail,
									new IdDocument( (firstName + lastName), ("sn" + (age * 7)) ) ,
									new Address( lastName, "Paris", "France" ) 
									); 
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

	
	
}
