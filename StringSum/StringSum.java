// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class StringSum { 

	public static int sum( String s )
	{
		
		int sum = 0;
		char c;
		
		for (int i = 0; i < s.length(); i++){
			
			c = s.charAt(i);
			
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)){				
				if (Character.isUpperCase(c)) sum += (c-64);
				else sum += (c-96);			
			}						
		}
		
		return sum;
	}

    public static void main( String[] args ) 
    { 
 
    }
}
