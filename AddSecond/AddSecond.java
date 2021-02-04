import java.io.*;
import java.util.*;

public class AddSecond { 

	public static String addSecond( int h, int m, int s )
	{
		s += 1;
		String secondAdded = "";
		
		if (s == 60) {
			m += 1;
			s = 0;			
			if (m == 60) {
				h += 1;
				m = 0;
				if (h == 24) {
					h = 0;
				}				
			}						
		}
		
		if (h < 10) secondAdded += "0";
		secondAdded = secondAdded + h + ":";
		
		if (m < 10) secondAdded += "0";		
		secondAdded = secondAdded + m + ":";
		
		if (s < 10) secondAdded += "0";
		secondAdded += s;
		
		return secondAdded;
	}

    public static void main( String[] args ) 
    { 
    	
    }
}
