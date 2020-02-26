package pkg_4;
import java.time.*;
import java.time.format.*;
public class TimeTraveller {


    private static final TimeTraveller instance = new TimeTraveller();

    private static TimeTraveller getInstance(){
        return instance;
    }

    public static void main(String[] args){

        //getInstance().learnRomanHistory();
        getInstance().learnDateAndTime();
    }

    void learnRomanHistory(){
       
        LocalDate today = LocalDate.now();

        System.out.println( "learn roman history... : " + today );

        LocalDate foundingOfRome = LocalDate.of( -753, 4, 21 );

        System.out.println( foundingOfRome + " rome was founded." );

        //LocalTime lt = LocalTime.from( foundingOfRome );    // java.time.DateTimeException
            // Unable to obtain LocalTime from TemporalAccessor: -0753-04-21 of type java.time.LocalDate


    }

    void learnDateAndTime(){

        DateTimeFormatter f_dt_F = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL );
        DateTimeFormatter f_dt_L = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.LONG );
        DateTimeFormatter f_dt_M = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.MEDIUM );
        DateTimeFormatter f_dt_S = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT );

        DateTimeFormatter f_d_F = DateTimeFormatter.ofLocalizedDate( FormatStyle.FULL );
        DateTimeFormatter f_d_L = DateTimeFormatter.ofLocalizedDate( FormatStyle.LONG );
        DateTimeFormatter f_d_M = DateTimeFormatter.ofLocalizedDate( FormatStyle.MEDIUM );
        DateTimeFormatter f_d_S = DateTimeFormatter.ofLocalizedDate( FormatStyle.SHORT );

        DateTimeFormatter f_t_F = DateTimeFormatter.ofLocalizedTime( FormatStyle.FULL );
        DateTimeFormatter f_t_L = DateTimeFormatter.ofLocalizedTime( FormatStyle.LONG );
        DateTimeFormatter f_t_M = DateTimeFormatter.ofLocalizedTime( FormatStyle.MEDIUM );
        DateTimeFormatter f_t_S = DateTimeFormatter.ofLocalizedTime( FormatStyle.SHORT );


        ZonedDateTime launch = ZonedDateTime.of( 1969, 7, 16, 13, 32, 0, 0, ZoneOffset.of("+00:00") );
        LocalDate launchDate = LocalDate.of( 1969, 7, 16 );

        //LocalDateTime beginDecent = LocalDateTime.of( 1969, 6, 20, 12, 52, 0, 0 );
        ZonedDateTime beginDecent = ZonedDateTime.of(  1969, 6, 20, 12, 52, 0, 0, ZoneOffset.of( "+00:00" )  );

        LocalDate moonLanding = LocalDate.of( 1969, 7, 20 );

        Period p1 = Period.between( launchDate, moonLanding );
        System.out.println( "p1 = " + p1 );



        LocalTime seperationFromColumbia = LocalTime.of( 17, 44, 0, 0 );

        //System.out.println( "decent began " + beginDecent.format( canFormatFULL_DT ) ); 
                // java.time.DateTimeException: Unable to extract value: class java.time.LocalDateTime
                 

        System.out.println( "Apollo 11 landing was on " + moonLanding.format( f_d_F ) );
            // f_d_F        Friday, June 20, 1969
            // f_d_L        June 20, 1969
            // f_d_M        Jun 20, 1969
            // f_d_S        6/20/69

        System.out.println( "decent begun " + beginDecent.format( f_dt_M )  );
            // f_dt_F       Friday, June 20, 1969 12:52:00 PM Z     // RTE DTE if LocalDateTime
            // f_dt_L       June 20, 1969 12:52:00 PM Z             // RTE DTE if LocalDateTime
            // f_dt_M       Jun 20, 1969 12:52:00 PM
            // f_dt_S       6/20/69 12:52 PM

        System.out.println( "Seperation from Columbia at " + seperationFromColumbia.format( f_t_S ) );
            // f_t_F        java.time.DateTimeException: Unable to extract value:
            // f_t_L        java.time.DateTimeException: Unable to extract value
            // f_t_M        5:44:00 PM
            // f_t_S        5:44 PM


        LocalTime landingTime = LocalTime.of( 20, 17, 40 );
        LocalDateTime EagleHasLanded = LocalDateTime.of( moonLanding, landingTime );
        System.out.println( "touchdown was " + EagleHasLanded.format(f_dt_M) );

        LocalTime PrepEVA = LocalTime.of( 23, 43, 0, 0 );
        Duration dur1 = Duration.between( landingTime, PrepEVA );
        System.out.println( "dur1 = " + dur1 );


    }
}
