public class Player extends Snap {
    private String name;
    private boolean turn, won;
    private Card card;


    public Player(String name, boolean turn) {
        this.name = name;
        this.turn = turn;
        this.won = false;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }


    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public String getName() {
        return name;
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean checkIfPlayerWon(Card previousCard, Card card, Player player){
        if(previousCard.getSuit() == card.getSuit()){
            System.out.println(card);
            System.out.println("SNAPPPPP!!!");
            System.out.println("game over "+ player.getName() +" is the winner, the Suits match " + card.getSuit());
            setWon(true);
        }
        else {
            System.out.println(card);
            setWon(false);
        }
        return won;
    }

}

