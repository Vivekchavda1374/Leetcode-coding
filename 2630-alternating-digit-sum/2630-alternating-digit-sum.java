class Solution {
    public int alternateDigitSum(int n) {
        int sign = 1;
        int sum = 0 ;
        while(n>0){
           int rem =n%10;
           sign*=-1;
           sum += sign*rem;
           n /= 10;
            
        }
        return sign * sum;
    }
}   