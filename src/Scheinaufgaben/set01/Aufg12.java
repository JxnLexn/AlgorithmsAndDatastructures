package Scheinaufgaben.set01;

public class Aufg12 {
    public static void main(String[] args) {
        int x = 0;
        for (int n = 1; n < 1000; n++) {
            for (int j = 2 * n; j >= 1; j--) {
                for (int v = 0; v < j; v++) {
                    x++;
                }
            }
            System.out.print("n = " + n + "  ");
            System.out.println("x = " + x);
            x = 0;
        }
    }
}
