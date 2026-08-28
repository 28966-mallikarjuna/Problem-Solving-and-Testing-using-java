import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean matches(String word, String pattern) {
        int[] p2w = new int[26]; // Pattern to Word mapping
        int[] w2p = new int[26]; // Word to Pattern mapping
        
        // Initialize arrays with -1 to represent no mapping
        for (int i = 0; i < 26; i++) {
            p2w[i] = -1;
            w2p[i] = -1;
        }
        
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c1 = pattern.charAt(i);
            char c2 = word.charAt(i);
            
            int idx1 = c1 - 'a';
            int idx2 = c2 - 'a';
            
            // Check if mapping already exists and conflicts
            if (p2w[idx1] != -1 && p2w[idx1] != c2) {
                return false;
            }
            if (w2p[idx2] != -1 && w2p[idx2] != c1) {
                return false;
            }
            
            // Establish the mapping
            p2w[idx1] = c2;
            w2p[idx2] = c1;
        }
        
        return true;
    }
}
