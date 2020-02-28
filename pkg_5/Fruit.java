package pkg_5;
public class Fruit{

    private String s = "is a fruit";
    
    public String getS (){
        return s;
    }


    public static void main(String[] args){
        do1();
    }

    public static void do1(){

        int[] a = { 1, 2, 3, 4 };
        int[] b = { 2, 3, 1, 0 };
        System.out.println( a [ (a = b)[3] ] );
        System.out.println( a[ 0 ] );

    }

}
