package pack1;

public class Demo1 
{
	// static function is a function which is defined by the use of static keyword
	// these functions are part of class. that is why these are also known
	// as instance functions. They acquire memory only once in the class. 
	// it is not part of any object.
	// To access static funtions: -  classname.functionname();
	
	// static functions belongs to the class rather than any instance of the class.
	
	public static void main(String[] args) 
	{
		// Thread.currentThread() :
		// it returns the information about the currently running thread.
		// it returns the following information in the string format
		// like eg. Thread(main,5,main)

		System.out.println("Information : "+ Thread.currentThread());

		// setName() : it is used to change the name of the local thread
		Thread t=Thread.currentThread();
		t.setName("My Thread");
		
		// setPriority(num) : it is used to change the priority of a thread.
		// you can set priority between 1 to 10.
		t.setPriority(9);
		
		System.out.println("Information : "+ Thread.currentThread());
		
		System.out.println("Priority : "+t.getPriority());
		System.out.println("Thread name : "+t.getName());
		
		for(int i=1;i<=10;i++)
		{
			System.out.println(i);
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
					e.printStackTrace();
			}
		}
		
		
	}

}
