package hanu_10;
class Fruit{
	Fruit() throws Exception {}
	Fruit(int n){}
}
class Apple extends Fruit {
	Apple() //throws Exception 
	{
		this(42);
	}
	Apple (int n){
		super(n);
	}
}

class CtorTest1{

	public static void main(String[] args){
		Fruit f = new Apple();

	}

}
