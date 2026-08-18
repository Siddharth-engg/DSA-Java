class Solution {
    public int[] decrypt(int[] nums, int k) {

        int[] ans = new int[nums.length];

        if (k > 0) {

            for (int i = 0; i < nums.length; i++) {
                int sum = 0;

                for (int j = 1; j <= k; j++) {
                    sum += nums[(i + j) % nums.length];
                }

                ans[i] = sum;
            }

        } else if (k < 0) {

            for (int i = 0; i < nums.length; i++) {
                int sum = 0;

                for (int j = 1; j <= -k; j++) {
                    sum += nums[(i - j + nums.length) % nums.length];
                }

                ans[i] = sum;
            }

        }

        return ans;
    }
}