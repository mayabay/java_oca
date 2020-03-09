/*
 * Office
 * v0.1
 * public interface to the car rental service
 * */
package au.carrental;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.BiPredicate;

import au.carrental.assets.CoffeeMachine;
import au.carrental.assets.Site;
import au.carrental.assets.VehiclePool;
import au.carrental.crm.Account;
import au.carrental.crm.Customer;
import au.carrental.oms.IdDocument;
import au.carrental.oms.Order;
import au.carrental.oms.OrderItem;
import au.carrental.oms.Payment;
import au.carrental.test.Test;
import au.carrental.assets.Vehicle;

public class Office implements CarRentalService, CarRentalAdminService {



	private 	final 	static 		int 	MINIMUM_AGE_YEARS = 26;
	
	private 	final 	static 		double 	PRICE_KM = 0.15;
	
	private 	String 	welcomeMessage;
	

	
	@Override
	public void printServices() {
		System.out.println( "[01] print services" );
		System.out.println( "[02] set location*" );
		
		System.out.println( "[05] print my orders" );
		System.out.println( "[06] print vehicles" );
		System.out.println( "[07] add customer account" );
		System.out.println( "[71] logout (order in process is lost, vehicle reservation revoked)" );
		System.out.println( "[72] login" );
		System.out.println( "[08] list locations" );
		System.out.println( "[09] drink coffee" );
		System.out.println( "[10] place an order" );
		System.out.println( "[11] revoke order" );
		System.out.println( "[12] checkout vehicle" );
		System.out.println( "[13] drive to next destination" );
		System.out.println( "[14] return vehicle" );
		System.out.println( "[81] print all customers*" );
		System.out.println( "[82] print vehicle selection*" );
		System.out.println( "[99] exit the office" );
	}	
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	@Override
	public void printWelcomeMessage() {
		System.out.println( welcomeMessage );
		
	}

	@Override
	public void printLocations() {
		CarRental cr = CarRental.getInstance();
		System.out.println("We can be found at these locations: ");
		List<Site> locations = cr.getLocations();
		for( int i = 0; i < locations.size(); i++) {
			System.out.println("[" + i + "] " + locations.get(i).getName() + ", " + locations.get(i).getAddress() + " vehicles = " + locations.get(i).getVehiclePool().size() );
		}
	}

	@Override
	public void offerLiquid( Site site ) {
		CoffeeMachine cm = site.getCoffeeMachine();
		System.out.println(cm + " => " +  cm.getLiquid() ); 
	}

	@Override
	public Customer addCustomer(String firstName, String lastName, int age, String eMail, String passw) {
		
		// 1) create account 
		//Account account = new Account( (firstName + "_" + lastName), eMail, passw );
		Account account = new Account( (firstName + "_" + lastName), passw, eMail  );
		
		// 2) create customer
		Customer c = new Customer( 	firstName,
									lastName, (LocalDate.now()).minusYears(age) ,
									eMail,
									new IdDocument( (firstName + lastName), ("sn" + (age * 7)) ) ,
									new Address( lastName, "Paris", "France" ) ,
									account
									); 
		
		// 3) add customer to our list of customers
		CarRental cr = CarRental.getInstance();
		cr.addCustomer(c);
		return c;
	}

	@Override
	public void printVehicles(Site location) {
		if ( location == null ) { System.out.println("location?"); return; }
		VehiclePool vp = location.getVehiclePool();

		List<Vehicle> list = vp.getVehicleList();

		for ( int i = 0; i < list.size(); i++ ) {
			Vehicle v = list.get(i);
			String reserved = ""; if ( v.getReservedByOrder() != null ) { reserved = " |!RESERVED!| "; }
			System.out.println( "["+ i +"] " + v  + " " + reserved);
		}
	}

	@Override
	public void printMyOrders(Customer customer) {
		
		if ( customer == null) {
			System.out.println(" pls login, or create account. ");
			return;
		}
		
		for ( Order order : customer.getOrders() ) {
			System.out.println( "\t " + order );
			for( OrderItem oi : order.getItems() ) {
				System.out.println( "\t\t " + oi );	
			}
			if (order.getInvoiceId() != -1) {
				System.out.println("\t\t invoice id = " + order.getInvoiceId());
			}
		}
		
		if ( customer.getOrders().size() == 0 ) {
			System.out.println("No orders for this customer!");
		}
	}

