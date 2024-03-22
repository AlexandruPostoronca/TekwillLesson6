import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        int number = 0;
        boolean sorted = true;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            if (number <= array[i]) {
                number = array[i];
            } else {
                sorted = false;
            }
        }
        System.out.println(sorted);
    }
}