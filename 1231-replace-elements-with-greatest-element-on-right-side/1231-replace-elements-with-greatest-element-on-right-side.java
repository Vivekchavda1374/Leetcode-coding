class Solution {
    public int[] replaceElements(int[] arr) {
        int max1 = -1, n = arr.length;
        for(int i  = n-1 ; i>=0 ; --i){
            max1 = Math.max(arr[i],arr[i]=max1);
        }
        return arr;
    }
}