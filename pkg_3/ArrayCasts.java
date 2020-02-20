package pkg_3;
public class ArrayCasts{

    static int[][] game = new int[3][6];

    //static int[][][] game = new int[3][6][1];

    static int[][] ints2 = new int[2][2];

    static int[][][] ints3 = new int[1][2][3];
    
    public static void main(String[] args){
    
        //Object[][] obj = game;      // works with 3D int arr

        Object[] obj = game;      // works with 2D int arr

        int [][] ints2b = new int[1][];

        ints3[0] = ints2b;

        Object[] obj2 = ints3;
        Object obj3 = ints3;
    
        Object[][] obj23 = ints3;

       // Object[][][] obj3 = ints3; // 27: error: incompatible types: int[][][] cannot be converted to Object[][][]

    }
}
