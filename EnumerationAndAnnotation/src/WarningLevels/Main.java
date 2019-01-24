package WarningLevels;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Logger logger = new Logger();

        Importance importanceLevel = Enum.valueOf(Importance.class,scanner.nextLine());

        while(true){
            String str = scanner.nextLine();
            if(str.equalsIgnoreCase("End"))
                break;

            String[] input = str.split(": ");

            Importance importance = Enum.valueOf(Importance.class,input[0]);
            String message = input[1];

            if(importance.ordinal() >= importanceLevel.ordinal()){
                logger.setMessages().add(new Message(importance,message));
            }
        }

        Iterable<Message> iterable = logger.getMessages();
        for (Message message : iterable) {
            System.out.println(message);
        }

    }
}
