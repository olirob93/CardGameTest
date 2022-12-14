import java.util.*;

public class CardGame {

    private final Random rand = new Random();

    private static ArrayList<Card> deckOfCards;

    public CardGame() {
        List<String> suits = Card.getValidSuits();

        List<String> faceNames = Card.VALID_FACENAMES;

        List<Integer> values = Card.getValidValues();

        deckOfCards = new ArrayList<>();

        for (String suit:suits){
            for(int i = 0; faceNames.size() > i; i++){
                deckOfCards.add( new Card(faceNames.get(i), suit, values.get(i)));
            }
        }
    }


    public ArrayList<Card> getDeckOfCards() {
        System.out.println(deckOfCards);
        return deckOfCards;
    }
    public Card dealCard(){
        return deckOfCards.get(rand.nextInt(52));
    }
    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

    // couldn't do this one very annoying tried a number of things
    public ArrayList<Card> sortDeckInNumberOrder(){
        Collections.sort(deckOfCards);
        return deckOfCards;

    }



}
