package bsbonus;

class TestI {}

interface CanClimb { int maxHeight(); }

interface HasClaws { boolean isSharp(); }

class Koala implements CanClimb, HasClaws {
	public int maxHeight(){return 15;}
	public boolean isSharp(){ return true; }
}

class Ex2Q54 {

	public static void main(String[] args){
		Koala k = new Koala();
		Object o = k;
		CanClimb cc = (CanClimb)o;
		HasClaws hc = (HasClaws)cc;
		System.out.println( cc.maxHeight() );
		System.out.println( hc.isSharp() );
		
		Iterable it = (Iterable)hc;

		Iterable it2 = (Iterable)new TestI();	// 26: error: incompatible types: TestI cannot be converted to Iterable
				// if TestI is final !!!
				// https://stackoverflow.com/questions/16186474/java-casting-in-interfaces
				// JLS 5.6.1 
				//
				//
	}

}
