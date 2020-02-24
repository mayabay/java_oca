/*
 * CarRental
 * v0.1
 * represents a car rental service in australia at several locations, uses office as its public interface
 * */
package au.carrental;

public class CarRental {

	private		String 			name;
	private		List<Site> 		sites;
	private 	Office			office;
	
	public CarRental(String name, List<Site> sites, Office office) {
		super();
		this.name = name;
		this.sites = sites;
		this.office = office;
	}
	 	
	
	
}
