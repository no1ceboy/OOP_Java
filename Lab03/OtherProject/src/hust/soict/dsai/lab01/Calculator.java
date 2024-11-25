import javax.swing.JOptionPane;
public class Calculator {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null,
                                        "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null,
                                        "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = 0;
        if (num2 != 0) {
            quotient = num1 / num2;
            JOptionPane.showMessageDialog(null, "The sum, difference, product and quotient are " + sum + "," + difference + "," + product + "," + quotient);
        }
        else {
            JOptionPane.showMessageDialog(null, "Denominator can not be 0");
            JOptionPane.showMessageDialog(null, "The sum, difference, product are " + sum + "," + difference + "," + product);
        }
        System.exit(0);
    }
}
