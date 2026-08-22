class Solution {
public:
    bool halvesAreAlike(string s) {
        int n = s.length() / 2;
        int countA = 0, countB = 0;

        string vowels = "aeiouAEIOU";

        for (int i = 0; i < n; i++) {
            if (vowels.find(s[i]) != string::npos)
                countA++;
        }

        for (int i = n; i < s.length(); i++) {
            if (vowels.find(s[i]) != string::npos)
                countB++;
        }

        return countA == countB;
    }
};
