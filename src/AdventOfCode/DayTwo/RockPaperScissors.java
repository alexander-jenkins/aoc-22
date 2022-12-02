// Alexander Jenkins
// 2022-12-02

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        try {
            File rounds = new File("./src/AdventOfCode/DayTwo/tournamentRounds.txt");
            Scanner r = new Scanner(rounds);

            

        } catch (FileNotFoundException e) {
            System.out.println("Encountered and error opening the file.");
            e.printStackTrace();
        }

    }

    enum Round = {
        ROCK (1), // 'a' or 'x'
        PAPER (2), // 'b' or 'y'
        SCISSORS (3), // 'c' or 'z'
        LOSS (0),
        DRAW (3),
        WIN (6);

        private final char playerOne;
        private final char playerTwo;

        Round(char p1, char p2) {
            playerOne = p1;
            playerTwo = p2;
        }

        private String roundResult(Round r) {
            return switch(String.format("%s%s", r.playerOne, r.playerTwo)) {
                case "AX", "BY", "CZ" -> DRAW;
                case "CX", "YA", "BZ" -> WIN;
                default -> LOSS;
            }
        }

        int value() {
            return matchResult() + 

    }

}
