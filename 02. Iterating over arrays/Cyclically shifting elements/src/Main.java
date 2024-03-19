
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        int size = scanner.nextInt();
        int[] array = new int[size];
        int[] arrayNew = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length - 1; i++) {
            arrayNew[i + 1] = array[i];
        }
        arrayNew[0] = array[array.length - 1];
        for (int i : arrayNew)
            System.out.print(i + " ");
    }
}