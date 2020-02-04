package uebungen;
public class Auto {
	
	// ------------------------------
	
	static 		int 	miles;
	
	// ------------------------------
	private 	String 	producer;
	private 	String 	type;	
	private 	int 	horsePower;
	private 	int 	maxSpeed;
	private 	boolean hasManualGearbox;

	
	// ------------------------------
	// ctor
	Auto(){}
	
	Auto(String producer, String type){
		this.producer = producer;
		this.type = type;
	}
	
	Auto(String producer, String type, int horsePower, int maxSpeed){
		this.producer = producer;
		this.type = type;
		this.hasManualGearbox = true;
	}	
	
	// ------------------------------
	
	public static void main(String[] args){
		
		Auto car1 = new Auto();
		
		System.out.println(
			"Auto: () default Werte " +
			", static miles = " + Auto.miles + 
			", horsePower = " + car1.horsePower +
			", maxSpeed = " + car1.maxSpeed +
			", hasManualGearbox = " + car1.hasManualGearbox +
			", producer = " + car1.producer +
			", type = " + car1.type 
		);

		car1.producer = "Ford";
		car1.type = "Mondeo";
		car1.miles = 0;
		
		Auto car2 = new Auto();
		car2.miles = 128_000;
		
		System.out.println("car1 miles = " + car1.miles);
		System.out.println("car2 miles = " + car2.miles);
		
		// ---
		
		Auto ford = new Auto("BMW","E30",120,170);
		
		car1 = ford;
		
		ford = null;
		ford.miles = 1;
		
		car1.miles += 2000;
		
		System.out.println(
			" Auto: anderer ctor" +
			", static miles = " + Auto.miles + 
			", horsePower = " + car1.horsePower +
			", maxSpeed = " + car1.maxSpeed +
			", hasManualGearbox = " + car1.hasManualGearbox +
			", producer = " + car1.producer +
			", type = " + car1.type 
		);		
		
		
		System.out.println("miles : " + miles);
		
	}
	
}