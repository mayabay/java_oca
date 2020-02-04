package pkg_3;
import java.util.List;
import java.util.ArrayList;

public class LearnStrSBAL{

	static List<String> friends = new ArrayList<String>(6); 	


	public static void main(String[] args){

		Long lo1 = new Long(1);
		Integer in1 = new Integer(1);
		//Short sh1 = new Short(1);	// DNC 14: error: no suitable constructor found for Short(int)
											// constructor Short.Short(short) is not applicable "lossy conversion"
		double d = 0_1234.5_6;									
		System.out.println( d  );

		int i1 = new Integer(1);		// OK auto unboxing + assignment + Integer -> gc 

		long lo2 = new Long(1);			// promote to long + unboxing + assign + Long -> gc



		//goStr();
		


		try {
			crashIT();
			
			boolean canSeeMe = true;
		}
		catch ( Exception e  ){
			System.out.println( "caught:  " + e.getMessage() );
			//System.out.println( canSeeMe );	// DNC 33: error: cannot find symbol
			int catchyVar = 42;			
		}
		finally{
			System.out.println( "finally"  );
			//System.out.println( catchyVar  ); // DNC 39: error: cannot find symbol

		}


		System.out.println( "out"  );
		
		// -- 
		goStr();

	}

	static void crashIT() throws Exception {
		throw new Exception("destroyer");
	}

	static void goStr(){
		
		/* 
			------------------
			String 
			------------------
		*/

		// -- 
		String str1_monica = "Monica Geller";

		String str2_ross = new String("Ross Geller");

		char[] carr1_joey = {'J','o','e','y',' ','T','r','i','b','b','i','a','n','i'   };
		
		String str3_joey = new String (carr1_joey);

		byte[] byteArr1 = { 0x1, 0x2, 0x3, 0b100, 0b101, 06 };

		String strFromByteArr = new String( byteArr1 );
		
		StringBuffer sb1_chandler = new StringBuffer("Chandler Bing");

		String str4_chandler = new String(sb1_chandler);
		
		String str5_phoebe = "Phoebe Buffet";

		String str6_rachel = new String ( new char[] { 'R','a','c','h','e','l',' ','G','r','e','e','n'  }  ); 

		friends.add(str1_monica);

		friends.add(str2_ross);

		friends.add(str3_joey);

		friends.add(str4_chandler);

		friends.add(str5_phoebe);

		friends.add(str6_rachel);

		listThem();
		
		// -- 	

		// -- equals()

		System.out.println("equals() -> " + ( "Phoebe Buffet".equals( str5_phoebe ) ) );

		// -- replace()	
		
		String tmp = str5_phoebe.replace( "Buffet", "Baffet" );
		String oldElem = friends.set(4, tmp);
		System.out.println( oldElem );
		//listThem();
		
		tmp = tmp.replace('a','u');
		System.out.println( tmp );
		friends.set(4,tmp);	
		listThem();

		System.out.println( "Phoebe Buffet".toUpperCase() );	// PHOEBE BUFFET
		
		System.out.println( tmp.endsWith("Buffet") );		// true
		
		System.out.println( friends.get(5).charAt(7) );		// G

		System.out.println( friends.get(5).indexOf("Green") );		// 7
		
		// add()
		System.out.println( friends.add("Ross Geller") );
		friends.add(friends.size(),"John Rambo");			// added ad end of List
		try {
			friends.remove(friends.size());			// IOOE
		}catch(IndexOutOfBoundsException ioobe){
			ioobe.printStackTrace();
			friends.remove(2);
		}
		;
		listThem();

	}	


	static void listThem(){
		for( int i = 0; i < friends.size(); i++ ){
			System.out.println( "["+ i +"]  " + friends.get(i) );

		} 
	}
}
