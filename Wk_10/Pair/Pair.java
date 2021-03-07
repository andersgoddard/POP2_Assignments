// 13184648
// agodda02@mail.bbk.ac.uk

public class Pair<E>
{
	E a;
	E b;
	
	public Pair(E a, E b){
		this.a = a;
		this.b = b;
	}
	
	public E getFirstElem(){
		return a;
	}
	
	public E getSecondElem(){
		return b;
	}
	
	public boolean containedIn(E elem){
		return (elem.equals(a) || elem.equals(b));
	}
}