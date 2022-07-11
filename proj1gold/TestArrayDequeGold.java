import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {
    @Test
    public void testDequeRandomly() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < 12; ++i) {
            int temp = StdRandom.uniform(10);
            if (temp < 5) {
                sad.addFirst(temp);
                ads.addFirst(temp);
                tmp.append("addFirst(").append(temp).append(")").append("\n");

            } else {
                sad.addLast(temp);
                ads.addLast(temp);
                tmp.append("addLast(").append(temp).append(")").append("\n");
            }
        }
        for (int i = 0; i < 3; ++i) {
            assertEquals(tmp + "removeFirst()\n", sad.removeFirst(), ads.removeFirst());
        }

        for (int i = 0; i < 3; ++i) {
            assertEquals(tmp + "removeLast()\n", sad.removeLast(), ads.removeLast());
        }
    }
}
