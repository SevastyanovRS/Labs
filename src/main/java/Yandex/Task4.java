package Yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        if (n < 1 || n > 11) return;

        generator("", 0, 0, n);
    }

    public static void generator(String cur, int open, int closed, int n) {
        if (cur.length() == n*2) {
            System.out.println(cur);
            return;
        }

        if (open < n) {
            generator(cur + "(", open+1, closed, n);
        }
        if (closed < open) {
            generator(cur + ")", open, closed+1, n);
        }
    }

}
