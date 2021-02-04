Add one second (AddSecond.java).

Write a method addSecond that, given three ints h, m, and s representing the hours, minutes, and seconds of a clock time in 24-hour format, returns a String containing the given clock time plus one second. You can assume that the given ints obey 0 <= h < 24, 0 <= m < 60, and 0 <= s < 60. Your method should always return a clock time in hours:minutes:seconds format where the hours, minutes, and seconds obey the constraints given in the previous sentence, and where each of these three components is represented using exactly two digits.

For example, upon being given (19,45,59), the method should return the String “19:46:00”.