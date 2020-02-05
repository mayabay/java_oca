package pkg_2;
import java.util.Scanner;
public class IsEvenNumber{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println( "enter a number: " );
        
        int n = sc.nextInt();
    
        int r = n % 2;
        
        System.out.println( 
            (n % 2) > 0 ? "number is odd" : "number is even"
        );
        
        sc.close();
    }
}
