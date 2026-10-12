import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        // Build frequency map for all words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Slide the window for each possible offset (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String subWord = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(subWord)) {
                    windowMap.put(subWord, windowMap.getOrDefault(subWord, 0) + 1);
                    count++;

                    // If the word count exceeds the allowed count, shrink from left
                    while (windowMap.get(subWord) > wordMap.get(subWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If all words match
                    if (count == numWords) {
                        result.add(left);
                        // Shift left by one word to search for next valid window
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // Not a valid word, reset the window
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
