import java.util.Arrays;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        
        // Initialize the index array
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices in descending order of heights
        Arrays.sort(indices, (a, b) -> Integer.compare(heights[b], heights[a]));
        
        // Build the result names array using the sorted indices
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = names[indices[i]];
        }
        
        return sortedNames;
    }
}
