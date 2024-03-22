import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Integer array[] = new Integer[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int rotation = scanner.nextInt();

        Collections.rotate(Arrays.asList(array), +rotation);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}