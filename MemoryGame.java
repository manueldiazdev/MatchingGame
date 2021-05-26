/*
	Manuel Diaz
	CSC15
	Spring 19
	Project #4
 */
import java.util.*;

public class MemoryGame {
	public static Scanner kb= new Scanner(System.in);
	public static Card c = new Card(4);
	public static MemoryGameBoard game = new MemoryGameBoard();
	public static void main(String[] args) {
		//ACTUAL GAME

		int bestScore = 0;
		int turnCount = 0;
		int pairsLeft = 0;
		int best = -1;
		boolean decision = true;
		System.out.println("CSC 15 - Manuel Diaz\n\n\n"+
				"Welcome to the Memory Game.\n" +
				"The goal is to find all the matching pairs in as few turns as possible.\n" +
				"At each turn select two different positions on the board to see if they match.");

		while (decision == true){
			game.shuffleCards();

			turnCount = 0;
			pairsLeft =(int)Math.pow(game.BOARD_SIZE, 2)/2;
			//single game mechanic
			while(pairsLeft != 0) {
				System.out.print("Press any key to continue...");
				while(!kb.hasNext()){

				}
				kb.next();

				int row1;
				int col1;
				int row2;
				int col2;
				turnCount++;

				game.showBoard();


				System.out.println("First card?");
				row1 = getValidInt("\tRow: ", 1, game.BOARD_SIZE);


				col1 = getValidInt("\tCol: ", 1, game.BOARD_SIZE);
				while(game.isFaceUp(row1,col1)) {
					System.out.println("Sorry you already picked that card.");
					System.out.println("First card?");
					row1 = getValidInt("\tRow: ", 1, game.BOARD_SIZE);


					col1 = getValidInt("\tCol: ", 1, game.BOARD_SIZE);
				}
				game.flipCard(row1,col1);
				game.showBoard();

				kb.nextLine();
				System.out.println("Second card?");
				row2 = getValidInt("\tRow: ", 1, game.BOARD_SIZE);

				col2 = getValidInt("\tCol: ", 1, game.BOARD_SIZE);
				while(game.isFaceUp(row2,col2)) {
					System.out.println("Sorry you already picked that card.");
					System.out.println("Second card?");
					row2 = getValidInt("\tRow: ", 1, game.BOARD_SIZE);


					col2 = getValidInt("\tCol: ", 1, game.BOARD_SIZE);
				}
				game.flipCard(row2,col2);
				game.showBoard();

				if(game.cardsMatch(row1,col1,row2,col2)){
					pairsLeft--;
					game.showBoard();
					System.out.println("They Match!");


				}else{
					game.flipCard(row1,col1);
					game.flipCard(row2,col2);
					System.out.println("srry they didnt match");




				}




			}
			System.out.println("\t\tCONGRATULATIONS! You found all the matching pairs!");

			System.out.printf("You did it in %d turns\n",turnCount);
			if(best == -1){
				System.out.println("That's your best so far");
				best = turnCount;
			}else if (best > turnCount){
				System.out.println("That's your best so far!\n");
				best = turnCount;
			}
			String answer;
			do{
				System.out.print("Would you like to play another game? (Yes or No): ");
				answer = kb.next();
				answer = answer.toLowerCase();
			}while( !(answer.equals("yes")||answer.equals("no")));
			if(answer.equals("no")){
				decision = false;
			}


		}
		System.out.println("Thanks for playing!");













		/* TESTING METHODS
		//TESTING Card Class


		c.flipCard();
		System.out.println(c);
		
		
		
		//TESTING MemoryGameBoard Class

		game.showBoard();
		
		//TESTING Flip
		
		game.flipCard(1, 1);
		game.showBoard();

		//Look at all the cards (CODING purposes)
		game.displayGameBoardValues();
		game.showBoard();
		game.shuffleCards();
		game.showBoard();
		game.displayGameBoardValues();
		game.showBoard();
		*/



	}
	public static int getValidInt(String prompt,int min, int max){

		int num=0;
		System.out.print(prompt);

		while(!kb.hasNextInt()){
			kb.next();
			System.out.println("srry needs to be a number!");
			System.out.print(prompt);
		}
		num = kb.nextInt();
		while(!(min<=num && num<=max)){

			System.out.println("Not in range"+"("+min+"..."+max+")");
			System.out.print(prompt);

			while(!kb.hasNextInt()){
				kb.next();
				System.out.println("Sorry needs to be a number!");
				System.out.print(prompt);
			}
			num = kb.nextInt();
		}

		return num;
	}


}
