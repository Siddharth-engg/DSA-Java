class Solution {
    public int maxSubArray(int[] nums) {
        int a=0;
        int mx=Integer.MIN_VALUE;
       
        for(int i=0;i<nums.length;i++){
            a=a+nums[i];
            mx=Math.max(a,mx);
            if(a<0){
                a=0;
            }

        }
        return mx;
    }
}