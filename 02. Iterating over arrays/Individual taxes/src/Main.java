import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] array = new int[2][N+1];

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
                if (i==2){
                    array[i][j]=array[i-1][j]* scanner.nextInt();
                }
                System.out.print(array[i][j]+" ");
            }
        }
    }
}