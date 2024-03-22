import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        int maximNumber = 0;
        int firstIndex = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (maximNumber < array[i]) {
                maximNumber = array[i];
                firstIndex = i;
            }
        }
        System.out.println(firstIndex);
    }
}