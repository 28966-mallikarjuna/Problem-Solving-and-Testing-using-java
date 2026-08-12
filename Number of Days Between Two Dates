class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(countDays(date1) - countDays(date2));
    }
    
    // Helper function to check if a year is a leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    // Helper function to calculate total days from year 1971-01-01 to the given date
    private int countDays(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        int days = day;
        
        // Days in months for a non-leap year
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Add days for completed months in the current year
        for (int m = 1; m < month; m++) {
            if (m == 2 && isLeapYear(year)) {
                days += 29;
            } else {
                days += monthDays[m];
            }
        }
        
        // Add days for completed years from 1971 up to year - 1
        for (int y = 1971; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }
        
        return days;
    }
}
