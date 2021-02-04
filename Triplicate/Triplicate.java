// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Triplicate {

	public static void triplicate( ArrayList<Integer> list )
	{	
		for (int i = 0; i < list.size(); i += 3){
			int elem = list.get(i);
			list.add(i, elem);
			list.add(i, elem);
		}
	}

    public static void main(String[] args) {

    }
}
