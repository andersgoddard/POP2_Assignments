import java.io.*;
import java.util.*;

public class Remove { 

	public static void remove( ArrayList<String> lst )
	{
		
		int i;
		int target = 0;
		
		for (i = 0; i < lst.size(); i++){
			lst.remove(target);
			target++;
		}		
	}

    public static void main( String[] args ) 
    { 
 
    }
}
