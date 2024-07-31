/*

Multithreading is a Java feature that allows concurrent execution of two or more
parts of a program for maximum utilization of CPU. Each part of such program is
called a thread. So, threads are light-weight processes within a process.

process - program/software/application under execution

multitasking -
				1. If Operating System level > multi-processing; here one application
					is also one process. This is process based multitasking
				2. If Application level > multi-threading; within application if
					various units of program (threads) execute simultaneously. This is
					thread based multitasking

In java program/application, threads are managed by an inbuilt class Thread.
So, whenever a java program is ran first main thread is created and executed to run main()
when u run java program has ran JVM will invoke main thread which first execute main() method

Runtime stack is maintained by some thread which executes every method present in the runtime stack

//simply there is a thread which executes every method in runtime stack; (might be) it is main thread.
so main thread cannot go outside runtime stack

Thread scheduler in java manages all user defined threads and inbuilt threads of java

Whether it is user-defined thread or java inbuilt thread, every thread has a name and a priority (less
value high priority) default name is "main" and default priority is 5.

Thread.currentThread() : gives info of current thread returns Thread object
Thread.currentThread().setName() : to change name of current thread
Thread.currentThread().setPriority() : to change priority of current thread
Thread.currentThread().getName() : returns name as String object
Thread.currentThread().getPriority() : returns priority
Thread.sleep(x); sleeps for x milliseconds

*/

/*
 * Multi-threading

 How to create multi-threads?

 	Make each task a separate class and (let the class extend Thread class or
 	implement Runnable interface)

 How many maximum threads I can create?

 	As you wish. No limit

 Multi-threading can be achieved in two ways:

 1. inheriting java's inbuilt Thread class

 	This class has run() method : whatever the thread has to do
 	it must present in this run() method.

 2. implementing java's inbuilt Runnable interface

 	This interface has only run() method signature

 	[Runnable interface is a functional interface]

 It is better to use Runnable interface to create threads because,
 while implementing runnable interface the thread class can implement
 many other interfaces and inherit other classes also. But if you use
 Thread class you cannot inherit any other classes because multiple inheritance
 is not supported in java.


 */

public class C19MultiThreading {

