import java.util.Arrays;
import java.util.Scanner;
//create the class Course with the below Attributes.
//
//courseId- int
//courseName- String
//courseAdmin- String
//quiz- int
//handson -int
//
//The above methods should be private ,write getter and
//setter and parametrized constructor as required.
//
//create class courseProgram with main method.
//
//implement two static methods-
//   findAvgOfQuizByAdmin method:this method will take array
//of Course objects and a String  value as input parameters.
//This method will find out Average (as int) of Quiz questions
//for given Course Admin (String parametre passed)
//This method will return Average if found.if there is no course
//that matches then the method should return 0.
//
//sortCourseByHandsOn method:
//This method will take an Array of Course Objects and int
//value as input parameters.
//This methods should return an Array of Course objects in an
//ascending order of their  handson which are less than the
//given handson(int parameter passed) value. if there is no
//such course then the method should return null.
//
//The above mentioned static methods should be called from
//main methods.
//
//for findAvgOfQuizByAdmin method: The main method
//should print the average if the returned value is not 0.
//if the returned value is 0 then it should print "No Course
//found."
//
//
//for sortCourseByHandsOn method:
//                        the  main method should print the name
//of the Course from the returned Course object Array if the
//returned value is not null.if the returned value is null then
//it should print "No Course found with mentioned attribute."
//
//input1:
//111
//kubernetes
//Nisha
//40
//10
//321
//cassandra
//Roshini
//30
//15
//457
//Apache Spark
//Nisha
//30
//12
//987
//site core
//Tirth
//50
//20
//Nisha
//17
//
//output1:
//35
//kubernetes
//Apache Spark
//cassandra
//
//input2:
//111
//kubernetes
//Nisha
//40
//10
//321
//cassandra
//Roshini
//30
//15
//457
//Apache Spark
//Nisha
//30
//12
//987
//site core
//Tirth
//50
//20
//Shubhamk
//5
//
//output 2:
//No Course found
//No Course found with mentioned attributes.
public class IPA1 {
	public static int findAvgOfQuizByAdmin(Course[] c, String input)
	{
		int avg = 0, x = 0;
		for(Course a: c)
		{
			if(a.getCadmin().equalsIgnoreCase(input)) {
				avg += a.getQuiz();
				x++;
			}
		}
		if(x == 0)
			return 0;
		
		return avg/x;
	}
	public static Course[] sortCourseByHandsOn(Course[] c, int input)
	{
		Course[] ans = new Course[0];
		for(Course a: c)
		{
			if(a.getHandson() < input)
			{
				ans = Arrays.copyOf(ans, ans.length+ 1);
				ans[ans.length - 1] = a;
			}
		}
		for(int i = 0;i < ans.length;i++)
		{
			for(int j = i + 1;j < ans.length;j++)
			{
				if(ans[i].getHandson() > ans[j].getHandson())
				{
					Course temp = ans[i];
					ans[i] = ans[j];
					ans[j] = temp;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			Course[] c = new Course[4];
			for(int i  = 0; i < 4;i++)
			{
				int cid = Integer.parseInt(sc.nextLine().trim());
				String cname = sc.nextLine();
				String cadmin = sc.nextLine();
				int quiz = Integer.parseInt(sc.nextLine().trim());
				int handson = Integer.parseInt(sc.nextLine().trim());
				c[i] = new Course(cid, cname, cadmin, quiz, handson);
			}
			String admin = sc.nextLine();
			int handson = Integer.parseInt(sc.nextLine().trim());
			int avg = findAvgOfQuizByAdmin(c, admin);
			if(avg > 0)
			{
				System.out.println(avg);
			}
			else {
				System.out.println("No Course Found");
			}
			Course[] ans = sortCourseByHandsOn(c, handson);
			if(ans.length > 0)
			{
				for(Course a:ans)
				{
					System.out.println(a.getCname());
				}
			}
			else {
				System.out.println("No Course found with mentioned attributes.");
			}
		}

}
class Course{
	int cid;
	String cname;
	String cadmin;
	int quiz;
	int handson;
	public Course(int cid, String cname, String cadmin, int quiz, int handson) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cadmin = cadmin;
		this.quiz = quiz;
		this.handson = handson;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadmin() {
		return cadmin;
	}
	public void setCadmin(String cadmin) {
		this.cadmin = cadmin;
	}
	public int getQuiz() {
		return quiz;
	}
	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}
	public  int getHandson() {
		return handson;
	}
	public void setHandson(int handson) {
		this.handson = handson;
	}
	
}
