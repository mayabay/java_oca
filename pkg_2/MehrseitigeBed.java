package pkg_2;
import java.util.Scanner;
public class MehrseitigeBed {
    
    static int age = 7;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);     

        System.out.println( "Eingabe alter: " );
        
        String input = "";
        input = sc.nextLine();
    
        age = Integer.parseInt(input);

        if (age < 7) {
            System.out.println( "GF. unf." );
        }   
        else if (age >= 7 && age < 18){
            System.out.println( "GF. beschr. " );
        }
        else{
            System.out.println( "GF unbeschr." );
        }

        sc.close();    

    }




}
