// 13184648
// agodda02@mail.bbk.ac.uk

public class Square extends Rectangle
{
	Square( int xLowerLeft, int yLowerLeft, int sideLength )
	{
		super(xLowerLeft, yLowerLeft, sideLength, sideLength);
	}

	Square( int sideLength )
	{
		super(sideLength, sideLength);
	}
}