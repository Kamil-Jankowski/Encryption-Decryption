package encryptdecrypt;

import java.util.Scanner;
import java.io.*;

class ReadAndWrite {

    static String readFromFile(String inputPath) throws FileNotFoundException {
        File file = new File(inputPath);
        String inputString = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                inputString = inputString.concat(scanner.nextLine()).concat("\n");
            }
        } catch (IOException e){
            throw new FileNotFoundException();
        }
        return inputString;
    }

    static void writeToFile(String outputPath, String message) {
        try{
            File file = new File(outputPath);
            FileWriter writer = new FileWriter(file);
            writer.write(message);
            writer.close();
            System.out.println("File " + outputPath + " saved successfully");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
