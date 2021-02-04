import java.io.*;
import java.util.*;

public class Middle { 

	public static int middle( int a, int b, int c )
	{
		
		int min;
		int mid;
		int max;
		
		if (a > b) {
			max = a;
			min = b;
		} else {
			max = b;
			min = a;
		}
		
		if (c > max){
			mid = max;
			max = c;
		} else if (c < min) {
			mid = min;
			min = c;
		} else {
			mid = c;
		}
		
		return mid;
	}

    public static void main( String[] args ) 
    { 
    	
    }
}
