class Solution {
    public int dayOfYear(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        // Days in months for a non-leap year
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Check for leap year
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeap) {
            monthDays[2] = 29;
        }
        
        int dayOfYear = day;
        // Add days of all previous months in the current year
        for (int m = 1; m < month; m++) {
            dayOfYear += monthDays[m];
        }
        
        return dayOfYear;
    }
}
