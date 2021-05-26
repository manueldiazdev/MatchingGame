/*
	Manuel Diaz
	CSC15
	Spring 19
	Project #4
 */
public class Card {
	//value represents the value of the card
	private int value;
	//true= faced up
	//false= faced down
	private boolean faceUp;
	
	public Card(int initValue) {
		value = initValue;
		faceUp = false;
		
	}
	public int getValue() {

		
		return value;
	}
	public boolean isFaceUp() {
		return faceUp;
	}
	public void flipCard() {
		faceUp = !faceUp;
	}
	public void setFaceUp() {
		if(faceUp != true) {
			flipCard();
		}
	}
	public void setFaceDown() {
		if(faceUp != false) {
			flipCard();
		}
	}
	public boolean equals(Card otherCard) {
		
		return value == otherCard.value;
	}
	public String toString() {
		if(faceUp == true) {
			return String.format("%d",value);
		}else {
			return "*";
		}
	}
}
