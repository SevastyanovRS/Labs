package Yandex;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("5\n1\n0\n1\n0\n1".getBytes());
        System.setIn(in);
        Assert.assertEquals(1, task2());

        in = new ByteArrayInputStream("5\n1\n0\n1\n1\n1".getBytes());
        System.setIn(in);
        Assert.assertEquals(3, task2());

    }

    static int task2() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(r.readLine());
        }
        int resultMaxSeq = 0;
        int currentMaxSeq = 0;

        for (int i: numbers) {
            if (i == 1) {
                ++currentMaxSeq;
                resultMaxSeq = Math.max(currentMaxSeq, resultMaxSeq);
            } else {
                currentMaxSeq = 0;
            }
        }
        return (resultMaxSeq);
    }

}
