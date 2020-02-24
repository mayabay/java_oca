package au.carrental.test;

import java.util.List;

public class Test {

	private 	List<String> 	v1pool;
	private 	List<String> 	v2pool;
	private 	List<String> 	v3pool;
	private 	List<String> 	v4pool;
	private 	List<String> 	v5pool;
	private 	List<String> 	v6pool;
	private 	List<String> 	v7pool;
	private 	List<String> 	v8pool;
	
	{
		// type (car,bike) | manufacturer | model | purchaseDate JJJJ-MM-TT | kilometersTravelled | vehicleId| rentalPrice 
		v1pool.add( "car|Ford|Ka|2015-11-10|32214|HH IO 5367|25" );
		
		v2pool.add( "car|Mercedes|A|2018-01-05|6230|HH XX 5368|55" );
		
		v3pool.add( "car|VW|Kaefer|2019-01-23|1978|HH XX 5369|25" );
		
		v4pool.add( "car|Ford|Mondeo|2018-10-30|10213|HH XX 5370|40" );
		
		v5pool.add( "transporter|Mercedes|Vito|2016-04-13|45109|HH TP 4007|49" );
		
		v6pool.add( "transporter|Mercedes|Sprinter|2018-12-15|10356|HH TP 4008|59" );
		
		v7pool.add( "transporter|Ford|Transit|2019-02-23|3045|HH TP 4009|69" );
		
		v8pool.add( "transporter|VW|Crafter|2017-07-30|28987|HH TP 4010|39" );
		
		// bikes
		
		v8pool.add( "motorbike|Suzuki|type a|2015-11-10|3333|HH IO 5367|60" );
		
		v7pool.add( "motorbike|Yamaha|type b|2018-05-01|4444|HH XX 5368|70" );
		
		v6pool.add( "motorbike|BMW|type c|2019-01-23|5555|HH XX 5369|80" );
		
		v5pool.add( "motorbike|Mercedes|type d|2018-10-30|6666|HH XX 5370|70" );
		
		
	}
	
	CarRental carRental;
	
	void buildCarRentalService() {
		
		
		// build vehicles
		
		
		// build 8 sites with car pools
		
		// build office object
		
		// build CarRental object
			// name
			// sites
			// office
		
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.buildCarRentalService();

	}

	
	
	
}
