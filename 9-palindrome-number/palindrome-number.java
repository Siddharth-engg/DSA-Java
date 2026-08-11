class Solution {
    public boolean isPalindrome(int x) {
        int o=x;
        int rev=0;
        while(x>0){
            int ld=x%10;
            rev=rev*10+ld;
            x=x/10;
        }
        if(o==rev){
            return true;
        }
        else
        return false;
    }
}