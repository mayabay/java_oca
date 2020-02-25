package pkg_4;
import java.time.*;
import java.time.format.*;
public class TimeTraveller {


    private static final TimeTraveller instance = new TimeTraveller();

    private static TimeTraveller getInstance(){
        return instance;
    }

    public static void main(String[] args){
        getInstance().learnRomanHistory();
    }

    void learnRomanHistory(){
       
        LocalDate today = LocalDate.now();

        System.out.println( "learn roman history... : " + today );

        LocalDate foundingOfRome = LocalDate.of( -753, 4, 21 );

        System.out.println( foundingOfRome + " rome was founded." );


    }
}
