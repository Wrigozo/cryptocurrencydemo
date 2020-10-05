package hu.unideb.inf.model;

import java.util.Arrays;

/**
 * Represents a transaction.
 */
public class Transaction {

    /**
     * Represents the public key of the vendor of the transaction.
     */
    private String sellerPK;

    /**
     * Represents the public key of the customer of the transaction.
     * Customer: the currency owner who will send the coin to the seller.
     */
    private String customerPK;

    /**
     * Represents the currency sent.
     */
    private int value;

    /**
     * Represents the digital signature of the transaction.
     */
    private byte[] signature;

    private String hash;

    public Transaction(String sellerPK, String customerPK, int value, byte[] signature) {
        this.sellerPK = sellerPK;
        this.customerPK = customerPK;
        this.value = value;
        this.signature = signature;
        this.hash= Hash.applySha256(customerPK+value);
    }

    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "\n\t\tTransaction{ " +
                "sellerPK='" + sellerPK + '\'' +
                ", customerPK='" + customerPK + '\'' +
                ", value=" + value +
                ", signature=" + Arrays.toString(signature) +
                ", hash='" + hash + '\'' +
                '}';
    }
}
