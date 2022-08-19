package codewars.Persistent_Bugger;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Persistent_Bugger {
    public static void main(String[] args) {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, Persistent_Bugger.persistence(39));
        assertEquals(0, Persistent_Bugger.persistence(4));
        assertEquals(2, Persistent_Bugger.persistence(25));
        assertEquals(4, Persistent_Bugger.persistence(999));
    }

    public static int persistence(long n) {
        if (n < 10) return 0;
        return multiple(n, 0);
    }

    public static int multiple(long n, int result) {
        List<Integer> digits = String.valueOf(n).chars().map(Character::getNumericValue).boxed().toList();
        if (digits.size() != 1) {
            int reduce = digits.stream().reduce(1, (a, b) -> a * b);
            result += 1;
            return multiple(reduce, result);
        }
        return result;
    }


    public static int persistenceBest(long n) {
        long m = 1, r = n;
        if (r / 10 == 0)
            return 0;
        for (r = n; r != 0; r /= 10)
            m *= r % 10;
        return persistenceBest(m) + 1;
    }


}
