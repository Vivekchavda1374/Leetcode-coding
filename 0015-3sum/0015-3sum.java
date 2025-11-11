class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Set<List<Integer>> res = new HashSet<>();
        for(int i=0; i<n;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = arr[i] + arr[j] +arr[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    List<Integer> ele = new ArrayList<>();
                    ele.add(arr[i]);
                    ele.add(arr[j]);
                    ele.add(arr[k]);
                    res.add(ele);
                    j++;
                    k--;
                    while(j<n && arr[j]==arr[j-1]) j++;
                    while(k>0 && arr[k] == arr[k+1]) k--;
                }
                
            }
        }
        
        return new ArrayList<>(res);
    }
}