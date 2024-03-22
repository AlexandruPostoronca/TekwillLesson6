import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        boolean compare = false;

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int compareNumber = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == compareNumber) {
                compare = true;
                break;
            }
        }
        System.out.println((compare) ? true : false);
    }
}