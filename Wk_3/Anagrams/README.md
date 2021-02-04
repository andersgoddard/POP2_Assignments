Anagrams (Anagrams.java).

Two Strings are anagrams if, for every letter of the alphabet, the letter occurs in each of them with the same frequency (where the frequency is computed in a case-insensitive fashion). As examples, “The cockroach” and “Cook, catch her!” are anagrams; “The Hilton” and “Hint: Hotel” are anagrams. The Strings “A Serenading Marvel” and “Anagrams never lie” are not anagrams; the first contains the letter ‘d’ one time, whereas the second does not contain the letter ‘d’ at all.

Write a method anagrams that, given two Strings, returns the exclamation character (‘!’) if the two given Strings are anagrams, and otherwise, returns the latest letter of the alphabet that does not occur with the same frequency in the two given Strings. This latest letter should be returned in lowercase.

For example, anagrams( “abbey”, “cabbie”) should return the letter ‘y’: the letters ‘c’, ‘i’, and ‘y’ are the letters that do not occur with the same frequency in the two given Strings, and of these letters, ‘y’ is the one that comes latest in the alphabet.