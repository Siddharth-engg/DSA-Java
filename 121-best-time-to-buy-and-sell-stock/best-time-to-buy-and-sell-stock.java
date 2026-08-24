class Solution {
    public int maxProfit(int[] prices) {
        
        int mp=Integer.MIN_VALUE;
        int bp=Integer.MAX_VALUE;
        int p=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<bp){
                bp=prices[i];
            }
            p=prices[i]-bp;
            mp=Math.max(mp,p);

        }
        return mp;
    }
}