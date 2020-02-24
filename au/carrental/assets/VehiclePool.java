/*
 * CarPool
 * v0.1
 * represents list of cars at a site
 * */
package au.carrental.assets;

import java.util.List;

public class VehiclePool {

	private List<Vehicle> vehicles;

	public VehiclePool(List<Vehicle> vehicles) {
		super();
		this.vehicles = vehicles;
	}
	
	public int size() {
		return vehicles.size();
	}
	
	public addVehicle( Vehicle v ) {
		return vehicles.add(v);
	}

	public removeVehicle( Vehicle v ) {
		return vehicles.remove(v);
	} 

	public boolean isEmpty() {
		return vehicles.isEmpty();
	}



}
