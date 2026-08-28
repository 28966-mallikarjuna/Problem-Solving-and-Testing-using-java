import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int n = s.size();
        
        // If the chocolate bar has fewer squares than Ron's birth month, it's impossible
        if (n < m) {
            return 0;
        }
        
        int currentSum = 0;
        
        // Calculate the sum of the first window of size m
        for (int i = 0; i < m; i++) {
            currentSum += s.get(i);
        }
        
        if (currentSum == d) {
            count++;
        }
        
        // Slide the window across the rest of the array
        for (int i = m; i < n; i++) {
            currentSum = currentSum - s.get(i - m) + s.get(i);
            if (currentSum == d) {
                count++;
            }
        }
        
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
