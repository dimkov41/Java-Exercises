package ThePartyReservationFilterModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String[] arr = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            arr[i] = names.get(i);
        }

        while (true) {
            String[] input = reader.readLine().split(";");

            if (input[0].equals("Print")) {
                for (String name : names) {
                    System.out.printf("%s ", name);
                }
                break;
            } else if (input[0].equals("Add filter")) {

                if (input[1].equals("Starts with")) {
                    names = names.stream().filter(x -> !Character.toString(x.charAt(0)).equals(input[2])).collect(Collectors.toList());
                } else if (input[1].equals("Ends with")) {
                    names = names.stream().filter(x -> !Character.toString(x.charAt(x.length() - 1)).equals(input[2])).collect(Collectors.toList());
                }

                else if(input[1].equals("Length")){
                    names = names.stream().filter(x -> x.length() > Integer.parseInt(input[2])).collect(Collectors.toList());
                }

                else if(input[1].equals("Contains")){
                    names = names.stream().filter(x -> !x.contains(input[2])).collect(Collectors.toList());
                }
            } else if(input[0].equals("Remove filter")){
                if(input[1].equals("Starts with")){
                    String[] s = Arrays.stream(arr).filter(x -> Character.toString(x.charAt(0)).equals(input[2])).toArray(String[]::new);
                    for (String st : s) {
                        names.add(st);
                    }
                } else if(input[1].equals("Ends with")){
                    String[] s = Arrays.stream(arr).filter(x -> Character.toString(x.charAt(x.length() - 1)).equals(input[2])).toArray(String[]::new);
                    for (String st : s) {
                        names.add(st);
                    }
                } else if(input[1].equals("Length")){
                    String[] s = Arrays.stream(arr).filter(x -> x.length() < Integer.parseInt(input[2])).toArray(String[]::new);
                    for (String st : s) {
                        names.add(st);
                    }
                } else if(input[1].equals("Contains")){
                    String[] s = Arrays.stream(arr).filter(x -> x.contains(input[2])).toArray(String[]::new);
                    for (String st : s) {
                        names.add(st);
                    }
                }
            }
        }
    }
}
