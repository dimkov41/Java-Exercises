package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("P","G");
        System.out.println(stringScale.getHeavier());
    }
}
