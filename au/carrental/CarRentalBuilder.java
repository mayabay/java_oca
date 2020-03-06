/*
 * CarRentalBuilder
 * v0.1
 * builds the cer rental service
 * */
package au.carrental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import au.carrental.assets.Car;
import au.carrental.assets.CoffeeMachine;
import au.carrental.assets.Motorbike;
import au.carrental.assets.RacingBike;
import au.carrental.assets.Site;
import au.carrental.assets.StarShip;
import au.carrental.assets.Vehicle;
import au.carrental.assets.VehiclePool;

public class CarRentalBuilder {

	// builder instance
	private static	CarRentalBuilder 	instance;
	
	// vehicle pools from which site pools are created
	private	static 	List<String> 	v1pool = new ArrayList<>();
	private static	List<String> 	v2pool = new ArrayList<>();
	private static	List<String> 	v3pool = new ArrayList<>();
	private static	List<String> 	v4pool = new ArrayList<>();
	private static	List<String> 	v5pool = new ArrayList<>();
	private static	List<String> 	v6pool = new ArrayList<>();
	private static	List<String> 	v7pool = new ArrayList<>();
	private static	List<String> 	v8pool = new ArrayList<>();	
	
	// name of company
	private 		String 			nameOfCompany = "James Cook's Car Rental Service, since 1770!" ;
	
	// vehicle pools for all sites
	private List<Vehicle> vehiclesSite1 = new ArrayList<>();
	private List<Vehicle> vehiclesSite2 = new ArrayList<>();
	private List<Vehicle> vehiclesSite3 = new ArrayList<>();
	private List<Vehicle> vehiclesSite4 = new ArrayList<>();
	private List<Vehicle> vehiclesSite5 = new ArrayList<>();
	private List<Vehicle> vehiclesSite6 = new ArrayList<>();
	private List<Vehicle> vehiclesSite7 = new ArrayList<>();
	private List<Vehicle> vehiclesSite8 = new ArrayList<>();	

	// vehicle pool objects
	private VehiclePool vehiclePool1;
	private VehiclePool vehiclePool2;
	private VehiclePool vehiclePool3;
	private VehiclePool vehiclePool4;
	private VehiclePool vehiclePool5;
	private VehiclePool vehiclePool6;
	private VehiclePool vehiclePool7;
	private VehiclePool vehiclePool8;
	
	// site address objects
	private Address address1;
	private Address address2;
	private Address address3;
	private Address address4;
	private Address address5;
	private Address address6;
	private Address address7;
	private Address address8;
	
	// all coofee machines
	private CoffeeMachine coffeeMachine1;
	private CoffeeMachine coffeeMachine2;
	private CoffeeMachine coffeeMachine3;
	private CoffeeMachine coffeeMachine4;
	private CoffeeMachine coffeeMachine5;
	private CoffeeMachine coffeeMachine6;
	private CoffeeMachine coffeeMachine7;
	private CoffeeMachine coffeeMachine8;
	
	// all sites
	private Site site1;
	private Site site2;
	private Site site3;
	private Site site4;
	private Site site5;
	private Site site6;
	private Site site7;
	private Site site8;
	
	// list of all sites
	private List<Site> sites = new ArrayList<>();
	
	// ------------------------------------------------------------------------

	// ------------------------------------------------------------------------	
	
	private CarRentalBuilder() {		
	}

	// ------------------------------------------------------------------------
	
	public static void buildInstance() {
		if ( instance == null ) {
			instance = new CarRentalBuilder( );
		} else {
			throw new IllegalStateException("This method can only be called once!");
		}		
	}
	
	public static CarRentalBuilder getInstance() {
		return instance;
	}		
	
