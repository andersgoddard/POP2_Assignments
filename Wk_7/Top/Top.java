// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Top implements Sequence
{
	
	String first;
	String second;
	String third;
		
	public void push(String candidate){
		
		if (first == null){ 														// Is this the first item?
			first = candidate;	
		} else if (getLower(first, candidate).equals(candidate)){ 					// if this isn't the first item, should it come before the first?
			third = second;													
			second = first;
			first = candidate; 									
		} else if (second == null){ 												// If the item shouldn't come before the first, is it the second item?
			second = candidate;
		} else if (getLower(second, candidate).equals(candidate)){					// If it isn't the second item, should it come before the second?
			third = second;													
			second = item;										
		} else if (third == null || getLower(third, candidate).equals(candidate)){	// The null check here avoids a NullPointerException - checking if this is the third item or lower than the third item 
			third = candidate;												
		}		
	}
	
	private String getLower(String existing, String candidate){					
		if (existing.compareTo(candidate) < 0) 										// Uses the String class's compareTo method - a positive number means the parameter is the "lower" String
			return existing;
		else
			return candidate;
	}
	
	public void reset(){												
		first = null;
		second = null;
		third = null;
	}
	
	public ArrayList<String> getTopThree(){
		ArrayList<String> topThree = new ArrayList<String>();
		
		if (first != null)
			topThree.add(first);
		if (second != null)
			topThree.add(second);
		if (third != null)
			topThree.add(third);

		return topThree;
	}

}