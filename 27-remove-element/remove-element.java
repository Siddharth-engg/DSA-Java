class Solution {
    public int removeElement(int[] nums, int val) {
        int w=0;
        for(int i=0;i<=nums.length-1;i++){
            if(nums[i]!=val){
                nums[w]=nums[i];
                w++;
            }
        }
        return w;
    }
}