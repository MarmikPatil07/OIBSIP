import java.util.*;
class BankAccount{
	String Name,Username,Password,AccountNo;
	float Balance=100000f;
	int Transactions=0;
	String TransactionHistory="";
	
	    
public void Register() {
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter your Name :");
	this.Name=scn.nextLine();
	System.out.println("Enter your Username :");
	this.Username=scn.nextLine();
	System.out.println("Enter your Password :");
	this.Password=scn.nextLine();
	System.out.println("Enter your AccountNo :");
	this.AccountNo=scn.nextLine();
	
	System.out.println("Registration completed ... Kindly login");
	
}

	public boolean Login() {
	
		boolean isLogin=false;
		Scanner scn = new Scanner(System.in);
		while(!isLogin) {
			System.out.println("Enter your username :");
			String username=scn.nextLine();
			if(username.equals(Username)) {
				while(!isLogin) {
					System.out.println("Enter your password :");
					String password=scn.nextLine();
					if(password.equals(Password)) {
						System.out.println("Login Successful");
						isLogin=true;
					}
					else {
						System.out.println("Incorrect Password");
					}
				}
			}
			else {
				System.out.println("Username not found");
			}
		}
		return isLogin;
	}
	
	public void Withdraw() {
		
		System.out.println("Enter amount to withdraw");
		Scanner scn=new Scanner(System.in);
		float amount = scn.nextFloat();
		
		try {
			if(Balance>=amount) {
				Transactions++;
				Balance=Balance-amount;
				System.out.println("Withdraw Successful...");
				String str=amount+"Rs Withdrawed";
				TransactionHistory=TransactionHistory.concat(str);
			}
			else {
				System.out.println("Insufficient Balance");
			}
		}
		catch(Exception obj1) {
			
		}
	}
	
	
	public void Deposit() {
		System.out.println("Enter amount to Deposit :");
		Scanner scn=new Scanner(System.in);
		float amount=scn.nextFloat();
		
		try {
			if(amount<=100000f) {
				Transactions++;
				Balance=Balance+amount;
				System.out.println("Amount Successfully Deposited");
				String str = amount+"Rs deposited";
				TransactionHistory=TransactionHistory.concat(str);
			}
			else {
				System.out.println("Sorry..Limit is 100000.00");
			}
		}
		catch(Exception obj2) {
			
		}
	}
	
	
	public void Transfer() {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Recipents Name :");
		String recerpent=scn.nextLine();
		System.out.println("Enter amont to transfer");
		float amount=scn.nextFloat();
		
		try {
			if(Balance>=amount) {
				if(amount<=50000f) {
					Transactions++;
					Balance=Balance-amount;
					System.out.println("Successfully transferred to "+recerpent);
					String str=amount+"Rs Transferred to "+recerpent+"\n";
					TransactionHistory=TransactionHistory.concat(str);
				}
				else {
					System.out.println("\nSorry.. Limit is 50000.00");
				}
			}
			else {
				System.out.println("Insufficient Balance");
			}
		}
		catch(Exception obj3) {
			
		}
	}
	
	public void checkBalance() {
		System.out.println("\n"+"Account balance is "+Balance+"Rs");
	}
	
	public void TransactionHistory() {
		if(Transactions==0) {
			System.out.println("Empty");
		}
		else {
			System.out.println("\n"+TransactionHistory+"\n");
		}
	}
	
	}

	public class ATMInterface{
		public static int TakeIntegerInput(int limit) {
			int input=0;
			boolean flag=false;
			
			while(!flag) {
				try {
					Scanner scn=new Scanner(System.in);
					input=scn.nextInt();
					flag=true;
					
					if(flag&&input>limit||input<1) {
						System.out.println("Choose the number between 1 to "+limit);
						flag=false;
					}
				}
				catch(Exception obj4) {
					System.out.println("Enter only integer value");
					flag=false;
				}
			}
			return input;
		}
		
		public static void main(String[] args) {
			System.out.println("\n------WELCOME TO ATM SYSTEM------\n");
			System.out.println("1.Register\n2.Exit");
			System.out.println("Enter your choice :");
			
			int choice=TakeIntegerInput(2);
			
			if(choice==1) {
				BankAccount scn=new BankAccount();
				scn.Register();
				while(true) {
					System.out.println("\n1. Login \n 2.Exit");
					System.out.println("Enter your choice :");
					int ch=TakeIntegerInput(2);
					if(ch==1) {
						if(scn.Login()) {
							System.out.println("\n-------Welcome Back"+scn.Name+"------\n");
							boolean isFinished=false;
							while(!isFinished) {
								System.out.println("\n1.Withdraw\n2.Deposit\n3.Transfer\n4.CheckBalance\n5.TransactionHistory\n6.Exit\n");
								System.out.println("Enter your choice");
								
								int i=TakeIntegerInput(6);
								switch(i) {
								case 1:
									scn.Withdraw();
									break;
								case 2:
									scn.Deposit();
									break;
								case 3:
									scn.Transfer();
									break;
								case 4:
									scn.checkBalance();
									break;
								case 5:
									scn.TransactionHistory();
								case 6:
									isFinished=true;
									break;
						
								}
							}
						}
					}
					else {
						System.exit(0);
					}
				}
			}
			else {
				System.exit(0);
			}
		}
		
	}