// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Reverse { 

	public static String reverse( String s )
	{
		String reversed_string = "";
		
		for (int i = s.length(); i > 0; i--){
			reversed_string += s.charAt(i-1);
		}
		
		return reversed_string;
	}

    public static void main( String[] args ) 
    { 
 
    }
}
