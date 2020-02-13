package encryptdecrypt;

class ShiftAlgorithm extends CypherAlgorithm {
    // small letters:
    private final int UNICODE_SMALL_MIN = 97;
    private final int UNICODE_SMALL_MAX = 123;
    // big letters:
    private final int UNICODE_BIG_MIN = 65;
    private final int UNICODE_BIG_MAX = 91;

    @Override
    String encryption(String data, int key) {
        char[] array = data.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (UNICODE_SMALL_MIN <= array[i] && array[i] < UNICODE_SMALL_MAX) {             // checking if it is a small letter
                if (array[i] + key < UNICODE_SMALL_MAX) {
                    array[i] = (char) (array[i] + key);
                } else {
                    array[i] = (char) (array[i] + key - UNICODE_SMALL_MAX + UNICODE_SMALL_MIN);
                }
            } else if (UNICODE_BIG_MIN <= array[i] && array[i] < UNICODE_BIG_MAX){           // checking if it is a big letter
                if (array[i] + key < UNICODE_BIG_MAX) {
                    array[i] = (char) (array[i] + key);
                } else {
                    array[i] = (char) (array[i] + key - UNICODE_BIG_MAX + UNICODE_BIG_MIN);
                }
            } else array[i] = array[i];
        }
        setOutput(String.valueOf(array));
        return getOutput();
    }

    @Override
    String decryption(String data, int key) {
        char[] array = data.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (UNICODE_SMALL_MIN <= array[i] && array[i] < UNICODE_SMALL_MAX) {             // checking if it is a small letter
                if (array[i] - key >= UNICODE_SMALL_MIN){
                    array[i] = (char) (array[i] - key);
                } else {
                    array[i] = (char) (array[i] - key + UNICODE_SMALL_MAX - UNICODE_SMALL_MIN);
                }
            } else if (UNICODE_BIG_MIN <= array[i] && array[i] < UNICODE_BIG_MAX){           // checking if it is a big letter
                if (array[i] - key >= UNICODE_BIG_MIN){
                    array[i] = (char) (array[i] - key);
                } else {
                    array[i] = (char) (array[i] - key + UNICODE_BIG_MAX - UNICODE_BIG_MIN);
                }
            } else array[i] = array[i];
        }
        setOutput(String.valueOf(array));
        return getOutput();
    }
}
