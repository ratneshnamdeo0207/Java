import java.util.Arrays;
import java.util.Scanner;

//create a class Footwear which consists of the below attributes.
//footwearId=int
//footwearName=String
//footwearType=String
//price =int
//
//the above attributes should be private.
//write getter and setter and parametrised constructor as required.
//
//create the class footwearProgrammm with the main method.
//implement the 2 static methods.getCountByType and
//getSecondHighestPriceByBrand in the Solution class.
//
//
//getCountByType method:
// this method will take two input parameters.
//array of the Footwear objects and string parameter footwear type.
//this method will return the count of the footwears from array of the
//footwear objects for the given type of footwear.
//if no footwear with the given footwear type is found in the
//array of footwear abjects,then the method should return 0.
//
//
//
//getSecondHighestPriceByBrand method:
//this method will take 2 input parameters-array of footwear objects and string parameter inputFootwearName.the method
//will return the second highest footwear objects based on the price from the array of the Footwear objects
//
//
//whose brand name matches with the input string parameter.
//
//
//if no footwear with the given brand is present in the array of the footwear objects,the the method
//should return null.
//
//NOTE: no two footwear objects would have the same footwearId.All the searches should be case insensitive.
//the above mentioned static methods should be called from the main method.
//
//for getCountByType method- the main method should print the count of the footwears ,if the returned value
//is greater than zero. or it should print "Footwear not available";
//
//for getSecondHighestPriceByBrand method-The main method should print price from the returned footwear objects
//
//
//if the returned footwear object is not null.else it should print "Brand not available".
//for example.
//112
//ABC
//25555
//where 112 is the footwear id,ABC is brand name,25555 is price.
//
//consider the sample input and output.
//100
//Sketchers
//sneekers
//12345
//103
//Puma
//running shoes
//10099
//102
//reebok
//Running shoes
//5667
//101
//Reebok
//running shoes
//5656
//99
//reebok
//floaters
//5666
//Running shoes
//reebok
//
//Sample output:
//3
//99
//reebok
//5666
//
//Sample input2:
//
//100
//Puma
//sneekers
//12345
//101
//Puma
//sneekers
//10099
//102
//Puma
//sneekers
//5000
//102
//Reebok
//sneekers
//8000
//104
//Puma
//floaters
//2000
//running shoes
//bata
//
//Sample output:
//Footwear not available
//Brand not available
class Footwear{
	int fid;
	String fname;
	String ftype;
	int price;
	public int getFid() {
		return fid;
	}
	
	public Footwear(int fid, String fname, String ftype, int price) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.ftype = ftype;
		this.price = price;
		
	}

	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
public class IPA2 {
	public static int getCountByType(Footwear[] f, String type)
	{
		int c = 0;
		for(Footwear a:f)
		{
			if(a.getFtype().equalsIgnoreCase(type))
			{
				c++;
			}
		}
		return c;
	}
	public static Footwear getSecondHighestPriceByBrand(Footwear[] f, String name)
	{
		Footwear[] ans  = new Footwear[0];
		for(Footwear a: f)
		{
			if(a.getFname().equalsIgnoreCase(name))
			{
				ans = Arrays.copyOf(ans, ans.length + 1);
				ans[ans.length - 1] = a;			}
		}
		
		if(ans.length < 2)
			return null;
		
		for(int i = 0;i < ans.length;i++)
		{
			for(int j = i + 1; j < ans.length; j++)
			{
				if(ans[i].getPrice() > ans[j].getPrice())
				{
					Footwear temp = ans[i];
					ans[i] = ans[j];
					ans[j] = temp;
				}
			}
		}
		return ans[ans.length - 2];
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Footwear[] f = new Footwear[5];
		for(int i = 0;i < f.length;i++)
		{
			int fid = Integer.parseInt(sc.nextLine().trim());
			String fname = sc.nextLine();
			String ftype = sc.nextLine();
			int price = Integer.parseInt(sc.nextLine().trim());
			f[i] = new Footwear(fid, fname, ftype, price);
		}
		String type = sc.nextLine();
		String name = sc.nextLine();
		int c = getCountByType(f, type);
		if(c > 0)
		{
			System.out.println(c);
		}
		else {
			System.out.println("Footwear not available");
		}
		Footwear ans = getSecondHighestPriceByBrand(f, name);
		if(ans != null)
		{
			System.out.println(ans.getFid());
			System.out.println(ans.getFname());
			System.out.println(ans.getPrice());
		}else {
				System.out.println("Brand not available");
		}
		
	}
}
