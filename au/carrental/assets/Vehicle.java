/*
 * Vehicle
 * v0.1
 * basic representation of car and mototbike
 * */
package au.carrental.assets;
import java.time.LocalDate;
import au.carrental.oms.Order;
public abstract class Vehicle {

	private final		String		type;
	private final		String 		manufacturer;
	private final		String 		model;
	private final		LocalDate	purchaseDate;
	private String 		vehicleId;
	private int 		kilometersTravelled;	
	private double		rentalPrice;
	private Order		reservedByOrder; 
	private boolean 	isRented;
	
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
	
	// ----------------------------------------
	
	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void addKilometersTravelled(int kilometersTravelled) {
		this.kilometersTravelled += kilometersTravelled;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public double getRentalPrice() {
		return rentalPrice;
	}

	public Order getReservedByOrder() {
		return reservedByOrder;
	}

	public void setReservedByOrder(Order reservedByOrder) {
		this.reservedByOrder = reservedByOrder;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	// ----------------------------------------
	
	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", manufacturer=" + manufacturer + ", model=" + model + ", vehicleId="
				+ vehicleId + "]";
	}

	@Override
	public int hashCode() {
		return this.vehicleId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if ( obj == null ) {
			return false;
		}
		
		if ( !( obj instanceof Vehicle ) ) {
			return false;
		}
		
		Vehicle otherVehicle = (Vehicle)obj;
		
		if ( otherVehicle.getVehicleId().equals(this.vehicleId) ) {
			return true;
		}else {
			return false;
		}
	}

	
	
	
	
}
