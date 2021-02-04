import junit.framework.TestCase;

public class RectangleTest extends TestCase {
	
	public void testCreateFirstConstructor(){
		Rectangle r = new Rectangle(1, 2, 4, 5);
		assertEquals(1, r.getXLowerLeft());
		assertEquals(2, r.getYLowerLeft());
		assertEquals(5, r.getXUpperRight());
		assertEquals(7, r.getYUpperRight());
		assertEquals(5, r.getXLowerRight());
		assertEquals(2, r.getYLowerRight());
		assertEquals(1, r.getXUpperLeft());
		assertEquals(7, r.getYUpperLeft());		
	}
	
	public void testCreateSecondConstructor(){
		Rectangle r = new Rectangle(4, 5);
		assertEquals(0, r.getXLowerLeft());
		assertEquals(0, r.getYLowerLeft());
		assertEquals(4, r.getXUpperRight());
		assertEquals(5, r.getYUpperRight());
	}
	
	public void testContainsPoint(){
		Rectangle r = new Rectangle(1, 2, 4, 5);
		assertTrue(r.containsPoint(1, 2));
		assertTrue(r.containsPoint(5, 7));
		assertTrue(r.containsPoint(5, 5));
		assertTrue(r.containsPoint(3, 7));
		assertFalse(r.containsPoint(0, 0));
		assertTrue(r.containsPoint(2, 6));
		assertTrue(r.containsPoint(3, 4));
	}
	
	public void testContainsRectangle(){
		Rectangle r1 = new Rectangle(1, 2, 7, 8);
		Rectangle r2 = new Rectangle(2, 3, 2, 2);
		assertTrue(r1.containsRectangle(r2));
	}
	
	public void testToString(){
		Rectangle r = new Rectangle(1, 2, 4, 5);
		assertEquals("(1,2), (5,7)", r.toString());
	}
	
}