	@Override
	public void logout( Order inProcessOrder ) {
		// remove session data
		// 1. remove vehicle reservations
		if ( inProcessOrder != null ) {
			for( OrderItem oi : inProcessOrder.getItems() ) {
				Vehicle vehicle = oi.getVehicle();
				vehicle.setReservedByOrder(null);
			}
		}
		
	}

	@Override
	public Customer login(String username, String password) {
		
		// 1) check for existing account
		Account account = Account.validateCredentials(username, password);
		if ( Test.debug ) 
			System.out.println("Test.login() ->  " + account);		
		if ( account == null ) { return null; }
		
		// 2) get customer and retrieve name
		String user = account.getUser();
		String[] splits = username.split("[_]");
		String firstName = splits[0], lastName = splits[1];
		if ( Test.debug )
			System.out.println("Office.login()  firstName =  " + firstName + ", lastName = " + lastName);
		
		// 3)
		return Customer.findCustomerByNames(firstName, lastName);

	}
	
	@Override
	public void printAllCustomers() {
		CarRental cr = CarRental.getInstance();
		List<Customer> customers =  cr.getCustomers();
		for( Customer c : customers ) {
			System.out.println("\t\t " + c );
		}
	}

	@Override
	public Order placeAnOrder(java.util.Scanner sc , Customer customer, Site site) {
		
		if ( (site.getVehiclePool()).size() == 0 ) {
			System.out.println( "No vehicles to rent at this site!" );
			return null;
		}
		
		CarRental cr = CarRental.getInstance();
		
		System.out.println("---------- rent a vehicle  ----------");
		
		if ( customer == null ) {
			System.out.println("[canceled] pls login first or create an account!");
			return null;
		}
		
		// 1) Order we return
		Order order = null;
		
		// 1.1)
		java.time.Period period = Period.between(customer.getBirthDate(), LocalDate.now()  );
		//System.out.println("years = " + period.getYears());
		if ( period.getYears() < Office.MINIMUM_AGE_YEARS ) {
			System.out.println("[canceled] minimum age is " + Office.MINIMUM_AGE_YEARS + " years for using our service.");
			return null;
		}
		
		// 2) pickup
		System.out.println("List of all our locations:   ");
		this.printLocations();
		System.out.println("Choose a pickup location and date  -->2,2020-05-15T15:30<--:");
		
		String inPickup = sc.nextLine();
		// 2,2020-05-15
		Site pickupSite = getSiteFromInput(cr,  inPickup );
		LocalDateTime pickupLDT = getDTFromInput( cr, inPickup );
		
		if (Test.debug)
			System.out.println("pickup -->" + pickupSite + " " + pickupLDT );
		
		// 3) return
		System.out.println("Choose a return location and date  -->2,2020-05-15T15:30<--:");
		String inReturn = sc.nextLine();
		Site returnSite = getSiteFromInput(cr,  inReturn );
		LocalDateTime returnLDT = getDTFromInput( cr, inReturn );		

		// 3b) period
		Period p = Period.between( pickupLDT.toLocalDate(), returnLDT.toLocalDate()  );
		if ( p.getDays() < 1 ) {
			System.out.println("[ERR] minimum rent is 1 day.");
			return null;
		}
		
		if (Test.debug)
			System.out.println("return --> " +  returnSite + " " + returnLDT );		
		
		// 4) choose vehicle
		System.out.println("Choose a vehicle located at your pickup site:");
		this.printVehicles( pickupSite );

		Vehicle vehicle;
		while (true) {
			String inIdx = sc.nextLine();
			vehicle = (pickupSite.getVehiclePool()).getVehicle( Integer.parseInt(inIdx) );
			if ( vehicle.getReservedByOrder() == null )	{ break; }
			else{ System.out.println("vehicle is reserved, pls choose again :"); }
		}
		
		System.out.println("Your vehicle " + vehicle);
		
		// 5) choose extras
			// todo
		
		// 6) review and choose payment
		System.out.println("---------- review  ----------");
		System.out.println("[1] pickup " + pickupSite + " at " + pickupLDT);
		System.out.println("[2] return" + returnSite + " at " + returnLDT);
		System.out.println("[3] vehicle " + vehicle);
		
		System.out.println("payment selected [cash???] (todo)");
		Payment payment = new Payment();
		
		System.out.println("OK? [y]es or [c]ancel ");
		String finalStep = sc.nextLine();
		
		// 7) final steps for created order
		if ( finalStep.equals("y") ) {
			// 7.1 create order	
			OrderItem orderItem = new OrderItem( vehicle, pickupSite, pickupLDT, returnSite, returnLDT );
			order = new Order( LocalDateTime.now(), customer );
			order.addItem(orderItem);
			customer.addOrder(order);
			// 7.2 reserve the vehicle
			vehicle.setReservedByOrder(order);
			// 7.3 checkout (distance required )
			// Office.printOrder(order, true);
			// double price = checkoutOrder( order );
			// System.out.println("total $ " + price + " for " + p.getDays() + " days.");
			// 7.4 add order to car rental orders
			cr.addOrder(order);
			// 7.5 return urder
			return order;
		}

		return order;
	}

