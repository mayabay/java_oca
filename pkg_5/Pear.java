package pkg_5;
public class Pear extends Fruit {
   
    final protected int i = 0;      // DC non access can be placed before access modifier

    public static void main(String[] args){
        new Pear().run();
    
    }

    public String getS(){
        return "is a Pear";
    }

    void run(){
        System.out.println( getS() );
    }
}
