import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysTest {

    @Test
    public void TestInsert() {
        int[] arr = new int[]{5, 9, 14, 15};
        int[] after = Arrays.insert(arr, 6, 2);

        assertArrayEquals(after, new int[]{5, 9, 6, 14, 15});
    }

    @Test
    public void TestReverse() {
        int[] arr = new int[]{1, 2, 3};
        Arrays.reverse(arr);

        assertArrayEquals(new int[]{3, 2, 1}, arr);
    }

    @Test
    public void TestReplicate() {

        int[] after = Arrays.replicate(new int[]{3, 2, 1});

        assertArrayEquals(new int[]{3, 3, 3, 2, 2, 1}, after);
    }

}
