package NUMBER_GAME;

import java.util.Random;
import java.util.Scanner;

public class GesstheNumber {
    public static void main(String[] args) {
        Random r = new Random();
        //here we set limit between 1  to 100

        int round = 0 , win_count = 0;

        while (round < 3) {
            int number = r.nextInt(1 , 100);
            int Number_of_attempts = 0;
            boolean flag = true;
            while (flag && Number_of_attempts < 10) {
                System.out.println("you have " + (10 - Number_of_attempts) + "  attempts left");
                System.out.println("Guess the number between 1 to 100");
                System.out.println("Enter your guess between 1 to 100");
                Scanner sc = new Scanner(System.in);
                int guess = sc.nextInt();
                Number_of_attempts++;
                if (guess == number) {
                    System.out.println("You guessed it right");
                    win_count++;
                    flag = false;
                    break;
                } else if (guess < number) {
                    System.out.println("Your guess is too low ");
                    System.out.println();
                } else if (guess > number) {
                    System.out.println("Your guess is too high ");
                    System.out.println();
                }
                System.out.println(number);
            }
            round++;
            System.out.println("======================================================");
            if (Number_of_attempts == 10) {
                System.out.println("You lose the game");
            }
            System.out.println("Game stage "+ round +" Over");
            //here minimum score is 1 and maximum score is 10
            System.out.println("your score is " + (10 - Number_of_attempts) +"  out of 10");
            System.out.println("======================================================");
        }
        if (win_count == 3) {
            System.out.println("you won the All the game");
        }

    }
}
