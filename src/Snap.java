import java.util.Scanner;

public class Snap extends CardGame {
    private boolean gameOver = false;
    private static final boolean  started = true;
    public Scanner scanner = new Scanner(System.in);


    public Snap() {

    }

    public void startSinglePlayerGame() {
        shuffleDeck();

        Card card = dealCard();

        while (!gameOver) {
            //store previous card
            Card previousCard = card;
            // use scanner to take turn
            System.out.println("Press enter to Take Turn");
            scanner.nextLine();
            // store new card from a dealt card
            card = dealCard();
            // check for winner method
            checkForWinner(previousCard, card);
        }
    }

    public void startMultiplayerGame() {

        System.out.println("Enter Name for player 1");
        Player playerOne = new Player(scanner.nextLine(), true);
        System.out.println("Enter Name for player 2");
        Player playerTwo = new Player(scanner.nextLine(), false);

        shuffleDeck();
        Card card = new Card();
        Player currentPlayer = playerOne;

        while (!gameOver) {

            //store previous card
            Card previousCard = card;
            // use scanner to take turn
            if (!gameOver && !started) {
                System.out.println("Player 1 will go first press enter to start");
                scanner.nextLine();
            }

            System.out.println(currentPlayer.getName() + "'s" + " turn, Press enter");
            scanner.nextLine();
            card = dealCard();
            currentPlayer.setCard(card);
            // check for winner method
            if (currentPlayer.checkIfPlayerWon(previousCard, card, currentPlayer)) {
                gameOver = true;
            }

            if(currentPlayer==playerOne && currentPlayer.isTurn()){
                currentPlayer.setTurn(false);
                currentPlayer = playerTwo;
                currentPlayer.setTurn(true);
            } else {
                currentPlayer.setTurn(false);
                currentPlayer = playerOne;
                currentPlayer.setTurn(true);
            }

        }

    }

    private void checkForWinner(Card previousCard, Card card) {
        if (previousCard.getSuit().equals(card.getSuit())) {
            System.out.println(card);
            System.out.println("SNAPPPPP!!!");
            System.out.println("game over");
            gameOver = true;
        } else {
            System.out.println(card);
        }
    }


}
