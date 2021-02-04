Knight’s tour (Knight.java).

In this exercise, you are to write a method that, given a chessboard with one knight, rocks on some of the squares, and a target position, indicates whether or not the knight can reach the target without landing on any rocks, and if so, the smallest number of moves needed by the knight to reach the target. (No prior knowledge of chess is required to solve this exercise.)

You are to implement a method with the following header:

public static int numMoves( int dim, int xstart, int ystart, 
        int xtarget, int ytarget, int[] xrock, int[] yrock )

Here,

dim is the dimension of the chessboard, and will be between 1 and 20 (inclusive). The squares of the chessboard are denoted by their positions; each position is a pair (x,y) where 0 <= x < dim, and 0 <= y < dim.
The knight’s initial position is (xstart, ystart). It can be assumed that this pair is a valid position.
The target position is (xtarget, ytarget).
The positions of the rocks are given by the arrays xrock and yrock; these arrays will have the same length L, and the rock positions are the pairs (xrock[i], yrock[i]) where i varies from 0 to L-1 (inclusive).
It can be assumed that each pair given, in each of the last 3 bullet points, is a valid position.

In one move, a knight may go from its position to a position obtained by traversing two squares in either a vertical or horizontal direction, and then one square in a perpendicular direction. For example, in an 8-by-8 chessboard (that is, where dim is equal to 8), a knight at position (1,1), in one move, could move to any of the following positions: (0,3), (2,3), (3,2), (3,0). A knight at position (1,2), in one move, could move to any of the following positions: (0,0), (0,4), (2,0), (2,4), (3,1), (3,3). See below for diagrams depicting these examples. (Note that if a knight is, for example, at position (1,1), what determines whether or not it can move to position (0,3) is the absence/presence of rocks on the positions (1,1) and (0,3), and not whether there are rocks on any intermediate positions.)

If it is possible for the knight to reach the target from its initial position without using or entering any position having a rock, via some sequence of moves, the method should return the minimum number of moves needed to do so; otherwise, the method should return the value -1. (If the initial position has a rock on it, the method should return -1; likewise, if the target position has a rock on it, the method should return -1.)