
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[3][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        reverseElements(array);
    }

    public static void reverseElements(int[][] twoDimArray) {
        // write your code here
        int[][] newTwoArray = new int[twoDimArray.length][twoDimArray.length];

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray.length; j++) {
                newTwoArray[i][j] = twoDimArray[j][i];
                System.out.println(newTwoArray[i][j]);
            }
        }

    }
}