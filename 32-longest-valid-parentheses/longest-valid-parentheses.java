import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 as a base index to handle edge cases
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Push the index of the opening bracket
                stack.push(i);
            } else {
                // Pop the top element for the closing bracket
                stack.pop();
                if (stack.isEmpty()) {
                    // If stack is empty, push the current index as a new base
                    stack.push(i);
                } else {
                    // Calculate the length of the valid substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
