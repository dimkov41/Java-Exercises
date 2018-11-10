package HandsOfCards;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Set<String>> map = new LinkedHashMap<>();

        while(true){
            String input = scan.nextLine();
            if(input.equals("JOKER"))
                break;

            String[] personArray = input.split(":");
            String person = personArray[0];

            if(map.containsKey(person)){
                Set<String> currentPersonCards = map.get(person);
                String[] cardsArray = personArray[1].trim().split(", ");
                for (int i = 0; i < cardsArray.length; i++) {
                    currentPersonCards.add(cardsArray[i]);
                }
                map.put(person,currentPersonCards);
            }
            else{
                String[] cardsArray = personArray[1].trim().split(", ");
                Set<String> cards = new HashSet<>(Arrays.asList(cardsArray));
                map.put(person,cards);
            }
        }

        for (Map.Entry<String, Set<String>> entryset : map.entrySet()) {
            String person = entryset.getKey();

            Set<String> cards = entryset.getValue();

            int totalSum = 0;
            for (String c : cards) {

                String[] currentCard = (c.substring(0,c.length() - 1) + " " + c.substring(c.length()-1,c.length())).split(" ");

                String power = currentCard[0];
                String type = currentCard[1];

                int powerNum = 0;
                int typeNum = 0;

                switch (power){
                    case "2":
                        powerNum = 2;
                        break;
                    case "3":
                        powerNum = 3;
                        break;
                    case "4":
                        powerNum = 4;
                        break;
                    case "5":
                        powerNum = 5;
                        break;
                    case "6":
                        powerNum = 6;
                        break;
                    case "7":
                        powerNum = 7;
                        break;
                    case "8":
                        powerNum = 8;
                        break;
                    case "9":
                        powerNum = 9;
                        break;
                    case "10":
                        powerNum = 10;
                        break;
                    case "J":
                        powerNum = 11;
                        break;
                    case "Q":
                        powerNum = 12;
                        break;
                    case "K":
                        powerNum = 13;
                        break;
                    case "A":
                        powerNum = 14;
                        break;
                }


                switch (type){
                    case "S":
                        typeNum = 4;
                        break;
                    case "H":
                        typeNum = 3;
                        break;
                    case "D":
                        typeNum = 2;
                        break;
                    case "C":
                        typeNum = 1;
                        break;

                }
                totalSum += typeNum * powerNum;
            }
            System.out.printf("%s: %d%n",entryset.getKey(),totalSum);
        }

    }
}
