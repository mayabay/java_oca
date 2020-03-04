/*
 * Session
 * v0.1
 * represents a customer session to you the car rental office
 * */
package au.carrental;
import au.carrental.crm.Customer;
import au.carrental.assets.Site;

public class Session {

	private Customer	customer;
	private Site 		site;
	
	public Session(Customer customer, Site site) {
		super();
		this.customer = customer;
		this.site = site;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	
}