	private void buildVehicleStringLists() {
		// type (car,bike) | manufacturer | model | purchaseDate JJJJ-MM-TT | kilometersTravelled | vehicleId| rentalPrice 
		v1pool.add( "car|Ford|Ka|2015-11-10|32214|HH IO 5367|25" );
		v1pool.add( "car|Ford|Shelby GT350|1968-03-12|67421|HH SH 7382|79" );
		v1pool.add( "racingbike|Cannondale|Synapse 2017|2017-01-01|4021|FT Ma 1973|19" );
		v1pool.add( "racingbike|Canyon|Ultimate CF SL|2019-07-01|8131|HH Do 7482|29" );
		v1pool.add( "starship|USS Enterprise|NCC-1701|2245-04-02|234678123|NCC-1701|1250000" );
		
		v2pool.add( "car|Mercedes|A|2018-01-05|6230|HH XX 5368|55" );
		v2pool.add( "car|Ford|T|1915-05-05|75402|HH FT 1915|75" );
		
		v3pool.add( "car|VW|Kaefer|2019-01-23|1978|HH XX 5369|25" );
		
		v4pool.add( "car|Ford|Mondeo|2018-10-30|10213|HH XX 5370|40" );
		
		v5pool.add( "transporter|Mercedes|Vito|2016-04-13|45109|HH TP 4007|49" );
		v5pool.add( "car|Jeep|Grand Cherokee|2017-04-17|173219|HH CH 7119|69" );
		
		v6pool.add( "transporter|Mercedes|Sprinter|2018-12-15|10356|HH TP 4008|59" );
		
		v7pool.add( "transporter|Ford|Transit|2019-02-23|3045|HH TP 4009|69" );
		
		v8pool.add( "transporter|VW|Crafter|2017-07-30|28987|HH TP 4010|39" );
		v8pool.add( "car|Jeep|Willys|1945-01-01|2784|HH JP 1945|59" );
		
		// bikes
		
		v8pool.add( "motorbike|Suzuki|type a|2015-11-10|3333|HH IO 5367|60" );
		
		v7pool.add( "motorbike|Yamaha|type b|2018-05-01|4444|HH XX 5368|70" );
		
		v6pool.add( "motorbike|BMW|type c|2019-01-23|5555|HH XX 5369|80" );
		
		v5pool.add( "motorbike|Mercedes|type d|2018-10-30|6666|HH XX 5370|70" );		
	}
	
	private Vehicle getVehicleObj( String[] s ) {
		Vehicle v = null;
		switch( s[0] ) {
			case "car": 
				v = new Car( s[0], s[1], s[2], LocalDate.parse(s[3]), s[5], (new Integer(s[4])).intValue() , (new Double( s[6]) ).doubleValue()  ); 
				break;
			case "transporter": 
				v = new Car( s[0], s[1], s[2], LocalDate.parse(s[3]), s[5], (new Integer(s[4])).intValue() , (new Double( s[6]) ).doubleValue()  ); 
				break;				
			case "motorbike": 
				v = new Motorbike( s[0], s[1], s[2], LocalDate.parse(s[3]), s[5], (new Integer(s[4])).intValue() , (new Double( s[6]) ).doubleValue()  ); 
				break;
			case "racingbike": 
				v = new RacingBike( s[0], s[1], s[2], LocalDate.parse(s[3]), s[5], (new Integer(s[4])).intValue() , (new Double( s[6]) ).doubleValue()  ); 
				break;		
			case "starship": 
				v = new StarShip( s[0], s[1], s[2], LocalDate.parse(s[3]), s[5], (new Integer(s[4])).intValue() , (new Double( s[6]) ).doubleValue()  ); 
				break;					
			default: //throw new IllegalStateException("pls check vehicle type!");
				break;
		}
		//System.out.println(v);
		return v;
	}	
	
	private void buildVehicleListsForSites() {
		// build vehicles
		for( String s : v1pool ) {
			String[] splits = s.split("[|]");
			//System.out.println( Arrays.toString(splits) );
			vehiclesSite1.add( getVehicleObj(splits) );
		}
		for( String s : v2pool ) {
			String[] splits = s.split("[|]");
			vehiclesSite2.add( getVehicleObj(splits) );
		}
		for( String s : v3pool ) {
			String[] splits = s.split("[|]");
			vehiclesSite3.add( getVehicleObj(splits) );
		}
		for( String s : v4pool ) {
			String[] splits = s.split("[|]");
			vehiclesSite4.add( getVehicleObj(splits) );
		}
		for( String s : v5pool ) {
			String[] splits = s.split("[|]");
			vehiclesSite5.add( getVehicleObj(splits) );
		}
		for( String s : v6pool ) {
			String[] splits = s.split("[|]");
			vehiclesSite6.add( getVehicleObj(splits) );
		}
		for( String s : v7pool ) {
			String[] splits = s.split("[|]");
			vehiclesSite7.add( getVehicleObj(splits) );
		}
		for( String s : v8pool ) {
			String[] splits = s.split("[|]");
			vehiclesSite8.add( getVehicleObj(splits) );
		}		
	}
	
