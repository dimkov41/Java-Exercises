package MapDistricts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,List<Integer>> cities = new HashMap<>();

        String[] input = reader.readLine().split(" ");
        for (String s : input) {
            String[] ciryArgs = s.split(":");
            String cityName = ciryArgs[0];
            int cityDistrict = Integer.parseInt(ciryArgs[1]);

            if(!cities.containsKey(cityName)){
                cities.put(cityName, new ArrayList<>());
            }

            cities.get(cityName).add(cityDistrict);

        }

        int populationBound = Integer.parseInt(reader.readLine());

        cities.entrySet()
                .stream()
                .filter(kv -> kv.getValue().stream().reduce((x,y) -> x+y).get() > populationBound)
                .sorted((kv1,kv2) -> {
                    int kv1Sum = kv1.getValue().stream().reduce((x,y) -> x + y).get();
                    int kv2Sum = kv2.getValue().stream().reduce((x,y) -> x + y).get();

                    //IMPORTANT
                    return Integer.compare(kv2Sum,kv1Sum);
                }).forEach(kv ->{
            StringBuilder sb = new StringBuilder();
            sb.append(kv.getKey()).append(": ");
            kv.getValue().stream().sorted((x,y) -> Integer.compare(y,x))
                    .limit(5).forEach(p -> sb.append(p).append(" "));
            System.out.println(sb.toString());
        });
    }
}
