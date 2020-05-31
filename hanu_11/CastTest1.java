package hanu_11;
interface Poisonous{}
interface Edible {}
class Fruit implements Edible {
	final static int ID = 42;
	static int getID(){ return ID; }
	int count = 10;
	int getCount(){ return count; }
}
class Apple extends Fruit {
	static int ID = 43;
	static int getID(){ return ID; }
	int count = 20;
	int getCount(){ return count; }
}
class Mango extends Fruit {
	int count = 30;
	int getCount(){ return count; }
}
class CastTest1 {
	
	public static void main(String[] args){
		Fruit f = new Apple();
		Mango mango = new Mango();
		Poisonous p = (Poisonous)mango;
		//p = (Poisonous)f;		// is allowed because Comp cannot analyze dynamic type of f at compile tinme
		boolean bool = f instanceof Poisonous;
		System.out.println( bool );

	}

}
