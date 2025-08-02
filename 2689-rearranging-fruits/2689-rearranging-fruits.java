import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int fruit : basket1) freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2) freq.put(fruit, freq.getOrDefault(fruit, 0) - 1);

        List<Integer> swapList = new ArrayList<>();
        long minVal = Long.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int fruit = entry.getKey();
            int count = entry.getValue();
            if (count % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                swapList.add(fruit);
            }

            minVal = Math.min(minVal, fruit);
        }

        Collections.sort(swapList);
        long cost = 0;
        int swaps = swapList.size() / 2;

        for (int i = 0; i < swaps; i++) {
            cost += Math.min((long)swapList.get(i), 2 * minVal);
        }

        return cost;
    }
}
