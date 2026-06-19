public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: Empty string and empty pattern match
        dp[0][0] = true;

        // Base case: Handle patterns that can reduce to an empty string
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill out the dynamic programming table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char patternChar = p.charAt(j - 1);
                char stringChar = s.charAt(i - 1);

                if (patternChar == '.' || patternChar == stringChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (patternChar == '*') {
                    // Match 0 occurrences of the character before '*'
                    dp[i][j] = dp[i][j - 2];

                    // Match 1 or more occurrences if the preceding character fits
                    char precedingChar = p.charAt(j - 2);
                    if (precedingChar == '.' || precedingChar == stringChar) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[n][m];
    }
}
