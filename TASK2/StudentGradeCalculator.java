import java.util.Scanner;
class StudentInfo
{
	double marks[];
	int n;
	static Scanner sc = new Scanner(System.in);
	StudentInfo(int n)
	{
		this.n = n;
		marks = new double[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Marks [ "+(i+1)+" ] : ");
			marks[i] = sc.nextDouble();
		}
	}
	double getTotalMarks()
	{
		int i;
		double sum=0;
		for(i=0;i<n;i++)
		{
			sum +=marks[i];
		}
		return sum;
	}
	double getAveragePercentage()
	{
		return ( ((double)getTotalMarks() ) / ( (double)n ));
	}
	String getGrade()
	{
		double per = getAveragePercentage();
		if(per > 90 && per <= 100)
		{
			return "O";
		}
		else if(per > 80 && per < 90)
		{
			return "A+";
		}
		else if(per > 70 && per < 80)
		{
			return "A";
		}
		else if(per > 65 && per < 70)
		{
			return "B";
		}
		else if(per > 60 && per < 65)
		{
			return "C";
		}
		else if(per > 55 && per < 60)
		{
			return "D";
		}
		else if(per > 40 && per < 55)
		{
			return "E";
		}
		else
		{
			return "Fail";
		}
	}
	void display()
	{
		System.out.println("\nMarks :\n");
		int i;
		for(i=0;i<n;i++)
		{
			System.out.print("\nSubject [ "+(i+1)+" ] : "+marks[i]);
		}
		System.out.println("\nTotal Marks : "+getTotalMarks());
		System.out.println("\nAverage Percentage : "+getAveragePercentage());
		System.out.println("\nGrade : "+getGrade());	
	}
	
}
public class StudentGradeCalculator
{
	public static void main(String a[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter no. of subjects : ");
		int n = sc.nextInt();
		StudentInfo s = new StudentInfo(n);
		s.display();
	}
}