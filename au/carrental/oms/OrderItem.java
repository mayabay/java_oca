package au.carrental.oms;
import au.carrental.assets.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class OrderItem {
	
	private 		Vehicle			vehicle;
	
	private 		Site			pickupSite;
	private 		LocalDateTime	pickupDT;
	
	private 		Site			returnSite;
	private 		LocalDateTime	returnDT;
	
	private 		boolean			isFinished;
	private			int 			distanceTravelled;
	
	public OrderItem( Vehicle vehicle, Site pickupSite, LocalDateTime pickupDT, Site returnSite,
			LocalDateTime returnDT) {
		super();
		this.vehicle = vehicle;
		this.pickupSite = pickupSite;
		this.pickupDT = pickupDT;
		this.returnSite = returnSite;
		this.returnDT = returnDT;
	}

	// ----------------------------------------
	
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public Site getPickupSite() {
		return pickupSite;
	}

	public LocalDateTime getPickupDT() {
		return pickupDT;
	}

	public Site getReturnSite() {
		return returnSite;
	}

	public LocalDateTime getReturnDT() {
		return returnDT;
	}

	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(int distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}	
	
	// ----------------------------------------
	


	@Override
	public String toString() {
		return "OrderItem [vehicle = "+ vehicle +", pickupSite=" + pickupSite.getAddress().getCity() + ", returnSite=" + returnSite.getAddress().getCity() + "]";
	}
	
	
}
