import junit.framework.TestCase;
import java.io.*;
import java.util.*;

public class CustomStringSortTest extends TestCase {
	
	public void testNormalSort(){
		ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("apple");
		
		PredicateStringPair pred = (a, b) -> {
			if (a.charAt(0) <= b.charAt(0)) return true;
			else return false;
		};
		
		CustomStringSort.sortStrings(fruits, pred);
		
		ArrayList<String> check = new ArrayList<String>();
		check.add("apple");
		check.add("banana");
		check.add("orange");
		
		assertEquals(fruits, check);		
	}
	
	public void testLongerSort(){
		ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("apple");		
        fruits.add("bananas");
        fruits.add("orange");
		
		CustomStringSort.sortStringsLonger(fruits);
		
		ArrayList<String> check = new ArrayList<String>();
		check.add("bananas");
		check.add("orange");
		check.add("apple");
		
		assertEquals(fruits, check);	
	}
	
	public void testNumAsSort(){
		ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("kiwi");		
        fruits.add("apple");		
        fruits.add("banana");	
		
		CustomStringSort.sortStringsNumAs(fruits);

		ArrayList<String> check = new ArrayList<String>();		
		check.add("banana");
		check.add("apple");		
		check.add("kiwi");		
		
		assertEquals(fruits, check);		
	}
	
	public void testDictionarySortOnLength(){
		ArrayList<String> words = new ArrayList<String>();
		words.add("bananas");
		words.add("bananass");		
		words.add("banana");
		
		CustomStringSort.sortStringsDictionary(words);
		
		ArrayList<String> check = new ArrayList<String>();				
		check.add("banana");
		check.add("bananas");
		check.add("bananass");
		
		assertEquals(words, check);
	}
	
	public void testDictionarySortOnLetters(){
		ArrayList<String> words = new ArrayList<String>();
		words.add("abs");
		words.add("grimsby");
		words.add("zebra");
		words.add("aardvark");
		
		CustomStringSort.sortStringsDictionary(words);
		
		ArrayList<String> check = new ArrayList<String>();				
		check.add("aardvark");
		check.add("abs");
		check.add("grimsby");
		check.add("zebra");
		
		assertEquals(words, check);		
	}
	
	public void testDictionarySortOnNonAlphaNumerics(){
		ArrayList<String> words = new ArrayList<String>();
		words.add("@betts");
		words.add("zebra");
		words.add("@anders");
		words.add("betts");
		
		CustomStringSort.sortStringsDictionary(words);
		
		ArrayList<String> check = new ArrayList<String>();				
		check.add("betts");
		check.add("zebra");
		check.add("@anders");
		check.add("@betts");
		
		assertEquals(words, check);		
	}	
	
	public void testDictionarySortOnNumerics(){
		ArrayList<String> words = new ArrayList<String>();
		words.add("@anders");
		words.add("zebra");
		words.add("9 oranges");
		words.add("@betts");
		words.add("betts");
		words.add("33 oranges");
		words.add("3 oranges");
		
		CustomStringSort.sortStringsDictionary(words);
		
		ArrayList<String> check = new ArrayList<String>();				
		check.add("betts");
		check.add("zebra");
		check.add("3 oranges");
		check.add("33 oranges");	
		check.add("9 oranges");	
		check.add("@anders");
		check.add("@betts");
		
		assertEquals(words, check);			
	}
	
	public void testIndividualItems(){
		// Testing the same non-alphanumerics against each other		
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> check = new ArrayList<String>();
		
		words.add("@plum");
		words.add("@kumquat");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("@kumquat");	
		check.add("@plum");
		assertEquals(words, check);
		
		words = new ArrayList<String>();
		words.add("@kumquat");
		words.add("@plum");
		
		CustomStringSort.sortStringsDictionary(words);
		assertEquals(words, check);
		
		// Testing different non-alphanumerics against each other		
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("@plum");
		words.add(":kumquat");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add(":kumquat");	
		check.add("@plum");		
		assertEquals(words, check);

		words = new ArrayList<String>();
		words.add(":kumquat");
		words.add("@plum");
		
		CustomStringSort.sortStringsDictionary(words);
		assertEquals(words, check);		
		
		//Testing numbers against each other
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("3 orange");
		words.add("33 orange");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("3 orange");	
		check.add("33 orange");
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("33 orange");
		words.add("3 orange");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);			
		
