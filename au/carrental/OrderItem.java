package au.carrental;
import au.carrental.assets.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class OrderItem {
	
	private			int				orderID;
	private 		Vehicle			vehicle;
	
	private 		Site			pickupSite;
	private 		LocalDateTime	pickupDT;
	
	private 		Site			returnSite;
	private 		LocalDateTime	returnDT;
	
	protected OrderItem(int orderID, Vehicle vehicle, Site pickupSite, LocalDateTime pickupDT, Site returnSite,
			LocalDateTime returnDT) {
		super();
		this.orderID = orderID;
		this.vehicle = vehicle;
		this.pickupSite = pickupSite;
		this.pickupDT = pickupDT;
		this.returnSite = returnSite;
		this.returnDT = returnDT;
	}

	@Override
	public String toString() {
		return "OrderItem [orderID=" + orderID + ", pickupSite=" + pickupSite.getAddress().getCompanyName() + ", returnSite=" + returnSite.getAddress().getCompanyName() + "]";
	}
	
	
}
