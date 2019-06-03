package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackJackApp {

	Dealer dealer = new Dealer();
	Player player = new Player();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new BlackJackApp().run();
	}

	private void run() {
		dealer.deck.shuffle();
		dealer.shuffle();

		// Deal two cards and shows
		for (int i = 0; i < 2; i++) {
			player.addCard(dealer.deck.dealCard());

			dealer.addCard(dealer.deck.dealCard());
		}
		System.out.println(player.getHand());
		System.out.println();
		System.out.println("Dealers Hand: " + dealer.getHand().getCards().get(0));
		System.out.println();

		if (dealer.getHand().getHandValue() == 21) {
			System.out.println("Dealer Wins");
			System.out.println();
			System.out.println("Dealers Hand: " + dealer.getHand().getCards());
			System.exit(0);
		}
		if (player.getHand().getHandValue() == 21) {
			System.out.println("Player Wins");
			System.exit(0);
		}

		// Player hit or stay
		boolean hit = true;
		do {
			System.out.println("Do you want to HIT(1) or STAY(2)? ");
			hit = input.nextInt() == 1;
			if (hit) {
				player.addCard(dealer.deck.dealCard());
				System.out.println(player.getHand());
				System.out.println();
				if (player.getHand().getHandValue() > 21) {
					System.out.println("Over 21 you LOSE! Dealer Wins");
					System.exit(0);
					if (player.getHand().getHandValue() == 21) {
						System.out.println("BlackJack Player wins");
						System.exit(0);
					}
				}
			}
			System.out.println();
		} while (hit == true);

		// After player stays dealer looks at his hand
		System.out.println("Dealers Hand: " + dealer.getHand().getCards());
		System.out.println();

		while (dealer.getHand().getHandValue() < 17) {
			System.out.println("Dealer adds card!");
			dealer.addCard(dealer.deck.dealCard());
			System.out.println("Dealers Hand: " + dealer.getHand().getCards());
			System.out.println();
		}

		// Outcome of the game
		if (dealer.getHand().getHandValue() > 21) {
			System.out.println("Dealer over 21 player wins ");
			System.exit(0);
		}
		if (dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
			System.out.println("Player Wins");
		}
		if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
			System.out.println("Dealer Wins");
		}
		if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
			System.out.println("No one wins its a TIE");
		}
	}
}