		// Testing numbers against non-alphanumerics
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("@plum");
		words.add("33 orange");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("33 orange");
		check.add("@plum");	
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("33 orange");
		words.add("@plum");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);				
		
		// Testing numbers against lower case letters
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("orange");
		words.add("33 orange");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("orange");	
		check.add("33 orange");
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("33 orange");
		words.add("orange");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);		
		
		// Testing lower case letters against each other on length (i.e. same sequence until lengths diverge)
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("strawberries");
		words.add("straw");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("straw");	
		check.add("strawberries");
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("straw");
		words.add("strawberries");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);		

		// Testing lower case letters against each other - different words
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("strawberries");
		words.add("apple");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("apple");	
		check.add("strawberries");
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("apple");
		words.add("strawberries");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);			
		
		// Testing lower case letters against non-alphanumerics
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("strawberries");
		words.add("@kumquat");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("strawberries");
		check.add("@kumquat");	
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("@kumquat");
		words.add("strawberries");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);		

		// Testing numbers against upper case letters
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("Orange");
		words.add("33 orange");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("Orange");	
		check.add("33 orange");
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("33 orange");
		words.add("Orange");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);		
		
		// Testing upper case letters against each other on length (i.e. same sequence until lengths diverge)
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("Strawberries");
		words.add("Straw");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("Straw");	
		check.add("Strawberries");
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("Straw");
		words.add("Strawberries");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);		

		// Testing upper case letters against each other - different words
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("Strawberries");
		words.add("Apple");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("Apple");	
		check.add("Strawberries");
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("Apple");
		words.add("Strawberries");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);			
		
		// Testing upper case letters against non-alphanumerics
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("Strawberries");
		words.add("@kumquat");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("Strawberries");
		check.add("@kumquat");	
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("@kumquat");
		words.add("Strawberries");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);	

		// Testing upper case letters against each other
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("Strawberries");
		words.add("Apple");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("Apple");
		check.add("Strawberries");	
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("Apple");
		words.add("Strawberries");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);	
		
		// Testing different letters - upper case vs lower case
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("Strawberries");
		words.add("apple");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("apple");
		check.add("Strawberries");	
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("apple");
		words.add("Strawberries");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);	
		
		// Testing the same letters - upper case vs lower case
		words = new ArrayList<String>();
		check = new ArrayList<String>();
		
		words.add("Strawberries");
		words.add("strawberry");
		
		CustomStringSort.sortStringsDictionary(words);
		check.add("strawberry");
		check.add("Strawberries");	
		assertEquals(words, check);

		words = new ArrayList<String>();	
		words.add("strawberry");
		words.add("Strawberries");
		
		CustomStringSort.sortStringsDictionary(words);		
		assertEquals(words, check);			
	}
	
	public void testDictionarySortOnCapitals(){
		ArrayList<String> words = new ArrayList<String>();
		words.add("Kiwi");	
		words.add("@kumquat");
		words.add("9 oranges");			
		words.add("Banana");
		words.add("@plum");
		words.add("33 oranges");
		words.add("3 oranges");
		words.add("Strawberry");		
		words.add("strawberries");	
		words.add("bananas");	
		words.add("kiwis");		
		words.add("banana");		
		
		CustomStringSort.sortStringsDictionary(words);
		
		ArrayList<String> check = new ArrayList<String>();				
		check.add("banana");
		check.add("bananas");
		check.add("Banana");
		check.add("kiwis");
		check.add("Kiwi");	
		check.add("strawberries");	
		check.add("Strawberry");	
		check.add("3 oranges");	
		check.add("33 oranges");	
		check.add("9 oranges");	
		check.add("@kumquat");
		check.add("@plum");
				
		assertEquals(words, check);				
	}
}