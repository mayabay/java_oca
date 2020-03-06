/*
 * Customer
 * v0.1	
 * represents a customer in the car rental project
 * 
 * */
package au.carrental.crm;
import java.util.*;

import au.carrental.Address;
import au.carrental.CarRental;
import au.carrental.oms.IdDocument;
import au.carrental.oms.Order;
import au.carrental.assets.Vehicle;
import au.carrental.test.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Customer {

	private static	int customerIdPool = 1;			
	
	private String 			firstName;
	private String 			lastName;
	private LocalDate		birthDate;
	private String 			eMail;
	
	private IdDocument		idDoc; 	
	private Address			address;
	private List<Order>		orders;
	private Account			account;
	private int				customerId;
	private List<Vehicle>	rentedVehicles;
	
	public Customer(String firstName, String lastName, LocalDate birthDate, String eMail, IdDocument idDoc,
			Address address, Account account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.eMail = eMail;
		this.idDoc = idDoc;
		this.address = address;
		this.orders = new ArrayList<>();
		this.account = account;
		this.customerId = customerIdPool++;
		this.rentedVehicles = new ArrayList<>();
	}

	// ----------------------------------------
	
	public List<Order> getOrders(){
		return Collections.unmodifiableList(this.orders);
	}

	public Order popOrder() {
		if ( this.orders.size() > 0 ) {
			return this.orders.get(this.orders.size() -1 );
		}else {
			return null;
		}
	}
	
	public void addOrder (Order order) {
		this.orders.add(order);
	}
	
	public Order setOrder (Order order) {
		 return this.orders.set(( this.orders.indexOf(order) ), order);
	}	
	
	protected Account getAccount() {
		return this.account;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}
	
	public boolean addRentedVehicle( Vehicle vehicle ) {
		return this.rentedVehicles.add( vehicle );
	}
	
	public boolean removeRentedVehicle( Vehicle vehicle ) {
		return this.rentedVehicles.remove(vehicle);
	}

	public List<Vehicle> getRentedVehicles(){
		return Collections.unmodifiableList(this.rentedVehicles);
	}
	
	public void printRentedVehicles() {
		for( Vehicle vehicle : this.rentedVehicles ) {
			System.out.println("\t\t rented --> " + vehicle);
		}
	}

	public Address getAddress() {
		return address;
	}	
	
	
	// ----------------------------------------

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (firstName == null) {						// first name is null
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))		// not null but v not equal
			return false;
		if (lastName == null) {							// last name is null
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))		// not null but v not equal
			return false;
		return true;		// both objects (and relevant fields) are not null and same 
	}
	
	public static Customer findCustomerByNames( String firstName, String lastName ) {
		Customer customer = null;
		
		CarRental cr = CarRental.getInstance();
		List<Customer> allCustomers = cr.getCustomers();
		cloop: for( Customer c : allCustomers ) {
			if ( c.getFirstName().equals(firstName) && c.getLastName().equals(lastName) ) {
				customer = c; 
				if (Test.debug)
					System.out.println("Customer.findCustomerByNames() custoemer found ");
				break cloop;
			}
		}
		if (Test.debug) {
			if (customer == null)
				System.out.println("Customer.findCustomerByNames() custoemer not found ");
		}
		
		return customer;
	}
	
}
