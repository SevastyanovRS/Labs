package Yandex;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        if (n < 1) return;

        int last = r.nextInt();
        System.out.println(last);
        int current;
        for (int i = 1; i < n; i++) {
            current = r.nextInt();
            if (current != last) {
                last = current;
                System.out.println(last);
            }
        }
    }
}
