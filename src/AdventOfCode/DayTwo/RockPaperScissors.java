// Alexander Jenkins
// 2022-12-02

package AdventOfCode.DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/*
 *  Advent of Code - 2022
 *  Day Two, Part One
 *
 *  Rock, Paper and Scissors
 *  
 *  Rules: Rock < Paper < Scissors < Rock
 *
 *  Scoring:
 *      - Rock = 1pt
 *      - Paper = 2pt
 *      - Scissors = 3pt
 *      - Loss = 0pt
 *      - Draw = 3pt
 *      - Win = 6pt
 *
 *  Part 1: read the file in and see how many points you would get.
 *
 */

public class RockPaperScissors {
    public static void main(String[] args) {
        try {
            File rounds = new File("./src/AdventOfCode/DayTwo/tournamentRounds.txt");
            
            // figure out how many points I have
            partOne(rounds);

        } catch (FileNotFoundException e) {
            System.out.println("Encountered and error opening the file.");
            e.printStackTrace();
        }

    }

    private static void partOne(File rounds) throws FileNotFoundException { 
        Scanner r = new Scanner(rounds);

        // create a list to hold each individual round
        List<String> roundList = new ArrayList<String>();

        while(r.hasNextLine()) {
            roundList.add(r.nextLine().trim());
        }

        // parse each round as a tuple and add up the scores
        int score = 0;
        for (String rd : roundList) score += roundScore(rd);
        System.out.printf("Your Total: %d%n", score);

    }

    private static int opponentPoints(char move) {
        return switch(move) {
            case 'A' -> 1;                              // 1 for rock
            case 'B' -> 2;                              // 2 for paper
            case 'C' -> 3;                              // 3 for scissors
            default -> 0;
        };
    }

    private static int playerPoints(char move) {
        return switch(move) {
            case 'X' -> 1;                              // 1 for rock
            case 'Y' -> 2;                              // 2 for paper
            case 'Z' -> 3;                              // 3 for scissors
            default -> 0;
        };
    }

    private static int roundScore(String rd) {
        int opponent = opponentPoints(rd.charAt(0));
        int player = playerPoints(rd.charAt(rd.length() - 1));

        // calc the round result
        return switch(rd) {
            case "A X", "B Y", "C Z" -> player + 3;     // draw case
            case "A Y", "B Z", "C X" -> player + 6;     // win case
            case "A Z", "B X", "C Y" -> player;         // loss case
            default -> -1;                              // something went wrong here...
        };
    }

}
