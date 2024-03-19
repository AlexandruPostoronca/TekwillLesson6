import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int size = scanner.nextInt();
        int[] elementsArray = new int[size];
        int sum = 0;

        for (int i = 0; i < elementsArray.length; i++) {
            elementsArray[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();

        for (int i = 0; i < elementsArray.length; i++) {
            if (elementsArray[i] > n) {
                sum += elementsArray[i];
            }
        }
        System.out.println(sum);
    }
}