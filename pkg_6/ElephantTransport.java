package pkg_6;

class TransportFailedException extends Exception{
    TransportFailedException( String s ){
        super(s);
    } 
}
class CageTooSmallException extends TransportFailedException{
    CageTooSmallException( String s ){
        super(s);
    } 
}
class ElephantAngryException extends TransportFailedException{
    ElephantAngryException( String s ){
        super(s);
    }
}
class ElephantCrashedCageException extends RuntimeException{
    ElephantCrashedCageException(String s){
        super(s);
    } 
}

class Truck {

    CanBeContainer container;

    Truck(  ){
         
    }

    CanBeContainer loadTruck( CanBeContainer cbc ){
        container = cbc;
        return cbc;
    }
}

interface CanBeContainer {
    int WIDTH_FT = 8;
    int LENGTH_FT = 40;
}

class Cage implements CanBeContainer  { 
    Animal animal;
    Cage(  ){
        
    }
    Cage load(Animal a){
        animal = a;
        return this;
    }
}

class Animal {}
class Elephant extends Animal {}



public class ElephantTransport{


    public static void main(String[] args){
    
        // transport elephant to new zoo
        ElephantTransport et = new ElephantTransport();
        
        Cage cage = et.getCage();
       
        try{
            et.loadCage( new Elephant() );
        }
        catch( CageTooSmallException ctse ){
            System.out.println( "cage too small" );
        }
        catch( ElephantAngryException eae ){
            System.out.println( "grrrrrr" );
        }

        try{
            try {
                et.driveToDestination( "Los Angeles" );
            } 
            catch( RuntimeException rte ){
                System.out.println( "turn on onboard HBO MAX stream of friends tv series  ..." );
                System.out.println( "roarr... mmmhmmmm .. :-D" );
            }
            finally {
                System.out.println( "elephant relaxed now ..." );
            }

        }
        catch( TransportFailedException tfe ){
            System.out.println( tfe.getMessage() );
        }
        finally{
            System.out.println( "finally trucks arrives in Los Angeles." );
        }

    }

    Cage getCage(){
        return new Cage();
    };

    Cage loadCage( Animal a ) throws CageTooSmallException, ElephantAngryException {
       return new Cage().load( a );
    }

    void loadTruck( Truck t, CanBeContainer cbc ){
        t.loadTruck( cbc );
    }

    void driveToDestination( String destination ) throws TransportFailedException {
    
        // unfortunatly ...
        throw new ElephantCrashedCageException("rooarrrr!");
    }


}
