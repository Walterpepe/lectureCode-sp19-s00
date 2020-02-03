public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public SLList() {
        first = new IntNode(-1, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int item, int position) {

        IntNode ptr = first;
        int index = 0;
        while(true){
            if (position == index || ptr.next == null){
                IntNode insertNode = new IntNode(item, ptr.next);
                ptr.next = insertNode;
            }
            ptr = ptr.next;
            index++;
        }

    }

}