package encryptdecrypt;

class UnicodeAlgorithm extends CypherAlgorithm {
    private final int UNICODE_MIN = 0;
    private final int UNICODE_MAX = Character.MAX_VALUE;

    @Override
    String encryption(String data, int key) {
        char[] array = data.toCharArray();
        for (int i = 0; i < array.length; i++){
            if (array[i] + key <= UNICODE_MAX){
                array[i] = (char) (array[i] + key);
            } else {
                array[i] = (char) (array[i] + key - UNICODE_MAX + UNICODE_MIN);
            }
        }
        setOutput(String.valueOf(array));
        return getOutput();
    }

    @Override
    String decryption(String data, int key) {
        char[] array = data.toCharArray();
        for (int i = 0; i < array.length; i++){
            if (array[i] - key >= UNICODE_MIN){
                array[i] = (char) (array[i] - key);
            } else {
                array[i] = (char) (array[i] - key + UNICODE_MAX - UNICODE_MIN);
            }
        }
        setOutput(String.valueOf(array));
        return getOutput();
    }
}

