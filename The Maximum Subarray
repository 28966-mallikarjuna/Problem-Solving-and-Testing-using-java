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

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxSubarraySum = arr.get(0);
        int currentMax = arr.get(0);
        
        int maxSubsequenceSum = 0;
        int maxElement = arr.get(0);
        boolean hasPositive = false;

        for (int num : arr) {
            // Maximum Element tracking (for edge case when all numbers are negative)
            maxElement = Math.max(maxElement, num);
            
            // Subsequence Sum: Add all positive numbers
            if (num > 0) {
                maxSubsequenceSum += num;
                hasPositive = true;
            }
        }

        // 1. Calculate Maximum Subarray using Kadane's algorithm
        for (int i = 1; i < arr.size(); i++) {
            int num = arr.get(i);
            currentMax = Math.max(num, currentMax + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentMax);
        }

        // 2. If no positive numbers exist, max subsequence sum is the largest negative element
        if (!hasPositive) {
            maxSubsequenceSum = maxElement;
        }

        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
