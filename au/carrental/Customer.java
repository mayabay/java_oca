/*
 * Customer
 * v0.1	
 * represents a customer in the car rental project
 * 
 * */
package au.carrental;
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
	
	public Customer(String firstName, String lastName, LocalDate birthDate, String eMail, IdDocument idDoc,
			Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.eMail = eMail;
		this.idDoc = idDoc;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
}
