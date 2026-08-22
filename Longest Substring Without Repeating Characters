class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        
        // Map to store the last seen index of each character
        // Using an array of size 128 for ASCII characters is faster than HashMap
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            
            // If the character was seen within the current window, move the left pointer
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1;
            }
            
            // Update the last seen position of the current character
            lastSeen[c] = right;
            
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
