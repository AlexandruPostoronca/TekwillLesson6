import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Write your solution here
        int[] arrays1 = {1, 2, 3, 4};
        int[] arrays2 = {1, 2, 3, 4};
        int[] arrays3 = {4, 3, 2, 1};
        int[] arrays4 = {1, 2, 3,};

        System.out.println(Arrays.equals(arrays2, arrays3));
        System.out.println(Arrays.equals(arrays1, arrays2));
        System.out.println(Arrays.equals(arrays1, arrays1));
        System.out.println(Arrays.equals(arrays3, arrays1));
        System.out.println(Arrays.equals(arrays1, arrays4));
    }
}