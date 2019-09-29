package encryptdecrypt;

abstract class CypherAlgorithm {
    private String output;

    abstract String encryption(String data, int key);

    abstract String decryption(String data, int key);

    void setOutput(String output){
        this.output = output;
    }

    String getOutput(){
        return output;
    }
}
