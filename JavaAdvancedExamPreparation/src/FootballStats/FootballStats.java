package FootballStats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String patternStr = "([a-zA-Z]+) - ([a-zA-Z]+) result ([0-9]+):([0-9]+)";
        Pattern pattern = Pattern.compile(patternStr);

        Map<String, Deque<String>> teams = new LinkedHashMap<>();

        while (true) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);

            if (input.equalsIgnoreCase("Season End")) {
                break;
            }

            if (matcher.find()) {
                String firstTeamName = matcher.group(1);
                String secondTeam = matcher.group(2);

                int firstTeamScore = Integer.parseInt(matcher.group(3));
                int secondTeamScore = Integer.parseInt(matcher.group(4));


                // if does not exists
                if (!teams.containsKey(firstTeamName)) {
                    Deque<String> list = new ArrayDeque<>();
                    list.add(secondTeam + " -> " + firstTeamScore + ":" + secondTeamScore);

                    teams.put(firstTeamName, list);
                } else {
                    Deque<String> list = teams.get(firstTeamName);
                    list.addLast(secondTeam + " -> " + firstTeamScore + ":" + secondTeamScore);

                    teams.replace(firstTeamName, list);
                }

                if (!teams.containsKey(secondTeam)) {
                    Deque<String> list = new ArrayDeque<>();
                    list.add(firstTeamName + " -> " + secondTeamScore + ":" + firstTeamScore);

                    teams.put(secondTeam, list);

                } else {
                    Deque<String> list = teams.get(secondTeam);
                    list.add(firstTeamName + " -> " + secondTeamScore + ":" + firstTeamScore);

                    teams.put(secondTeam, list);
                }
            }
        }

        String[] teamsToPrint = reader.readLine().replaceAll("\\s+", "").split(",");

        for (int i = 0; i < teamsToPrint.length; i++)  {
            String teamName = teamsToPrint[i];

            for (Map.Entry<String, Deque<String>> map : teams.entrySet()) {
                if (map.getKey().equalsIgnoreCase(teamName)) {
                    for (String s : map.getValue().stream()
                            .sorted(Comparator.comparing(p -> Character.toString(p.charAt(0))))
                            .collect(Collectors.toList())) {
                        System.out.printf("%s - %s%n", map.getKey(), s);
                    }
                }
            }
        }
    }
}
