package pkg_2;
import java.util.Scanner;
public class Noten {

    public static void main(String[] args){
        
        if (args.length == 0){
            System.out.println( "pls enter a number 1 ... 6" );
            System.exit(0);
        }
        
        switch(args[0]){
            case "1": System.out.println( "1 = sehr gut" ); break;
            case "2": System.out.println( "2 = gut" ); break;
            case "3": System.out.println( "3 = befriedigend" ); break;
            case "4": System.out.println( "4 = ausreichend" ); break;
            case "5": System.out.println( "5 = mangelhaft" ); break;
            case "6": System.out.println( "6 = ungenuegend" ); break;
            default: System.out.println( "keine Note" ); break;
    
        }

    }
}
