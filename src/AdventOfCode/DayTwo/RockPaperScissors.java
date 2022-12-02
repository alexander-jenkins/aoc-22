// Alexander Jenkins
// 2022-12-02

package AdventOfCode.DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        try {
            File rounds = new File("./src/AdventOfCode/DayTwo/tournamentRounds.txt");
            Scanner r = new Scanner(rounds);

            
            while (r.hasNextLine()) {
                var line = r.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Encountered and error opening the file.");
            e.printStackTrace();
        }

    }

}
