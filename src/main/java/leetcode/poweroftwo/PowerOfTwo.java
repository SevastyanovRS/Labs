package leetcode.poweroftwo;

import java.util.StringJoiner;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(256));
        System.out.println(isPowerOfTwo(255));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo2(1073741825));
        System.out.println(isPowerOfTwo(9));
        System.out.println(isPowerOfTwo(27));

    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        for (long i = 1; i <= n;) {
            i = i * 3;
            System.out.println(i);
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPowerOfTwo2(int n) {
        if(n<=0)
            return false;
        return ((n&(n-1))==0);
    }
}
