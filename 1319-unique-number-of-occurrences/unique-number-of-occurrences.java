import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurrenceCount = new HashMap<>();
        for (int num : arr) {
            occurrenceCount.put(num, occurrenceCount.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> uniqueCounts = new HashSet<>(occurrenceCount.values());
        
        return occurrenceCount.size() == uniqueCounts.size();
    }
}