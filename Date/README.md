Dates (Date.java).

The following list gives, for a non-leap year, the name of each month (in order) followed by the number of days in the month.

January: 31
February: 28
March: 31
April: 30
May: 31
June: 30
July: 31
August: 31
September: 30
October: 31
November: 30
December: 31
In this exercise, we will implement methods for a class whose objects are intended to represent a day of such a year.

You are to flesh out the skeleton given in the file Date.java.

In the given class, the member variable month is intended to hold a value between 1 and 12 (inclusive), and the member variable day is intended to hold a value between 1 and the number of days in the month represented by month (inclusive).

You are asked to implement the following methods. (You may add further methods to help you, but should otherwise not modify the provided code.)

Date(int d, int m) should be implemented so that when the parameter variables d and m hold a valid day of the year, the member variables day and month are set equal to these parameter variables, respectively; otherwise, day and month should each be set to 1.

void addDays( int n ) should be implemented so that the date represented by the object (on which the method is invoked) is set forward by n many days. You may assume that the value of n is greater than or equal to 0. If the resulting date is not part of the same year, then this method should set both of the instance variables to 1.

public String toString() should be implemented so that it outputs a string in the format dd/mm (that is, with the day before the month) containing the values of the member variables of the object on which it is invoked (respectively).

As an example, the code fragment

Date a = new Date( 1, 1 );
a.addDays( 31 );
System.out.println( a );

Date b = new Date( 30, 11 );
System.out.println( b );
b.addDays( 1 );
System.out.println( b );
b.addDays( 30 );
System.out.println( b );
b.addDays( 5 );
System.out.println( b );
should print out the following:

01/02
30/11
01/12
31/12
01/01