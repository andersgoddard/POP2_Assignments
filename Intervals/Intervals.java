import java.io.*;
import java.util.*;

public class Intervals { 

	public static String intersect( int a1, int b1, int a2, int b2 )

	{
		int a_max;
		int b_min;
		String intersect = "";
		
		if (a1 > a2) a_max = a1;
		else a_max = a2;
		
		if (b2 > b1) b_min = b1;
		else b_min = b2;
				
		if (b_min >= a_max) intersect = "[" + a_max + "," + b_min + "]"; 
		else intersect = "[]";
		
		return intersect;
	}

    public static void main( String[] args ) 
    { 
    	
    }
}


