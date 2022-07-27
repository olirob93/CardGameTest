
public class Main {

    public static void main(String[] args) {

        // cardGame class and methods
            CardGame cardGame = new CardGame();
            // get full deck of cards
            cardGame.getDeckOfCards();

            // deal random card from deck
            cardGame.dealCard();

            // shuffle deck
            cardGame.shuffleDeck();

        //Starts Snap Game with no players
        Snap singlePlayerSnap = new Snap();
        singlePlayerSnap.startSinglePlayerGame();

        // starts Snap game with two players
        Snap multiplayerSnap = new Snap();
        multiplayerSnap.startMultiplayerGame();

    }
}
