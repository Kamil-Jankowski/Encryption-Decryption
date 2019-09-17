package encryptdecrypt;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private static String method = "enc";						// default method set to encryption
    private static String data;
    private static int key;
    private static String inputPath;
    private static String outputPath;
    private static String message;
    private static String output;
    private final static int unicodeMin = 0;
    private final static int unicodeMax = Character.MAX_VALUE;

    public static void main(String[] args){
        try {
            // ---------- reading parameters from cmd ----------
            for (int i = 0, j = 1; j < args.length; i+=2, j+=2){
                if (args[i].equals("-mode") && !args[j].startsWith("-")){
                    method = args[j];
                } else if (args[i].equals("-data") && !args[j].startsWith("-")){
                    data = args[j];
                } else if (args[i].equals("-key") && !args[j].startsWith("-")){
                    key = Integer.parseInt(args[j]);
                } else if (args[i].equals("-in") && !args[j].startsWith("-")){
                    inputPath = args[j];
                } else if (args[i].equals("-out") && !args[j].startsWith("-")){
                    outputPath = args[j];
                } else {										// incorrect parameter name provided
                    throw new IllegalArgumentException();
                }
            }
            // ---------- reading input and checking if data provided ----------
            if (inputPath != null && data == null){
                data = readFromFile(inputPath);
            } else if (inputPath == null && data == null){
                System.out.println("-data: ");
                data = scanner.nextLine();
            }
            // ---------- selecting program mode ----------
            if (method.equals("enc")){
                message = encryption(data, key);
            } else if (method.equals("dec")){
                message = decryption(data, key);
            }
            // ---------- writing / printing result of the program ----------
            if (outputPath != null && data != null){
                writeToFile(outputPath, message);
            } else {
                System.out.println(message);
            }
        } catch (IllegalArgumentException e){
            System.out.println("Wrong input provided");
            System.out.println("Correct application parameters are:");
            System.out.println("-mode <enc/dec>");
            System.out.println("-key int");
            System.out.println("-in <path to file in quotes> OR -data String");
            System.out.println("-out <path to file in quotes>");
        } catch (NullPointerException ex){
            System.out.println("File cannot be created");
        }
    }

    private static String encryption(String m, int k){
        char[] array = m.toCharArray();
        for (int i = 0; i < array.length; i++){
            if (array[i]+k <= unicodeMax){
                array[i] = (char) (array[i]+k);
            } else {
                array[i] = (char) (array[i]+k - unicodeMax + unicodeMin);
            }
        }
        output = String.valueOf(array);
        return output;
    }

    private static String decryption(String m, int k){
        char[] array = m.toCharArray();
        for (int i = 0; i < array.length; i++){
            if (array[i]-k >= unicodeMin){
                array[i] = (char) (array[i]-k);
            } else {
                array[i] = (char) (array[i]-k + unicodeMax - unicodeMin);
            }
        }
        output = String.valueOf(array);
        return output;
    }

    private static String readFromFile(String path){
        File file = new File(path);
        String inputString = "";
        try(Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)){
            while (scanner.hasNext()){
                inputString = inputString.concat(scanner.nextLine()).concat("\n");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
            throw new NullPointerException();
        }
        return inputString;
    }

    private static void writeToFile(String path, String text){
        try{
            File file = new File(path);
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();
            System.out.println("File " + path + " saved successfully");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}