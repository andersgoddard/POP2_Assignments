Problem: Bounded queue. (Files: BoundedQueue.java, QueueUser.java.)

In the given file called BoundedQueue.java, implement a queue class called BoundedQueue, where each instance is a queue that can hold a bounded number of String values. The main data structure of your class should be an instance of ArrayList<String>. The class should have push and pop methods which are synchronized. (These two methods should behave in a first-in first-out fashion; when the pop method is able to dequeue a string, it should dequeue the oldest string in the queue.) The methods should behave as follows:

The constructor of this class should receive an int which specifies the maximum number of Strings that the queue can hold.

The push method should first check if there are already the maximum number of elements in the queue; if so, the method should call wait() until the number of elements is strictly less than the maximum number. After that, it should push the argument of the method into the queue; print out "Pushed: " followed by the string that was just pushed, a slash, and the queue size; call notifyAll(); and then return.

The pop method should first check if there is at least one element in the queue; if not, the method should call wait() until this holds. After that, it should pop a string from the queue; print out "Popped: " followed by the popped string, a slash, and the queue size; call notifyAll(); and then return.

In the given file called QueueUser.java, implement 3 classes:

A class Pusher which implements Runnable. The constructor of this class should receive an instance of BoundedQueue, a name, and a number iterations. The run() method of this class should call push on the given instance of BoundedQueue the specified number of times, with a loop having an index variable whose value varies from 1 to the number iterations; the argument passed to push should be a String which consists of the value of the index variable plus the name.

A class Popper which implements Runnable. The constructor of this class should receive an instance of BoundedQueue and a number iterations. The run() method of this class should call pop on the given instance of BoundedQueue the specified number of times.

A public class QueueUser with a main method that does the following. First, it creates a single instance of BoundedQueue, passing the value 2 to the constructor of BoundedQueue. Then, it creates two instances of the class Pusher, passing the constructor the instance of BoundedQueue, the names a and b, and the value 8 as the number of iterations. After this, it creates one instance of the class Popper, passing the constructor the instance of BoundedQueue, and the value 16 as the number of iterations. Finally, it creates 3 threads based on these 3 instances of Pusher and Popper, and starts these threads. (See the sample output below. You are of course free to experiment with different values and different numbers of threads, but please submit a main method that behaves as described.)

Answer each of the following questions with an answer consisting of 1-2 sentences, placing each answer in a comment right after your student information in the file QueueUser.java:

Q1: What is the difference in behavior if the code is modified so that the value 15 is passed to the constructor of the class Popper? Why?

Q2: What is the difference in behavior if the code is modified so that the value 17 is passed to the constructor of the class Popper? Why?

Q3: What potential difference in behavior is there if the code is modified so that the push method of the class BoundedQueue does not call notifyAll()? Why?

Sample output:

  Pushed: 1 a / 1
  Popped: 1 a / 0
  Pushed: 2 a / 1
  Pushed: 3 a / 2
  Popped: 2 a / 1
  Popped: 3 a / 0
  Pushed: 4 a / 1
  Popped: 4 a / 0
  Pushed: 5 a / 1
  Pushed: 6 a / 2
  Popped: 5 a / 1
  Popped: 6 a / 0
  Pushed: 1 b / 1
  Popped: 1 b / 0
  Pushed: 2 b / 1
  Pushed: 3 b / 2
  Popped: 2 b / 1
  Popped: 3 b / 0
  Pushed: 4 b / 1
  Popped: 4 b / 0
  Pushed: 5 b / 1
  Pushed: 6 b / 2
  Popped: 5 b / 1
  Popped: 6 b / 0
  Pushed: 7 b / 1
  Popped: 7 b / 0
  Pushed: 8 b / 1
  Pushed: 7 a / 2
  Popped: 8 b / 1
  Popped: 7 a / 0
  Pushed: 8 a / 1
  Popped: 8 a / 0