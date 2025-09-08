import java.util.PriorityQueue;

class Solution {
    public String reorganizeString(String s) {
        if (s == null || s.length() <= 1) return s;

        int n = s.length();
        int[] counts = new int[26];
        for (char c : s.toCharArray()) counts[c - 'a']++;
        int maxCount = 0;
        for (int c : counts) maxCount = Math.max(maxCount, c);
        if (maxCount > (n + 1) / 2) return "";
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) pq.offer(new int[]{i, counts[i]});
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            sb.append((char) (first[0] + 'a'));
            sb.append((char) (second[0] + 'a'));

            if (--first[1] > 0) pq.offer(first);
            if (--second[1] > 0) pq.offer(second);
        }
        if (!pq.isEmpty()) {
            sb.append((char) (pq.poll()[0] + 'a'));
        }

        return sb.toString();
    }
}
