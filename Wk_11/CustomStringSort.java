// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

interface PredicateStringPair
{
    boolean better( String a, String b );
}

public class CustomStringSort {

    public static Comparator<String> createComparator( PredicateStringPair pred )
    {	
		Comparator<String> comparator = (a, b) -> { // The returned instance of Comparator<String> should receive two strings, which we’ll call a and b
			if (pred.better(a, b)) return -1;		// a negative value when the better method of pred returns true on the pair a, b
			if (pred.better(b, a)) return 1;		// a positive value when better returns true on the pair b, a
			else return 0;							// 0 otherwise
		};	
        return comparator;
    }

    public static void sortStrings( ArrayList<String> lst, PredicateStringPair pred )
    {
		Comparator<String> comparator = createComparator(pred);
		Collections.sort(lst, comparator);
    }

    public static void sortStringsLonger( ArrayList<String> lst )
    {
		PredicateStringPair pred = (a, b) -> {
			if (a.length() > b.length()) return true;
			else return false;
		};     
		
		sortStrings(lst, pred);
    }

    public static void sortStringsNumAs( ArrayList<String> lst )
    {
		PredicateStringPair pred = (a, b) -> {
			int aCountAs = 0;
			int bCountAs = 0;
			
			for (int i = 0; i < a.length(); i++){
				if (Character.toLowerCase(a.charAt(i)) == 'a') 
					aCountAs++;
			}
			for (int i = 0; i < b.length(); i++){
				if (Character.toLowerCase(b.charAt(i)) == 'a') 
					bCountAs++;
			}
			
			if (aCountAs > bCountAs) return true;
			else return false;
		};
		
		sortStrings(lst, pred);
    }

    public static void sortStringsDictionary( ArrayList<String> lst )
    {	
		PredicateStringPair pred = (a, b) -> {
			
			boolean better = true;
			boolean sameString = true;
			
			// This loop is checking whether the letters in the shorter string are the same sequence of letters from 0 to shorter.length()-1 in the longer string
			for (int i = 0; i < getLoopLength(a, b); i++){
				char aChar = a.charAt(i);
				char bChar = b.charAt(i);
				if (charsAreNotStrictlyEqual(aChar, bChar)){
					sameString = false;
					if (charsAreSameLetter(aChar, bChar)) 	
						// a is better if it is lower case
						better = Character.isLowerCase(aChar); 
					else if (isInAlphabet(aChar) && isInAlphabet(bChar)) 	
						// a is better if it is lower than b in the alphabet (case insensitive)						
						better = Character.toLowerCase(aChar) < Character.toLowerCase(bChar); 
					else if (!isInAlphabet(aChar) && !isInAlphabet(bChar))	
						// a is better if it is lower than b in the unicode characters
						better = aChar < bChar; 								
					else
						// a is better if it is in the alphabet and b is not
						better = isInAlphabet(aChar);
					break;
				}
			}
			
			if (sameString)
				better = a.length() < b.length(); // if the for loop found no differences between the strings, the shorter string is better
			
			return better;
		};
		
		sortStrings(lst, pred);
    }

	private static int getLoopLength(String a, String b){
		int loopLength = 0;
		
		if (a.length() < b.length()){ 
			loopLength = a.length();
		} else {
			loopLength = b.length();
		}
		
		return loopLength;
	}
	
	private static boolean charsAreNotStrictlyEqual(char aChar, char bChar){
		return aChar != bChar;
	}
	
	private static boolean charsAreSameLetter(char aChar, char bChar){
		return Character.toLowerCase(aChar) == Character.toLowerCase(bChar);
	}

	private static boolean isInAlphabet(char ch){
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return alphabet.indexOf(ch) > -1;
	}
	  
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<String>();

        fruits.add("Strawberry");
        fruits.add("strawberries");
        fruits.add("Kiwi");
        fruits.add("kiwis");
        fruits.add("Banana");
        fruits.add("bananas");

        System.out.println( fruits );
        sortStringsLonger( fruits );
        System.out.println( fruits );
        
        sortStringsNumAs( fruits );
        System.out.println( fruits );

        fruits.add( "@plum" );
        fruits.add( "@kumquat" );
        fruits.add( "banana" );
        fruits.add( "3 oranges" );
        fruits.add( "9 oranges" );
        fruits.add( "33 oranges" );
        System.out.println( fruits );
        sortStringsDictionary( fruits );
        System.out.println( fruits );
    }
}
