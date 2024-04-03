import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] array = new int[size][size];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        boolean result = true;
        for (int i = 0; i < array.length && result != false; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i > j) continue;
                if (array[i][j] != array[j][i]) {
                    result = false;
                    break;
                }
            }
        }
        System.out.println(result ? "YES" : "NO");
    }
}