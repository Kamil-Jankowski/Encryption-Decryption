package encryptdecrypt;

import java.util.*;

public class Main {
    private final static int unicodeMin = 32;
    private final static int unicodeMax = Character.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        String text = scanner.nextLine();
        int key = scanner.nextInt();
        String output;

        if (method.equals("enc")){
            output = encrypt(text, key);
        } else if (method.equals("dec")){
            output = decrypt(text, key);
        } else {
            output = "Wrong input. Program will now terminate.";
        }
        System.out.println(output);
    }

    private static String encrypt(String m, int k){
        char[] text = m.toCharArray();
        char[] cyphertext = new char[text.length];

        for (int i = 0; i < text.length; i++){
            if (text[i] < unicodeMax - k){
                cyphertext[i] = (char) (text[i] + k);
            } else {
                cyphertext[i] = (char) (text[i] + k + unicodeMin - unicodeMax);
            }
        }
        return String.valueOf(cyphertext);
    }

    private static String decrypt(String m, int k){
        char[] text = m.toCharArray();
        char[] message = new char[text.length];

        for (int i = 0; i < text.length; i++){
            if (text[i] >= unicodeMin + k){
                message[i] = (char) (text[i] - k);
            } else {
                message[i] = (char) (text[i] - k - unicodeMin + unicodeMax);
            }
        }
        return String.valueOf(message);
    }
}