// Alexander Jenkins
// 2022-12-02

package AdventOfCode.DayOne;

// import files
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;

public class CalorieCounting {
    public static void main(String[] args) {

        // read the data into memory
        try {
            File elves = new File("./src/AdventOfCode/DayOne/dayOne.txt");
            Scanner r = new Scanner(elves);
       
            // Create a PriorityQueue in reverse order for the sums
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

            // go through the file
            int tempSum = 0;
            while (r.hasNextLine()) {
                var token = r.nextLine();
                if (token.equals("")) {
                    queue.add(tempSum);
                    tempSum = 0;
                    continue;
                }
                tempSum += Integer.parseInt(token);
            }
            r.close();
            System.out.printf("The top three elves have a total of %d calories.%n", queue.poll() + queue.poll() + queue.poll());
        } catch (FileNotFoundException e) {
            System.out.println("An error occured when opening the file");
            e.printStackTrace();
        }

    }
}
