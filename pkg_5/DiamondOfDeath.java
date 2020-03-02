package pkg_5;

interface ConsumesFood {
    
    void eat( Food food );

    // ok, if calc lives only here
    /*
    default int calcAmount( int mass, int units ){
        return mass * units;
    }
    */
}
interface Carnivore extends ConsumesFood {
    
    default int calcAmount( int mass, int units ){
        return mass * units;
    }
}

interface Herbivore extends ConsumesFood {

    default int calcAmount( int mass, int units ){
        return mass - units;
    }
}

/*
    pkg_5\DiamondOfDeath.java:28: error: interface Omnivore inherits unrelated defaults
    for calcAmount(int,int) from types Carnivore and interface Omnivore extends Carnivore, Herbivore {}

    pkg_5\DiamondOfDeath.java:30: error: class Bear inherits unrelated defaults for calcAmount(int,int) 
    from types Carnivore and Herbiv
        class Bear implements Omnivore {
        ^
    2 errors
 * */

interface Omnivore extends Carnivore, Herbivore {

    default int calcAmount( int mass, int units ){
        return mass * units;
    }
}

class Bear implements Omnivore {
    public void eat(Food food){
            
        System.out.println( "eating " + food );
    }
}

class Food {
    private String eatable;
    Food( String eatable ){
        this.eatable = eatable;
    }

    public String toString(){
        return eatable;
    }
}

public class DiamondOfDeath{
    
    
    public static void main(String[] args){

        Food leafs = new Food("Leafs");

        Bear barnie = new Bear();
        barnie.eat(leafs);
        System.out.println( barnie.calcAmount(2,4) );

        int res = ((Herbivore)barnie).calcAmount(1,2);
        System.out.println( res );

    }

}
