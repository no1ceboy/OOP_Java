import java.util.Scanner;
public class Stars {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("n = ?");
        int n = keyboard.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ((2*n + 1) - (2*i + 1))/2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k< 2*i + 1; k++) {
                System.out.print("*");
            }
            for (int l = 0; l < ((2*n + 1) - (2*i + 1))/2; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

