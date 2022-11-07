package Yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task5 {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        char[] ones = r.readLine().toCharArray();
        char[] twos = r.readLine().toCharArray();
        Arrays.sort(ones);
        Arrays.sort(twos);
        if (String.valueOf(ones).equals(String.valueOf(twos))) System.out.println(1);
        else System.out.println(0);
    }

}
