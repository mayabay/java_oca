package pkg_4;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Calculator {
    
    String[] operators;

    public Calculator( String [] ops ){
        this.operators = ops;
    }

    private char parseOperator(String input ){
        char[] chars = input.toCharArray();
        char op = '?';

        for( char c : chars ){
            switch( c ){
                case '+': op = '+'; break;
                case '-': op = '-'; break;
                case '*': op = '*'; break;
                case '/': op = '/'; break;
                case '%': op = '%'; break;
                case '^': op = '^'; break;
            }
        }

        return op;
    } 

    public double[] calculate( String ... input ){
        
        double[] results = new double[input.length];

        for ( int i = 0; i < input.length; i++ ){
            char op = parseOperator( input[i] );
            if (op == '?') {
                results[i] = 0;
            }
            Character CharObj = new Character( op );

            //System.out.println( CharObj );


            String[] operands = input[i].split(  "\\" +  CharObj.toString() );
            if ( operands.length != 2) throw new IllegalArgumentException("wrong input!");

            double op1 = Double.parseDouble( operands[0] );

            double op2 = Double.parseDouble( operands[1] );

            switch( op ){
                case '+': results[i] = (op1 + op2) ; break;
                case '-': results[i] = (op1 - op2) ; break;
                case '*': results[i] = (op1 * op2) ; break;
                case '/': results[i] = (op1 / op2) ; break;
                case '%': results[i] = (op1 % op2) ; break;
                case '^': results[i] = Math.pow(op1,op2) ; break;
            }
        }
        return results;
    }

    public double[] calculate ( List<String> chained ) {
        List<Double> dss = new ArrayList<>();
        for ( String s : chained ){

            if (s.contains(".")){
                throw new IllegalArgumentException("only integer values in chained expressions!");
            }

            System.out.println( s );
            char[] expr = s.toCharArray();
            boolean calculate = true;
            int id1 = 0;        // 1st operand1
            int id2 = 1;        // 1st operator
            int id3 = 2;        // 1st operand2

            Double d1 = new Double( (new Character( expr[id1] ).toString() ) );
            double op1 = d1.doubleValue();
            
            loop: while( calculate ){

                Double d3 = new Double( (new Character( expr[id3] ).toString()  ) );
                double op3 = d3.doubleValue();
                double result = calculate( expr[id2], op1, op3  );
                op1 = result;
                dss.add( result );

                id2 +=2; id3 += 2;
                if ( id3 >= ( expr.length  ) ){ calculate = false; break loop; }
            } 


        }
        double[] retVal = new double[ dss.size() ]; int dsi = 0;
        for( double d : dss ){  retVal[dsi] = dss.get(dsi); dsi++; }
        return retVal;
    }

    public double calculate( char op, double op1, double op2  ){
        
        double result = 0; 

        switch( op ){
            case '+': result = (op1 + op2) ; break;
            case '-': result = (op1 - op2) ; break;
            case '*': result = (op1 * op2) ; break;
            case '/': result = (op1 / op2) ; break;
            case '%': result = (op1 % op2) ; break;
            case '^': result = Math.pow(op1,op2) ; break;
        }
        return result;
    }


}
