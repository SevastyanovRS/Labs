package codewars.disemvowel_trolls;

import static org.junit.Assert.assertEquals;

public class DisemvowelTrolls {

    public static void main(String[] args) {
        assertEquals("Ths wbst s fr lsrs LL!", DisemvowelTrolls.disemvowel("This website is for losers LOL!")
        );
        assertEquals("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd",
                DisemvowelTrolls.disemvowel("No offense but,\nYour writing is among the worst I've ever read"));
        assertEquals("Wht r y,  cmmnst?", DisemvowelTrolls.disemvowel("What are you, a communist?"));
    }


    public static String disemvowel(String str) {
        return str.replaceAll("(?i)[aeiou]", "");
    }
}
