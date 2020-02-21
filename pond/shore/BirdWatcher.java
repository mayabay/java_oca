package pond.shore;
public class BirdWatcher{
    public void watchBird(){
        Bird bird = new Bird();
        bird.floatInWater();                // same package => can access protected member
        System.out.println( bird.text );    // same 

    }
}
