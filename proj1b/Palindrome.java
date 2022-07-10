public class Palindrome {

    /** Turns a string to a LinkedListDeque. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> lld = new LinkedListDeque<>();
        char[] c = word.toCharArray();
        for (char cc : c) {
            lld.addLast(cc);
        }
        return lld;
    }

    /** Judges if a string is palindrome. */
    public boolean isPalindrome(String word) {
        if (word.length() == 1 || word.isEmpty()) {
            return true;
        }

        char[] c = word.toCharArray();
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            if (c[i] != c[c.length - i - 1]) {
                flag = false;
            }
        }
        return flag;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1 || word.isEmpty()) {
            return true;
        }

        char[] c = word.toCharArray();
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            if (!cc.equalChars(c[i], c[c.length - i - 1]) && (i != c.length - i - 1)) {
                flag = false;
            }
        }
        return flag;
    }

}
