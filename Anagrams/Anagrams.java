import java.io.*;
import java.util.*;

public class Anagrams { 

	public static char anagrams( String a, String b )
	{
		
		String checkWord;
		String targetWord;
		StringBuilder targetWordBuilder = new StringBuilder();
		int targetIndex;
		int alphabetIndex;
		int unmatchedLetterIndex = -1;
		char letter;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		
		if (a.length() <= b.length()){
			checkWord = a;
			targetWord = b;
		} else {
			checkWord = b;
			targetWord = a;
		}
				
		for (int i = 0; i < targetWord.length(); i++){
			letter = Character.toLowerCase(targetWord.charAt(i));
			alphabetIndex = alphabet.indexOf(letter);
			if (alphabetIndex != -1) targetWordBuilder.append(letter);
		}
		
		for (int i = 0; i < checkWord.length(); i++){
			letter = Character.toLowerCase(checkWord.charAt(i));
			alphabetIndex = alphabet.indexOf(letter);
			if (alphabetIndex != -1) {
				targetIndex = targetWordBuilder.indexOf(Character.toString(letter));
				if (targetIndex != -1) targetWordBuilder.deleteCharAt(targetIndex);
				if (alphabetIndex > unmatchedLetterIndex) unmatchedLetterIndex = alphabetIndex; 
			}
		}
		
		for (int i = 0; i < targetWordBuilder.length(); i++){
			letter = targetWordBuilder.charAt(i);
			int index = alphabet.indexOf(letter);
			if (index > unmatchedLetterIndex) unmatchedLetterIndex = index;
		}
		
		if (targetWordBuilder.length() == 0) return '!';
		else if (targetWordBuilder.length() == 1) return targetWordBuilder.charAt(0);
		else return alphabet.charAt(unmatchedLetterIndex);
		
	}

    public static void main( String[] args ) 
    { 
    
    }
}
