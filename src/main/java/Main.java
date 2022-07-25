
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, -3));
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 2));
        System.out.println(findRestaurants(new ArrayList<>(Arrays.asList(arrayList, arrayList1)), 0));
        System.out.println(predictDays(new ArrayList<>(Arrays.asList(3,2,2,2,3,4)), 2));
        List<Integer> integers = numberOfItems("|**|*|*", new ArrayList<>(Arrays.asList(1, 1)), new ArrayList<>(Arrays.asList(5, 6)));
        System.out.println(integers);

    }

    public static List<List<Integer>> findRestaurants(List<List<Integer>> allLocations, int numRestaurants) {
        Map<Integer,Double> dis = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < allLocations.size(); i++) {

            dis.put(i,Math.sqrt(Math.pow(allLocations.get(i).get(0),2
            )) + Math.sqrt(Math.pow(allLocations.get(i).get(1),2
            )));


        }
        LinkedHashMap<Integer, Double> collect = dis.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        int c =0;
        for (Integer integer : collect.keySet()) {
            if (c<numRestaurants){
                res.add(allLocations.get(integer));
                c++;
            }
        }
        if (res.size()==0) return new ArrayList<>(Collections.singletonList(new ArrayList<>()));

        return res;

    }
    public static List<Integer> predictDays(List<Integer> day, int k) {
        List<Integer> res = new ArrayList<>();
        boolean leftSuccess = false;
        boolean rightSuccess = false;

        for (int i = k; i < day.size()-k; i++) {
            if (k>=1) {
                for (int j = i ; j > i - k; j--) {
                    if (day.get(j) <= day.get(j - 1)) {
                        leftSuccess = true;
                    } else {
                        leftSuccess = false;
                        break;
                    }
                }
                for (int j = i ; j < i + k; j++) {
                    if (day.get(j) <= day.get(j + 1)) {
                        rightSuccess = true;
                    } else {
                        rightSuccess = false;
                        break;
                    }
                }
                if (rightSuccess && leftSuccess){
                    res.add(i+1);
                    rightSuccess=false;
                    leftSuccess=false;
                }
            }



        }
        return res;
    }

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); i++) {
            int arrRes=0;
            int start = startIndices.get(i);
            int end = endIndices.get(i);
            boolean run = false;
            for (int i1 = start-1; i1 < end-1; i1++) {
                if (run && !Character.toString(s.charAt(i1)).equals("|")) arrRes++;
                if (Character.toString(s.charAt(i1)).equals("|"))
                    run = true;
                else if (Character.toString(s.charAt(i1)).equals("|") && run){
                    break;
                }
            }
            res.add(arrRes);
        }
        return res;
    }
}
