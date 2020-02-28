package au.carrental.oms;
import java.util.*;

import au.carrental.crm.Customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class Order {

	private static 	int orderIdPool = 1001;
	
	private 		LocalDateTime 	dtOrdered;
	private			int				orderID;
	private 		Customer		customer;
	private 		List<OrderItem> items;
	private 		int 			invoiceId;
	
	protected Order(LocalDateTime dtOrdered, Customer customer) {
		super();
		this.dtOrdered = dtOrdered;
		this.orderID = orderIdPool++;
		this.customer = customer;
		this.items = new ArrayList<>();
		this.invoiceId = -1;
	}
	
	public boolean addItem( OrderItem oi ) {
		return items.add(oi);
	}
	
	public boolean removeItem( OrderItem oi ) {
		return items.remove(oi);
	}
	
	public void setInvoiceId( int id ) {
		this.invoiceId = id;
	}

	public  List<OrderItem> getItems(){
		return Collections.unmodifiableList(this.items);
	}
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + "]";
	}
	
	
	
	
}
