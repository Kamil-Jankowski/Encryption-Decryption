package encryptdecrypt;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String method = "enc";						// default method set to encryption
    private static String data;
    private static int key;
    private static String message;
    private static String output;
    private final static int unicodeMin = 32;
    private final static int unicodeMax = Character.MAX_VALUE;

    public static void main(String[] args){
        // ---------- reading parameters from cmd ----------
        for (int i = 0, j = 1; j < args.length; i++, j++){
            if (args[i].equals("-mode") && (!args[j].equals("-data") || !args[j].equals("-key"))){
                method = args[j];
            } else if (args[i].equals("-data") && (!args[j].equals("-mode") || !args[j].equals("-key"))){
                data = args[j];
            } else if (args[i].equals("-key") && !(args[j].equals("-data") || args[j].equals("-mode"))){
                key = Integer.parseInt(args[j]);
            }
        }
        // ---------- checking if data provided ----------
        if (data == null){
            System.out.println("-data: ");
            data = scanner.nextLine();
            System.out.println("-key: ");
            key = scanner.nextInt();
        }
/* Above checker is correct according to provided task, however I think solution below is more useful:

        // ---------- checking if all parameters are provided ----------
        if (data == null){
            System.out.println("-data: ");
            data = scanner.nextLine();
        }
        if (key == 0){
            System.out.println("-key: ");
            key = scanner.nextInt();
        }

 */
        // ---------- selecting program mode ----------
        if (method.equals("enc")){
            message = encryption(data, key);
        } else if (method.equals("dec")){
            message = decryption(data, key);
        }
        // ---------- printing result of the program ----------
        System.out.println(message);
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
}
