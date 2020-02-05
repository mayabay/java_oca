package pkg_2;
import java.util.Scanner;
public class BedVerkn {


    public static void main(String[] args){
   
        Scanner sc = new Scanner(System.in);

        System.out.println( "enter number: " );
        int n = sc.nextInt();

        if ( n >= 100 && n <= 200 )
             System.out.println( "wert = 200" );


        if ( n >= 150 || n <= 10  )
            System.out.println( "wert = 200" );

        System.out.println( "Ende" );

    

        /*
        if (n <= 10){
            System.out.println( "wert = 200" );

        }
        else if (  n > 10 && n <= 150  ){
            System.out.println( "wert = 200" );
        }
        else if ( n > 150 && n <= 200)
            System.out.println( "wert = 200" );
        else {
            System.out.println( "?!" );

        }
        */


        sc.close();


    }

}