	private static Site getSiteFromInput(CarRental cr,  String input ) {
		// 2,2020-05-15T15:30
		String splits[] = input.split(",");
		Integer SiteIdx = new Integer( splits[0] );	
		return cr.getSite(SiteIdx);
	}
	
	private static LocalDateTime getDTFromInput(CarRental cr, String input ) {
		// 2,2020-05-15T15:30
		String splits[] = input.split(",");
		String ldtStr = splits[1];	// 2020-05-15T15:30
		String[] ldtSplits = ldtStr.split("T");
		String[] ld = ldtSplits[0].split("-"); // 2020-05-15
		String[] lt = ldtSplits[1].split(":"); // 15:30
		int year = Integer.parseInt(ld[0]), month = Integer.parseInt(ld[1]), day = Integer.parseInt(ld[2]);
		int hour = Integer.parseInt(lt[0]), min = Integer.parseInt(lt[1]);
		return LocalDateTime.of(year, month, day, hour, min);
	}

	private static void printOrder( Order order, boolean writeToFile  ) {
		
		CarRental cr = CarRental.getInstance();		// only to get the company name
		
		StringBuffer sb = new StringBuffer();
		sb.append("Company : " + cr.getName() + "\n");
		sb.append("Order ID = " + order.getOrderID() + "\n");
		Customer customer = order.getCustomer();
		sb.append("customer = " + customer + "\n");
		sb.append("address = " + customer.getAddress() + "\n");
		
		sb.append(" ---------------------------- " + "\n");
		
		double total = 0;
		for(OrderItem oi : order.getItems() ) {
			Vehicle vehicle = oi.getVehicle();
			double price = vehicle.getRentalPrice();
			LocalDateTime pickupLDT = oi.getPickupDT();
			LocalDateTime returnLDT = oi.getReturnDT();
			Period p = Period.between( pickupLDT.toLocalDate(), returnLDT.toLocalDate()  );
			int days = p.getDays();
			double oiPrice = price * days;
			total += oiPrice;
			sb.append(oi.toString() + "\n");
			sb.append("\t\t $ (car rental) " + oiPrice + "\n");
			sb.append("\t\t $ (distance km )" + (oi.getDistanceTravelled() * Office.PRICE_KM) + "\n");
			total += oi.getDistanceTravelled() * Office.PRICE_KM;
		}
		sb.append(" ---------------------------- " + "\n");
		sb.append("\t\t $ total: " + total + "\n");
		sb.append("payment: " + order.getPayment() + "\n");
		
		// write file 
		if ( writeToFile ) {
			// https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
			String userHome = System.getProperty("user.home");
			File f = new File(userHome + File.separatorChar + "Order_id" + order.getOrderID() + "_.txt"  );
			try {
				if ( f.exists() ) {
					f.delete();
				}
				
				FileWriter writer = new FileWriter(f);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);			
				bufferedWriter.write(sb.toString());
				bufferedWriter.close();
			}catch( IOException ioex ) {
				ioex.printStackTrace();
				System.out.println("[ERR] unable to write order to users home directory");
			}			
		}

	}
	
	@Override
	public void revokeOrder(Order order) {
		for(OrderItem oi : order.getItems() ) {
			(oi.getVehicle()).setReservedByOrder(null);
		}
	}

	@Override
	public void checkOutVehicle(Order order, Site site) {
		
		LocalDate ldToday = LocalDate.now(); 
				
		int checkedOutCount = 0;
		oiloop: for(OrderItem oi : order.getItems() ) {
			
			// only if pickup day is equal to current day
			LocalDateTime pickupLDT = oi.getPickupDT();
			if ( ldToday.isEqual(pickupLDT.toLocalDate()) ) {
				System.out.println("[info] current date and pickup date match!");
			}else {
				System.out.println("[err] you normaly cannot pickup the vehicle: <DEMO MODE>");
			}
			
			// only vehicles at our site can be checked out
			if ( oi.getPickupSite().equals( site ) ) {
				// (1) flag the vehicle as rented
				Vehicle vehicle = oi.getVehicle();	
				if ( vehicle.isRented() == true ) { 
						continue oiloop; 	// vehicle is already rented
					}
				vehicle.setRented(true);	
				// (2) remove vehicle from pool
				VehiclePool vp = site.getVehiclePool();
				vp.removeVehicle(vehicle);		
				// (3) assign to customer
				(order.getCustomer()).addRentedVehicle(vehicle);
				// (4) vehicle reservation has been added in place order process
				// (5) will be set to true if returned
				oi.setFinished(false);
				
				System.out.println( "\t\tchecked out: vehicle " + vehicle  ); checkedOutCount++;
			}
		}
		System.out.println( checkedOutCount > 0 ?  "Have a good trip!" : "pls check vehicle location");	

	}

	@Override
	public Site driveToNextDst(Order order) {
		Site dst = null;
		// get first oi
		oiloop: for(OrderItem oi : order.getItems() ) {
			Vehicle vehicle = oi.getVehicle();
			if ( vehicle.isRented() ) {		// vehicle must be checked out
				dst = oi.getReturnSite();
				break oiloop;
			}
			
		}
		// return returnSite
		System.out.println(dst == null ? "You need an ordered vehicle" : "bromm, bromm,  vrooommmm ..... arriving at " + dst.getName());
		return dst;
	}

	@Override
	public Order returnVehicle(java.util.Scanner sc, Order order, Site site) {
		
		// after updateing the order obj, update order in customers list;
		Customer customer = order.getCustomer();
		
		// 1) get distance travelled from customer
		System.out.println("pls enter distance travelled in km: ");
		String input = sc.nextLine();
		int km = Integer.parseInt(input);
		double distancePrice = Office.PRICE_KM * km;
		// calculate distance price
		System.out.println("pls pay $ " + distancePrice + " for " + km + " km travel distance.");
		
		// 2) create invoice
		double totalPrice = checkoutOrder( order, km );
		System.out.println("total $ " + totalPrice + " (and travel distance of " + km + " km).");
		Office.printOrder(order, true);
		
		// 2.1) update changed order in car rental list
		CarRental cr = CarRental.getInstance();	
		Order orderOldObj = cr.setOrder(order);	// updates the order object, returns  old version
		
		// 2.2 update customers order list
		customer.setOrder(order);
		
		// 3) return vehicle
		LocalDate ldToday = LocalDate.now(); 
		
		int returnCount = 0;
		oiloop: for(OrderItem oi : order.getItems() ) {
			// only if return day is equal to current day
			LocalDateTime returnLDT = oi.getReturnDT();
			if ( ldToday.isEqual(returnLDT.toLocalDate()) ) {
				System.out.println("[info] current date and return date match!");
			}else {
				System.out.println("[err] you normaly cannot return the vehicle: <DEMO MODE>");
			}	
			
			// only vehicles where destination is our side, can be returned
			if ( oi.getReturnSite().equals( site ) ) {
				// (1) flag the vehicle as rented
				Vehicle vehicle = oi.getVehicle();	
				if ( vehicle.isRented() == false ) { 
						continue oiloop; 	// unknwon state, cannot happen, customer only has rented vehicles
					}
				vehicle.setRented(false);	
				// (2) add vehicle to pool
				VehiclePool vp = site.getVehiclePool();
				vp.addVehicle(vehicle);		
				// (3) remove from customer
				(order.getCustomer()).removeRentedVehicle(vehicle);
				// (4) remove vehicle reservation
				vehicle.setReservedByOrder(null);
				// (4b) add km travelled to vehicle
				vehicle.addKilometersTravelled( km );
				// (5) orderItem is finished
				oi.setFinished(true);
				
				
				System.out.println( "\t\treturned: vehicle " + vehicle  ); returnCount++;
			}			
			System.out.println( returnCount > 0 ?  "Thank you!" : "no vehicles have been returned!");	
		}		
		
		return checkOrderCleared(order) ? null : order;
	
	}	

	/*
	 * calculate final price and create invoice
	 * */
	private double checkoutOrder( Order order, int kmTravelled ) {
		double total = 0;
		for(OrderItem oi : order.getItems() ) {
			// 
			oi.setDistanceTravelled(kmTravelled);
			
			Vehicle vehicle = oi.getVehicle();
			
			// calculate rental price
			double price = vehicle.getRentalPrice();
			LocalDateTime pickupLDT = oi.getPickupDT();
			LocalDateTime returnLDT = oi.getReturnDT();
			Period p = Period.between( pickupLDT.toLocalDate(), returnLDT.toLocalDate()  );
			int days = p.getDays();
			double oiPrice = price * days;
			total += oiPrice;
			
			// calculate price distance travelled
			double priceDistanceTravelled =  Office.PRICE_KM * kmTravelled;
			total += priceDistanceTravelled;
		}		
		
		// simulate invoice creation
		order.setInvoiceId(-1);
		
		return total;
	}	
	
	/*
	 * checks if all order items are flagged finish, in that case, order
	 * will be removed from car rental
	 * */
	private boolean checkOrderCleared( Order order ) {
		CarRental cr = CarRental.getInstance();
		boolean isCleared = true;
		for( OrderItem oi : order.getItems() ) {
			if (oi.isFinished() == false ) {
				isCleared = false;
			}
		}
		if ( isCleared )
			cr.removeOrder(order);
		return isCleared;
	}
	

	@Override
	public void printVehicleSelection() {
		
		CarRental cr = CarRental.getInstance();
		
		Scanner sc = new Scanner(System.in);
		
		List<Vehicle> retList = new ArrayList<>();
		
		// 1.)
		System.out.println("enter search criteria and value like this -> type|car :");
		System.out.println("filter e.g. *|*  manufacturer|BMW  model|Sprinter vehicleId|NCC-1701");
		System.out.println("filter e.g. price|25-60");
		System.out.println("filter e.g. isRented|true");
		
		String input = sc.nextLine();
		String[] splits = input.split("[|]");
		
		// 2.) call predicate
		switch( splits[0] ) {
			case "*"	:			retList = cr.getAllVehicles(true); 
							break;
			case "type" :			retList = getVehicleSelectionByStringProperty( cr.getAllVehicles(true), Vehicle.filterByType, splits[1] );
							break;
			case "manufacturer" :	retList = getVehicleSelectionByStringProperty( cr.getAllVehicles(true), Vehicle.filterByManufacturer, splits[1] );
							break;
			case "model" :			retList = getVehicleSelectionByStringProperty( cr.getAllVehicles(true), Vehicle.filterByModel, splits[1] );
							break;	
			case "vehicleId" :		retList = getVehicleSelectionByStringProperty( cr.getAllVehicles(true), Vehicle.filterByVehicleId, splits[1] );
							break;	
			case "price"	:		String[] doubles =  splits[1].split("[-]");
									retList = getVehicleSelectionByTriProperty( cr.getAllVehicles(true), Vehicle.filterByRentalPriceRange, new Double(doubles[0]) , new Double(doubles[1]) );
							break;
			case "isRented"	: 		retList = getVehicleSelectionByBiPredicateBoolProperty( cr.getAllVehicles(true), Vehicle.filterByRented, new Boolean(splits[1]) );
							break;
			default: 		System.out.println("unknown search criteria!");
							break;					
		}
		
		//sc.close();
		
		// 3.) show selection
		for( Vehicle vehicle : retList ) {
			System.out.println( vehicle );
		}
	}
	
	private List<Vehicle> getVehicleSelectionByStringProperty( List<Vehicle> vehicles, BiPredicate<Vehicle, String> filter, String property ){
		List<Vehicle> retList = new ArrayList<>();
		for( Vehicle vehicle : vehicles ) {
			if ( filter.test(vehicle, property) ) {
				retList.add(vehicle);
			}
		}
		return retList;
	}
	
	private List<Vehicle> getVehicleSelectionByTriProperty( List<Vehicle> vehicles, TriPredicate<Vehicle, Double, Double> filter, Double val1, Double val2 ){
		List<Vehicle> retList = new ArrayList<>();
		for( Vehicle vehicle : vehicles ) {
			if ( filter.test(vehicle, val1, val2) ) {
				retList.add(vehicle);
			}
		}
		return retList;
	}	
	
	private List<Vehicle> getVehicleSelectionByBiPredicateBoolProperty( List<Vehicle> vehicles, BiPredicate<Vehicle, Boolean> filter, Boolean b){
		List<Vehicle> retList = new ArrayList<>();
		for( Vehicle vehicle : vehicles ) {
			if ( filter.test(vehicle, b) ) {
				retList.add(vehicle);
			}
		}
		return retList;
	}		
	
}
