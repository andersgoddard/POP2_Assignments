// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Replace<T>
{
	public static <T> void replace(ArrayList<T> list, T item, T replacement){
		for (int i = 0; i < list.size(); i++){
			if (item == null){
				if (list.get(i) == null)
					list.set(i, replacement);
			}
			else {
				if (list.get(i) != null && list.get(i).equals(item))
					list.set(i, replacement);
			}
		}
	}
}