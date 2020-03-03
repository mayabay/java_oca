/*
 * CarRental
 * v0.1
 * represents a car rental service in australia at several locations, uses office as its public interface
 * */
package au.carrental;
import au.carrental.assets.*;
import au.carrental.crm.Customer;
import au.carrental.oms.Order;

import java.util.*;
public class CarRental {

	private		String 				name;
	private		List<Site> 			sites;
	private 	Office				office;
	
	private static CarRental 		instance;
	
	private static Site 			site;
	
	private static List<Customer>	customers;
	
	private static List<Order>		orders;
	
	public  static void buildInstance( String name, List<Site> sites, Office office ) {
		if ( instance == null ) {
			instance = new CarRental( name, sites, office );
			instance.customers = new ArrayList<>();
			instance.orders = new ArrayList<>();
		} else {
			throw new IllegalStateException("This method can only be called once!");
		}
	}
	
	private CarRental(String name, List<Site> sites, Office office) {
		super();
		this.name = name;
		this.sites = sites;
		this.office = office;
	}
	 	
	public static CarRental getInstance() {
		return instance;
	}
	
	
	
	public String getName() {
		return name;
	}

	public List<Site> getLocations(){
		return Collections.unmodifiableList(this.sites);
	}

	public List<Customer> getCustomers(){
		return Collections.unmodifiableList(this.customers);
	}	
	
	public Office getOffice() {
		return office;
	}
	
	public Site getSite ( int idx ) {
		if ( idx < 0 || idx > sites.size() ) {
			System.out.println("pls enter correct idx, 1st site returned!");
			return sites.get(0);
		}
		return sites.get(idx);
	}
	
	public boolean addCustomer( Customer c ) {
		return this.customers.add(c);
	}
	
	public boolean addOrder( Order o ) {
		return this.orders.add(o);
	}
	
	public boolean removeOrder( Order o ) {
		return this.orders.remove(o);
	}	
	
}
