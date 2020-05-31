package bsbonus;
import java.util.*;
class QE2Q16 {

	public static void main(String[] args){
		List<String> l = new ArrayList();
		l.add("iguana");
		l.add("gecko");
		l.set(1,"");
		String[] sarr = l.toArray( new String[l.size()] );
		System.out.println(  Arrays.toString(sarr) );

	}
}
