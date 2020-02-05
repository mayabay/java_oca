package pkg_2;
import java.util.Scanner;
public class BiggestNumber {

            

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println( "enter three numbers: " );
 
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        System.out.println( "n1 = " + n1 );
        System.out.println( "n2 = " + n2 );
        System.out.println( "n3 = " + n3 );
           
        int biggest = 0;

        if ( n1 > n2 )
            biggest = n1;
        else
            biggest = n2;

        if ( n3 > biggest )
            biggest = n3;

        System.out.println( "biggest = " + biggest );


        sc.close();
    }
}
