package com.skilldistillery.blackjack;

public class Player {
//all stuff that player can do but not dealer	
	private Hand hand = new BlackJackHand();
	
	public void addCard(Card card) {
		hand.addCard(card);
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
}
