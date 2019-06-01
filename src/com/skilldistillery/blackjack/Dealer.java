package com.skilldistillery.blackjack;

public class Dealer extends Player {
	// needs a deck
	Deck deck = new Deck();

	public void shuffle() {
		deck.shuffle();
	}
	// dealer needs to deal the cards

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
