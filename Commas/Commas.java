// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Commas { 

	public static String separate( String s )
	{
		
		if (s.length() < 2) return s;
		
		String returnString = "";
		boolean lastLetter = false;
		
		for (int i = 0; i < s.length(); i++){
			if (i == s.length()-1) lastLetter = true;
			returnString += s.charAt(i);			
			if (!lastLetter) returnString += ",";
		}
				
		return returnString;
	}

    public static void main( String[] args ) 
    { 
 
    }
}
