package enthu;
class Mammal {
	String name;
	{
		name = "unknown";
	};
	int numLegs;
	Mammal( int legs ){
		numLegs = legs;
	}
}
class Koala extends Mammal {

	{
		System.out.println( "in init .. name = " + name );

	};

	Koala(String name){
		super(4);
		this.name = name;
	}
}
class InheritTest1 {

	public static void main(String[] args){
		Koala k = new Koala("Charlie");
		System.out.println( k.name + " has " + k.numLegs + " legs." );

		String str[], $str2 = "";
		String str2[] = {"A","B"}, str3[][] = { {"A"},{} };

	}
}
