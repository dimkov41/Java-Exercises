package CardRank;

public class Main {

    public static void main(String[] args) {
        System.out.println("CardGame.Card Ranks:");
        for (CardRank rank : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",rank.ordinal(),rank.name());
        }


        //Ordinal value: 12; Name value: KING
    }
}
