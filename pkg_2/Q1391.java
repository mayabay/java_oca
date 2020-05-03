package pkg_2;
public class Q1391 {
    private int j;
    void showJ(){
        while(j<=5){
            for(int j=1; j <= 5;){
                System.out.print(j+" ");
                j++;
            }
            j++;
			System.out.println( "#" + j + " \n" );

        }
    }
    public static void main(String[] args) {
        new Q1391().showJ();
    }
}

