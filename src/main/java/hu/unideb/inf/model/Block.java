package hu.unideb.inf.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Block {

    /**
     * Represents the hash of the previous block.
     */
    private String previousHash;

    /**
     * Represents the root of the transactions of the block.
     */
    private String merkleRoot;

    private String timeStamp;

    /**
     * Represents a number to help creating the special hash.
     */
    private int nonce;

    /**
     * Represents the hash of the block.
     */
    private String specialHash;

    /**
     * Represents number of zeros at the beginning of the special hash.
     */
    private static final int difficulty = 4;

    private String target="0000";

    private List<Transaction> transactions = new ArrayList<Transaction>();

    public Block(String previousHash, List<Transaction> transactions) {
        this.previousHash = previousHash;
        this.timeStamp = LocalDateTime.now().toString();
        this.transactions=transactions;
        calculateMerkleRoot();
        mineBlock();
    }
    public String calculateHash() {
        return Hash.applySha256(
                // previousHash +
             merkleRoot +
                // timeStamp +
                   nonce
        );
    }

    public void mineBlock() {

        this.specialHash = calculateHash();
        while(!specialHash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            specialHash = calculateHash();
        }
        System.out.println("\tThe special hash : " + specialHash);
    }

    public void calculateMerkleRoot(){
        List<String> hashes=new ArrayList<>();
        for(Transaction transaction:transactions){
            hashes.add(transaction.getHash());
        }
        List<String> prevLayer=hashes;

        while(hashes.size()>1){
            prevLayer=new ArrayList<>();
            for(int i=0; i<hashes.size();i+=2)
            {
                prevLayer.add(Hash.applySha256(hashes.get(i)+hashes.get(i+1)));
            }
            hashes=prevLayer;

        }

        this.merkleRoot=hashes.get(0);
        System.out.println("Merkle root:"+this.merkleRoot);
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public String getSpecialHash() {
        return specialHash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    @Override
    public String toString() {
        return "\nBlock {\n\t" +
                "previousHash='" + previousHash + '\'' +
                ", \n\tmerkleRoot='" + merkleRoot + '\'' +
                ", \n\ttimeStamp='" + timeStamp + '\'' +
                ", \n\tnonce=" + nonce +
                ", \n\tspecialHash='" + specialHash + '\'' +
                ", \n\ttarget='" + target + '\'' +
                ", \n\ttransactions = \n\t\t" + transactions + "\n\t"+
                '}';
    }
}
