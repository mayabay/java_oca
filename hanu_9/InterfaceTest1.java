package hanu_9;
interface Readable{
	int SIZE = 10;
	void read();
	static void staticMethod(){
		System.out.println("In Readable.staticMethod");
	};
	default void defaultMethod(){
		System.out.println("In Readable.defaultMethod");
	};
}
interface Writable{
	int SIZE = 20;
	void write();
	static void staticMethod(){
		System.out.println("In Writable.staticMethod");
	};
	/* commenting the following two methods out
	default void defaultMethod(){
		System.out.println("In Writable.defaultMethod");
	};
	void defaultMethod();
	*/
}

interface ReadWritable extends Readable, Writable{
	//inherits SIZE, read(), and defaultMethod() from Readable
	//inherits SIZE and write() from Writable
}
class InterfaceTest1 {
	
	public static void main(String[] args){

	}
}
