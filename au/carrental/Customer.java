/*
 * Customer
 * v0.1	
 * represents a customer in the car rental project
 * 
 * */
package au.carrental;
import au.carrental.oms.Order;
import au.carrental.oms.OrderItem;
import au.carrental.oms.IdDocument;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Customer {

	private String 			firstName;
	private String 			lastName;
	private LocalDate		birthDate;
	private String 			eMail;
	
	private IdDocument		idDoc; 	
	private Address			address;
	private List<Order>		orders;
	
	public Customer(String firstName, String lastName, LocalDate birthDate, String eMail, IdDocument idDoc,
			Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.eMail = eMail;
		this.idDoc = idDoc;
		this.address = address;
		this.orders = new ArrayList<>();
	}

	public List<Order> getOrders(){
		return Collections.unmodifiableList(this.orders);
	}
	
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;		// both objects (and relevant fields) are not null and same 
	}
	
	
	
}
