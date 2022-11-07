package leetcode.GenerateParentheses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) throws IOException {
        System.out.println(generateParenthesis(15));
    }

    //((()))
    //()()()
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generator("", 0, 0, n, result);
        return result;
    }

    public static void generator(String cur, int open, int closed, int n, List<String> result) {
        if (cur.length() == n*2) {
            result.add(cur);
            return;
        }
        if (open < n) {
            generator(cur + "(", open+1, closed, n, result);
        }
        if (closed < open) {
            generator(cur + ")", open, closed+1, n, result);
        }
    }


}
