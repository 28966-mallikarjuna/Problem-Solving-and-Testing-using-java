class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int i = 0;
        int n = s.length();
        
        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // If the string was all spaces
        if (i == n) {
            return 0;
        }
        
        // 2. Check sign
        int sign = 1;
        char firstChar = s.charAt(i);
        if (firstChar == '-') {
            sign = -1;
            i++;
        } else if (firstChar == '+') {
            i++;
        }
        
        // 3. Convert digits and handle overflow
        long result = 0; // Use long to detect overflow before clamping
        while (i < n) {
            char c = s.charAt(i);
            
            // Stop if character is not a digit
            if (c < '0' || c > '9') {
                break;
            }
            
            result = result * 10 + (c - '0');
            
            // 4. Handle 32-bit signed integer overflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            i++;
        }
        
        return (int) (result * sign);
    }
}
