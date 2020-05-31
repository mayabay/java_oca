package hanu_9;
class Employee extends Person {
	
	String employeeId;

	static int getPersonCount(){ return 42; };

	public static void main(String[] args){
		Employee ee = new Employee();
		ee.employeeId = "101";
		ee.name = "Amy";
		System.out.println( ee.getName() );

		System.out.println(  getPersonCount() );

		
	}
}
