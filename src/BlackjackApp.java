public class BlackjackApp {

    private static BlackjackGame game;

    public static void main(String[] args) {
        System.out.println("BLACKJACK!");
        System.out.println("Blackjack payout is 3:2");
        System.out.println();

        game = new BlackjackGame();

        String playAgain = "y";
        while(playAgain.equalsIgnoreCase("y")) {
            // votre scenario de simulation vient ici

            System.out.println();
            getBetAmount();
            game.deal();
            showDealerShowCard();
            showPlayerHand();

            if (game.getPlayerHand().isBlackjack()){

                showWinner();
            } else {
                while (getHitOrStand().equals("h")) {
                    game.hit();
                    showPlayerHand();
                    if (game.getPlayerHand().isBust()) {
                        break;
                    }
                }
                game.stand();
                showWinner();
            }
            if(game.isOutOfMoney()){
                if(buyMoreChips()){
                    game.resetMoney();
                }else{
                    break;
                }
            }
            String[] answers = {"y", "n"};
            playAgain = Console.getString("Do you want to play again? (y/n): ",answers);

        }
        System.out.println("\nBye!");
    }

	// affiche le message Out of money! Would you like to add more? (y/n):. Si le joueur tappe y alors la fonction reset la balance du joueur au 100 et retourne true. False Sinon.
    private static boolean buyMoreChips() {
            return Console.getString("Out of money! Would you like to add more? (y/n): ").equalsIgnoreCase("y");
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
            Card[] cardsDealer = game.getDealerHand().getCards().toArray(new Card[0]);
            Card[] cardsPlayer = game.getPlayerHand().getCards().toArray(new Card[0]);

            System.out.println("Player hand: ");
            for(Card card: cardsPlayer) {
                System.out.println(card.display());
            }
            System.out.printf("Total point: %s", game.getPlayerHand().getPoints());
            System.out.println("Dealer hand: ");
            System.out.println();
            System.out.println();
            for(Card card: cardsDealer) {
                System.out.println(card.display());
            }
            System.out.printf("Total point: %s", game.getDealerHand().getPoints());
            System.out.println();
            System.out.println();

        }

	// affiche le message DEALER'S SHOW CARD et puis affiche le deuxieme carte dans la main du courtier
    private static void showDealerShowCard() {
        System.out.println(game.getDealerShowCard().display());
        System.out.println();
    }

	// affiche le message DEALER'S CARDS et puis affiche les cartes dans la main du courtier
    private static void showDealerHand() {
        System.out.println("Dealer's cards: ");
        Card[] cards = game.getDealerHand().getCards().toArray(new Card[0]);
        for (Card card: cards) {
            System.out.println(card.display());
        }
    }

	// affiche le message YOUR CARDS et puis affiche les cartes dans la main du joueur
    private static void showPlayerHand() {
        System.out.println("Your cards: ");
        Card[] cards = game.getPlayerHand().getCards().toArray(new Card[0]);
        for (Card card: cards) {
            System.out.println(card.display());
        }
    }

	// affiche Total money:  et le montant total
    private static void showMoney() {
        System.out.printf("Total money: %s",game.getTotalMoney());
        System.out.println();

    }


    private static void showWinner() {
        System.out.println();
        showPlayerHand();
        System.out.printf("YOUR POINTS: %d%n", game.getPlayerHand().getPoints());
        System.out.println();

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
