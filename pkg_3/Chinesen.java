package pkg_3;
public class Chinesen {

    static String song; 

    static {
        song = "Drei Chinesen mit dem Kontrabass, sassen auf der Strasse und erzaehlten sich was.\n"
             + "Da kam die Polizei und fragt: ja, was ist denn dass? \n"
             + "Drei Chinesen mit dem Kontrabass.\n"; 
    }

    static void printArr(char[] carr){
        for(char c : carr){
            System.out.print( c );
        }
    }

    public static void main(String[] args){
   
        System.out.println( "---------------------------------------" );
        System.out.println( song );

        char[] carr = song.toCharArray();
        
        System.out.println( "---------------------------------------" );

        // -- a
        printArr( switchVocal(carr,'a') );
        System.out.println( "---------------------------------------" );

        printArr( switchVocal(carr,'e') );
        System.out.println( "---------------------------------------" );

        printArr( switchVocal(carr,'i') );
        System.out.println( "---------------------------------------" );

        printArr( switchVocal(carr,'o') );
        System.out.println( "---------------------------------------" );

        printArr( switchVocal(carr,'u') );
        System.out.println( "---------------------------------------" );


        printArr( switchVocal(carr,'\u00FC') );
        System.out.println( "---------------------------------------" );

    }

    static char[] switchVocal(char[] src, char vocal){
        char[] trg = new char[ src.length ];
        for ( int i = 0; i < src.length; i++ ){
            char newC = src[i];
            switch( src[i] ){
                case 'a': newC = vocal; break;
                case 'e': newC = vocal; break;
                case 'i': newC = vocal; break;
                case 'o': newC = vocal; break;
                case 'u': newC = vocal; break;
            }
            trg[i] = newC;
        }
        return trg;
    }

}
