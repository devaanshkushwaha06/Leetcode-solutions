import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        String cleaned = paragraph.toLowerCase().replaceAll("[^a-z\\s]", " ");

        String[] words = cleaned.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}