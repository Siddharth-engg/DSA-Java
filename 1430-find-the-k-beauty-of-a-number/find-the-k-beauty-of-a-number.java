class Solution {
    public int divisorSubstrings(int num, int k) {
        int c=0;
        int div=(int)Math.pow(10,k);
        int original=num;
        while(num>=div/10){
            int sub=num % div;
            if(sub!=0 && original % sub==0){
                c++;
            }
            num=num/10;
        }
        return c;

    }
}