package primus.pawel.DAY_06;

import primus.pawel.InputType;

import java.util.ArrayList;
import java.util.List;

import static primus.pawel.FileReader.readFileAsString;

//2021-12-20 T:18:56:12
//https://adventofcode.com/2021/day/6
class DAY_06_1 {

    private final static int DAYS = 80;

    public static void main(String[] args) throws Exception {

        String[] input = readFileAsString("06", InputType.TEST).split(",");
        int[] initialState = new int[input.length];
        List<LanternFish> lanternFishList = new ArrayList<>();
        List<LanternFish> newLanternFishList = new ArrayList<>();


        for (int i = 0; i < input.length; i++) {
            initialState[i] = Integer.parseInt(input[i].trim());
            System.out.println(initialState[i]);
            LanternFish lanternFish = new LanternFish(initialState[i]);
            lanternFishList.add(lanternFish);
        }

        for (int i = 1; i <= DAYS; i++) {

            for (LanternFish lanternFish : lanternFishList) {

                if (lanternFish.getInternalTimer() == 0){
                    lanternFish.restInternalTimer();
                    LanternFish lanternFish1 = new LanternFish(8);
                    newLanternFishList.add(lanternFish1);
                } else {
                    lanternFish.minusInternalDay();
                }

            }
            lanternFishList.addAll(newLanternFishList);
            newLanternFishList.clear();
            System.out.print("After day " + i  + " :");
            //printLanternFishList(lanternFishList);
            System.out.println();

        }

        System.out.println(lanternFishList.size());

    }

    public static void printLanternFishList(List<LanternFish> lanternFishList) {

        for (LanternFish lanternFish : lanternFishList) {
            System.out.print(lanternFish.getInternalTimer() + "|");
        }


    }

}
