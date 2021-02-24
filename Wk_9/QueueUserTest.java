import junit.framework.TestCase;
import java.io.*;
import java.util.*;

public class QueueUserTest extends TestCase {
	
	public void testCreatePusher(){
		BoundedQueue bq = new BoundedQueue(6);
		Pusher pusher = new Pusher(bq, "a", 5);
		pusher.run();
	}
	
	public void testCreatePopper(){
		BoundedQueue bq = new BoundedQueue(6);
		Popper popper = new Popper(bq, 5);
		popper.run();
	}
}
