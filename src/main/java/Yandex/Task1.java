package Yandex;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class Task1 {

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("ab\nbaabab".getBytes());
        System.setIn(in);
        Assert.assertEquals(6, task1());

        in = new ByteArrayInputStream("ab\nbaab".getBytes());
        System.setIn(in);
        Assert.assertEquals(4, task1());

    }

    static int task1() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String j = r.readLine();
        String s = r.readLine();
        List<Character> collect = j.chars().mapToObj(c -> (char) c).toList();
        return (int) s.chars().mapToObj(c -> (char) c).filter(collect::contains).count();
    }
}