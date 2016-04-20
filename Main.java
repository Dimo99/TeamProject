import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose if you want to play Bull and Cows-1 or Question matrix -2");
        Scanner console = new Scanner(System.in);
        int n;
        BullsAndCows bullAndCowsRunner = new BullsAndCows();
        Questions questionRunner = new Questions();
        n = console.nextInt();
        switch (n)
        {
            case 1: bullAndCowsRunner.runBullAndCows(); break;
            case 2:questionRunner.runQuestionGame(); break;
        }
    }
}