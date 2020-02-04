package pkg_2;
public class NestedLoops {

	public static void main(String[] args){
		for (;;)

			break;	

		int count = 0;
		ROW_LOOP: for(int row = 1; row <=3; row++)
			for(int col = 1; col <=2 ; col++) {
				if(row * col % 2 == 0) continue ROW_LOOP;
				count++;
			}
		
		System.out.println(count);


		int x = 4; 
		long y = x * 4 - x++;
		if (y<10) 
		
		
		System.out.println("Too Low");
		else 
		
		
		System.out.println("Too high");


	}	
	
}





