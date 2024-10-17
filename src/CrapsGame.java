import java.util.Scanner;
import java.util.Random;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();
        String continueYN = "";
        String nextRound = "";
        String playGame = "";
        boolean done = false;
        int crapsRoll, die1, die2, roll2;

        System.out.println("Welcome to Craps!\nThe rules are simple:");
        System.out.println("1. Roll Two Dice.\n2. If the sum is 2,3, or 12; You got craps or crapping out and you lose.");
        System.out.println("3. If the sum is 7 or 11 it is a natural and you win!");
        System.out.println("4. For everything else, the sum becomes 'the point' and you keep rolling until you roll a 7 and lose or make the point sum and win!\n");
        System.out.println("Time to Roll!");

        while (!done) {
            System.out.print("Press R to roll or Q to quit: ");
            playGame = in.nextLine();
            if (playGame.equalsIgnoreCase("Q")) {
                done = true;
                System.out.println("Thanks for playing Craps!");
            } else if (playGame.equalsIgnoreCase("R")) {
                die1 = gen.nextInt(6) + 1;
                die2 = gen.nextInt(6) + 1;
                crapsRoll = die1 + die2;
                if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                    System.out.printf("\nYou rolled: %d and %d to make %d\n", die1, die2, crapsRoll);
                    System.out.println("Craps! You lost.");
                } else if (crapsRoll == 7 || crapsRoll == 11) {
                    System.out.printf("\nYou rolled: %d and %d to make %d\n", die1, die2, crapsRoll);
                    System.out.println("Natural! You won.");
                    done = true;
                } else {//if (crapsRoll == 4 || crapsRoll == 5 || crapsRoll == 6 || crapsRoll == 8 || crapsRoll == 9 || crapsRoll == 10)
                    System.out.printf("\nYou rolled: %d and %d to make %d\n", die1, die2, crapsRoll);
                    System.out.printf("The point is: %d\n", crapsRoll);
                    boolean continueGame = true;

                    while (continueGame) {
                        System.out.print("\nPress R to roll again to match the point or Q to quit: ");
                        nextRound = in.nextLine();
                        if (nextRound.equalsIgnoreCase("R")) {
                            die1 = gen.nextInt(6) + 1;
                            die2 = gen.nextInt(6) + 1;
                            roll2 = die1 + die2;

                            if (roll2 == crapsRoll) {
                                System.out.printf("\nYou rolled: %d and %d to make %d\n", die1, die2, roll2);
                                System.out.println("You made the point! You win!");
                                continueGame = false;
                            } else if (roll2 == 7) {
                                System.out.printf("\nYou rolled: %d and %d to make %d\n", die1, die2, roll2);
                                System.out.println("You rolled a 7. You lose!");
                                continueGame = false;
                            } else {
                                System.out.printf("\nYou rolled: %d and %d to make %d\n", die1, die2, roll2);
                                System.out.printf("Keep trying to get the %d!\n", crapsRoll);
                            }
                        } else if (nextRound.equalsIgnoreCase("Q")) {
                            continueGame = false;
                            System.out.println("Thanks for playing Craps!");
                        } else {
                            System.out.println("Invalid input: " + nextRound + "\nPlease select [R/Q]");
                        }
                    }
                }
                do {
                    System.out.println("\nWould you like to play again? [Y/N]: ");
                    continueYN = in.nextLine();
                    if (continueYN.equalsIgnoreCase("Y")) {
                        done = false;
                    } else if (continueYN.equalsIgnoreCase("N")) {
                        done = true;
                    } else {
                        System.out.println("Invalid input: " + continueYN + "\nPlease select [Y/N]");
                    }
                } while (!continueYN.equalsIgnoreCase("Y") && !continueYN.equalsIgnoreCase("N"));
            } else {
                System.out.println("\nInvalid input: " + playGame + "\nPlease select [R/Q]\n");
            }
        }
    }
}