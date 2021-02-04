Rectangles (Rectangle.java).

In this exercise, you will implement a class Rectangle, an instance of which describes a rectangle in a plane (where each of the corners has each coordinate equal to an integer).

Implement the following methods:

Rectangle( int xLowerLeft, int yLowerLeft, int width, int height ) - This constructor should accept the coordinates of the lower left-hand corner of the rectangle, the width, and the height of the rectangle. (Note that the width corresponds to the x-coordinate, and the height corresponds to the y-coordinate.)

Rectangle( int xUpperRight, int yUpperRight ) - This constructor should accept the coordinates of the upper right-hand corner of the rectangle, and set the lower left-hand corner of the rectangle to be located at the origin, (0,0).

public boolean containsPoint( int x, int y ) - This method should indicate whether or not the rectangle contains the given point.

If the point lies on an edge of the rectangle or is a corner of the rectangle, the rectangle is considered to contain the point. For example, if the lower left-hand corner of a rectangle is at (0,0) and the upper right-hand corner of the rectangle is at (3,3), then the rectangle is considered to contain the points (0,0) and (0,1).

public boolean containsRectangle( Rectangle r ) - This method should indicate whether or not the rectangle contains all points that are contained in the given Rectangle r.

public String toString() - This method should return a String containing the coordinates of the lower left-hand corner of the rectangle (in the format (x,y)), followed by a comma, and then the coordinates of the upper right-hand corner of the rectangle. As an example, on the example rectangle given above, this method should return the String “(0,0),(3,3)”.