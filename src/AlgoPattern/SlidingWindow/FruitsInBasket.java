package AlgoPattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {
    /*
    *
    * You are visiting a farm to collect fruits. The farm has a single row of fruit trees. You will be given two baskets,
    * and your goal is to pick as many fruits as possible to be placed in the given baskets.

    You will be given an array of characters where each character represents a fruit tree. The farm has following restrictions:

    Each basket can have only one type of fruit. There is no limit to how many fruit a basket can hold.
    You can start with any tree, but you can’t skip a tree once you have started.
    You will pick exactly one fruit from every tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
    Write a function to return the maximum number of fruits in both baskets.
    *
    *
    * Input: Fruit=['A', 'B', 'C', 'A', 'C']
    Output: 3
    Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
    *
    * Contraint:
    *  - Basket can have one type of fruit.
    *  - Each character represent different fruit tree.
    *  - Three baskets with individual fruit.
    *  - pick from any three.
    * */
    public static int fruitsInBasket(char[] fruits){
        int maxFruitLen = 0, start = 0;

        Map<Character, Integer> fruitMap = new HashMap<>();

        for(int end = 0; end < fruits.length; end++) {

            fruitMap.put(fruits[end], fruitMap.getOrDefault(fruits[end], 0) + 1);

            while(fruitMap.size() > 2) {

                fruitMap.put(fruits[start], fruitMap.get(fruits[start]) - 1);

                if(fruitMap.get(fruits[start]) == 0) {
                    fruitMap.remove(fruits[start]);
                }
                start++;
            }

            maxFruitLen = Math.max(maxFruitLen, end - start + 1);
        }
        return maxFruitLen; // Time O(N + N) = O(N) | Space = O(1)
    }
}
