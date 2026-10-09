class Solution {
    public int maxSubArray(int[] nums) {
        int x=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            x=nums[i]+x;

             max=Math.max(max,x);
        if(x<0){
            x=0;
        }
           
        }
       return max;
    }
}