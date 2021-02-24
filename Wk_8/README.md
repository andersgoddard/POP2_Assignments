Problem to submit
Count words (CountWords.java). Write a program that reads all words in a file (specified as the first argument) and prints out, for each word, the line numbers on which the word occurred. This output should also be written to a second file (specified as the second argument). If the number of provided arguments is not 2 or the specified arguments can’t be opened as files, your program should report this, and not print anything else out.

By the arguments, we refer to the strings in the array String[] args that is passed to the main method.

Some guidelines:

You should use a FileReader wrapped in a BufferedReader to read from the first file.

You should use a FileWriter to write to the second file.

Number the lines of the file starting from 1.

For our purposes here, a word is a consecutive sequence of letters that appear in a line (of a file), such that in the line where the sequence appears, there is no letter before the sequence, and no letter after the sequence. A letter is one of the characters a, b, c, …, z, or one of the characters A, B, C, …, Z.

Words should be considered in a case-insensitive way: two words that differ only in terms of capitalization should be considered the same word.

You should use an instance of HashMap<String,Set<Integer>> to keep track of each word that has been encountered, along with the line numbers where the word has appeared.

Place all of your code in a file called CountWords.java.

Your program should print out the words in sorted order and in lowercase. Please follow the example.

Example input (placed into a file and specified as the first argument):

  Joey ate an apple; then,
  Joey ate two apples.
  Apples were eaten by Joey---in total, 3.
  Hooray for the apple-eater!!!
  
Example output (to be printed to the screen and written to the file specified as the second argument):

  an: line(s) 1
  apple: line(s) 1 4
  apples: line(s) 2 3
  ate: line(s) 1 2
  by: line(s) 3
  eaten: line(s) 3
  eater: line(s) 4
  for: line(s) 4
  hooray: line(s) 4
  in: line(s) 3
  joey: line(s) 1 2 3
  the: line(s) 4
  then: line(s) 1
  total: line(s) 3
  two: line(s) 2
  were: line(s) 3