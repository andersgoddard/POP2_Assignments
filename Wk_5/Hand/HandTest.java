import junit.framework.TestCase;

public class HandTest extends TestCase {
	
	public void testCreate(){
		Hand h = new Hand( "1 1 2 1 3 1 4 1 5 1" );	
		assertEquals("Ace of Diamonds, 2 of Diamonds, 3 of Diamonds, 4 of Diamonds, 5 of Diamonds", h.toString());
	}
	
	public void testSameSuit(){
		Hand h = new Hand( "1 1 2 1 3 1 4 1 5 1" );	
		assertTrue(h.allSameSuit());		
	}

	public void testStraight(){
		Hand h = new Hand( "1 1 2 2 3 3 4 0 5 1" );	
		assertEquals("straight", h.status());		
	}

	public void testStraightFlush(){
		Hand h = new Hand( "1 1 2 1 3 1 4 1 5 1" );	
		assertEquals("straight flush", h.status());		
	}
	
	public void testFlush(){
		Hand h = new Hand( "3 1 4 1 9 1 11 1 2 1" );	
		assertEquals("flush", h.status());		
	}
	
	public void testNone(){
		Hand h = new Hand( "3 1 1 2 9 1 11 1 2 1" );	
		assertEquals("none", h.status());
	}

}