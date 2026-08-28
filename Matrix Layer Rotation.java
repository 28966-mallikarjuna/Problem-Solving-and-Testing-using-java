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

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        
        int layers = Math.min(m, n) / 2;
        
        for (int layer = 0; layer < layers; layer++) {
            List<Integer> ring = new ArrayList<>();
            
            int r1 = layer, c1 = layer;
            int r2 = m - 1 - layer, c2 = n - 1 - layer;
            
            // 1. Traverse Top edge (left to right)
            for (int j = c1; j <= c2; j++) ring.add(matrix.get(r1).get(j));
            // 2. Traverse Right edge (top to bottom)
            for (int i = r1 + 1; i <= r2; i++) ring.add(matrix.get(i).get(c2));
            // 3. Traverse Bottom edge (right to left)
            for (int j = c2 - 1; j >= c1; j--) ring.add(matrix.get(r2).get(j));
            // 4. Traverse Left edge (bottom to top)
            for (int i = r2 - 1; i > r1; i--) ring.add(matrix.get(i).get(c1));
            
            int len = ring.size();
            int shift = r % len; // Effective rotations
            
            // Rotate the ring elements anti-clockwise by 'shift'
            List<Integer> rotatedRing = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                rotatedRing.add(ring.get((i + shift) % len));
            }
            
            // Put the rotated elements back into the matrix
            int idx = 0;
            for (int j = c1; j <= c2; j++) matrix.get(r1).set(j, rotatedRing.get(idx++));
            for (int i = r1 + 1; i <= r2; i++) matrix.get(i).set(c2, rotatedRing.get(idx++));
            for (int j = c2 - 1; j >= c1; j--) matrix.get(r2).set(j, rotatedRing.get(idx++));
            for (int i = r2 - 1; i > r1; i--) matrix.get(i).set(c1, rotatedRing.get(idx++));
        }
        
        // Print the resultant matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix.get(i).get(j) + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
