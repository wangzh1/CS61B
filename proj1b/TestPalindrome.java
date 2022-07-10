import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {

        CharacterComparator obn = new OffByN(5);
        CharacterComparator obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("binding", obn));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("noob"));
        assertTrue(palindrome.isPalindrome("AbA"));
        assertTrue(palindrome.isPalindrome("2323232"));
        assertTrue(palindrome.isPalindrome("AbB", obo));
        assertTrue(palindrome.isPalindrome("&b%", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("a", obo));
    }
}
