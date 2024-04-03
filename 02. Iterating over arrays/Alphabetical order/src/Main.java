import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String lne = scanner.nextLine();

        String[] strArr = lne.split(" ");

        boolean result = true;
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i - 1].compareTo(strArr[i]) > 0) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}