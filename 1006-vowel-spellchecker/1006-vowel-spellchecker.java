import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            String devowel = deVowel(lower);
            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(devowel, word);
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = matchWord(queries[i], exactWords, caseInsensitive, vowelInsensitive);
        }
        return result;
    }

    private String matchWord(String query, Set<String> exactWords,
                             Map<String, String> caseInsensitive,
                             Map<String, String> vowelInsensitive) {

        if (exactWords.contains(query)) return query;

        String lower = query.toLowerCase();
        if (caseInsensitive.containsKey(lower)) return caseInsensitive.get(lower);

        String devowel = deVowel(lower);
        return vowelInsensitive.getOrDefault(devowel, "");
    }
    
    private String deVowel(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (isVowel(c)) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
