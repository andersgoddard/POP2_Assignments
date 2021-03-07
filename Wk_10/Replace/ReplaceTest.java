import junit.framework.TestCase;
import java.io.*;
import java.util.*;

public class ReplaceTest extends TestCase {
	public void testReplaceStrings(){
		ArrayList<String> test = new ArrayList<String>();
		test.add("Andrew");
		test.add("India");
		test.add("Betts");
		test.add("Hunter");
		
		Replace.replace(test, "India", "Angelina");
		
		ArrayList<String> check = new ArrayList<String>();
		check.add("Andrew");
		check.add("Angelina");
		check.add("Betts");
		check.add("Hunter");
		
		assertEquals(test, check);
	}
	
	public void testReplaceIntegers(){
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(5);
		test.add(1);
		test.add(8);
		test.add(1);
		
		Replace.replace(test, 1, 12);
		
		ArrayList<Integer> check = new ArrayList<Integer>();
		check.add(12);
		check.add(12);
		check.add(2);
		check.add(3);
		check.add(5);
		check.add(12);
		check.add(8);
		check.add(12);
		
		assertEquals(test, check);
	}
	
	public void testDealWithNull(){
		ArrayList<String> test = new ArrayList<String>();
		test.add("Andrew");
		test.add("India");
		test.add("Betts");
		test.add("Frank");		
		test.add("Hunter");		
		test.set(3, null);
		
		Replace.replace(test, null, "Fish Tank");
		
		ArrayList<String> check = new ArrayList<String>();
		check.add("Andrew");
		check.add("India");
		check.add("Betts");
		check.add("Fish Tank");		
		check.add("Hunter");	

		assertEquals(test, check);
	}
	
	public void testDealWithNull2(){
		ArrayList<String> test = new ArrayList<String>();
		test.add("Andrew");
		test.add("India");
		test.add("Betts");
		test.add("Frank");		
		test.add("Hunter");		
		test.add("Frank");
		test.set(3, null);		
		
		Replace.replace(test, "Frank", "Fish Tank");
		
		ArrayList<String> check = new ArrayList<String>();
		check.add("Andrew");
		check.add("India");
		check.add("Betts");
		check.add("Frank");				
		check.add("Hunter");	
		check.add("Fish Tank");		
		check.set(3, null);

		assertEquals(test, check);
	}
}