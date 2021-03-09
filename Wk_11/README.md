Problem set 5

Problem (CustomStringSort.java).

In this problem, starting from the code in the named .java file, you will write lambda expressions that allow for the comparison of pairs of Strings, and then use them to create customized methods for sorting ArrayLists of Strings. In particular, you will work with the following interface:

  interface PredicateStringPair
  {
      boolean better( String a, String b );
  }
In this problem, we will make use of interface Comparator<T> and one of the static methods Collections.sort; both of these are provided by Java, and you are asked to look at the Java API documentation for more information on these.

You are to implement the following methods, as described.

Write a method
createComparator( PredicateStringPair pred )
that returns an instance of Comparator<String>. The returned instance of Comparator<String> should receive two strings, which we’ll call a and b, and return: a negative value when the better method of pred returns true on the pair a, b; a positive value when better returns true on the pair b, a; and, 0 otherwise. (We will only create instances of PredicateStringPair whose better method never returns true both on a pair a, b of Strings and on its transposition b, a.)

Write a method
sortStrings( ArrayList<String> lst, PredicateStringPair pred )
that calls createComparator on pred to obtain an instance of Comparator<String>, and then calls the built-in method Collections.sort, passing it both lst and the obtained instance of Comparator<String>.

Write a method
sortStringsLonger( ArrayList<String> lst )
that does the following. First, using a lambda expression, it defines an instance of PredicateStringPair whose method returns true on a pair of Strings a, b if and only if the length of a is strictly greater than the length of b. Then, it calls sortStrings on lst and the created instance of PredicateStringPair.

Write a method
sortStringsNumAs( ArrayList<String> lst )
that does the following. First, using a lambda expression, it defines an instance of PredicateStringPair whose method returns true on a pair of Strings s1, s2 if and only if the number of occurrences of the letter a (in either upper or lower case) in s1 is strictly greater than the number of such occurrences in s2. Then, it calls sortStrings on lst and the created instance of PredicateStringPair.

Write a method
sortStringsDictionary( ArrayList<String> lst )
that does the following. First, using a lambda expression, it defines an instance of PredicateStringPair whose method returns true on a pair of Strings s1, s2 if and only if s1 comes before s2 according to dictionary ordering. Then, it calls sortStrings on lst and the created instance of PredicateStringPair.

Here, we define dictionary ordering as follows. To determine if s1 comes before s2, scan them character-by-character from left-to-right, seeing if a mismatch is found, that is, seeing if one can find an index such that s1 and s2 differ at that index.

When no such mismatch can be found, then s1 is considered to come before s2 if and only if the length of s1 is strictly less than the length of s2.

When a mismatch is found, consider the first index (starting from the left) where the two strings differ. If at that index s1 contains a letter of the alphabet and s2 does not, then s1 comes before s2; analogously, if at that index s2 contains a letter of the alphabet and s1 does not, then s1 does not come before s2. If both s1 and s2 contain letters of the alphabet at that index, then use the ordering 'a' < 'A' < 'b' < 'B' < 'c' < 'C' < ..., that is, use normal alphabetical ordering, with the convention that a lowercase letter comes before its uppercase version. Finally, if neither s1 nor s2 contains a letter of the alphabet at that index, then use the normal ordering < defined by Java on char values.

As examples of dictionary ordering: abs comes before absolutely; absolutely does not come before abs, and abs does not come before abs. The word aardvark comes before abs, but abs comes before Aardvark. The following list is such that each word comes (in dictionary ordering) before any other word if and only if the first word appears above the second word.

  banana
  bananas
  Banana
  kiwis
  Kiwi
  strawberries
  Strawberry
  3 oranges
  33 oranges
  9 oranges
  @kumquat
  @plum       