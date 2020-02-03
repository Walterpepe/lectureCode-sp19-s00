public class PassByWhat {

    public static void value(int x) {
        x = 10;
    }

    public static void main(String[] args) {
        int x = 5;
        value(5);
        System.out.println("after value " + x);
    }
}
