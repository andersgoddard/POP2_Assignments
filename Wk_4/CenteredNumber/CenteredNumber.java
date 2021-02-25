// 13184648
// agodda02@mail.bbk.ac.uk

import java.util.*;

public class CenteredNumber {
	
	private String centeredNumberString;
	private int centeredNumber;
	private static HashMap<Character, Integer> charToNumber = new HashMap<Character, Integer>();
	private static HashMap<Integer, Character> numberToChar = new HashMap<Integer, Character>();
	
	static {
		charToNumber.put('t', -2);
		charToNumber.put('n', -1);
		charToNumber.put('z', 0);
		charToNumber.put('N', 1);
		charToNumber.put('T', 2);
		
		numberToChar.put(-2, 't');
		numberToChar.put(-1, 'n');
		numberToChar.put(0, 'z');
		numberToChar.put(1, 'N');
		numberToChar.put(2, 'T');
	}
	
	public CenteredNumber( String s ){
		if (!isValid(s)){
			this.centeredNumberString = "z";
			this.centeredNumber = 0;
		} else {
			if (s.charAt(0) == 'z') s = removeLeadingZeroes(s);
			this.centeredNumberString = s;
			this.centeredNumber = computeNumber(s);			
		}
	}
	
	public CenteredNumber( int n ){
		this.centeredNumber = n;
		this.centeredNumberString = computeString(n);
	}
	
	public int toInteger(){
		return centeredNumber;
	}
	
	public String toString(){
		return centeredNumberString;
	}
	
	boolean isValid(String centeredNumberString){
		if (centeredNumberString == "") return false;
		
		for (int i = 0; i < centeredNumberString.length(); i++){
			if (!charToNumber.containsKey(centeredNumberString.charAt(i))) return false;
		}
		return true;
	}
	
	private String removeLeadingZeroes(String s){
		StringBuilder buffer = new StringBuilder();
		boolean leadingZero = true;
		
		for (int i = 0; i < s.length(); i++){	
			if (!leadingZero || s.charAt(i) != 'z'){
				buffer.append(s.charAt(i));
				leadingZero = false;
			}
		}
		
		if (buffer.toString().length() == 0) 
			return "z";
		else 	
			return buffer.toString();
	}
	
	public void negate(){
		if (centeredNumber == 0) return;
		
		centeredNumber = 0 - centeredNumber;
		centeredNumberString = negateString(centeredNumberString);
	}
	
	String negateString(String centeredNumberString){
		StringBuilder buffer = new StringBuilder();
		
		for (int i = 0; i < centeredNumberString.length(); i++){
			char letter = centeredNumberString.charAt(i);
			if (Character.isLowerCase(letter) && letter != 'z') buffer.append(Character.toString(letter).toUpperCase());
			else buffer.append(Character.toString(letter).toLowerCase());
		}
		
		return buffer.toString();
	}
	
	public void add( CenteredNumber m ){
		StringBuilder top;
		StringBuilder bottom;
		
		if (m.toString().length() > this.toString().length()){
			top = new StringBuilder(m.toString());
			bottom = new StringBuilder(this.toString());
		} else {
			top = new StringBuilder(this.toString());
			bottom = new StringBuilder(m.toString());			
		}

		top.reverse();
		bottom.reverse();			

		StringBuilder sum = new StringBuilder();	
		int carry = 0;
		
		for (int i = 0; i < top.length(); i++){
			int first = charToNumber.get(top.charAt(i));
			int second;
			if (i < bottom.length()) second = charToNumber.get(bottom.charAt(i));
			else second = 0;
			
			int result = first + second + carry;
			
			if (result > 2){
				carry = 1;
				result -= 5;
			} else if (result < -2){
				carry = -1;
				result += 5;
			} else {
				carry = 0;
			}
			
			sum.append(numberToChar.get(result));
		}
				
		if (carry != 0) sum.append(numberToChar.get(carry));
		sum.reverse();
				
		this.centeredNumberString = removeLeadingZeroes(sum.toString());
	}
	
	private String computeString(int num){
		
		int mod = 0;
		StringBuilder buffer = new StringBuilder();
		boolean isNegative = num < 0;
		
		if (num < 0) num = 0 - num;
		
		while (num > 2){
			mod = num % 5;
			if (mod > 2) mod = mod - 5;
			buffer.append(numberToChar.get(mod));
			num = num / 5;
			if (mod < 0) num += 1;
		}
		
		buffer.append(numberToChar.get(num));
		buffer.reverse();
		
		if (isNegative) return negateString(buffer.toString());
		
		return buffer.toString();
	}
	
	private int computeNumber(String word){
		int power = 0;
		int result = 0;
		
		for (int i = word.length()-1; i >= 0; i--){
			int num = charToNumber.get(word.charAt(i));
			num = num * raisePower(5, power);
			result += num;
			power++;
		}
		
		return result;
	}
	
	int raisePower(int base, int power){
		int result = 1; 
		for (int i = 0; i < power; i++) result *= base; 
		return result;
	}
}
