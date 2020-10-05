package hu.unideb.inf.model;

/**
 * Represents the wallet of the currency owner.
 */
public class Wallet {

    /**
     * Represents the private key of the owner.
     */
    private String privateKey;

    /**
     * Represents the public key of the owner.
     */
    private String publicKey;

    private int value;

    public Wallet(String privateKey, String publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.value=0;
    }

    public Wallet(String privateKey, String publicKey, int value) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.value=value;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "privateKey='" + privateKey + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", value=" + value +
                '}';
    }
}
