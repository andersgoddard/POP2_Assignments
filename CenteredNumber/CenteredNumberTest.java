import junit.framework.TestCase;

public class CenteredNumberTest extends TestCase {
	
	public void testCreateWithNumbers(){
		CenteredNumber number1 = new CenteredNumber(0);
		assertEquals("z", number1.toString());		

		CenteredNumber number2 = new CenteredNumber(1);
		assertEquals("N", number2.toString());

		CenteredNumber number3 = new CenteredNumber(2);
		assertEquals("T", number3.toString());	

		CenteredNumber number4 = new CenteredNumber(-5);
		assertEquals("nz", number4.toString());
	}
	
	public void testCreateWithString(){
		CenteredNumber number1 = new CenteredNumber("z");
		assertEquals(0, number1.toInteger());		
		
		CenteredNumber number2 = new CenteredNumber("T");
		assertEquals(2, number2.toInteger());				
	}
	
	public void testComplexNumbersFromStrings(){
		CenteredNumber number1 = new CenteredNumber("TnN");
		assertEquals(46, number1.toInteger());

		CenteredNumber number2 = new CenteredNumber("tt");
		assertEquals(-12, number2.toInteger());				
	}
	
	public void testComplexNumbersFromInts(){
		CenteredNumber number1 = new CenteredNumber(46);
		assertEquals("TnN", number1.toString());
		
		CenteredNumber number2 = new CenteredNumber(9);
		assertEquals("Tn", number2.toString());
		
		CenteredNumber number3 = new CenteredNumber(-46);
		assertEquals("tNn", number3.toString());
		
		CenteredNumber number4 = new CenteredNumber(13);
		assertEquals("Ntt", number4.toString());		
	}
	
	public void testInvalidEntry(){
		CenteredNumber number1 = new CenteredNumber("A");
		assertEquals("z", number1.toString());

		CenteredNumber number2 = new CenteredNumber("");
		assertEquals("z", number2.toString());
		
		CenteredNumber number3 = new CenteredNumber("zzzzT");
		assertEquals("T", number3.toString());		
		
		CenteredNumber number4 = new CenteredNumber("Tzzzz");
		assertEquals("Tzzzz", number4.toString());				
	}
	
	public void testNegate(){
		CenteredNumber number1 = new CenteredNumber(1);
		assertEquals("N", number1.toString());
		number1.negate();
		assertEquals("n", number1.toString());		
		
		CenteredNumber number2 = new CenteredNumber("tN");
		number2.negate();
		assertEquals("Tn", number2.toString());		
		
		CenteredNumber number3 = new CenteredNumber(0);
		number3.negate();
		assertEquals("z", number3.toString());				
	}
	
	public void testAdd(){
		CenteredNumber number1 = new CenteredNumber(1);
		CenteredNumber number2 = new CenteredNumber(2);
		number1.add(number2);
		assertEquals("Nt", number1.toString());
		
		CenteredNumber number3 = new CenteredNumber(5);
		number2.add(number3);
		assertEquals("NT", number2.toString());
		
		CenteredNumber number4 = new CenteredNumber(8);
		number4.add(number3);
		assertEquals("Ntt", number4.toString());
		
		CenteredNumber number5 = new CenteredNumber(-5);
		CenteredNumber number6 = new CenteredNumber(3);
		number5.add(number6);
		assertEquals("t", number5.toString());
		
		CenteredNumber number7 = new CenteredNumber(13);
		CenteredNumber number8 = new CenteredNumber(1);
		number7.add(number8);
		assertEquals("Ntn", number7.toString());
		
		CenteredNumber number9 = new CenteredNumber(-3);
		CenteredNumber number10 = new CenteredNumber(1);
		assertEquals("nT", number9.toString());
		assertEquals("N", number10.toString());
		number9.add(number10);
		assertEquals("t", number9.toString());
		
		CenteredNumber number11 = new CenteredNumber(2);
		CenteredNumber number12 = new CenteredNumber(2);
		number11.add(number12);
		assertEquals("Nn", number11.toString());
		
		CenteredNumber number13 = new CenteredNumber(7);
		CenteredNumber number14 = new CenteredNumber(2);
		number13.add(number14);
		assertEquals("Tn", number13.toString());
	}
	
	public void testAddingToSameNumber(){
		CenteredNumber num = new CenteredNumber("zzzznz");
		assertEquals("nz", num.toString());
		CenteredNumber one = new CenteredNumber(1);
		num.add(one);
		assertEquals("nN", num.toString());
		num.add(one);
		assertEquals("nT", num.toString());		
		num.add(one);
		assertEquals("t", num.toString());		
		num.add(one);
		assertEquals("n", num.toString());
		num.add(one);
		assertEquals("z", num.toString());		
	}
}
