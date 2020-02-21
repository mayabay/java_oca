package pkg_4;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class UserCalculates {

   
    static String[] operators = {"+","-","*","/","%","^"};

    static int countOps( String input ){
        int count = 0;
        char[] chars = input.toCharArray();
        for( char c : chars ){
            Character CharObj = new Character(c);
            for ( String op : operators ){
                if ( op.equals( CharObj.toString() ) ){
                    count++;
                }
            }
        }
        return count;
    }  

    public static void main(String[] args){
   
        System.out.println( "calculator on the command line (2 operands, 2 operands, operators = "+ Arrays.toString(operators) +") , use quit to exit: ..." );

        Scanner sc = new Scanner(System.in);

        Calculator calc = new Calculator( operators );

        boolean readInput = true;

        inputloop: while(readInput){
            String input = sc.nextLine();    
            input = input.trim();
            if (  input.equals( "quit" ) ){
                readInput = false;
                break;
            }
            System.out.print( "[input = "+ input +" ] " );

            // array of expressions
            // raw input
            List<String> elemList = new ArrayList<>();  
            // chained expr
            List<String> elemChainedList = new ArrayList<>();  
            // list of simple expr op1 + op2
            List<String> elemRawList = new ArrayList<>();  
            

            if ( input.contains(",") ){
                String[] elem = input.split(",");
                for( String e : elem ){ elemList.add(e); }
            }else{
                 elemList.add( input );
            }

            // array of results 
            double[] results = null; 
            
            // 
            for( String e : elemList ){

                if ( countOps(e) > 1 ){ elemChainedList.add(e); }
                else { elemRawList.add(e); }
            }
           
            // raw
            if ( elemRawList.size() > 0 ){
                results = calc.calculate( elemRawList.toArray( new String[ elemRawList.size() ] ) );  
            }

            // chained
            if ( elemChainedList.size() > 0 ){
                //System.out.println( "list of chained expr ... " + elemChainedList.size() );
                results = calc.calculate( elemChainedList );
            }

            System.out.print( "\t\t\t result = " + Arrays.toString(results) );
            System.out.println(  );

        }

        System.out.println( "ok, bye." );

        sc.close();

    }
}
