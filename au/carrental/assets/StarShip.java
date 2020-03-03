package au.carrental.assets;

import java.time.LocalDate;

public class StarShip extends Vehicle {

	private String description;	
	
	public StarShip(String type, String manufacturer, String model, LocalDate purchaseDate, String description) {
		super(type, manufacturer, model, purchaseDate);
		this.description = description;
	}

	public StarShip(String type, String manufacturer, String model, LocalDate purchaseDate, String vehicleId,
			int kilometersTravelled, double rentalPrice) {
		super(type, manufacturer, model, purchaseDate, vehicleId, kilometersTravelled, rentalPrice);
		// TODO Auto-generated constructor stub
	}		
	
	@Override
	public String getVehicleDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
