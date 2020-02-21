package pond.swan;
import pond.shore.Bird;
public class Swan extends Bird {
    public void swim(){
        floatInWater();     // protected in Bird so OK
        System.out.println( text ); // same

    }

    public void helpOtherSwanSwim(){
        Swan other = new Swan();
        other.floatInWater();
        System.out.println( other.text );

    }

    public void helpOtherBirdSwim(){
        Bird bird = new Bird();
        //bird.floatInWater();                // DNC 19: error: floatInWater() has protected access in Bird
        //System.out.println( bird.text );    // DNC 20: error: text has protected access in Bird

    }

}
