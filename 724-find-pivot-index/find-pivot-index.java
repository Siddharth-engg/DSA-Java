class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int s1=0;

        for(int i=0;i<n;i++){
            int s2=0;
          for(int j=i+1;j<n;j++){

            s2+=nums[j];
          }
          if(s1==s2){
            return i;
          }
          s1+=nums[i];

        }
        
        return -1;
        
    }
}