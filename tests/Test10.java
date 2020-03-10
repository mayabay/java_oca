package tests;
interface Friend {
    String getName();
}
class Cat implements Friend {
    public String getName() {
        return "friend";
    }
}
class Dog implements Friend {
    public String getName() {
        return "dog";
    }
}
class JavaProgrammer {
    void code(){
        // CODE
    }
}
public class Test10  {

    public static void main(String[] args){
        Friend f = new Dog();
        Dog dog = new Dog();
        //System.out.println( ((Dog)null).getName() );    // NPE
        Dog notADog = (Dog)null;
        //JavaProgrammer jp = ((JavaProgrammer)null).code();  // DNC 27: error: incompatible types: 
                                                              //void cannot be converted to JavaProgrammer

    }

}
