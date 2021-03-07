import junit.framework.TestCase;
import java.io.*;
import java.util.*;

public class AppendTest extends TestCase {
	public void testAppendString(){
		ArrayList<String> one = new ArrayList<String>();
		one.add("Andrew");
		one.add("India");
		one.add("Betts");
		
		ArrayList<String> two = new ArrayList<String>();
		two.add("Hunter");
		two.add("Cliff");
		two.add("Matt");
		
		Append.append(one, two);
		
		ArrayList<String> check = new ArrayList<String>();
		check.add("Hunter");
		check.add("Cliff");
		check.add("Matt");
		check.add("Andrew");
		check.add("India");
		check.add("Betts");
		
		assertEquals(two, check);
	}
	
	public void testAppendInteger(){
		ArrayList<Integer> one = new ArrayList<Integer>();
		for (int i = 6; i <= 10; i++){
			one.add(i);
		}		
		
		ArrayList<Integer> two = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++){
			two.add(i);
		}
		
		Append.append(one, two);
		
		ArrayList<Integer> check = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++){
			check.add(i);
		}
		
		assertEquals(two, check);
	}
}
