// your_ID_here
// your_email_address_here

import junit.framework.TestCase;
import java.io.*;
import java.util.*;

public class TopTest extends TestCase {
	
	public void testCreate1(){
		Top t = new Top();
		ArrayList<String> testTopThree = new ArrayList<String>();			
		
		t.push("b");
		testTopThree.add("b");
		assertEquals(testTopThree, t.getTopThree());
		
		t.push("a");
		testTopThree.add(0, "a");
		assertEquals(testTopThree, t.getTopThree());
		
		t.push("c");
		testTopThree.add(2, "c");
		assertEquals(testTopThree, t.getTopThree());
		
		t.push("abba");
		testTopThree.add(1, "abba");
		testTopThree.remove(3);
		assertEquals(testTopThree, t.getTopThree());	

		t.reset();
		t.push("Jules");
		t.push("Jim");
		
		testTopThree.clear();
		testTopThree.add("Jim");
		testTopThree.add("Jules");
		
		assertEquals(testTopThree, t.getTopThree());
		
		for (char ch = 'I'; ch <= 'Z'; ch++){
			t.push("" + ch);
		}
		
		testTopThree.clear();
		testTopThree.add("I");
		testTopThree.add("J");
		testTopThree.add("Jim");
		
		assertEquals(testTopThree, t.getTopThree());
		
	}

}
