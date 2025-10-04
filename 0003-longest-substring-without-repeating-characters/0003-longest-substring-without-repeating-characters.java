class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0,j=0,len =0;
        int n = s.length();
        char[] c = s.toCharArray();
        boolean[] chars = new boolean[255];
        while(j<n){
            while(chars[c[j]]){
                chars[c[i]] = false;
                i++;
            }
            chars[c[j]] = true;
            len = Math.max(len,j-i+1);
            j++;
        }

        return len;
    }
}