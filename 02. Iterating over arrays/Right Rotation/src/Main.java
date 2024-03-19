import java.util.Scanner;
import java.util.Arrays;

class Main {

    public static void rotate(int[] arr, int k) {
        // write your code here
    }

    // do not change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}