package synthesizer;
import org.junit.Test;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(10);
        arb.enqueue(1);
        arb.enqueue(12);
        arb.enqueue(13);
        arb.enqueue(14);
        arb.enqueue(15);
        arb.enqueue(17);
        arb.enqueue(18);
        arb.enqueue(145);
        arb.enqueue(76);
        arb.enqueue(13);

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
