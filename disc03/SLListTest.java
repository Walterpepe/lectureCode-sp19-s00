import static org.junit.Assert.*;

import org.junit.Test;

public class SLListTest {

    @Test
    public void testOf() {
        SLList s1 = new SLList();
        s1.addFirst(2);
        s1.addFirst(6);
        s1.addFirst(5);

        SLList x = SLList.of(5, 6, 2);
        assertEquals(x, s1);
    }

    @Test
    public void testInsert() {
        // Case 1
        SLList s1 = new SLList();
        s1.addFirst(2);
        s1.addFirst(6);
        s1.addFirst(5);

        s1.insert(10, 1);
        assertEquals(SLList.of(5, 10, 6, 2), s1);

        // Case 2
        SLList s2 = new SLList();
        s2.addFirst(2);
        s2.addFirst(6);
        s2.addFirst(5);

        s2.insert(10, 7);
        assertEquals(SLList.of(5, 6, 2, 10), s2);

    }


    @Test
    public void TestReverse() {
        // Case 1
        SLList s1 = SLList.of(5, 6, 2);
        s1.reverse();
        assertEquals(SLList.of(2, 6, 5), s1);

        // Case 2
        SLList s2 = SLList.of(5);
        s2.reverse();
        assertEquals(SLList.of(5), s2);

        // Case 3
        SLList s3 = SLList.of();
        s3.reverse();
        assertEquals(SLList.of(), s3);
    }

    @Test
    public void TestReverseRecur() {
        // Case 1
        SLList s1 = SLList.of(5, 6, 2, 10);
        s1.reverseRecur();
        assertEquals(SLList.of(10, 2, 6, 5), s1);

        // Case 2
        SLList s2 = SLList.of(5);
        s2.reverseRecur();
        assertEquals(SLList.of(5), s2);

        // Case 3
        SLList s3 = SLList.of();
        s3.reverseRecur();
        assertEquals(SLList.of(), s3);
    }

}
