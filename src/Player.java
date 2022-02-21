public class Player {

    public static void main(String[] args) {
        test();

    }

    private static void test() {
        boolean b = true;
        for (int i = 0; i < 3; i++) {
            System.out.println(b + " " + i);
            b = !b;
        }

    }
}
