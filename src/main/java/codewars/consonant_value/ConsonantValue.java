package codewars.consonant_value;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ConsonantValue {
    public static void main(String[] args) {
        assertEquals(solve("zodiac"), 26);
        assertEquals(solve("chruschtschov"), 80);
        assertEquals(solve("khrushchev"), 38);
        assertEquals(solve("strength"), 57);
        assertEquals(solve("catchphrase"), 73);
        assertEquals(solve("twelfthstreet"), 103);
        assertEquals(solve("mischtschenkoana"), 80);
    }

    public static int solve(final String s) {
        s.chars().boxed().forEach(c -> System.out.println(c.intValue()));
        return Arrays.stream(s.split("([AaEeIiOoUu])")).mapToInt(con -> con.chars().map(c -> c - 96).sum()).max().getAsInt();
    }
}
