public class Card {
    private final String suite; // Spades", "Hearts", "Clubs" ou "Diamonds"
    private final String rank;//2, 3, 4, ..., 10,  
    private final int points; 
    
    public Card(String suite, String rank, int points) {
        this.suite = suite;
        this.rank = rank;
        this.points = points;
    }
    
    public Card(Card c) {
        this.suite = c.suite;
        this.rank = c.rank;
        this.points = c.points;
    }
    
    public String getSuite() {
//        This suite ou suitee ------------------------
        return suite;
    }
    
    public String getRank() {
//        this rank ou rank ---------------------------
        return rank;
    }
    
    public int getPoints() {
//        this.point ou point ---------------------
        return points;
    }
    
	//qui retourne true si la carte est un Ace 
    public boolean isAce() {
        if (this.rank == "Ace") {
            return true;
        };
        return false;
    }
    
	//retourne une chaine de caractère : Valeur_rank_variable + " of " + valeur_suite_variable. Par exemple : 3 of Hearts 
    public String display() {
        return this.rank + " of " + this.suite +" "+ this.points;
    }
}