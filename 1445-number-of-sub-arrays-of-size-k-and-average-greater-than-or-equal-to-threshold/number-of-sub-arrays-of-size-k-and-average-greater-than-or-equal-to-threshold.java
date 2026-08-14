class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int count=0;
        for(int i=0;i<=nums.length-k; i++){
            int sum=0;

            for(int j=i;j<i+k;j++){
                sum=sum+nums[j];
            }
            double avg=(double)sum/k;
        
        if(avg>=threshold){
            count++;
        }}
        return count;
    }
}