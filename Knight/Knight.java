// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Knight {
	
	public static ArrayList<String> getRockPositions(int[] xrock, int[] yrock){
		
		ArrayList<String> rockPositions = new ArrayList<String>();
		
		for (int i = 0; i < xrock.length; i++){
			rockPositions.add("(" + xrock[i] + ", " + yrock[i] + ")");
		}
		
		return rockPositions;

	}
	
	public static HashMap<String, ArrayList<String>> buildBoard(int dim, ArrayList<String> rockPositions)
	{
		
		HashMap<String, ArrayList<String>> board = new HashMap<String, ArrayList<String>>();
		
		for (int i = 0; i < dim; i++){
			for (int j = 0; j < dim; j++){
				String key = "(" + i + ", " + j + ")";
				
				if (!rockPositions.contains(key)){
					
					ArrayList<String> nodes = new ArrayList<String>();
					
					if ((i + 2 < dim) && (j + 1 < dim)){
						String position = "(" + (i+2) + ", " + (j+1) + ")";
						if (!rockPositions.contains(position))
							nodes.add(position);
					}
					if ((i + 2 < dim) && (j - 1 >= 0)){
						String position = "(" + (i+2) + ", " + (j-1) + ")";
						if (!rockPositions.contains(position))
							nodes.add(position);
					}
					if ((i - 2 >= 0) && (j + 1 < dim)){
						String position = "(" + (i-2) + ", " + (j+1) + ")";
						if (!rockPositions.contains(position))
							nodes.add(position);
					}					
					if ((i - 2 >= 0) && (j - 1 >= 0)){
						String position = "(" + (i-2) + ", " + (j-1) + ")";
						if (!rockPositions.contains(position))
							nodes.add(position);
					}
					if ((i + 1 < dim) && (j + 2 < dim)){
						String position = "(" + (i+1) + ", " + (j+2) + ")";
						if (!rockPositions.contains(position))
							nodes.add(position);
					}
					if ((i + 1 < dim) && (j - 2 >= 0)){
						String position = "(" + (i+1) + ", " + (j-2) + ")";
						if (!rockPositions.contains(position))
							nodes.add(position);
					}
					if ((i - 1 >= 0) && (j + 2 < dim)){
						String position = "(" + (i-1) + ", " + (j+2) + ")";
						if (!rockPositions.contains(position))
							nodes.add(position);
					}
					if ((i - 1 >= 0) && (j - 2 >= 0)){
						String position = "(" + (i-1) + ", " + (j-2) + ")";
						if (!rockPositions.contains(position))
							nodes.add(position);
					}
					
					board.put(key, nodes);
					
				}
			}
		}
		
		return board;
		
	}
	
	public static ArrayList<String> getNextPositions(HashMap<String, ArrayList<String>> board, String position, ArrayList<String> visited){

		ArrayList<String> nextPositions = new ArrayList<String>();
		for (String pos : board.get(position)){
			if (!visited.contains(pos))
				nextPositions.add(pos);
		}
		
		return nextPositions;

	}


    public static int numMoves( int dim, int xstart, int ystart, int xtarget, int ytarget, int[] xrock, int[] yrock )
    {
		
		String startingPosition = "(" + xstart + ", " + ystart + ")";
		String targetPosition = "(" + xtarget + ", " + ytarget + ")";
		ArrayList<String> rockPositions = getRockPositions(xrock, yrock);
		
		if (rockPositions.contains(startingPosition))
			return -1;
		
		HashMap<String, ArrayList<String>> board = buildBoard(dim, rockPositions);
		
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> toVisit = new ArrayList<String>();
		
		toVisit.add(startingPosition);
		int moves = 0;
		
		while (!toVisit.contains(targetPosition)){
			
			ArrayList<String> nextPositions = new ArrayList<String>();
			
			for (String position : toVisit){
				if (!visited.contains(position)){
					visited.add(position);
					nextPositions.addAll(getNextPositions(board, position, visited));
				}
			}
			
			toVisit.clear();
			
			for (String position : nextPositions)
				toVisit.add(position);
		
			
			if (toVisit.size() == 0)
				return -1;
			
			moves++;

		}

		return moves;
    }

    public static void main( String[] args )
    {
 

    }

}




