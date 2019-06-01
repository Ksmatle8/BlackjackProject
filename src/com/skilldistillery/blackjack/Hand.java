package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	private List<Card> cards = new ArrayList<Card>();

	public void addCard(Card card) {
		cards.add(card);
	}

	public void clearHand() {
		cards.clear();
	}

	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	public List<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		return "Hand: [" + cards + "]";
	}

}
