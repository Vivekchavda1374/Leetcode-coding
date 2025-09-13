class Solution {
    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }
    
    public int maxFreqSum(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int maxVowel = 0, maxConsonant = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if (isVowel(ch)) {
                maxVowel = Math.max(maxVowel, count);
            } else {
                maxConsonant = Math.max(maxConsonant, count);
            }
        }
        return maxVowel + maxConsonant;
    }
}