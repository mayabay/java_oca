/*
 * Site
 * v0.1
 * represents an office site in the car rental project
 * */
package au.carrental.assets;
import au.carrental.*;

public class Site {

	private	 	String	 		name;
	private 	Address			address;
	private 	VehiclePool		vehiclePool;
	
	public Site(String name, Address address, VehiclePool vehiclePool) {
		super();
		this.name = name;
		this.address = address;
		this.vehiclePool = vehiclePool;
	}
	
	
	
}
