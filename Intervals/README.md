Intersecting intervals (Intervals.java).

When a and b are integers, the notation [a,b] is used to denote the set of all integers x such that a <= x and x <= b (that is, such that a is less than or equal to x, and x is less than or equal to b). A set of this form is called an interval.

The intersection of any two given intervals (that is, the set of integers that fall into both of the intervals) is always an interval. Write a method intersect that, given four ints a1, b1, a2, and b2, returns a String, as follows:

If the intersection of the intervals [a1,b1] and [a2,b2] is non-empty (that is, if this intersection contains one or more integers), the returned String should hold a value presenting this intersection using the introduced notation.
If this intersection is empty, the returned String should be “[]”.
For example, upon being given (1,3,2,4), the method should return the String “[2,3]”: this is because [2,3] is the intersection of [1,3] and [2,4].