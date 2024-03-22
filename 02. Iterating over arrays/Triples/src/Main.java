
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        int tripleCounter = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length-1; i++) {
            if (i == 0) {
                continue;
            }
            if ((array[i] == array[i + 1] - 1) && array[i] == array[i - 1] + 1) {
                ++tripleCounter;
            } //else if ((array[i] == array[i + 1]) && array[i] == array[i - 1]) {
               // ++tripleCounter;
//            } else if ((array[i] == array[i - 1] - 1) && array[i] == array[i + 1] + 1) {
//                ++tripleCounter;
//            }
        }
        System.out.println(tripleCounter);
    }
}