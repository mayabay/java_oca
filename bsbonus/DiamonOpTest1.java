package bsbonus;
import java.util.*;
class DiamondOpTest1 {

	//int j = ii;		// DNC 5: error: illegal forward reference

	int ii;

	public static void main(String[] args){
		List<Integer> I1 = new ArrayList();	 	// WARN 6: warning: [unchecked] unchecked conversion
		I1.add(42);
		//I1.add("42");			// DNC no suitable found
		//I1.add(new Object());	// DNC same
		
		//List<Object> oblist = (List<Object>)I1;	
				// DNC 11: error: incompatible types: List<Integer> cannot be converted to List<Object>
		


	}



}
