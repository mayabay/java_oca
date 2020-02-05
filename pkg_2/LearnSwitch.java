package pkg_2;
public class LearnSwitch {

    public static void main(String[] args){
    

        // byte, short, char, int and wrapper
        // String , enum

        switch(0){}

        final String another = "gunther";   // var can be used as case
        String ano = "john";                // not a case constant
        
        String friend = "monica";
        friend = another;

        switch(friend){
            
            case "monica":
                        System.out.println( "Hello monica!" );
                        //break;
            default:    System.out.println( "who are you?" );
            case "rachel":
                        System.out.println( "Its rachel :-)" );
                        //break;
            case "chandler":
                        System.out.println( "oh, chandler" );
                        break;
            case "joey": 
                        System.out.println( "yeah !!" );
                        break;
            //case friend:    // DNC 29: error: constant string expression required
            case another: 
                        System.out.println( "gunther?" );
                        break;
            case "ross":
                        System.out.println( "i like rachel" );
                        break;
        }

    }

}
