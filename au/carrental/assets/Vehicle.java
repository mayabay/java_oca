/*
 * Vehicle
 * v0.1
 * basic representation of car and mototbike
 * */
package au.carrental.assets;
import java.time.LocalDate;
public abstract class Vehicle {

	private final		String		type;
	private final		String 		manufacturer;
	private final		String 		model;
	private final		LocalDate	purchaseDate;
	private String 		vehicleId;
	private int 		kilometersTravelled;	
	private double		rentalPrice;
	
	public	abstract	String getVehicleDescription();

	protected Vehicle(String type, String manufacturer, String model, LocalDate purchaseDate) {
		super();
		this.type = type;
		this.manufacturer = manufacturer;
		this.model = model;
		this.purchaseDate = purchaseDate;
	}

	protected  Vehicle(String type, String manufacturer, String model, LocalDate purchaseDate, String vehicleId, int kilometersTravelled, double rentalPrice) {
		super();
		this.type = type;
		this.manufacturer = manufacturer;
		this.model = model;
		this.purchaseDate = purchaseDate;
		this.vehicleId = vehicleId;
		this.kilometersTravelled  = kilometersTravelled;
		this.rentalPrice = rentalPrice;
	}
	
	
	
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setKilometersTravelled(int kilometersTravelled) {
		this.kilometersTravelled = kilometersTravelled;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", manufacturer=" + manufacturer + ", model=" + model + ", vehicleId="
				+ vehicleId + ", kilometersTravelled=" + kilometersTravelled + ", rentalPrice=" + rentalPrice + "]";
	}

	
	
}
