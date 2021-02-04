// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Roman {

    public static String convert( int num ) {
		
		String romanNumeral = "";
		
		if (num < 4) {
			for (int i = 0; i < num; i++){
				romanNumeral += 'I';
			}
		} else if (num == 4) {
			romanNumeral = "IV";
		} else if (num < 9) {
			romanNumeral = 'V' + convert(num - 5);
		} else if (num == 9) {
			romanNumeral = "IX";
		} else if (num < 40) {
			romanNumeral = 'X' + convert(num - 10);
		} else if (num < 50) {
			romanNumeral = "XL" + convert(num - 40);
		} else if (num < 90) {
			romanNumeral = 'L' + convert(num - 50);
		} else if (num < 100) {
			romanNumeral = "XC" + convert(num - 90);
		} else if (num < 400) {
			romanNumeral = 'C' + convert(num - 100);
		} else if (num < 500) {
			romanNumeral = "CD" + convert(num - 400);
		} else if (num < 900) {
			romanNumeral = 'D' + convert(num - 500);
		} else if (num < 1000) {
			romanNumeral = "CM" + convert(num - 900);
		} else {
			romanNumeral = 'M' + convert(num - 1000);
		}
		
        return romanNumeral;
    }

    public static void main(String[] args) {
 
    }

}