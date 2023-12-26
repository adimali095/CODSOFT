import java.util.Scanner;

class BankAccount 
{
	private double balance;
	public BankAccount(double initialBalance)
	{
		this.balance = initialBalance;
	}
	public double getBalance()
	{
		return balance;
	}
	public void deposit(double amount) 
	{
		balance += amount;
		System.out.println("Deposited $" + amount + ". New balance: $" + balance);
	}
	public boolean withdraw(double amount) 
	{
		if (amount <= balance) 
		{
			balance -= amount;
			System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
			return true;
		}
		else
		{
			System.out.println("Insufficient funds. Cannot withdraw $" + amount);
			return false;
		}
	}
}

class ATM 
{
	private BankAccount bankAccount;
	public ATM(BankAccount bankAccount) 
	{
		this.bankAccount = bankAccount;
	}
	public void displayOptions() 
	{
		System.out.println("---------------------------------------------------");
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Check Balance");
		System.out.println("4. Exit");
		System.out.println("---------------------------------------------------");
	}
	public void processOption(int option)
	{
		Scanner scanner = new Scanner(System.in);
		switch (option) 
		{
			case 1:
				System.out.print("Enter amount to withdraw: $");
				double withdrawAmount = scanner.nextDouble();
				if (withdrawAmount > 0) 
				{
					bankAccount.withdraw(withdrawAmount);
				}
				else
				{
					System.out.println("Invalid amount. Please enter a positive value.");
				}
				break;
			case 2:
				System.out.print("Enter amount to deposit: $");
				double depositAmount = scanner.nextDouble();
				if (depositAmount > 0)
				{
					bankAccount.deposit(depositAmount);
				}
				else 
				{
					System.out.println("Invalid amount. Please enter a positive value.");
				}
                		break;
			case 3:
				System.out.println("Current balance: $" + bankAccount.getBalance());
				break;
			case 4:
				System.out.println("Exiting. Thank you!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option. Please choose a valid option.");
		}
	}	
}

public class ATMDriver 
{
	public static void main(String[] args) 
	{
		BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
		ATM atm = new ATM(userAccount);
		while (true) 
		{
			atm.displayOptions();
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			atm.processOption(choice);
		}
	}
}