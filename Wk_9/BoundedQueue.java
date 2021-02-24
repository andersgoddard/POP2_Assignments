// 13184648
// agodda02@mail.bbk.ac.uk

import java.io.*;
import java.util.*;

public class BoundedQueue {
	
	private int maxsize;
	private ArrayList<String> queue;

    public BoundedQueue( int maxsize )
    {
		this.maxsize = maxsize;
		this.queue = new ArrayList<String>(maxsize);
    }
	
	int getMaxSize(){
		return maxsize;
	}
	
	ArrayList<String> getQueue(){
		return queue;
	}
    
    synchronized void push( String s )
    {
		
        try
        {
            while(queue.size() == maxsize) {
                wait();
            }
        }
        catch( InterruptedException exc )
        {
            System.out.println( "Thread interrupted." );
        }

		queue.add(s);
		System.out.println("Pushed: " + s + " / " + queue.size());
		notifyAll();
		return;
    }

    synchronized String pop()
    {

        try
        {
            while(queue.isEmpty()) {
                wait();
            }
        }
        catch( InterruptedException exc )
        {
            System.out.println( "Thread interrupted." );
        }
		
		String toRemove = queue.get(0);
		queue.remove(0);
		System.out.println("Popped: " + toRemove + " / " + queue.size());
		notifyAll();
		return toRemove;
    }
}
