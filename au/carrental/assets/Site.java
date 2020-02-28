/*
 * Site
 * v0.1
 * represents an office site in the car rental project
 * */
package au.carrental.assets;
import au.carrental.*;
import java.time.*; 
public class Site {

	private	 	String	 		name;
	private 	Address			address;
	private 	VehiclePool		vehiclePool;
	private 	CoffeeMachine	coffeeMachine;
	
	
	
	public Site(String name, Address address, VehiclePool vehiclePool, CoffeeMachine coffeeMachine) {
		super();
		this.name = name;
		this.address = address;
		this.vehiclePool = vehiclePool;
		this.coffeeMachine = coffeeMachine;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public CoffeeMachine getCoffeeMachine() {
		return coffeeMachine;
	}

	public VehiclePool getVehiclePool() {
		return vehiclePool;
	}

	@Override
	public String toString() {
		return "Site [name=" + name + "]";
	}
	
	
	
}
