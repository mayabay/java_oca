
/*
arithmetic

1. 	x = 2 + 5 *10 *2 /4 - 20 *4 % 2
2. 	x = (2 + 5 *10) *(2 /(4 - 20) *4 % 2)
3. 	y = 10; z = 5.0;
	y = --y * (y = 2) + ++z / y
4.  x = (x = 5) + x * --x % 4
5.  z = 5 % 2 * 3 +10 % 3 +(z = 4)
6.  ok = true;
	system.out.println(ok = !ok)
	system.out.println(!ok)
7.  y = 5
	y = y++ - --y * y++ - --y
8.  y = x = z = 5
	system.out.println(y + ++y +" " + x + z)
	system.out.println(y + ++y +" " + (x + z))

*/	

package pkg_2;
public class AufgOp {

	public static void main(String[] args){	
        // task1();
        //task2();
        task8();

    }	
    

    static void task1(){
        
        //1. 	x = 2 + 5 *10 *2 /4     - 20 *4 % 2
        int x = 2 + 5 * 10 * 2 / 4 - 20 * 4 % 2;    
        
        //      2 + (( 50 * 2 ) / 4)  
        
        //                        2 + 25 - ( 0  ) 

        
        System.out.println( "x = " + x  );

    }

    static void task2(){

        //2. 	x = (2 + 5 *10) *(2 /(4 - 20) *4 % 2)
    
        //              (2 + 50) * (  2 / -16   ) * 4 % 2)

        int x = (2 + 5 *10) * (2 /(4 - 20) * 4 % 2);

        System.out.println( "x = " + x  );

        //System.out.println( 2 / (4-20)  );



    }

    static void task3(){

        //  3. 	y = 10; z = 5.0;
	    //    y = --y * (y = 2) + ++z / y
    
        int y = 10, z = 5;

        //int y = 10; double z = 5.0D;

	    y = --y * (y = 2) + ++z / y;
        
        System.out.println( "y = " + y  );

    }

    
    static void task4(){
        
        //4.  x = (x = 5) + x * --x % 4
        
        int x = (x = 5) + x * --x % 4;
       
        //      5 + (5 * 4)
        //      5 + (20 % 4)
        //      5 + 0

        System.out.println( "x = " + x  );
    }

    static void task5(){
        
        int z = 5 % 2 * 3   + 10 % 3 + (z = 4);
        //          1 * 3   + 1
        //                     4    +   4

        System.out.println("Z = " +  z  );
    }


    static void task6(){

    //6.  ok = true;
	    boolean ok = true;
        System.out.println("-> false -> " + ( ok = !ok));
	    System.out.println("-> true ->  " + ( !ok ));
    }


    static void task7(){

    //  7.  
    int y = 5;
	y = y++ - --y * y++ - --y;

        System.out.println( "y = " + y  );

    }

    static void task8(){

    //8.
    int y, x, z;
    y = x = z = 5;
	System.out.println(y + ++y +" " + x + z);

    System.out.println(y + ++y +" " + (x + z));

    }


}


