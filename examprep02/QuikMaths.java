import java.util.Arrays;

public class QuikMaths {

    public static void main(String[] args) {

        int[] arr;
        arr = new int[]{2, 3, 3, 4};

        for (int x: arr) {
            x = x * 3;
        }

        System.out.println(Arrays.toString(arr));

    }
}