import java.util.*;

public class CardGame {

    private static ArrayList<Card> deckOfCards;

    public CardGame() {
        List<String> suits = Card.getValidSuits();

        List<String> faceNames = Card.getValidFaceNames();

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
        Random rand = new Random();
        Card randomCard = deckOfCards.get(rand.nextInt(52));
        return randomCard;
    };
    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

    // couldn't do this one very annoying tried a number of things
    public void sortDeckInNumberOrder(ArrayList<Card> deckOfCards){
        // not sure how to do this
        // need first thought was to loop through the deck of cards and compare it's value against the
        //previous iteration each time but there must be a better way

//        ArrayList<Card> sortedArrayList = new ArrayList<>();
//
//        Card previousCard = new Card();
//        for (Card card:deckOfCards
//             ) {
//            if(previousCard.getValues() <= card.getValues()){
//                System.out.println("getting here");
//                previousCard = card;
//                sortedArrayList.add(card);
//            }
//            System.out.println("each card" + card);
//        }
//        System.out.println(sortedArrayList);
    }



}
