import java.util.ArrayList;

public class GFG {

    static ArrayList<Integer> search(String pat, String txt) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i <= n - m; i++) {

            int j;

            for (j = 0; j < m; j++) {

                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String txt = "geeksforgeeks";
        String pat = "geeks";

        ArrayList<Integer> result = search(pat, txt);

        System.out.println(result);
    }
}
