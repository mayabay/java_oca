package pond.inland;
import pond.shore.Bird;
public class BirdWatcherFromAfar{
    public void watchBird(){
        Bird bird = new Bird();
        //bird.floatInWater();                // DNC 6: error: floatInWater() has protected access in Bird
        //System.out.println( bird.text );    // DNC 7: error: text has protected access in Bird 

    }
}
