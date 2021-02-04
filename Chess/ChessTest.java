import junit.framework.TestCase;

public class ChessTest extends TestCase {
	
	public void testKing(){
		Chess.King king = new Chess.King(1, 1);
		
		Chess.Queen queen = new Chess.Queen(2, 1);
		assertTrue(king.canAttack(queen));
		
		Chess.Bishop bishop = new Chess.Bishop(4, 4);
		assertFalse(king.canAttack(bishop));
		
		assertTrue(queen.canAttack(king));
		assertFalse(queen.canAttack(bishop));
	}	
	
	public void testKnight(){
		Chess.Knight knight = new Chess.Knight(3, 3);
		
		Chess.Queen queen = new Chess.Queen(5, 4);
		assertTrue(knight.canAttack(queen));
		assertFalse(queen.canAttack(knight));
		
		queen = new Chess.Queen(2, 1);
		assertTrue(knight.canAttack(queen));
		
		queen = new Chess.Queen(6, 4);
		assertFalse(knight.canAttack(queen));
		assertFalse(queen.canAttack(knight));
	}
	
	public void testRook(){
		Chess.Rook rook = new Chess.Rook(2, 2);
		
		Chess.Queen queen = new Chess.Queen(7, 2);
		assertTrue(rook.canAttack(queen));
		// assertTrue(queen.canAttack(rook));
		
		queen = new Chess.Queen(2, 5);
		assertTrue(rook.canAttack(queen));
		// assertTrue(queen.canAttack(rook));
		
		queen = new Chess.Queen(6, 6);
		assertFalse(rook.canAttack(queen));
		assertTrue(queen.canAttack(rook));
	}
	
	public void testBishop(){
		Chess.Bishop bishop = new Chess.Bishop(2, 3);
		
		Chess.Queen queen = new Chess.Queen(5, 6);
		assertTrue(bishop.canAttack(queen));
		assertTrue(queen.canAttack(bishop));
		
		queen = new Chess.Queen(1, 4);
		assertTrue(bishop.canAttack(queen));
		assertTrue(queen.canAttack(bishop));
	}
}