package pkg_5;

class Animal {}
class Primate extends Animal implements CanSpeak {
    public void say(){
        System.out.println( "hunger have" );
    }
}
class HomoSapiens extends Primate implements CanSpeakWithGrammar {
    public void say(){
        System.out.println( "I have hunger." );
    }
    public void sayGrammatically(){
        System.out.println( "I am hungry and would like to eat something." );
    }
}

interface CanSpeak{
    void say();
}
interface CanSpeakWithGrammar extends CanSpeak{
    void sayGrammatically();
}

interface CanDoStuff{
   
    //{} // DNC 5: error: illegal start of type

    public  static  final   int MINUTES_OF_HOUR = 60;

            static  final   int MONTHS_OF_YEAR  = 12;

                    final   int DAYS_OF_WEEK    = 7;

                            int HOURS_OF_DAY    = 24;

    default void canDoManyThings(String stuff){
        System.out.println( "doing " + stuff + " at " + MONTHS_OF_YEAR + " months of the year" );

    }

}
interface CanLearn extends CanDoStuff {

    //static {} // DNC 4: error: illegal start of type

    void learnIt();

    default String learnStuff (String stuff){
        return "learning " + stuff;

    }
}
public class LearnInterfaces implements CanLearn {
   
    static final boolean haveMotivation;    // final static here

    static { haveMotivation = true; }       // last chance to initiate final var

    final boolean isHungry;             // can init final in declaration 

    // { isHungry = false; }            // can init in insta initer

    public LearnInterfaces (){
        isHungry = true;                // can init final in ctor
    }

    public static void main(String[] args){
        
        //new LearnInterfaces().learnIt();
        LearnInterfaces li =  new LearnInterfaces();
        li.castIt();
    }

    // DNC  11: error: learnIt() in LearnInterfaces cannot implement learnIt() in CanLearn
    //static void learnIt(){
    //}
    
    public void learnIt(){
        System.out.println( "learnIt()" );

        canDoManyThings("swimming");
    }

    void castIt(){
        Animal bear = new Animal();
        Primate gongo = new Primate();
        HomoSapiens frank = new HomoSapiens();  

        //showLanguage( bear );   // DNC 85: error: incompatible types: Animal cannot be converted to CanSpeak
        showLanguage( gongo );
        showLanguage( frank );

        showLanguageWithGrammar( frank );
    }

    void showLanguage( CanSpeak speaker ){
        speaker.say();
    }

    void showLanguageWithGrammar( CanSpeakWithGrammar speaker ){
        speaker.sayGrammatically();
    }




}
