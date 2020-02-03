public class Arrays {

    // problem 2.1
    public static int[] insert(int[] arr, int item, int position) {

        int[] a = new int[arr.length + 1];

        if (position > arr.length) {
            position = arr.length;
        }

        System.arraycopy(arr, 0, a, 0, position);
        a[position] = item;
        if (position != arr.length) {
            System.arraycopy(arr, position, a, position + 1, arr.length - position);
        }

        return a;
    }

    // problem 2.2
    // NOTE: 答案用交换两头的值来实现。
    public static void reverse(int[] arr) {

        int a[] = new int[arr.length];

        int index = arr.length - 1;
        for (int item : arr) {
            a[index--] = item;
        }

        System.arraycopy(a, 0, arr, 0, arr.length);
    }

    // problem 2.3
    public static int[] replicate(int[] arr) {

        int length = 0;
        for (int item : arr) {
            length += item;
        }

        int a[] = new int[length];

        int index = 0;
        for (int item : arr) {
            int j = item;
            while(j != 0){
                a[index++] = item;
                j--;
            }
        }

        return a;
    }
}
