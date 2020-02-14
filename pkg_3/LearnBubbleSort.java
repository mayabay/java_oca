package pkg_3;

public class LearnBubbleSort {

	static int[] iarr = { 3,25,8,43,2,5,86,0,6,4,22,6,45,1001,0,3,61,1,5,43,12,6 }; 

	public static void main(String[] args) {
		
		pa(iarr);
		System.out.println("array has "+ iarr.length +" elements, now sort ..");
		sort1(iarr);
		//sort2(iarr);
		pa(iarr);
		System.out.println("integer array has been scanned " + arrScans + " times.");
	}
	
	static int arrScans = 0;

	static void pa(int[] arr) {
		//System.out.print( "[ "+arrScans+" ]" );
		for( int i = 0; i < arr.length; i++ ) {
			
			System.out.print( " " + arr[i] + " "  );
		}
		System.out.println();
	}
	
	static void swap( int[] arr, int idx1, int idx2 ){
		int tmp = arr[idx1];
		arr[idx1] = arr[ idx2 ];
		arr[idx2] = tmp;
	}
	
	static void sort1( int[] arr ) {
		
		boolean isNotSorted = true;
		while(isNotSorted) {
			isNotSorted = false;

			for( int i = 0; i < arr.length; i++ ) {
				if ( (i +1) == arr.length ) {
					arrScans++;
					pa( iarr );
					break;
					
				}
				if ( arr[i+1] < arr[i] ) {
					isNotSorted = true;
					swap( arr, i, (i+1) );
					//int tmp = arr[i];
					//arr[i] = arr[i+1];
					//arr[i+1] = tmp;
					
				}
			}			
		}
	}
	
	static void sort2( int[] arr ) {
		
		outer: for ( int i = 0; i < arr.length; i++ ) {
			inner: for ( int j = arr.length-1; j > i; j-- ) {
				if ( arr[j] < arr[i] ) {
					swap( arr, i, j );
				}
			}
			pa(iarr);
			arrScans++;
		}
		
	}
}
