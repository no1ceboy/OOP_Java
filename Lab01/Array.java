import java.util.Scanner;
import java.util.Arrays;
public class Array {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = keyboard.nextInt();
        int array[] = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = keyboard.nextInt();
        }

        Arrays.sort(array);

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = (double) sum / n;
        
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("The sum of all elements is " + sum);
        System.out.println("The average of all elements is " + average);
    }
}
