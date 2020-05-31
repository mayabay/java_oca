package hanu_9;
interface Readable {
	int SIZE = 10;
	void read();
	default int say(){ return 42; }
	static boolean isHappy(){ return Boolean.valueOf("yes"); }
}
interface MoreReadable extends Readable {
	int SIZE = 20;
	void read();
	default int say(){ return 43; }
	static boolean isHappy(){ return Boolean.valueOf("True"); }
}
class A1 {
	void m1() {System.out.println("A");};
	void m2() {System.out.println("A2");};
}

class B1 extends A1 implements MoreReadable {
	public int say(){ return 23; }
	void m1() {System.out.println("B");};
	public void read(){
		System.out.println( "reading ..." );
		
		System.out.println("B1 say() " +  say() );	// 24 is polymorphic
		System.out.println("MoreReadable.super.say() " +  MoreReadable.super.say() );	// 43 call overridden version
	}
}


class C1 extends B1 {
	public int say(){ return 24; }
  
	void m1() {System.out.println("C");};
	void m2() {System.out.println("C2");};
	void test(C1 c1){
		m1();			// C
		super.m1();		// B
		m2();			// C2
		super.m2();		// A2

		System.out.println( "SIZE = " + SIZE );	// 20
		System.out.println( "SIZE = " + Readable.SIZE );	// 10
		System.out.println( say() );	// 24	because C1 has overridden say()
		//	System.out.println( MoreReadable.super.say() );	// DNC non encl... this works only from B1
		read();
		//System.out.println( Readable.super.say() );		// DNC 39: error: not an enclosing class: Readable
		//System.out.println( MoreReadable.super.say() );		// DNC 40: error: not an enclosing class: MoreReadable
		//System.out.println( isHappy() );		// DNC cannot find static interface methods are not inherited
		
		//System.out.println( MoreReadable.isHappy() );	// true
		//System.out.println( Readable.isHappy() );	// false



	}
}



class OrderOfInitTest {

	public static void main(String[] args){
		C1 c1 = new C1();
		c1.test(c1);	
	}
}


