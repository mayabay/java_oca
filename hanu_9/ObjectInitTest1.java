package hanu_9;
class Person {
	String name;
	Person(String name){
		this.name = name;
	}
	Person(){}
}
class Employee extends Person{
	Employee(String s){
		name = s;
	}
}
class ObjectInitTest1 {

	public static void main(String[] args){

		Employee e = new Employee("Peter Parker");
		System.out.println( e.name );

	}
}
