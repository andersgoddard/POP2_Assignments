// 13184648
// agodda02@mail.bbk.ac.uk

// Response to Q1:
// Passing 15 into the constructor for Popper results in one less iteration overall.
// Essentially, pushing 16 items into the queue but only popping 15 out results in 31 outputs to the console.

// Response to Q2:
// Passing 17 into the constructor for Popper has the result of printing 32 outputs to the console and then hanging in an infinite loop.
// This is because the pop method of the BoundedQueue class remains in the while loop waiting for a 17th item to be pushed into the queue.

// Response to Q3:
// Commenting the notifyAll() call in the push method means that, when the pop method is called on an empty queue, it waits in the while loop 
// for the push method to add an item but, because the push method doesn't notify it that there are more items, it can never break out of the while loop.


class Pusher implements Runnable
{
	
	BoundedQueue q;
	String name;
	int iterations;
	
	
    Pusher( BoundedQueue q, String name, int iterations )
    {
		this.q = q;
		this.name = name;
		this.iterations = iterations;
    }
	
    public void run()
    {
		for (int i = 1; i <= iterations; i++){
			q.push(i + " " + name);
		}
    }
	
}

class Popper implements Runnable
{
	
	BoundedQueue q;
	int iterations;
	
    Popper( BoundedQueue q, int iterations )
    {
        this.q = q;
		this.iterations = iterations;
    }
    public void run()
    {
		for (int i = 1; i <= iterations; i++){
			q.pop();
		}      
    }
}

public class QueueUser {
    public static void main(String[] args) {
		BoundedQueue q = new BoundedQueue(2);
		Pusher pusher1 = new Pusher(q, "a", 8);
		Pusher pusher2 = new Pusher(q, "b", 8);
		Popper popper = new Popper(q, 16);
		
		Thread t1 = new Thread(pusher1);
		Thread t2 = new Thread(pusher2);
		Thread t3 = new Thread(popper);
		
		t1.start();
		t2.start();
		t3.start();
    }
}