    public static void main(String[] args) throws InterruptedException {

		/*

		for(int i=0;i<1000;i++) {

			try {
				if(i==500) {
					System.out.println("I'm going to sleep now for 20 seconds");
					Thread tInfo = Thread.currentThread();//name of thread, priority, main
					System.out.println(tInfo);
					String tName = tInfo.getName();
					System.out.println(tName);
					int tPriority = tInfo.getPriority();
					System.out.println(tPriority);
					Thread.sleep(20000);
					tInfo.setName("MainJava");
					tInfo.setPriority(3);
					System.out.println(tInfo);
					System.out.println(tInfo.getName());
					System.out.println(tInfo.getPriority());
				}
				System.out.println(i);
			}

			catch(InterruptedException e) {
				System.out.println(e);
			}
		}

		*/

		/*

		 // Single thread process - CPU efficiency is not good
		 // The following are three independent tasks implemented using single thread process

		 // Task one : Bank Task
		 System.out.println("Bank task started.");
		 for(int i=0; i<3; i++){
		 	try{
		 		Thread.sleep(3000);
		 		System.out.println("Banking...");
		 	}
		 	catch(InterruptedException e){
		 		System.out.println(e);
		 	}
		 }


		 // Task two : Print Task
		 System.out.println("Print task started.");
		 for(int i=0; i<3; i++){
		 	try{
		 		Thread.sleep(3000);
		 		System.out.println("Printing...");
		 	}
		 	catch(InterruptedException e){
		 		System.out.println(e);
		 	}
		 }


		 // Task three : Calculation Task
		 System.out.println("Calculation task started.");
		 for(int i=0; i<3; i++){
		 	try{
		 		Thread.sleep(3000);
		 		System.out.println("Calculating...");
		 	}
		 	catch(InterruptedException e){
		 		System.out.println(e);
		 	}
		 }


		 //main thread executes each task one after the other
		 //As the above task is single threaded, as one task is executing
		 //remaining tasks have to wait. so CPU is not utilized properly.
		 //  Solution: Multi-threading

		 */

/*
 * 		Multi-threading using Thread class

		TaskBank TB = new TaskBank();
		TaskPrint TP = new TaskPrint();
		TaskCalculate TC = new TaskCalculate();
		TB.start();//its like a child process which executes parallelly with main thread
		TP.start();//its like a child process which executes parallelly with main thread and TB
		TC.start();//its like a child process which executes parallelly with main thread, TB and TP

		//start() method internally calls run() method
		//you should not call run() method explicitly
		//now all three tasks run simultaneously/parallelly but first banking,
		//then printing and then calculating is handovered to thread scheduler.
		//start() method handovers thread to Thread scheduler
		//we don't know which thread gets ran first by thread scheduler.
		//If you did not call start() method and called run() method explicily
		// your program behaves as single threaded program

 */

/*
 // 		Multi-threading using Runnable interface

				TaskBankR TBR = new TaskBankR();
				TaskPrintR TPR = new TaskPrintR();
				TaskCalculateR TCR = new TaskCalculateR();
				Thread threadBank = new Thread(TBR);
				Thread threadPrint = new Thread(TPR);
				Thread threadCalculate = new Thread(TCR);

				threadBank.start();
				threadPrint.start();
				threadCalculate.start();

				//create objects for the class implementing Runnable interfaces
				//now create objects for Thread class passing the above objects
				// as constructor parameter. This how you link runnable interface objects
				//to Thread class
				//start() method handovers thread to Thread scheduler
				//we don't know which thread gets ran first by thread scheduler.

 */



        // Achieving multi threading using single run() method



        BPC bpcObj1 = new BPC();
        BPC bpcObj2 = new BPC();
        BPC bpcObj3 = new BPC();

        Thread bThread = new Thread(bpcObj1);
        Thread pThread = new Thread(bpcObj2);
        Thread cThread = new Thread(bpcObj3);

        bThread.setName("Bank");
        pThread.setName("Print");
        cThread.setName("Calculate");

        System.out.println("bThread.isAlive() : "+bThread.isAlive());//false
        System.out.println("pThread.isAlive() : "+pThread.isAlive());//false
        System.out.println("cThread.isAlive() : "+cThread.isAlive());//false

        System.out.println("Thread.currentThread().isAlive() : "+Thread.currentThread().isAlive());//true

        bThread.start();
        cThread.start();
        pThread.start();

        //along with these three threads main thread (current thread here)is also running


        System.out.println("bThread.isAlive() : "+bThread.isAlive());//true
        System.out.println("pThread.isAlive() : "+pThread.isAlive());//true
        System.out.println("cThread.isAlive() : "+cThread.isAlive());//true

        System.out.println("Thread.currentThread().isAlive() : "+Thread.currentThread().isAlive());//true


        bThread.join();//serialization, main thread is paused until bThread is done
        pThread.join();//serialization, main thread, bThread are paused until pThread is done
        cThread.join();//main thread, bThread and pThread are paused until cThread is done

        System.out.println("Thread.currentThread().isAlive() : "+Thread.currentThread().isAlive());//this will print at last after completion of all three threads





        Counter counterObj = new Counter();
        Thread t1 = new Thread(counterObj, "Thread-1");
        Thread t2 = new Thread(counterObj, "Thread-2");
        Thread t3 = new Thread(counterObj, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

		/* Expected Output

		 Value for Thread After increment Thread-1 1
		 Value for Thread at last Thread-1 0
		 Value for Thread After increment Thread-3 1
		 Value for Thread at last Thread-3 0
		 Value for Thread After increment Thread-2 1
		 Value for Thread at last Thread-2 0

		 */

        //but the above code gives wrong values for variable c each time you run, because of race condition
        //i.e all the threads are acting single resource which is variable c of counterObj.

        //To achieve synchronization between threads in java we use synchronized() method.
        //this method can be applied to a block or a method for mutual exclusion


        //what is difference between using join() method and synchronized keyword for synchronization?
        //using join(): we decide which method has to run first but not thread scheduler

        //what is deadlock in java?

        //ThreadGroup class

        //Daemon thread, isDaemon(), setDaemon(true)

        //every thread either inbuilt thread or user created one is a non daemon thread
        //you cannot make main thread as daemon any other threads you can make them daemon
        //daemon thread means a thread which is not important that is the one with lowest priority
        //once daemon thread goes to sleep state then goes to runnable state, thread scheduler terminates it as it is not important


        //Garbage Collector of java is a Daemon Thread (garbage collector clears heap memory)
    }
}

//-----------------------------------------------------------------------------------------------------


//implementing multi-tasking using Thread class
class TaskBank extends Thread{// Task one : Bank Task
    public void run() {
        System.out.println("Bank task started.");
        for(int i=0; i<3; i++){
            try{
                Thread.sleep(3000);
                System.out.println("Banking...");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Bank Task completed.");
    }
}

class TaskPrint extends Thread{// Task two : Print Task
    public void run() {
        System.out.println("Print task started.");
        for(int i=0; i<3; i++){
            try{
                Thread.sleep(3000);
                System.out.println("Printing...");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Print task completed.");
    }
}

class TaskCalculate extends Thread{// Task three : Calculate Task
    public void run() {
        System.out.println("Calculate task started.");
        for(int i=0; i<3; i++){
            try{
                Thread.sleep(3000);
                System.out.println("Calculating...");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Calculate Task completed.");
    }
}


//implementing multi-tasking using Runnable Interface

class TaskBankR implements Runnable{// Task one : Bank Task
    public void run() {
        System.out.println("Bank task started.");
        for(int i=0; i<3; i++){
            try{
                Thread.sleep(3000);
                System.out.println("Banking...");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Bank Task completed.");
    }
}

class TaskPrintR implements Runnable{// Task two : Print Task
    public void run() {
        System.out.println("Print task started.");
        for(int i=0; i<3; i++){
            try{
                Thread.sleep(3000);
                System.out.println("Printing...");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Print task completed.");
    }
}

class TaskCalculateR implements Runnable{// Task three : Calculate Task
    public void run() {
        System.out.println("Calculate task started.");
        for(int i=0; i<3; i++){
            try{
                Thread.sleep(3000);
                System.out.println("Calculating...");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Calculate Task completed.");
    }
}

// achieving multi-threading using single run() method

class BPC implements Runnable{

    public void run() {
        if(Thread.currentThread().getName().equals("Bank"))
            Banking();
        else if(Thread.currentThread().getName().equals("Print"))
            Printing();
        else
            Calculating();
    }

    public void Banking() {
        System.out.println("Bank task started.");
        for(int i=0; i<3; i++){
            try{
                Thread.sleep(3000);
                System.out.println("Banking...");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Bank Task completed.");
    }

    public void Printing() {
        System.out.println("Print task started.");
        for(int i=0; i<3; i++){
            try{
                Thread.sleep(3000);
                System.out.println("Printing...");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Print Task completed.");
    }

    public void Calculating() {
        System.out.println("Calculate task started.");
        for(int i=0; i<3; i++){
            try{
                Thread.sleep(3000);
                System.out.println("Calculating...");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Calculate Task completed.");
    }

}


/*
 * 	States of Thread

  	1. new
  	2. runnable (at a time multiple threads can be in this state)
  	3. running (at a time only one thread can be in this state,  which is scheduled by Thread scheduler)
  	4. sleeping/timed waiting
  	5. waiting
  	6. dead/terminated
  	7. blocked


 */


	/*

	A condition in which the critical section (a part of the program where shared memory is accessed) is
	concurrently executed by two or more threads. It leads to incorrect behavior of a program.

	In layman terms, a race condition can be defined as, a condition in which two or more threads compete
	together to get certain shared resources.

	*/


/*
	Using threads might lead to race condition problem.
	Solution : Synchronization
*/


class Counter implements Runnable{
    private int c = 0;
    public void increment(){
        try{
            Thread.sleep(10);
        }
        catch (InterruptedException e){
            //Auto-generated catch block
            e.printStackTrace();
        }
        c++;
    }
    public void decrement(){
        c--;
    }
    public int getValue(){
        return c;
    }

	/*
	@Override
	public void run(){  //no synchronization
		//incrementing
		this.increment();
		System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue());
		//decrementing
		this.decrement();
		System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
	}

	// If synchronized is used for static method/block then it is class level synchronization
	// If synchronized is used for non-static method/block then it is object level synchronization

	//synchronized(x) : x is an object, which is a resource that can be owned by only thread at a time


	*/

    synchronized public void run(){  //synchronization applied to method
        //incrementing
        this.increment();
        System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue());
        //decrementing
        this.decrement();
        System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
    }

	/*

	public void run(){  //synchronization applied to block

		synchronized(this) {
			//incrementing
			this.increment();
			System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue());
			//decrementing
			this.decrement();
			System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
		}
	}
	*/

}
