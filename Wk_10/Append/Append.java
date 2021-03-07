// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Append<T>
{
	public static <T> void append(ArrayList<T> first, ArrayList<T> second){		
		for (T item : first){
			second.add(item);
		}
	}
}

