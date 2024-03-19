import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int size = scanner.nextInt();
        int[] array = new int[size];
        int suma = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            suma+=array[i];
        }
        System.out.println(suma);
    }
}