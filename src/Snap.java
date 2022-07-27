import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {
    private boolean gameOver = false;
    private boolean started = true;



    public Snap(){

    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void startSinglePlayerGame(){
        shuffleDeck();
        Card card = new Card();

        while(!gameOver){
            Scanner takeTurn = new Scanner(System.in);
            //store previous card
            Card previousCard = card;
            // use scanner to take turn
            System.out.println("Press enter to Take Turn");
            takeTurn.nextLine();
            // store new card from a dealt card
            card = dealCard();
            // check for winner method
            checkForWinner(previousCard, card);
        }
    }

    public void startMultiplayerGame(){

            Scanner name = new Scanner(System.in);
            System.out.println("Enter Name for player 1");
            Player playerOne = new Player(name.nextLine(), true);
            System.out.println("Enter Name for player 2");
            Player playerTwo = new Player(name.nextLine(), false);

        shuffleDeck();
        Card card = new Card();

        while(!gameOver){
            Scanner scanner = new Scanner(System.in);
            //store previous card
            Card previousCard = card;
            // use scanner to take turn
            if(!gameOver && !started){
                System.out.println("Player 1 will go first press enter to start");
                scanner.nextLine();
            }

            if(playerOne.isTurn()){
                System.out.println( playerOne.getName() +"'s" + " turn, Press enter");
                scanner.nextLine();
                card = dealCard();
                playerOne.setCard(card);
                // check for winner method
                if( playerOne.checkIfPlayerWon(previousCard, card, playerOne)){
                    setGameOver(true);
                }
                playerOne.setTurn(false);
                playerTwo.setTurn(true);
            } else {
                System.out.println(playerTwo.getName() + "'s" + " turn, Press enter");
                scanner.nextLine();
                card = dealCard();
                playerTwo.setCard(card);
                // check for winner method
                if(playerTwo.checkIfPlayerWon(previousCard, card, playerTwo)){
                    setGameOver(true);
                };
                playerTwo.setTurn(false);
                playerOne.setTurn(true);

            }

        }

    }

    private void checkForWinner(Card previousCard, Card card){
        if(previousCard.getSuit() == card.getSuit()){
            System.out.println(card);
            System.out.println("SNAPPPPP!!!");
            System.out.println("game over");
            setGameOver(true);
        }
        else {
            System.out.println(card);
        }
    }


}
