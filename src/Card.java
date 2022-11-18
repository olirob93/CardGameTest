import java.util.Arrays;
import java.util.List;

public class Card implements Comparable<Card> {
    private String faceName = "", suit = "";
    private Integer values;

    public static final List<String> VALID_FACENAMES =
            Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack",
                    "queen", "king", "ace");


    public Card(String faceName, String suit, Integer values) {
        setFaceName(faceName);
        setSuit(suit);
        setValues(values);
    }

    public Card() {

    }


    public String getFaceName() {
        return faceName;
    }

    public Integer getValues() {
        return values;
    }

    public static List<Integer> getValidValues() {
        return Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14);
    }

    public void setValues(Integer value) {
        List<Integer> validValues = getValidValues();

        if (validValues.contains(value))
            this.values = value;
        else
            throw new IllegalArgumentException("Valid values are: " +
                    validValues);

    }


    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();

        if (VALID_FACENAMES.contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException("Valid face names are: " +
                    VALID_FACENAMES);
    }

    public String getSuit() {
        return suit;
    }

    public static List<String> getValidSuits() {
        return Arrays.asList("\u2665", "\u2666", "\u2663", "\u2660");
    }

    public void setSuit(String suit) {
        List<String> validSuits = getValidSuits();
        suit = suit.toLowerCase();

        if (validSuits.contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException("valid suits are: " + validSuits);
    }

    @Override
    public int compareTo(Card o) {

        return this.suit.compareTo(o.suit);
    }

    public String toString() {
        return String.format("%s of %s", faceName, suit);
    }
}
