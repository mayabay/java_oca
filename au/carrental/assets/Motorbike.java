/*
 * Motorbike
 * v0.1
 * represents a vehicle type of a motorbike
 * */
package au.carrental.assets;

public class Motorbike extends Vehicle {

	private String description;
	
	@Override
	public String getVehicleDescription() {
		return description;
	}

	public Motorbike(String type, String manufacturer, String model, LocalDate purchaseDate, String description) {
		super(type, manufacturer, model, purchaseDate);
		this.description = description;
	}

}
