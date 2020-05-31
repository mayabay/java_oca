package enthu;
class Doll{
    String name;
    Doll(String nm){
        this.name = nm;
    }
}

class Barbie extends Doll{
    Barbie(){
        //1
		this("unknown");
    }
    Barbie(String nm){
        //2
		//super(nm);
		super(name);	// DNC 17: error: cannot reference name before supertype constructor has been called
    }
}
  public class Q1309 {
       public static void main(String[] args) {
          Barbie b = new Barbie("mydoll");
       }
   }
