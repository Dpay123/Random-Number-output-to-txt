import java.io.*;
import java.util.Random;

/** this program runs from command line input
 * user specifies # of simulations to run and the output file
 * simulation chooses random number
 * each result is written to the output file
 */

public class random2 {

    int pickRandom() {
        // set range
        int max = 100;
        int min = 1;
        // create instance of random class
        Random randomNum = new Random();
        return (min + randomNum.nextInt(max));
    }

    public static void main(String[] args) throws IOException {
        String outFile = "";
        String inRuns = "";
        int runs = 0;
        // run only if specified # of simulations and output file
        if(args.length == 2) {
            // store user command input in variable
            inRuns = args[0];
            runs = Integer.parseInt(inRuns);
            outFile = args[1];
        } else {
            System.out.println("Usage: Java random2.java <simulations #> <outputfile.txt>");
        }

        // create file writer for output file
        FileWriter writer = new FileWriter(outFile);
        // run simulation x times and write each result to output file
        for(int i = 0; i < runs; i++) {
            random2 simulation = new random2();
            int result = simulation.pickRandom();
            writer.write(result + "\n");
        }
        writer.close();
        return;
    }
}