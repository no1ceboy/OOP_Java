import java.util.Scanner;
public class DayofMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String monthRaw;
        int year = 0;
        int month = 0;

        boolean valid = false;

        while (!valid) {
            System.out.println("Enter the month:");
            monthRaw = keyboard.next();

            System.out.println("Enter the year:");
            year = keyboard.nextInt();

            month = validMonth(monthRaw);

            if (validMonth(monthRaw) != 0 && validYear(year)) {
                valid = true;
            } else {
                System.out.println("Invalid month of year");
            }
        }

        int num = NumOfDay(month, year);
        System.out.println("The number of days is " + num);

    }

    public static int validMonth(String month) {
        switch (month.toLowerCase()) { case "january":
            case "jan":
            case "jan.":
            case "1":
                return 1;
            case "february":
            case "feb":
            case "feb.":
            case "2":
                return 2;
            case "march":
            case "mar":
            case "mar.":
            case "3":
                return 3;
            case "april":
            case "apr":
            case "apr.":
            case "4":
                return 4;
            case "may":
            case "5":
                return 5;
            case "june":
            case "jun":
            case "jun.":
            case "6":
                return 6;
            case "july":
            case "jul":
            case "7":
                return 7;
            case "august":
            case "aug":
            case "aug.":
            case "8":
                return 8;
            case "september":
            case "sep":
            case "sep.":
            case "9":
                return 9;
            case "october":
            case "oct":
            case "oct.":
            case "10":
                return 10;
            case "november":
            case "nov":
            case "nov.":
            case "11":
                return 11;
            case "december":
            case "dec":
            case "dec.":
            case "12":
                return 12;
            default:
                return 0; 
        }
    }

    public static boolean validYear(int year) {
        if (year >= 0) {
            return true;
        } else {
            return false;
        }   
    }

    public static int NumOfDay(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}