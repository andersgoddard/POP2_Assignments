// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class CountWords {

    public static void main(String[] args) {
	  String readFile;
	  String writeFile;
  	  HashMap<String,Set<Integer>> wordCountMap = new HashMap<String,Set<Integer>>();
	  
	  try {
		  readFile = args[0];
		  writeFile = args[1];
	  } catch (ArrayIndexOutOfBoundsException e) {
		  System.out.println("Two filenames are required");
		  return;
	  }
	  
	  fillMapFromFile(wordCountMap, readFile);
	  Map<String,Set<Integer>> wordCountTreeMap = new TreeMap<String,Set<Integer>>(wordCountMap);
	  writeMapToFileAndPrint(wordCountTreeMap, writeFile);
	}
	
	static void fillMapFromFile(HashMap<String,Set<Integer>> wordCountMap, String readFile){
		try (BufferedReader br = new BufferedReader(new FileReader(readFile))){
		  String s;
		  String alphabet = "abcdefghijklmnopqrstuvwxyz";
  		  int line = 1;
		  while (( s = br.readLine()) != null){
			  s = s.toLowerCase();
			  StringBuilder buffer = new StringBuilder();
			  for (int i = 0; i < s.length(); i++){
				  char character = s.charAt(i);
				  if (alphabet.indexOf(character) != -1){
					  buffer.append(character);
				  } else {
					  String key = buffer.toString();
					  int value = line;						  
					  if (key.length() > 0){					  
						  if (wordCountMap.containsKey(key)){
							  wordCountMap.get(key).add(line);
						  } else {
							  Set<Integer> values = new TreeSet<Integer>();
							  values.add(value);
							  wordCountMap.put(key, values); 
						  }
					  }
					  buffer = new StringBuilder();
				  }
			  }
			  line++;
		  }
	  }
	  catch (IOException e)
	  {
		  System.out.println("I/O Error: " + e);
	  }		
	}
	
	static void writeMapToFileAndPrint(Map<String,Set<Integer>> wordCountTreeMap, String writeFile){
		try (FileWriter fw = new FileWriter(writeFile)){
		  StringBuilder buffer;
		  int count = 1;
		  for (Map.Entry<String, Set<Integer>> entry : wordCountTreeMap.entrySet()){
			  buffer = new StringBuilder();
			  buffer.append(entry.getKey());
			  buffer.append(": line(s)");
			  for (int result : entry.getValue()){
				  buffer.append(" " + result);
			  }
			  fw.write(buffer.toString());	
			  System.out.println(buffer.toString());
			  if (count != wordCountTreeMap.size()) fw.write("\n");
			  count++;
		  }
	  } catch (IOException e) {
		  System.out.println("I/O Error: " + e);
	  }
    }
}