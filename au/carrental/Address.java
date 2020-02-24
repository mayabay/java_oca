/*
 * Address
 * v0.1	
 * represents an address
 * */
package au.carrental;

public class Address {

	private 	String		name;
	private		String 		companyName;
	private 	String 		street;
	private		String		district;
	private		String		city;
	private		String		county;
	private		String		postalCode;
	private		String 		country;
	
	public Address(String name, String companyName, String street, String district, String city, String county,
			String postalCode, String country) {
		super();
		this.name = name;
		this.companyName = companyName;
		this.street = street;
		this.district = district;
		this.city = city;
		this.county = county;
		this.postalCode = postalCode;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", city=" + city + "]";
	}
	
	
	
	
}
