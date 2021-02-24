import junit.framework.TestCase;
import java.io.*;
import java.util.*;

public class BoundedQueueTest extends TestCase {
	
	public void testCreate(){
		BoundedQueue bq = new BoundedQueue(6);		
		assertEquals(6, bq.getMaxSize());
		BoundedQueue bq2 = new BoundedQueue(10);
		assertEquals(10, bq2.getMaxSize());			
		assertTrue(bq.getQueue() instanceof ArrayList);
	}
	
	public void testPush(){
		BoundedQueue bq = new BoundedQueue(6);
		bq.push("a");
		assertEquals("a", bq.getQueue().get(0));
	}
	
	public void testPop(){
		BoundedQueue bq = new BoundedQueue(2);
		bq.push("a");
		bq.push("b");
		bq.push("c");
		bq.pop();
		assertEquals("b", bq.getQueue().get(0));
		bq.pop();
		assertEquals("c", bq.getQueue().get(0));		
	}
	
	public void testIsEmpty(){
		BoundedQueue bq = new BoundedQueue(6);
		bq.push("a");
		bq.pop();
		assertTrue(bq.getQueue().isEmpty());
	}
	
}
