import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> resultSet = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Skip comparing a word with itself
                if (i == j) {
                    continue;
                }
                
                // If words[i] is a substring of words[j], add it to our set
                if (words[j].contains(words[i])) {
                    resultSet.add(words[i]);
                    break; // No need to check other words for this words[i] once matched
                }
            }
        }
        
        return new ArrayList<>(resultSet);
    }
}
