package pkg_2;

public class OpAufgaben {
	// Lasst euch die Ergebnisse von a, b und c in der Konsole anzeigen
	
	
    int getResult(int a ) {
		return a++ * 2;
	}

	
    public static void main(String[] args) {
		
        int a =0, b =0, c;
		
		c = a++ + (15 % 2) -a;
	
        // 0 + ( 1  ) - 1

        System.out.println( "c = " + c  );

		a = b = 2;
	    
        // c = 0

        c = new OpAufgaben().getResult(a) + 10 * OpAufgaben.add(a, b);

        //                              4 + 10 * 4

        System.out.println( "c = " + c  );
        
        // c = 44

		a = 10 ; b = 5;
	
		c = ++b * 2 / 4 - b++ + b;
	    
        // 6 * 2 = 12 / 4 =     3 - 6 + 7
       
        System.out.println( "c = " + c  );
        // c = 4

		a = 25 ; b = 6;

        c = OpAufgaben.mod(a, b) - new OpAufgaben().getResult(a);
        
        // 4 - 50

        System.out.println( "c = " + c  );
        // -46

		c = (a = OpAufgaben.add(3, 5)) + 10 - (b = OpAufgaben.mod(9, 4)) * ++b / a++;
	
        // (a = 8)  +   10 = 
        //                              18 - ( b = 4  ) * 5
                                    //  18 -   ( 20 / 8 )
                                    //  18 - 2
                                    //  16
       

        System.out.println( "c = " + c  );
    }
	
	

    static int  add(int a , int b) {
		return a + b;
	}
   
   
   
   static int mod (int a, int b) {
	   return a % ++b;
   }
}
