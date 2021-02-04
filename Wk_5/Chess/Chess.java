import java.io.*;
import java.util.*;

public class Chess {

	public static abstract class ChessPiece
	{
		private int locX, locY;

		ChessPiece( int x, int y )
		{
			locX = x;
			locY = y;
		}

		int getX()
		{
			return locX;
		}

		int getY()
		{
			return locY;
		}

		abstract boolean canAttack( ChessPiece p );
	}

	public static class King extends ChessPiece
	{
		King( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			ArrayList<Integer> nextX = new ArrayList<Integer>();
			if ((this.getX() - 1) >= 0)
				nextX.add(this.getX() - 1);
			nextX.add(this.getX());
			if ((this.getX() + 1) < 8)
				nextX.add(this.getX() + 1);
			
			ArrayList<Integer> nextY = new ArrayList<Integer>();
			if ((this.getY() - 1) >= 0)
				nextY.add(this.getY() - 1);
			nextY.add(this.getY());
			if ((this.getY() + 1) < 8)
				nextY.add(this.getY() + 1);
			
			return nextX.contains(p.getX()) && nextY.contains(p.getY());
		}
	}

	public static class Bishop extends ChessPiece
	{
		Bishop( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			
			String pos = "(" + p.getX() + ", " + p.getY() + ")";
			ArrayList<String> nextXY = new ArrayList<String>();
			
			int greater = Math.max(this.getX(), this.getY());
			
			for (int i = - 8; i < 8; i++){
				if (((this.getX() + i) >= 0 && (this.getY() + i) >= 0) && ((this.getX() + i) < 8 && (this.getY() + i) < 8))
					nextXY.add("(" + (this.getX() + i) + ", " + (this.getY() + i) + ")");
				if (((this.getX()+1 - i) >= 0 && (this.getY()-1 + i) >= 0) && ((this.getX()+1 - i) < 8 && (this.getY()-1 + i) < 8))
					nextXY.add("(" + (this.getX() - i + 1) + ", " + (this.getY() + i - 1) + ")");	
			}
			
			return nextXY.contains(pos);
		}
	}

	public static class Rook extends ChessPiece
	{
		Rook( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			return (p.getX() == this.getX() && p.getY() >= 0 && p.getY() < 8) || (p.getY() == this.getY() && p.getX() >= 0 && p.getX() < 8);
		}		
	}

	public static class Queen extends ChessPiece
	{
		Queen( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{

			String pos = "(" + p.getX() + ", " + p.getY() + ")";
			ArrayList<String> nextXY = new ArrayList<String>();
			
			int greater = Math.max(this.getX(), this.getY());
						
			for (int i = - 8; i < 8; i++){			
				if (((this.getX() + i) >= 0 && (this.getY() + i) >= 0) && ((this.getX() + i) < 8 && (this.getY() + i) < 8))
					nextXY.add("(" + (this.getX() + i) + ", " + (this.getY() + i) + ")");
				if (((this.getX()+1 - i) >= 0 && (this.getY()-1 + i) >= 0) && ((this.getX()+1 - i) < 8 && (this.getY()-1 + i) < 8))
					nextXY.add("(" + (this.getX() - i + 1) + ", " + (this.getY() + i - 1) + ")");	
			}			
			
			return nextXY.contains(pos) || ((p.getX() == this.getX() && p.getY() >= 0 && p.getY() < 8)) || ((p.getY() == this.getY() && p.getX() >= 0 && p.getX() < 8));
		}
	}

	public static class Knight extends ChessPiece
	{
		Knight( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			String pos = "(" + p.getX() + ", " + p.getY() + ")";
			ArrayList<String> nextXY = new ArrayList<String>();
			if ((this.getX() + 1 < 8) && (this.getY() + 2 < 8))
				nextXY.add("(" + (this.getX() + 1) + ", " + (this.getY() + 2) + ")");
			if ((this.getX() + 2 < 8) && (this.getY() + 1 < 8))			
				nextXY.add("(" + (this.getX() + 2) + ", " + (this.getY() + 1) + ")");
			if ((this.getX() -1 >= 0) && (this.getY() - 2 >= 0))			
				nextXY.add("(" + (this.getX() - 1) + ", " + (this.getY() - 2) + ")");
			if ((this.getX() - 2 >= 0) && (this.getY() - 1 >= 0))			
				nextXY.add("(" + (this.getX() - 2) + ", " + (this.getY() - 1) + ")");
			if ((this.getX() + 1 < 8) && (this.getY() - 2 >= 0))			
				nextXY.add("(" + (this.getX() + 1) + ", " + (this.getY() - 2) + ")");
			if ((this.getX() + 2 < 8) && (this.getY() - 1 >= 0))			
				nextXY.add("(" + (this.getX() + 2) + ", " + (this.getY() - 1) + ")");
			if ((this.getX() - 1 >= 0) && (this.getY() + 2 < 8))			
				nextXY.add("(" + (this.getX() - 1) + ", " + (this.getY() + 2) + ")");
			if ((this.getX() - 2 >= 0) && (this.getY() + 1 < 8))			
				nextXY.add("(" + (this.getX() - 2) + ", " + (this.getY() + 1) + ")");

			return nextXY.contains(pos);
		}		
	}


	public static void main(String[] args) { 

		// sample use of the classes
		ChessPiece a = new King(0,0);
		ChessPiece b = new Queen(1,1);
		System.out.println( a.canAttack(b));

	}
}