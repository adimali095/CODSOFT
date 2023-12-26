import java.util.*;
public class RandomNumberGenerator
{
	public static void main(String a[])
	{
		menu();
	}
	static void menu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter no of rounds : ");
		int rounds = sc.nextInt();
		int score = 0;
		for(int i=0;i<rounds;i++)
		{
			System.out.println("--------------------------------------------------------");
			System.out.println("\nROUND "+(i+1));
			score += round();
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("\nYour Score : "+score);
		System.out.println("--------------------------------------------------------");
	}
	static int round()
	{
		int res = 0;
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter No1 : ");
		int n1 = sc.nextInt();
		System.out.print("\nEnter No2 : ");
		int n2 = sc.nextInt();
		int min,max;
		if(n1>n2)
		{
			min = n2;max=n1;
		}
		else
		{
			min=n1;
			max = n2;
		}	
		int randomNo = r.nextInt(max-min+1)+min;
		int choices = 10;
		
		int guess = n1;
		while(choices !=0)
		{
			System.out.print("\nEnter guess : ");
			guess = sc.nextInt();
			if(guess == randomNo)
			{
				System.out.println("\nCorrect guess !");
				res = 1;
				break;
			}
			else
			{
				System.out.println("\nIncorrect ! You may try again !");
			}
		}
		if(choices == 0 && guess != randomNo)
		{
			System.out.println("\nChoices have expired !");
		}
		return res;
	}
}