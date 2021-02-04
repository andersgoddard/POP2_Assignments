import java.io.*;
import java.util.*;

public class Classify { 

	public static String classify( char c )
	{
		
		String vowels = "aeiouAEIOU";
		String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
		String classification = "";
		boolean vowel = false;
		boolean consonant = false;
		
		if (vowels.indexOf(c) >= 0) vowel = true;
		else if (consonants.indexOf(c) >= 0) consonant = true;
		else return "";
		
		if (Character.isUpperCase(c)) classification += "uppercase ";
		else classification += "lowercase ";
		
		if (vowel) classification += "vowel";
		else classification += "consonant";
		
		return classification;
	}

    public static void main( String[] args ) 
    { 
 
    }
}
