package enthu;
class Q984 {

	public static void main(String[] args){
			System.out.println( 	new Q984().parseFloat("42")  );

	}

	public float parseFloat(String s){
	   float f = 0.0f;
	   try{
		  f = Float.valueOf(s).floatValue();
		  return f ;
	   }
	   catch(NumberFormatException nfe){
		  System.out.println("Invalid input " + s);
		  f = Float.NaN ;
		  return f;
	   }
	   finally { System.out.println("finally");  }
	   //return f ;	// DNC unreachabl	// DNC unreachablee
	}
}
