/*
 * Car
 * v0.1
 * represents a vehicle type of car
 * */
package au.carrental.assets;

public class Car extends Vehicle {

	private String description;
	
	@Override
	public String getVehicleDescription() {
		return description;
	}

	public Car(String type, String manufacturer, String model, LocalDate purchaseDate, String description) {
		super(type, manufacturer, model, purchaseDate);
		this.description = description;
	}

}
