package uebungen;
class A {
	int m = 8848;
	void mA() { System.out.println("A summit at " + m); }
}
class B extends A {
	int m = 6800;
	void mB() { System.out.println("B lhotse wall at " + m); }
}
class C extends B {
	int m = 5400;
	void mC() { System.out.println("C base camp at " + m); }
}
public class Mountain {

	public static void main(String[] args){
		
		A a = new A();
		B b = new B();
		C c = new C();
		
		A a1 = new B();
		B b1 = new C();
		
		//B b3 = new A(); 		// DNC 25: error: incompatible types: A cannot be converted to B
		B b3 = (B) new A();		// OK but RTE CCE A obj is not B


		a.mA();
		b.mB();
		c.mC();

		

		// up <-- implicit cast
		//a = b;	// Tenzing Hillary 1953
		//b = c;	// Messner Habeler 1978

		//a = c;

		// no
		// b = a; // DNC 18: error: incompatible types: A cannot be converted to B

		// down <-- explicit cast ()
		//b = (B) a;		// RTE CCE a is not a B
		//c = (C) b;		// RTE CCE b is not a C

		b1 = (B)a1;		// a1 is a B
		b1.mB();

		// 
		//a.mA();




	}
}
