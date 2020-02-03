import java.util.Formatter;

public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(-1, null);
        size = 0;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    // solution to problem 1.1
    public void insert(int item, int position) {

        IntNode ptr = sentinel;
        int index = 0;
        while (true) {
            if (position == index || ptr.next == null) {
                IntNode insertNode = new IntNode(item, ptr.next);
                ptr.next = insertNode;
                size++;
                break;
            }
            ptr = ptr.next;
            index++;
        }

    }

    // problem 1.2
    public void reverse() {

        if (size == 0) {
            return;
        }

        IntNode ptr0 = sentinel.next;
        IntNode ptr1 = sentinel.next.next;
        ptr0.next = null;

        while (ptr1 != null) {

            IntNode tmp = ptr1.next;

            ptr1.next = ptr0;

            ptr0 = ptr1;
            ptr1 = tmp;
        }

        sentinel.next = ptr0;

    }

    // problem 1.3 递归版本
    // @source 参考了答案，没看懂写递归的思路。
    public void reverseRecur() {
        sentinel.next = reverseHelper(sentinel.next);
    }

    private IntNode reverseHelper(IntNode lst) {
        if (lst == null || lst.next == null) {
            return lst;
        } else {
            IntNode endOfReversed = lst.next;
            IntNode reversed = reverseHelper(lst.next);
            endOfReversed.next = lst;
            lst.next = null;
            return reversed;
        }
    }

    // 从IntList拷贝，做了一些修改。

    /**
     * DO NOT MODIFY ANYTHING BELOW THIS LINE! Many of the concepts below here
     * will be introduced later in the course or feature some form of advanced
     * trickery which we implemented to help make your life a little easier for
     * the lab.
     */

    @Override
    public int hashCode() {
        return size;
    }

    /**
     * Returns a new IntList containing the ints in ARGS. You are not
     * expected to read or understand this method.
     */
    public static SLList of(Integer... args) {
        SLList result = new SLList();

        int k;
        for (k = args.length - 1; k >= 0; k--) {
            result.addFirst(args[k]);
        }
        return result;
    }

    /**
     * Returns true iff X is an IntList containing the same sequence of ints
     * as THIS. Cannot handle IntLists with cycles. You are not expected to
     * read or understand this method.
     */
    public boolean equals(Object x) {
        if (!(x instanceof SLList)) {
            return false;
        }
        SLList SL = (SLList) x;
        IntNode L = SL.sentinel.next;
        IntNode p;

        for (p = this.sentinel.next; p != null && L != null; p = p.next, L = L.next) {
            if (p.item != L.item) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }

    /**
     * If a cycle exists in the IntList, this method
     * returns an integer equal to the item number of the location where the
     * cycle is detected.
     * <p>
     * If there is no cycle, the number 0 is returned instead. This is a
     * utility method for lab2. You are not expected to read, understand, or
     * even use this method. The point of this method is so that if you convert
     * an IntList into a String and that IntList has a loop, your computer
     * doesn't get stuck in an infinite loop.
     */

    private int detectCycles(SLList A) {
        IntNode tortoise = A.sentinel.next;
        IntNode hare = A.sentinel.next;

        if (A == null) {
            return 0;
        }

        int cnt = 0;


        while (true) {
            cnt++;
            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                return 0;
            }

            tortoise = tortoise.next;

            if (tortoise == null || hare == null) {
                return 0;
            }

            if (hare == tortoise) {
                return cnt;
            }
        }
    }

    @Override
    /** Outputs the IntList as a String. You are not expected to read
     * or understand this method. */
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(this);
        int cnt = 0;

        for (IntNode p = this.sentinel.next; p != null; p = p.next) {
            out.format("%s%d", sep, p.item);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }
}