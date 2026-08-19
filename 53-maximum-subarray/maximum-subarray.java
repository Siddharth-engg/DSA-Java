class Solution {
    public int maxSubArray(int[] nums) {
        int c=0;
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            c=c+nums[i];
            
            
            mx=Math.max(c,mx);
            if(c<0){
                c=0;
                
            }
        }
        return mx;
    }
}