package hanu_12;
import java.util.*;
import java.lang.Math.*;		// OK 
//import java.lang.System.*.*;	// DNC
class ALTest1 {
	

	public static void main(String[] args){
		do2();

	}

	static void do2(){
		
		ArrayList<String> l1 = new ArrayList<>();
		ArrayList<String> l2 = new ArrayList<>();
		l1.add("a");
		l1.add("b");
		l1.add("b");
		l1.add("c");
		l1.add("d");
		System.out.println( l1 );

		l1.addAll(l2);
		//l1.removeAll("b");		// DNC no suitable
		l1.remove("b");

		System.out.println( l1 );

	}

	static void do1(){
		ArrayList<String> al = new ArrayList<>();
		al.add("a");
		al.add("b");
		al.add(al.size(), "c");

		System.out.println( al );

	}
}
