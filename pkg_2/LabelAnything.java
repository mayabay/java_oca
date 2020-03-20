package pkg_2;
public class LabelAnything{
	
	public static void main(String[] args){

		label1: {}

		label2: if (true) {
		}		

		label3: do{
				
		}while( false );

		label4: switch(1){

		}
		
		label6: try{
			//m2();	
		}
		catch( Exception e ){
			// ignored
		}

		//label8: int i = 3; // DNC 26: error: '.class' expected
		
		label9: ; 

		crazyLoop();
	}


	static int m(){
		label5: return 1;
	}

	static void m2() throws Exception {
		label7: throw new Exception();
	}

static void crazyLoop(){
  int c = 0;
  JACK: while (c < 8){
    JILL: System.out.println(c);
    if (c > 3) break JACK; else c++;
  }
}


}
