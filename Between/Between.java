// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Between { 

	public static String between( int a, int b )
	{
		String s = "";
		boolean firstNumber = true;
		
		if (a <= b){
			for (int i = a + 1; i < b; i++){
				if (i % 2 != 0) { 
					if (firstNumber) firstNumber = false;
					else s+= " ";
					s += i;
				}
			}
		} else {
			for (int i = a - 1; i > b; i--){
				if (i % 2 != 0) {
					if (firstNumber) firstNumber = false;
					else s+= " ";
					s += i;
				}
			}
		}
		
		return s;
	}

    public static void main( String[] args ) 
    { 
 
    }
}
