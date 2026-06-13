class Solution {

    public int maxDigit(int num) {
        int maxDigit = 0;

        while (num > 0) {
            int ld = num % 10;

            if (ld > maxDigit) {
                maxDigit = ld;
            }

            num /= 10;
        }

        return maxDigit;
    }

    public int maxSum(int[] nums) {
        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (maxDigit(nums[i]) == maxDigit(nums[j])) {
                    ans = Math.max(ans, nums[i] + nums[j]);
                }

            }
        }

        return ans;
    }
}