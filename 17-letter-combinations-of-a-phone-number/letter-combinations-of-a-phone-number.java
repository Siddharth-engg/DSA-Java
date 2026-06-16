import java.util.*;

class Solution {

    static String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;   // important edge case

        let(digits, "", ans);
        return ans;
    }

    public void let(String q, String str, List<String> ans) {

        if (q.length() == 0) {
            ans.add(str);
            return;
        }

        char ch = q.charAt(0);
        int idx = ch - '0';
        String ss = map[idx];

        for (int i = 0; i < ss.length(); i++) {
            let(q.substring(1), str + ss.charAt(i), ans);
        }
    }
}