package codewars.YouraSquare;

import static org.junit.Assert.assertEquals;

public class YoureSquare {
    public static void main(String[] args) {
        assertEquals("negative numbers aren't square numbers", false, YoureSquare.isSquare(-1));
        assertEquals("0 is a square number (0 * 0)",    true,   YoureSquare.isSquare(0));
        assertEquals("3 isn't a square number", false,  YoureSquare.isSquare(3));
        assertEquals("4 is a square number (2 * 2)",    true,   YoureSquare.isSquare(4));
        assertEquals("25 is a square number (5 * 5)",   true,   YoureSquare.isSquare(25));
        assertEquals("26 isn't a square number",false,  YoureSquare.isSquare(26));
    }

    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }
}
