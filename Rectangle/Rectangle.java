// 13184648
// agodda02@mail.bbk.ac.uk

public class Rectangle {
	
	private int xLowerLeft;
	private int yLowerLeft;
	private int xUpperRight;
	private int yUpperRight;
	private int xLowerRight;
	private int yLowerRight;
	private int xUpperLeft;
	private int yUpperLeft;	

    Rectangle( int xLowerLeft, int yLowerLeft, int width, int height )
    {
	   this.xLowerLeft = xLowerLeft;				// 1
	   this.yLowerLeft = yLowerLeft;				// 2
	   this.xUpperRight = xLowerLeft + width;		// 5
	   this.yUpperRight = yLowerLeft + height;		// 7
	   this.xUpperLeft = xLowerLeft;				// 1
	   this.yUpperLeft = yUpperRight;				// 7
	   this.xLowerRight = xUpperRight;				// 5
	   this.yLowerRight = yLowerLeft;				// 2
    }

    Rectangle( int xUpperRight, int yUpperRight )
    {
		this.xLowerLeft = 0;
		this.yLowerLeft = 0;
		this.xUpperRight = xUpperRight;
		this.yUpperRight = yUpperRight;          
    }
	
	public int getXLowerLeft(){
		return xLowerLeft;
	}
	
	public int getYLowerLeft(){
		return yLowerLeft;
	}
	
	public int getXUpperRight(){
		return xUpperRight;
	}
	
	public int getYUpperRight(){
		return yUpperRight;
	}
	
	public int getXLowerRight(){
		return xLowerRight;
	}
	
	public int getYLowerRight(){
		return yLowerRight;
	}
	
	public int getXUpperLeft(){
		return xUpperLeft;
	}
	
	public int getYUpperLeft(){
		return yUpperLeft;
	}

    public boolean containsPoint( int x, int y )
    {
		
		return (x >= this.getXLowerLeft() && x <= this.getXLowerRight() && y >= this.getYLowerLeft() && y <= this.getYUpperLeft());
    }

    public boolean containsRectangle( Rectangle r )
    {
        return (this.getXLowerLeft() <= r.getXLowerLeft() && this.getXUpperRight() >= r.getXUpperRight() && this.getYLowerLeft() <= r.getYLowerLeft() && this.getYUpperRight() >= r.getYUpperRight());
    }

    public String toString()
    {
        return "(" + xLowerLeft + "," + yLowerLeft + "), (" + xUpperRight + "," + yUpperRight + ")";
    }
	
    public static void main(String[] args) 
    {
        
    }
}