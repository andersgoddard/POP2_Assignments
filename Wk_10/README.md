Problem set 4

Problem (Pair.java). In a file called Pair.java, implement a class Pair<E> that stores an ordered pair of elements of type E. 
Provide accessors that return the first and second elements. Also provide a method containedIn that, given an element of type E, 
returns true or false depending on whether or not the given element is equal to one contained in the pair, where equality is determined 
using the method equals() (see the API documentation for information on this method, for example, here). (It is suggested that you test 
your class using Strings and any other classes that you would like.)

Problem (Append.java). In a file called Append.java, implement a generic method append that receives two ArrayLists, and appends all elements 
from the first array list (holding elements of some type E) to the second (holding elements of the same type E).

Problem (Replace.java). In a file called Replace.java, write a generic method replace, using a generic type parameter <T>, that replaces every 
element in an ArrayList<T> that is equal to a specified item, with a specified replacement item. The method should have three parameters: the 
list and the two items; each of the items should be of type T.
Take into account the fact that the item that is being replaced might be null (and that equals() cannot be invoked on null). For a non-null item, use the equals() method to perform comparison.