	private void buildVehiclePools() {
		vehiclePool1 = new VehiclePool( vehiclesSite1 );
		vehiclePool2 = new VehiclePool( vehiclesSite2 );
		vehiclePool3 = new VehiclePool( vehiclesSite3 );
		vehiclePool4 = new VehiclePool( vehiclesSite4 );
		vehiclePool5 = new VehiclePool( vehiclesSite5 );
		vehiclePool6 = new VehiclePool( vehiclesSite6 );
		vehiclePool7 = new VehiclePool( vehiclesSite7 );
		vehiclePool8 = new VehiclePool( vehiclesSite8 );		
	}
	
	private void buildSiteAddresses() {
		address1 = new Address( "Sydney Airport",nameOfCompany,"Terminal Buildings","NSW","Sydney","","2020","Australia" );
		address2 = new Address( "Melbourne Clayton",nameOfCompany,"2093/2097 Princes Hwy","VIC","Clayton","","3168","Australia" );
		address3 = new Address( "Adelaide Airport",nameOfCompany,"James Schofield Dr","SA","Adelaide","","5950","Australia" );
		address4 = new Address( "Perth Fremantle",nameOfCompany,"96 Queen Victoria St","WA","Fremantle","","6160","Australia" );
		address5 = new Address( "Port Hedland Airport",nameOfCompany,"Great Northern Hwy","WA","Port Hedland","","6721","Australia" );
		address6 = new Address( "Darwin City",nameOfCompany,"77 Cavenagh St","NT","Darwin City","","0800","Australia" );
		address7 = new Address( "Brisbane Airport",nameOfCompany,"Brisbane Airport","QLD","Brisbane","","4007","Australia" );
		address8 = new Address( "Alice Springs Airport",nameOfCompany,"Terminal Building","NT","Connellan","","0871","Australia" );		
	}
	
	private void builCoffeeMachines() {
		coffeeMachine1 = new CoffeeMachine("Nespresso Vertuo Plus");
		coffeeMachine2 = new CoffeeMachine("Sage by Heston Blumenthal");
		coffeeMachine3 = new CoffeeMachine("Melitta Caffeo CI Bean to Cup");
		coffeeMachine4 = new CoffeeMachine("Wacaco Nanopresso");
		coffeeMachine5 = new CoffeeMachine("Gaggia Gran Deluxe");
		coffeeMachine6 = new CoffeeMachine("Delonghi Nespresso Gran Lattissima Pod Machine");
		coffeeMachine7 = new CoffeeMachine("Krups Evidence Plus EA894 Bean to Cup");
		coffeeMachine8 = new CoffeeMachine("Lavazza Deséa Pod Machine");		
	}
	
	private void buildSites() {
		
		// build 8 sites with car pools
		site1 = new Site ( "Sidney", address1, vehiclePool1, coffeeMachine1  );
		site2 = new Site ( "Melbourne", address2, vehiclePool2, coffeeMachine2  );
		site3 = new Site ( "Adelaide", address3, vehiclePool3, coffeeMachine3  );
		site4 = new Site ( "Perth", address4, vehiclePool4, coffeeMachine4  );
		site5 = new Site ( "Port Hedland", address5, vehiclePool5, coffeeMachine5  );
		site6 = new Site ( "Darwin City", address6, vehiclePool6, coffeeMachine6  );
		site7 = new Site ( "Brisbane", address7, vehiclePool7, coffeeMachine7  );
		site8 = new Site ( "Alice Springs", address8, vehiclePool8, coffeeMachine8  );		
		
		sites.add(site1);
		sites.add(site2);
		sites.add(site3);
		sites.add(site4);
		sites.add(site5);
		sites.add(site6);
		sites.add(site7);
		sites.add(site8);		
	}
	
	public  CarRental buildCarRentalInstance() {
		
		// 1)
		buildVehicleStringLists();
		
		// 2)
		buildVehicleListsForSites();
		
		// 3)
		buildVehiclePools();
		
		// 4)
		buildSiteAddresses();
		
		// 5)
		builCoffeeMachines();
		
		// 6)
		buildSites();
		
		// build office object
		Office office = new Office();
		office.setWelcomeMessage("Welcome " + nameOfCompany + " How can we help you?");		
		
		// build CarRental object
		// name
		// sites
		// office		
		CarRental.buildInstance(nameOfCompany, sites, office);		
		
		// get the instance for testing
		return CarRental.getInstance();		
	}
	
}
