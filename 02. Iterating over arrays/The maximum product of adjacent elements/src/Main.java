import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] array = new int[size];
        int firstProduct = 0;
        int secondProduct = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            firstProduct *= array[i];
            if (secondProduct < firstProduct) {
                secondProduct = firstProduct;
            }
            firstProduct = array[i];
        }
        System.out.println(secondProduct);
    }
}