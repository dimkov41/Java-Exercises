package WarningLevels;

public class Message {
    private Importance importance;
    private String message;

    public Message(Importance importance, String message) {
        this.importance = importance;
        this.message = message;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.importance + ": " + this.message;
    }
}
