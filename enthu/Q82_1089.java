package enthu;
public class Q82_1089{


	public static void main(String[] args){

		Short 		k = 9;
		Integer		i = 9;
		char 		c = 'a';


		//i = k.shortValue();		// DNC incompat short is not promoted to int an then boxed


		//c *= i;
		c = (char)i.intValue();
		System.out.println( c );


	}
}
