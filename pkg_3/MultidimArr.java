package pkg_3;

public class MultiDimArr{


    static  private String[][]  words = { {"Blume", "Rose", "Tulpe"},{"Pflanze", "Strauch", "Busch" } };


    public static void main(String[] args){
    
        do1();


    }


    static void do1(){
    
        outer: for ( int i = 0; i < words.length; i++ ){
            System.out.println( words[i] );

            inner: for ( int j = 0; j < words[i].length; j++ ){
                System.out.println( words[i][j] );
            }
        }


    }



}
