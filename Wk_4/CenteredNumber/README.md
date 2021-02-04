Centered numbers

In this exercise, we will implement a class whose objects hold and operate on centered numbers, which are integers represented in a particular format.

In this format, a number is represented as a String consisting of 5 characters: ‘t’, ‘n’, ‘z’, ‘N’, and ‘T’; these characters represent the values -2, -1, 0, 1, and 2, respectively. We define a centered number to be a string consisting only of these characters, obeying one rule: ‘z’ can never be the first character of a centered number having strictly more than one character (so, the string “z” is a centered number, although “zT” and “zzT” would not be centered numbers). That is, a centered number may only begin with the character ‘z’ if it is the string “z” itself. This rule is similar to the convention that we do not normally write a 0 at the very front of a decimal number (for example, we usually prefer to write 14 over 014 or 0014 when notating in decimal), unless the number we are writing is 0 itself.

As we will see, the positions of a centered number correspond to powers of 5. To determine the usual decimal value of a centered number, let’s first consider an example. The centered number TnN is equal to 46:

The rightmost character, ‘N’, has the value 1; this is multiplied by 5^0 = 1 to obtain 1.
The second-rightmost character, ‘n’, has the value -1; this is multiplied by 5^1 = 5 to obtain -5.
The third-rightmost character, ‘T’, has the value 2; this is multiplied by 5^2 = 25 to obtain 50.
Then, the contributions of all of these characters is summed, to obtain 2 * (5^2) + -1 * (5^1) + 1 * (5^0) = 50 + -5 + 1 = 46.

In general, each digit is multiplied by a power of 5, and these powers increase from right to left. The rightmost digit is multiplied by 5^0 = 1; the digit to its immediate left, by 5^1 = 5; the next digit, to the left again, by 5^2 = 25; and so on. In the end, all of the resulting products are summed together. (Recall that 5 to the 0th power is 5^0 = 1; 5 to the 1st power is 5^1 = 5; 5 to the 2nd power is 5^2 = 25; and so on.) There is thus some resemblance to base-5 representation, in that each position is weighted by a successive power of 5, and that at each position there are 5 possible symbols that may occur; but now, the symbols’ values are centered around the value zero. A feature of this representation system is that no negative signs are explicitly needed; to negate a number, one needs only swap ‘N’ and ‘n’ at each position, and ‘T’ and ‘t’ at each position; for example, -46 is represented by tNn.

The following table shows the centered number representation for the decimal numbers -12 through 12, inclusive:

  -12: tt
  -11: tn
  -10: tz
   -9: tN
   -8: tT
   -7: nt
   -6: nn
   -5: nz
   -4: nN
   -3: nT
   -2:  t
   -1:  n
    0:  z
    1:  N
    2:  T
    3: Nt
    4: Nn
    5: Nz
    6: NN
    7: NT
    8: Tt
    9: Tn
   10: Tz
   11: TN
   12: TT
In fact, this table shows all of the numbers that can be represented as a centered number with 2 or fewer characters; there are 25 of them, and they are centered around zero.

It holds that each integer has a unique representation as a centered number. While we won’t prove this fact (leaving it as an exercise to the interested reader), let us make some related observations. For the purposes of our discussion, let us define, for any integer b, the value b mod 5 to be the unique integer x among 0, 1, 2, 3, and 4 such that the value 5 can be added to or subtracted from b some number of times to obtain x. Alternatively and equivalently, we can define the value b mod 5 to be the smallest non-negative integer a such that b - a is a multiple of 5 (that is, is evenly divisible by 5). (For positive numbers, the value of b mod 5 can be thought of as the remainder when the number b is divided by 5; this definition is a natural extension which covers negative numbers as well.) The following table shows some example values of integers mod 5 under this definition:

  -12 mod 5 == 3
  -11 mod 5 == 4
  -10 mod 5 == 0
   -9 mod 5 == 1
   -8 mod 5 == 2
   -7 mod 5 == 3
   -6 mod 5 == 4
   -5 mod 5 == 0
   -4 mod 5 == 1
   -3 mod 5 == 2
   -2 mod 5 == 3
   -1 mod 5 == 4
    0 mod 5 == 0
    1 mod 5 == 1
    2 mod 5 == 2
    3 mod 5 == 3
    4 mod 5 == 4
    5 mod 5 == 0
    6 mod 5 == 1
    7 mod 5 == 2
    8 mod 5 == 3
    9 mod 5 == 4
   10 mod 5 == 0
   11 mod 5 == 1
   12 mod 5 == 2
Under this definition of mod 5, adding 5 or subtracting 5 from any integer does not change its value mod 5. In particular, when one has an integer in hand, adding or subtracting 5^i, where i is any power greater than or equal to 1, does not change the integer’s value mod 5. Consequently, the rightmost character of a centered number determines its value mod 5: when the rightmost character is ‘t’, ‘n’, ‘z’, ‘N’, or ‘T’, the value of the number mod 5 is equal to 3, 4, 0, 1, or 2, respectively. (This can be verified directly for the numbers in the given tables.) Conversely, a centered number’s value mod 5 determines the rightmost character in the centered number. These facts generalize: for instance, the two rightmost characters of a centered number determine its value mod 25, and vice-versa.

In this exercise, we will implement methods for a class, each object of which stores a centered number.

You are asked to implement the following methods:

public CenteredNumber( String s ): This is a constructor. When the given String s consists only of the characters ‘t’, ‘n’, ‘z’, ‘N’, and ‘T’:

in the case that the string consists only of ‘z’ characters or is empty, the object should store “z”;
otherwise, all leading ‘z’ characters (i.e., ‘z’ characters at the left of the string) should be removed, and the object should store the resulting centered number.
When the String s does not consist only of the 5 specified characters, the object should also store “z”.

public CenteredNumber( int n ): This is a constructor which should set the object to store the centered number whose value is equal to the given int.

public void negate(): This method should negate the centered number stored by the object.

public void add( CenteredNumber m ): This method should mutate the object on which it is invoked, by adding the given number to it. Note that there is a procedure for adding two centered numbers which first considers the rightmost digits of the numbers, then the second-rightmost digits of the numbers, and so on—just as the classical procedure for adding two ordinary positive decimal numbers does. It is recommended that you implement a procedure that operates in this fashion; your method should run in time proportional to the length of the longer of the two centered numbers that are to be added.

public String toString(): This method should simply return the centered number stored by the object.

As an example, consider the following code fragment:

  CenteredNumber one = new CenteredNumber( 1 );
  CenteredNumber a = new CenteredNumber( "zzzznz" );
  for( int i = -5; i <= 15; i++ )
  {
      System.out.println( "" + i + ": " + a.toString());
      a.add( one );
  }
When executed, the following should be printed:

  -5: nz
  -4: nN
  -3: nT
  -2: t
  -1: n
  0: z
  1: N
  2: T
  3: Nt
  4: Nn
  5: Nz
  6: NN
  7: NT
  8: Tt
  9: Tn
  10: Tz
  11: TN
  12: TT
  13: Ntt
  14: Ntn
  15: Ntz