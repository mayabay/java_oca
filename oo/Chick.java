package oo;
public class Chick{
	
	private String name = "Fluffy";

	static {
		// doStuff();	// DNC 7: error: non-static method doStuff() cannot be referenced from a static context
		
	}
	
	{
		System.out.println("setting field");
		doStuff();		// runs before ctor finishes
	}
	
	public Chick(){
		name = "Tiny";
		System.out.println("setting constructor");
	}
	
	void doStuff(){
		System.out.println("doStuff()");
		
	}
	
	
	public static void main(String[] args){
		Chick chick = new Chick();
		
		System.out.println(chick.name);
	}
}