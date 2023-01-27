import java.util.*;
public class NumberGuessing {

	public static void guessingNumber()
	{
		Scanner scn = new Scanner(System.in);
		int number = 1 + (int)(100*Math.random());
		int ui;
		int i , guess;
		System.out.println("Welcome to Number Guessing Game!! \nThe Number has to be chosen between 1 to 100");
		System.out.println("Enter no. of trials you think you can guess the number:");
		ui=scn.nextInt();
		
		for (i=0;i<ui;i++) {
			System.out.println("Round "+ i+" #");
			System.out.println("Guess the no.");
			guess=scn.nextInt();
			
			if(number == guess) {
				System.out.println("Congratulations !! You guessed the number ");
				break;
			}
			else if(number>guess&&i!=ui-1) {
				System.out.println("Try again! The number is greater than "+guess+"\n");
			}
			else if(number<guess&&i!=ui-1) {
				System.out.println("Try again! The no.is less than "+ guess+"\n");
			}
		}
		
		if(i==ui) {
			System.out.println("Game over!! you have used up all your k trials\nBetter Luck next time\n");
			System.out.println();
			
			System.out.println("The no. was" +number+"!");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		guessingNumber();
	}
}
