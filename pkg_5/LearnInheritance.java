package pkg_5;

interface I1 {

	static void w() {
		System.out.println( "w in I1" );
	}

	default void u(){
		System.out.println( "u in I1" );
	}
}

interface I2 extends I1 {

	static void w() {
		System.out.println( "w in I2" );
	}

	default void u(){
		System.out.println( "u in I2" );
	}
}

interface I3 {
	static void w(){ 
		System.out.println( "w In I3" );
	}
	
	default void u(){
		System.out.println( "u in I3" );
	}
}

abstract class A1 {
	static void w(){ 
		System.out.println( "w In A1" );
	}

	void u(){
		System.out.println( "u In A1" );
	}
}

class B1 extends A1 implements I2 {

	static void w(){ 
		System.out.println( "w In B1" );
	}
											// void u() DNC 31: error: u() in B1 cannot implement u() in I2
	public void u(){						// must be public, java thinks you want to @override I2 u()
		System.out.println( "u In B1" );
	}

	void callU(){

		System.out.println( "callU\n ------------------------"  );

		u();				// u in B1
		this.u();			// u in B1
		super.u();			// u in A1
		//I2.u();			// DNC 49: error: non-static method u() cannot be referenced from a static context
		I2.super.u();		// u in I2
		//I1.u();			// DNC 51: error: non-static method u() cannot be referenced from a static context
		//I1.super.u();		// DNC 52: error: not an enclosing class: I1
	
		// https://blog.codefx.org/java/everything-about-default-methods/
		// It is not possible to call a method from an interface that is not mentioned in the implements clause.

		/*
		Rule #1:
		Classes win over interfaces. If a class in the superclass chain has a declaration for the method (concrete or abstract),
		you’re done, and defaults are irrelevant.

		Rule #2:
		More specific interfaces win over less specific ones (where specificity means “subtyping”). 
		A default from List wins over a default from Collection, regardless of where 
		or how or how many times List and Collection enter the inheritance graph.

		Rule #3:
		There’s no Rule #3. If there is not a unique winner according to the above rules, concrete classes must disambiguate manually.
		Brian Goetz – Mar 3 2013 (formatting mine)

		* */



	}

	void callW(){

		System.out.println( "callW\n ------------------------"  );
		
		w();				// w in B1
		this.w();			// w in B1
		super.w();			// w in A1
		A1.w();				// w in A1
		I2.w();				// w in I2
		//I2.super.w();		// DNC 66: error: illegal static interface method call
		I1.w();				// w in I1
	}
}

public class LearnInheritance {

	public static void main(String[] args){
		A1 a1 = new B1();					// X <- x implicit cast OK

		a1.u();				// u in B1		u is instance m()	(actual object type is called)
		a1.w();				// w in A1		w is static m()		(ref type is called)

		//a1.callI(); // DNC cannot find symbol

		( (B1)a1 ).callU();					// x <- X explicit cast required
	
		//( (B1)a1 ).callW();					// OK cast again

		//B1 bb = a1;			// DNC 73: error: incompatible types: A1 cannot be converted to B1
		B1 bb = (B1) a1;		// x <- X ()

		bb.callW();

		System.out.println( "+++++++++++++++++++++++++" );


		I1 i1 = new B1();
		i1.u();

	}
}
