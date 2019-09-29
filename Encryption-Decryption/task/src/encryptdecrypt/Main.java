package encryptdecrypt;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args){
        try {
            CypherEngine enigma = new CypherEngine(args);
            enigma.checkIfDataProvided();
            CypherAlgorithm algorithm = enigma.checkAlgorithm();
            enigma.setCypherAlgorithm(algorithm);
            enigma.selectProgramMode();
            enigma.printResult();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("Wrong input provided \nCorrect application parameters are: \n  -mode <enc/dec>\n  -key int\n  -in <path to file in quotes> OR -data <message in quotes>\n  -out <path to file in quotes>\n  -alg <shift/unicode>");
        } catch (FileNotFoundException e){
            System.out.println("Cannot find input file");
        }
    }
}