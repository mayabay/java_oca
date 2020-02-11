package pkg_3;
import java.util.Scanner;

public class Password {

   static Scanner sc;

   static String getIn(){
        System.out.println( "enter value: " );
        return sc.nextLine();

   }


    public static void main(String[] args){
        sc = new Scanner(System.in);
        
        do71();

        sc.close();
    }


    static char[] get3RandChars(){
        //int n = (int)(Math.random() * 9 + 1);
        java.util.Random random = new java.util.Random();
        char[] carr = { (char)random.nextInt(256), (char)random.nextInt(256), (char)random.nextInt(256)};
        return carr;
    }

    static void do71(){
        String pw = getIn();

        boolean isTooShort = false;
        boolean isMissingSpecial = false;
        boolean isMissingDigit = false;
        boolean isMissingLower = false;
        boolean isMissingUpper = false;
        boolean hasRepeatedChar = false;

        char[] specials = {'!','\"','\u00A7','$','%','&','/','(',')','=','?' };

        char[] digits = { '0','1','2','3','4','5','6','7','8','9' };

        // ---

        // length
        if ( pw.length() < 8 ){
            isTooShort = true;
        }

        char[] carr = pw.toCharArray();
        
        // double char
        for( int i = 0; i < carr.length; i++ ){
            for( int j = 0; j < carr.length; j++ ){
                if ( j == i ) continue;
                if ( carr[i] == carr[j] ){
                    hasRepeatedChar = true; break;
                }
            }
        }

        // special char
        boolean hasSpecial = false;
        for ( int i = 0; i < carr.length; i++ ){
            for ( int j = 0; j < specials.length; j++ ){
                if (carr[i] == specials[j]){
                    hasSpecial = true; break;
                }
            }
        }
        if (!hasSpecial){
            isMissingSpecial = true;
        }

        // digits
        boolean hasDigit = false;
        for ( int i = 0; i < carr.length; i++ ){
            for ( int j = 0; j < digits.length; j++ ){
                if (carr[i] == digits[j]){
                    hasDigit = true; break;
                }
            }
        }
        if (!hasDigit){
            isMissingDigit = true;
        }

        boolean hasLowerCase = false, hasUpperCase = true;
        for ( int i = 0; i < carr.length; i++ ){
            if ( Character.isLowerCase( carr[i] ) ){
                hasLowerCase = true;
            }

            if ( Character.isUpperCase( carr[i] ) ){
                hasUpperCase = true;
            }
        }
        if (!hasLowerCase) { isMissingLower = true; }
        if (!hasUpperCase) { isMissingUpper = true; }




        // --- ----------------------------------------------
        boolean isOk = true;

        if ( isTooShort ){
            System.out.println( "[err] isTooShort" ); isOk = false;
        }

        if ( hasRepeatedChar ){
            System.out.println( "[err] hasRepeatedChar" ); isOk = false;
        }

        if ( isMissingSpecial ){
            System.out.println( "[err] isMissingSpecial" ); isOk = false;  
        }

        if ( isMissingDigit ){
            System.out.println( "[err] isMissingDigit" ); isOk = false;
        }

        if ( isMissingDigit ){
            System.out.println( "[err] isMissingDigit" ); isOk = false;
        }

        if ( isMissingLower ){
            System.out.println( "[err] isMissingiLower" ); isOk = false;
        }
        
        if ( isMissingUpper ){
            System.out.println( "[err] isMissingUpper" ); isOk = false;
        }

        if (isOk){

            String userName = null;
            java.util.Map<String, String> env = System.getenv();
            if (env.containsKey("USERNAME")){
                userName = env.get("USERNAME");
            }

            userName += ("@" + env.get("COMPUTERNAME")); 

            System.out.println( "[inf] is ok : " + userName );
        }



    } 


    /*
     *
 Aufgabe 73 Schreiben Sie eine Klasse Abrufcode.java. Das Programm soll einen String erzeugen, der als Abrufcode genutzt werden kann. Die ersten zwei Zeichen sollen “SQ“ sein, danach sollen acht Zufallsziffern generiert werden von 1 – 9. Am Ende soll eine Prüfzahl eingefügt werden, die folgenden Bedingungen entspricht: Die (Quersumme der Stellen 3-10 + Prüfzahl )%97 = 1  
     * */

}
