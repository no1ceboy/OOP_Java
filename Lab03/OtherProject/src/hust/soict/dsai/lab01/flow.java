public class flow {
    public static void main(String[] args) {
        int num = 2;
        if (num > 2) {
            System.out.println(num);
        }
        else if (num == 2) {
            System.out.println(++num);
        }
        else {
            System.out.println(--num);
        }
        int score = 100;
        boolean active = true;
        if (score >= 60 && active == true) {
            System.out.println("Your score is " + score);
        }
    }
}