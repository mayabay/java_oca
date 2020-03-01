package au.carrental.test;

import java.util.*;
import java.time.*;
import au.carrental.*;
import au.carrental.assets.*;
import au.carrental.crm.Account;
import au.carrental.crm.Customer;
import au.carrental.oms.Order;

public class Test {

	public static final boolean	debug = false;
	
	private static CarRental carRental;
	
	private	static 	List<String> 	v1pool = new ArrayList<>();
	private static	List<String> 	v2pool = new ArrayList<>();
	private static	List<String> 	v3pool = new ArrayList<>();
	private static	List<String> 	v4pool = new ArrayList<>();
	private static	List<String> 	v5pool = new ArrayList<>();
	private static	List<String> 	v6pool = new ArrayList<>();
	private static	List<String> 	v7pool = new ArrayList<>();
	private static	List<String> 	v8pool = new ArrayList<>();
	
	private 		Site 			location;
	private 		Customer		customer;
	
	{
		// type (car,bike) | manufacturer | model | purchaseDate JJJJ-MM-TT | kilometersTravelled | vehicleId| rentalPrice 
		v1pool.add( "car|Ford|Ka|2015-11-10|32214|HH IO 5367|25" );
		v1pool.add( "car|Ford|Shelby GT350|1968-03-12|67421|HH SH 7382|79" );
		
		v2pool.add( "car|Mercedes|A|2018-01-05|6230|HH XX 5368|55" );
		
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
			default: //throw new IllegalStateException("pls check vehicle type!");
				break;
		}
		//System.out.println(v);
		return v;
	}
	
	void buildCarRentalService() {
		
		// 1) name of company
		String nameOfCompany = "First Australian Car Rental Service since 1899!" ;
		
		// 2( build sites
		// vehicle pools
		List<Vehicle> vehiclesSite1 = new ArrayList<>();
		List<Vehicle> vehiclesSite2 = new ArrayList<>();
		List<Vehicle> vehiclesSite3 = new ArrayList<>();
		List<Vehicle> vehiclesSite4 = new ArrayList<>();
		List<Vehicle> vehiclesSite5 = new ArrayList<>();
		List<Vehicle> vehiclesSite6 = new ArrayList<>();
		List<Vehicle> vehiclesSite7 = new ArrayList<>();
		List<Vehicle> vehiclesSite8 = new ArrayList<>();
		
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
		
		// all 8 vehicle pools
		VehiclePool vehiclePool1 = new VehiclePool( vehiclesSite1 );
		VehiclePool vehiclePool2 = new VehiclePool( vehiclesSite2 );
		VehiclePool vehiclePool3 = new VehiclePool( vehiclesSite3 );
		VehiclePool vehiclePool4 = new VehiclePool( vehiclesSite4 );
		VehiclePool vehiclePool5 = new VehiclePool( vehiclesSite5 );
		VehiclePool vehiclePool6 = new VehiclePool( vehiclesSite6 );
		VehiclePool vehiclePool7 = new VehiclePool( vehiclesSite7 );
		VehiclePool vehiclePool8 = new VehiclePool( vehiclesSite8 );
		
		// all 8 addresses
		Address address1 = new Address( "Sydney Airport",nameOfCompany,"Terminal Buildings","NSW","Sydney","","2020","Australia" );
		Address address2 = new Address( "Melbourne Clayton",nameOfCompany,"2093/2097 Princes Hwy","VIC","Clayton","","3168","Australia" );
		Address address3 = new Address( "Adelaide Airport",nameOfCompany,"James Schofield Dr","SA","Adelaide","","5950","Australia" );
		Address address4 = new Address( "Perth Fremantle",nameOfCompany,"96 Queen Victoria St","WA","Fremantle","","6160","Australia" );
		Address address5 = new Address( "Port Hedland Airport",nameOfCompany,"Great Northern Hwy","WA","Port Hedland","","6721","Australia" );
		Address address6 = new Address( "Darwin City",nameOfCompany,"77 Cavenagh St","NT","Darwin City","","0800","Australia" );
		Address address7 = new Address( "Brisbane Airport",nameOfCompany,"Brisbane Airport","QLD","Brisbane","","4007","Australia" );
		Address address8 = new Address( "Alice Springs Airport",nameOfCompany,"Terminal Building","NT","Connellan","","0871","Australia" );
		
		// all 8 CoffeeMachine	
		// https://www.techradar.com/best/best-coffee-machines https://www.goodhousekeeping.com/uk/product-reviews/electricals/a30703067/lavazza-desea-pod-machine-review/
		CoffeeMachine coffeeMachine1 = new CoffeeMachine("Nespresso Vertuo Plus");
		CoffeeMachine coffeeMachine2 = new CoffeeMachine("Sage by Heston Blumenthal");
		CoffeeMachine coffeeMachine3 = new CoffeeMachine("Melitta Caffeo CI Bean to Cup");
		CoffeeMachine coffeeMachine4 = new CoffeeMachine("Wacaco Nanopresso");
		CoffeeMachine coffeeMachine5 = new CoffeeMachine("Gaggia Gran Deluxe");
		CoffeeMachine coffeeMachine6 = new CoffeeMachine("Delonghi Nespresso Gran Lattissima Pod Machine");
		CoffeeMachine coffeeMachine7 = new CoffeeMachine("Krups Evidence Plus EA894 Bean to Cup");
		CoffeeMachine coffeeMachine8 = new CoffeeMachine("Lavazza Deséa Pod Machine");
		
		// build 8 sites with car pools
		Site site1 = new Site ( "Sidney", address1, vehiclePool1, coffeeMachine1  );
		Site site2 = new Site ( "Melbourne", address2, vehiclePool2, coffeeMachine2  );
		Site site3 = new Site ( "Adelaide", address3, vehiclePool3, coffeeMachine3  );
		Site site4 = new Site ( "Perth", address4, vehiclePool4, coffeeMachine4  );
		Site site5 = new Site ( "Port Hedland", address5, vehiclePool5, coffeeMachine5  );
		Site site6 = new Site ( "Darwin City", address6, vehiclePool6, coffeeMachine6  );
		Site site7 = new Site ( "Brisbane", address7, vehiclePool7, coffeeMachine7  );
		Site site8 = new Site ( "Alice Springs", address8, vehiclePool8, coffeeMachine8  );
		
		List<Site> sites = new ArrayList<>();
		sites.add(site1);
		sites.add(site2);
		sites.add(site3);
		sites.add(site4);
		sites.add(site5);
		sites.add(site6);
		sites.add(site7);
		sites.add(site8);
		
		// build office object
		Office office = new Office();
		office.setWelcomeMessage("Welcome " + nameOfCompany + " How can we help you?");

		// build CarRental object
		// name
		// sites
		// office		
		CarRental.buildInstance(nameOfCompany, sites, office);
		
		// get the instance for testing
		carRental = CarRental.getInstance();
		
	}
	
	public static void main(String[] args) {
		
		// instance to Test
		Test t = new Test();
		
		// build model
		t.buildCarRentalService();

		// set location
		t.location = Test.carRental.getSite(0);
		
		// enter office
		t.enterOffice( Test.carRental );
		
	}

	public void enterOffice( CarRental carRental ) {
		
		Scanner sc = new Scanner(System.in);
		
		// get office services
		Office office = carRental.getOffice();
		
		//John,Doe,46,john.doe@mail.com,password
		if (debug) {
			this.customer = office.addCustomer("John", "Doe", 46, "john.doe@mail.com", "pw");
			System.out.println("Test.enterOffice() customer created: John,Doe,46,john.doe@mail.com,pw  ");
		}
		office.printWelcomeMessage();
		
		boolean visitingCarRental = true;
		
		office.printServices();
		
		while (visitingCarRental) {
			
			
			System.out.println( "\t->01<- print menu; (user located at " + this.location.getAddress() + "; customer account = "+ this.customer +" ):  " );
			System.out.println( "please enter service:  ");
			
			String input = sc.nextLine();

			switch( input ) {
				
				case "01": 	office.printServices(); 
							break;
				case "02": 	this.location = setSite(sc); 
							break;
				case "05":	office.printMyOrders(this.customer);	
							break;							
				case "06":	office.printVehicles(this.location);	
							break;
				case "07": 	this.customer = this.setCustomer(sc, office);
							System.out.println("customer created => " + this.customer );  
							break;
				case "71":  this.logout(office);
							break;
				case "72":  this.login(sc, office);
							break;							
				case "08": 	office.printLocations(); 
							break;
				case "09": 	office.offerLiquid(this.location); 
							break;
				case "10": 	Order order = office.placeAnOrder(sc, this.customer);
							if (order != null) {
								this.carRental.addOrder(order);
							}
							break;							
				case "81": 	office.printAllCustomers(); 
							break;							
				case "99": 	visitingCarRental = false; 
							break;
				default: 	//visitingCarRental = false; 
							System.out.println("unknown command.");
							break;
			}
			System.out.println();
		}
		
		System.out.println("Bye!");
		sc.close();
	}

	private void login(Scanner sc, Office office ) {
		System.out.println("enter credentials in one line: e.g. ->John_Doe|PASSWORD<- ");
		String in = sc.nextLine();

		String[] splits = in.split("[|]");
		this.customer = office.login(splits[0], splits[1]);
	}
	
	private void logout( Office office ) {
		this.customer = null;
		office.logout();
	}
	
	private Site setSite( Scanner sc ) {
		System.out.println("change your location, enter idx for new site: ");
		String in = sc.nextLine();
		return carRental.getSite( (new Integer( in ) ).intValue()  );
	}
	
	
	private Customer setCustomer(Scanner sc, Office office ) {
		// String firstName, String lastName, int age, String eMail
		System.out.println( "Customer account creation: pls enter like this: ->John,Doe,46,john.doe@mail.com,password<-" );
		System.out.println( "Your account username will be ->John_Doe<-" );
		String input = sc.nextLine();
		
		String[] splitted = input.split(",");
		return office.addCustomer(splitted[0], splitted[1], (new Integer(splitted[2])).intValue(), splitted[3], splitted[4]) ;
	}
	
}
