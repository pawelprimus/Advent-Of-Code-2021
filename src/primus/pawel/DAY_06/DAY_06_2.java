package primus.pawel.DAY_06;

import primus.pawel.InputType;

import java.math.BigDecimal;
import java.util.HashMap;

import static primus.pawel.FileReader.readFileAsString;

//2021-12-20 T:19:30:27
//https://adventofcode.com/2021/day/6
class DAY_06_2 {

    private final static int DAYS = 256;

    public static void main(String[] args) throws Exception {

        String[] input = readFileAsString("06", InputType.ORIGINAL).split(",");
        int[] initialState = new int[input.length];

        HashMap<Integer, BigDecimal> lanternHashMap = new HashMap<>();
        HashMap<Integer, BigDecimal> copiedLanternHashMap = new HashMap<>();

        HashMap<Integer, BigDecimal> youngLanternHashMap = new HashMap<>();
        HashMap<Integer, BigDecimal> copiedyoungLanternHashMap = new HashMap<>();


        lanternHashMap.put(0, BigDecimal.ZERO);
        lanternHashMap.put(1, BigDecimal.ZERO);
        lanternHashMap.put(2, BigDecimal.ZERO);
        lanternHashMap.put(3, BigDecimal.ZERO);
        lanternHashMap.put(4, BigDecimal.ZERO);
        lanternHashMap.put(5, BigDecimal.ZERO);
        lanternHashMap.put(6, BigDecimal.ZERO);

        youngLanternHashMap.put(0, BigDecimal.ZERO);
        youngLanternHashMap.put(1, BigDecimal.ZERO);
        youngLanternHashMap.put(2, BigDecimal.ZERO);
        youngLanternHashMap.put(3, BigDecimal.ZERO);
        youngLanternHashMap.put(4, BigDecimal.ZERO);
        youngLanternHashMap.put(5, BigDecimal.ZERO);
        youngLanternHashMap.put(6, BigDecimal.ZERO);
        youngLanternHashMap.put(7, BigDecimal.ZERO);
        youngLanternHashMap.put(8, BigDecimal.ZERO);

        for (int i = 0; i < input.length; i++) {
            initialState[i] = Integer.parseInt(input[i].trim());
            lanternHashMap.put(initialState[i], new BigDecimal(String.valueOf(lanternHashMap.get(initialState[i]).add(BigDecimal.ONE))));
        }

        for (int i = 1; i <= DAYS; i++) {
            copiedLanternHashMap.putAll(lanternHashMap);
            copiedyoungLanternHashMap.putAll(youngLanternHashMap);

            lanternHashMap.put(0, copiedLanternHashMap.get(1));
            lanternHashMap.put(1, copiedLanternHashMap.get(2));
            lanternHashMap.put(2, copiedLanternHashMap.get(3));
            lanternHashMap.put(3, copiedLanternHashMap.get(4));
            lanternHashMap.put(4, copiedLanternHashMap.get(5));
            lanternHashMap.put(5, copiedLanternHashMap.get(6));
            lanternHashMap.put(6, copiedLanternHashMap.get(0).add(copiedyoungLanternHashMap.get(0)));

            youngLanternHashMap.put(0, copiedyoungLanternHashMap.get(1));
            youngLanternHashMap.put(1, copiedyoungLanternHashMap.get(2));
            youngLanternHashMap.put(2, copiedyoungLanternHashMap.get(3));
            youngLanternHashMap.put(3, copiedyoungLanternHashMap.get(4));
            youngLanternHashMap.put(4, copiedyoungLanternHashMap.get(5));
            youngLanternHashMap.put(5, copiedyoungLanternHashMap.get(6));
            youngLanternHashMap.put(6, copiedyoungLanternHashMap.get(7));
            youngLanternHashMap.put(7, copiedyoungLanternHashMap.get(8));
            youngLanternHashMap.put(8, copiedyoungLanternHashMap.get(0).add(copiedLanternHashMap.get(0)));

            copiedLanternHashMap.clear();
            copiedyoungLanternHashMap.clear();
        }


        BigDecimal sumOfAll = BigDecimal.ZERO;

        for (Integer keyOfMap : lanternHashMap.keySet()) {
            Integer key = keyOfMap;
            BigDecimal value = lanternHashMap.get(keyOfMap);
            System.out.println(key + " " + value);
            sumOfAll = sumOfAll.add(value);
        }

        for (Integer keyOfMap : youngLanternHashMap.keySet()) {
            Integer key = keyOfMap;
            BigDecimal value = youngLanternHashMap.get(keyOfMap);
            System.out.println(key + " " + value);
            sumOfAll = sumOfAll.add(value);
        }

        System.out.println(sumOfAll);

    }


}
