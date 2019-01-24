package WarningLevels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Logger {
    private List<Message> messages;

    public Logger() {
        this.messages = new ArrayList<>();
    }

    public List<Message> setMessages() {
        return this.messages;
    }

    public Iterable<Message> getMessages(){
        return new Iterable<Message>() {
            @Override
            public Iterator<Message> iterator() {
                return new LoggerIterator();
            }
        };
    }

    private final class LoggerIterator implements Iterator<Message>{
        private int counter;

        @Override
        public boolean hasNext() {
            return this.counter < messages.size();
        }

        @Override
        public Message next() {
            return messages.get(this.counter++);
        }
    }
}
