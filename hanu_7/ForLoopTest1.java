package hanu_7;
import java.util.*;
class ForLoopTest1{

	public static void main(String[] args){
		do1();
	}

	static void do1(){
		Set set = new HashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		Iterator it = set.iterator();
		while( it.hasNext() ){
			String str = (String)it.next();
			System.out.println( str );

		}





	}
}
