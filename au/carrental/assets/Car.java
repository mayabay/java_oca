/*
 * Car
 * v0.1
 * represents a vehicle type of car
 * */
package au.carrental.assets;
import java.time.*;
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

	public Car(String type, String manufacturer, String model, LocalDate purchaseDate, String vehicleId,
			int kilometersTravelled, double rentalPrice) {
		super(type, manufacturer, model, purchaseDate, vehicleId, kilometersTravelled, rentalPrice);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
