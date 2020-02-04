package pkg_2;
public class LearnFlowCtrl {
            
    public static void main(String[] args){
       
        boolean hungry = true, tired = true, happy = true, emptyBelly = true, sleepy = false ;



        //eatCookies("AND", hungry, sleepy );

        //eatCookies(hungry,  "AND",  happy );
        //eatCookies(hungry,  "OR",   happy );
        //eatCookies(hungry,  "OR",   happy );
        
        eatCookies(hungry,  "EOR",   false );

        

    }

    static void eatCookies(boolean bool1, String boolOp, boolean bool2 ){

       switch(boolOp){
            case "AND":
                if (bool1 & bool2){
                    System.out.println( "yes cookies pls!" );
                }else{ 
                    System.out.println( "no no, thnx." );
                }
                break;
            case "OR":
                if (bool1 | bool2){
                    System.out.println( "yes cookies pls!" );
                }else{ 
                    System.out.println( "no no, thnx." );
                }
                break;
            case "EOR":
                if (bool1 ^ bool2){
                    System.out.println( "yes cookies pls!" );
                }else{ 
                    System.out.println( "no no, thnx." );
                }
                break;



       } 

    }

}
