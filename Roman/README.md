Roman numerals (Roman.java).

Write a method convert that, given a number, returns the equivalent Roman number as a String.

Remember that Roman numbers make use seven uppercase letters, which have the following values:

I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000
These are the rules by which Roman numbers are formed:

Each decimal digit is treated independently.
Units (1, 2, …, 9) are represented, respectively, as: I, II, III, IV, V, VI, VII, VIII, IX. Nothing is written for 0.
Tens (10, 20, …, 90) are written as units are, but replacing I by X, V by L, and X by C.
Hundreds (100, 200, …, 900) are written as units are, but repacing I by C, V by D, and X by M.
Thousands (1000, 2000, and 3000) are written as units are, but repacing I by M.
You may assume that the int passed to the method convert is an integer between 1 and 3999, inclusive. (There was no zero in the Roman numeral system, and the system described above cannot represent numbers greater than or equal to 4000.)

As examples, convert( 314 ) should return the String “CCCXIV”, and convert( 3490 ) should return the String “MMMCDXC”.