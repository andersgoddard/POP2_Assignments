import junit.framework.TestCase;
import java.io.*;
import java.util.*;

public class PairTest extends TestCase {
	
	public void testCreateStringPair(){
		String a = "Hello";
		String b = "World";
		Pair<String> p = new Pair<String>(a, b);
		
		assertEquals(a, p.getFirstElem());
		assertEquals(b, p.getSecondElem());
	}
	
	public void testCreateIntegerPair(){
		Integer a = 2;
		Integer b = 4;
		Pair<Integer> p = new Pair<Integer>(a, b);
		
		assertEquals(a, p.getFirstElem());
		assertEquals(b, p.getSecondElem());		
	}
	
	public void testContainedIn1(){
		Integer a = 2;
		Integer b = 4;
		Pair<Integer> p = new Pair<Integer>(a, b);

		assertTrue(p.containedIn(b));
		assertFalse(p.containedIn(5));
	}
	
	public void testContainedIn2(){
		String a = "Hello";
		String b = "World";
		
		Pair<String> p = new Pair<String>(a, b);
		
		assertTrue(p.containedIn("Hello"));
		assertFalse(p.containedIn("WORLD"));
	}
	
}