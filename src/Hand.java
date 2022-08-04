import java.util.ArrayList;

public class Hand {
    private Card [] hand;
    private String user; //Soit le le joueur soit le courtier. Selon comment on appelle le constrcuteur et le paramertre quand utilise

    public Hand(String user) {
        this.user = user;
    }

    //retroune le tableau hand
    public Card[] getHand() {
        return this.hand;
    }

    // retourne la somme des cartes dans le tableau hand. Si la somme est >21, il faut recompter les cartes pour verifier si il y a un ACE. Si oui on le considere comme 1, sinon on ajoute la somme des points
    public int getPoints() {
        int sum = 0;
        for (Card x: hand){
            System.out.println(x.getPoints());
            sum += x.getPoints();
        }
        return sum;
    }

	// ajouter une carte au tableau
    public void addCard(Card card) {
        hand = new Card[2];
        for (int x = 0; x < 2; x++){
            hand[x] = new Card(card);
        }

    }

	//retourne true si la somme de deux cartes est égale à 21. False sinon
//    public boolean isBlackjack() {
//
//    }

	// retourne true si la somme des points a une valeur supérieur a 21. False sinon.
//    public boolean isBust() {
//
//    }

}