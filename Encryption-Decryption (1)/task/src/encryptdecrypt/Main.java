package encryptdecrypt;

import java.util.*;

public class Main {
    private static Locale localePL = new Locale.Builder().setLanguage("pl").setRegion("PL").build();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] text = scanner.nextLine().toLowerCase(localePL).toCharArray();
        int key = scanner.nextInt();
        List<Character> alphabet = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        String cyphertext = "";

        for (int i = 0; i < text.length; i++){
            if (alphabet.contains(text[i])){
                if (alphabet.indexOf(text[i]) < alphabet.size() - key){
                    cyphertext += alphabet.get(alphabet.indexOf(text[i]) + key);
                } else {
                    cyphertext += alphabet.get(alphabet.indexOf(text[i]) + key - alphabet.size());
                }
            } else {
                cyphertext += text[i];
            }
        }
        System.out.println(cyphertext);
    }
}