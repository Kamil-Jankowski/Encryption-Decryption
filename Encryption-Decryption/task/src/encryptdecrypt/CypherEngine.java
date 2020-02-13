package encryptdecrypt;

import java.io.FileNotFoundException;
import java.util.Scanner;

class CypherEngine {
    private Scanner scanner = new Scanner(System.in);
    private String method = "enc";
    private int key;
    private String data;
    private String inputPath;
    private String outputPath;
    private String algorithm;
    private String message;
    private CypherAlgorithm cypherAlgorithm;

    CypherEngine(String[] args) {
        for (int i = 0, j = 1; j < args.length; i+=2, j+=2){
            if (args[i].equals("-mode") && !args[j].startsWith("-")){
                method = args[j];
            } else if (args[i].equals("-data") && !args[j].startsWith("-")){
                data = args[j];
            } else if (args[i].equals("-key") && !args[j].startsWith("-")){
                key = Integer.parseInt(args[j]);
            } else if (args[i].equals("-in") && !args[j].startsWith("-")){
                inputPath = args[j];
            } else if (args[i].equals("-out") && !args[j].startsWith("-")) {
                outputPath = args[j];
            } else if (args[i].equals("-alg") && !args[j].startsWith("-")){
                algorithm = args[j];
            } else {										// incorrect parameter name provided
                throw new IllegalArgumentException();
            }
        }
    }

    void checkIfDataProvided() throws FileNotFoundException {
        if (inputPath != null && data == null){
            data = ReadAndWrite.readFromFile(inputPath);
        } else if (inputPath == null && data == null){
            System.out.println("Please provide text to be cyphered: ");
            data = scanner.nextLine();
        }
    }

    CypherAlgorithm checkAlgorithm() {
        if ("unicode".equals(algorithm)) {
            return new UnicodeAlgorithm();
        } else {
            return new ShiftAlgorithm();
        }
    }

    void setCypherAlgorithm(CypherAlgorithm algorithm) {
        this.cypherAlgorithm = algorithm;
    }

    void selectProgramMode() {
        if (method.equals("enc")){
            message = cypherAlgorithm.encryption(data, key);
        } else if (method.equals("dec")){
            message = cypherAlgorithm.decryption(data, key);
        }
    }

    void printResult() {
        if (outputPath != null){
            ReadAndWrite.writeToFile(outputPath, message);
        } else {
            System.out.println(message);
        }
    }
}
