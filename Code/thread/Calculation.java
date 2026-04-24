package pack1;

public class Calculation
{
	public void sumN(int n)
	{
		int sum=0;
		String name = Thread.currentThread().getName();
		for(int i=1;i<=n;i++)
		{
			sum+=i;
			System.out.println(name+" Adding : "+i);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(name+" sum : "+sum);
	}
}
