import java.io.*;
import java.util.*;

class Card { 
	
	private static HashMap<Integer, String> suits = new HashMap<Integer, String>();
	private static HashMap<Integer, String> values = new HashMap<Integer, String>();
	private int value;
	private int suit;
	
	static {
		suits.put(0, "Clubs");
		suits.put(1, "Diamonds");
		suits.put(2, "Hearts");
		suits.put(3, "Spades");
		
		values.put(1, "Ace");
		values.put(11, "Jack");
		values.put(12, "Queen");
		values.put(13, "King");		
	}
	
	Card (int value, int suit){
		this.value = value;
		this.suit = suit;
	}
	
	String getSuit(){
		return suits.get(suit);
	}
	
	int getNumericValue(){
		return value;
	}
	
	String getValue(){
		if (values.containsKey(value))
			return values.get(value);
		else
			return Integer.toString(value);
	}
	
}

public class Hand
{
	
	private ArrayList<Card> hand;
 
    Hand( String str )
    {
		Scanner in = new Scanner(str);
		ArrayList<Card> hand = new ArrayList<Card>();		
		
		for (int i = 0; i < 5; i++){
			int value = in.nextInt();
			int suit = in.nextInt();
			hand.add(new Card(value, suit));
		}
		
		this.hand = hand;
    }


    public String toString()
    {
		
		StringBuilder buffer = new StringBuilder();
		
		int count = 1;
		
		for (Card card : hand){
			buffer.append(card.getValue());
			buffer.append(" of ");
			buffer.append(card.getSuit());			
			if (count < 5)
				buffer.append(", ");
			count++;
		}
		
        return buffer.toString();
    }


    public String status() // return "straight flush", "straight", "flush", or "none"
    { 
		if (allSameSuit() && straightHand())
			return "straight flush";
		else if (allSameSuit())
			return "flush";
		else if (straightHand())
			return "straight";
		 
		return "none";	
	}
	
	public boolean allSameSuit(){
		
		int loop = 1;
		String lastSuit = "";
		
		for (Card card : hand){
			if ((loop > 1) && (lastSuit != card.getSuit()))
				return false;
			lastSuit = card.getSuit();
			loop++;
		}

		return true;
	}
	
	public boolean straightHand(){
		ArrayList<Integer> valueComparison = new ArrayList<Integer>();
		
		for (Card card : hand){
			valueComparison.add(card.getNumericValue());
		}
		
		Collections.sort(valueComparison);
		
		boolean straight = true;
		
		for (int i = 0; i < valueComparison.size()-1; i++){
			if ((valueComparison.get(i+1) - valueComparison.get(i) != 1) && (valueComparison.get(0) != 1)){
				return false;
			} else if ((valueComparison.get(0) == 1) && (valueComparison.get(1) == 10)){
				if (i == 0)
					i++;
				if (valueComparison.get(i+1) - valueComparison.get(i) != 1)
					return false;
			} else if ((valueComparison.get(0) == 1) && (valueComparison.get(1) == 2)){
				if (valueComparison.get(i+1) - valueComparison.get(i) != 1)
					return false;				
			} else if ((valueComparison.get(0) == 1) && (valueComparison.get(1) != 2))
				return false;
		}
		
		return true;
	}

    public static void main(String[] args) {
        // sample testing code
        Hand h = new Hand( "1 1 2 1 3 1 4 1 5 1" );
        System.out.println( h.toString() );
        System.out.println( h.status() );
    }
    
}

