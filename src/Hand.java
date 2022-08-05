import java.util.ArrayList;

public class Hand {
    private Card [] hand;
    private String user; //Soit le le joueur soit le courtier. Selon comment on appelle le constrcuteur et le paramertre quand utilise
    private int i = 0;
    public Hand(String user) {
//        Trouver fixx pour empty array -------------------
        this.user = user;
        hand = new Card[2];
    }
    
	//retroune le tableau hand
    public Card[] getCards() {
        return this.hand;
    }
    
	// retourne la somme des cartes dans le tableau hand. Si la somme est >21, il faut recompter les cartes pour verifier si il y a un ACE. Si oui on le considere comme 1, sinon on ajoute la somme des points

//    TODO Pourrais regarder d'enlever une loop peut-etre
    public int getPoints() {
        int sum = 0;
        for (Card item : hand) {
            sum += item.getPoints();
        }
        if ( sum > 21) {
            for (Card item: hand) {
                if (item.isAce()) {
                    sum -= 10;
                }
            }
        }
        return sum;
    }


    
	// ajouter une carte au tableau
    public void addCard(Card card) {
//      hand[i++] = new Card(card)
        hand[i++] = card;
    }
    
	//retourne true si la somme de deux cartes est égale à 21. False sinon
    public boolean isBlackjack() {
        int sum = 0;
        for (Card card: hand){
            sum += card.getPoints();
        }
        if (sum == 21) {
            return true;
        } else {
            return false;
        }
    }
    
	// retourne true si la somme des points a une valeur supérieur a 21. False sinon.
    public boolean isBust() {
        if (getPoints() > 21) {
            return true;
        } else {
            return false;
        }
    }
}