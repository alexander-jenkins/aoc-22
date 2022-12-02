// Alexander Jenkins
// 2022-12-01

package AdventOfCode.DayOne;

// import files
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalorieCounting {
    public static void main(String[] args) {

        // read the data into memory
        try {
            File elves = new File("./src/AdventOfCode/DayOne/dayOne.txt");
            Scanner r = new Scanner(elves);
       
            // go through the file
            int mostCals = 0;
            int tempSum = 0;
            while (r.hasNextLine()) {
                var token = r.nextLine();
                if (token.equals("")) {
                    mostCals = tempSum > mostCals ? tempSum : mostCals;
                    tempSum = 0;
                    continue;
                }
                tempSum += Integer.parseInt(token);
            }
            r.close();
            System.out.printf("One elf has %d calories available!", mostCals);
        } catch (FileNotFoundException e) {
            System.out.println("An error occured when opening the file");
            e.printStackTrace();
        }


    }
}
