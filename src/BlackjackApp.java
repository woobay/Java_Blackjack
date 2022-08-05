public class BlackjackApp {

    private static BlackjackGame game;

    public static void main(String[] args) {
        System.out.println("BLACKJACK!");
        System.out.println("Blackjack payout is 3:2");
        System.out.println();

        String playAgain = "y";
        while(playAgain.equalsIgnoreCase("y")) {
            // votre scenario de simulation vient ici

        }
        System.out.println("\nBye!");
    }

	// affiche le message Out of money! Would you like to add more? (y/n):. Si le joueur tappe y alors la fonction reset la balance du joueur au 100 et retourne true. False Sinon.
    private static boolean buyMoreChips() {
        if (game.isOutOfMoney()) {
            String myArray[] = {"y", "n"};
            if (Console.getString("Out of money! Would you like to add more? (y/n): ", myArray).equalsIgnoreCase("y")) {
                game.resetMoney();
            }
            return true;
        } else {
            return false;
        }
    }
    
	// affiche le message Bet amount, lire la valeur de la mise saisi par le joueur. Valide cette valeur. Si la valeur n'est pas valide afficher le message Bet must be between
    private static void getBetAmount() {
        game.setBet(Console.getDouble("Enter bet amount: ", game.getMinBet(), game.getMaxBet()));
     }

	// Affiche le message Hit or Stand? (h/s): et puis retourne ce que le joueur a tappe.
    private static String getHitOrStand() {
        String myArray[] = {"h", "s"};
        return Console.getString("Hit or Stand? (h/s): ", myArray);

    }

	// affiche les cartes dans la main du courtier et les cartes dans la main du joueur
	    private static void showHands() {
            Card[] cardsDealer = game.getDealerHand().getCards();
            Card[] cardsPlayer = game.getPlayerHand().getCards();

            System.out.println("Player hand: ");
            for(Card card: cardsPlayer) {
                System.out.println(card.display());
            }
            System.out.printf("Total point: %s", game.getPlayerHand().getPoints());
            System.out.println();
            System.out.println();
            System.out.println("Dealer hand: ");
            for(Card card: cardsDealer) {
                System.out.println(card.display());
            }
            System.out.printf("Total point: %s", game.getDealerHand().getPoints());
            System.out.println();
            System.out.println();

        }

	// affiche le message DEALER'S SHOW CARD et puis affiche le deuxieme carte dans la main du courtier
    private static void showDealerShowCard() {
        System.out.println("Dealer's show card: ");
        game.getDealerShowCard().display();
    }

	// affiche le message DEALER'S CARDS et puis affiche les cartes dans la main du courtier
    private static void showDealerHand() {
        System.out.println("Dealer's cards: ");
        Card[] cards = game.getDealerHand().getCards();
        for (Card card: cards) {
            System.out.println(card.display());
        }
    }

	// affiche le message YOUR CARDS et puis affiche les cartes dans la main du joueur
    private static void showPlayerHand() {
        System.out.println("Your cards: ");
        Card[] cards = game.getPlayerHand().getCards();
        for (Card card: cards) {
            System.out.println(card.display());
        }
    }

	// affiche Total money:  et le montant total
    private static void showMoney() {
        game.loadMoney();
    }


    private static void showWinner() {
        showPlayerHand();
        System.out.printf("YOUR POINTS: %d%n", game.getPlayerHand().getPoints());

        showDealerHand();
        System.out.printf("DEALER'S POINTS: %d%n%n", game.getDealerHand().getPoints());

        if(game.isPush()) {
            System.out.println("Push!");
        } else if(game.getPlayerHand().isBlackjack()) {
            System.out.println("BLACKJACK! You win!");
            game.addBlackjackToTotal();
        } else if (game.playerWins()) {
            System.out.println("You win!");
            game.addBetToTotal();
        } else {
            System.out.println("Sorry, you lose.");
            game.subtractBetFromTotal();
        }
        showMoney();
    }
}
