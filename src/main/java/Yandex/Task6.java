package Yandex;

import org.junit.Assert;

import java.awt.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task6 {

    private static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream((
                """
                        7
                        0 0
                        0 2
                        2 2
                        0 -2
                        2 -2
                        2 -1
                        2 1
                        2
                        1 3""").getBytes());
        System.setIn(in);
        Assert.assertEquals(2, travel());

        in = new ByteArrayInputStream((
                """
                        4
                        0 0
                        1 0
                        0 1
                        1 1
                        2
                        1 4""").getBytes());
        System.setIn(in);
        Assert.assertEquals(1, travel());


    }

    static int travel() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int tn = Integer.parseInt(r.readLine());

        ArrayList<Point> arrayList = new ArrayList<>();
        for (int i = 0; i < tn; i++) {
            String[] s = r.readLine().split(" ");
            arrayList.add(new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }

        int range = Integer.parseInt(r.readLine());

        String[] fromTo = r.readLine().split(" ");
        Point from = arrayList.remove(Integer.parseInt(fromTo[0])-1);
        arrayList.add(0, from);

        Point to = arrayList.get(Integer.parseInt(fromTo[1])-1);
        move(from, to, arrayList, range, 0);
        return(min != Integer.MAX_VALUE ? min : -1);

    }
    public static void move(Point from, Point to, ArrayList<Point> arrayList, int range, int moves) {
        if (from.equals(to) && moves < min) {
            min = moves;
        }

        for (int i = 0; i < arrayList.size(); i++) {
            int currentMoves = moves;
            if (arrayList.get(i).distance(from) <= range) {
                ArrayList<Point> copy = new ArrayList<>(arrayList);
                move(copy.remove(i), to, copy, range, ++currentMoves);
            }
        }
    }

}
