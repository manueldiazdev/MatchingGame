/*
	Manuel Diaz
	CSC15
	Spring 19
	Project #4
 */


import java.util.*;
public class MemoryGameBoard {
	public final int BOARD_SIZE = 4;
	private final int NUM_SWAPS = 1000;
	
	private Card[][] gameBoard = new Card[BOARD_SIZE+1][BOARD_SIZE+1];
	
	
	public MemoryGameBoard() {
		initializeCards();
	}

	public void shuffleCards() {
		Random swaps = new Random();
		int row1;
		int col1;
		int row2;
		int col2;

		for(int i = 1; i <= NUM_SWAPS; i++){
			row1 = swaps.nextInt(BOARD_SIZE)+1;
			col1 = swaps.nextInt(BOARD_SIZE)+1;
			row2 = swaps.nextInt(BOARD_SIZE)+1;
			col2 = swaps.nextInt(BOARD_SIZE)+1;
			Card temp = gameBoard[row1][col1];
			gameBoard[row1][col1] =gameBoard[row2][col2];
			gameBoard[row2][col2] = temp;
		}
		turnCardsFaceDown();
	}
	public void showBoard() {
		hideBoard();
		System.out.print(toString());
	}
	public boolean cardsMatch(int row1, int col1, int row2, int col2){
		if(gameBoard[row1][col1].equals(gameBoard[row2][col2]))
			return true;
		else
			return false;
	}
		
	
	public boolean isFaceUp(int row, int col) {
		return gameBoard[row][col].isFaceUp();

	}
	public void flipCard(int row1, int col1) {
		gameBoard[row1][col1].flipCard();
		
	}
	public String toString() {
		String board = "";
		board+="    ";
		for(int i = 1; i <= BOARD_SIZE; i++) {
			
			board+=String.format("%d ",i );
			
		}
		board+="\n";
		board+="   ";
		board+=topBottom();
		for(int i = 1; i <= BOARD_SIZE; i++) {
			
			board+=String.format("%d | ", i);
			for(int j = 1; j <= BOARD_SIZE; j++) {
				
				board+=String.format("%s ", gameBoard[i][j]);
			}
			board+="|\n";
		}
		
		board+="   ";
		board+=topBottom();
		return board;
	}
	private void initializeCards() {
		for(int i = 1; i <= BOARD_SIZE; i++) {
			for(int j = 1; j <= BOARD_SIZE ; j++) {
				if(i%2 != 0) {
					gameBoard[i][j] = new Card(j);
				}else {
					gameBoard[i][j] = new Card(BOARD_SIZE+j);
				}
			}	
				
		
	}
	}
	private void hideBoard() {
		for(int i = 1; i<=10; i++) {
			System.out.println();
		}
	}
	private void turnCardsFaceDown() {
		for(int i = 1; i <= BOARD_SIZE; i++) {
			for(int j = 1; j <= BOARD_SIZE ; j++) {
				gameBoard[i][j].setFaceDown();
			}
		}
	}
	//testing purposes
	/*public void displayGameBoardValues() {
		for(int i = 1; i <= BOARD_SIZE; i++) {
			for(int j = 1; j <= BOARD_SIZE ; j++) {
				gameBoard[i][j].setFaceUp();
			}
		}
	}*/

	//prints the amount of "=" to make square
	private String topBottom(){
		String board ="";
		for(int i = 1; i <= BOARD_SIZE*2+1; i++) {

			board+=String.format("=");

		}
		board+="\n";
		return board;
	}
}
