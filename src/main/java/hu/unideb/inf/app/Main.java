package hu.unideb.inf.app;

import hu.unideb.inf.model.Block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hu.unideb.inf.model.Transaction;
import hu.unideb.inf.model.Wallet;

public class Main {

    public static ArrayList<Block> blockChain = new ArrayList<Block>();

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.getSpecialHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.getSpecialHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Wallet wallet1 = new Wallet("fahgiai", "gaehgea", 12);
        Wallet wallet2 = new Wallet("asdbfds", "asdafss", 5);
        Wallet wallet3 = new Wallet("gjklsé2", "jskdlf2", 7);
        Wallet wallet4 = new Wallet("léájfid", "gsigska", 10);
        Wallet wallet5 = new Wallet("fnguewg", "mvriwlw", 6);

        Transaction transaction1 = new Transaction(wallet1.getPublicKey(), wallet2.getPublicKey(), 2, null);
        Transaction transaction2 = new Transaction(wallet2.getPublicKey(), wallet1.getPublicKey(), 3, null);
        Transaction transaction3 = new Transaction(wallet1.getPublicKey(), wallet4.getPublicKey(), 1, null);
        Transaction transaction4 = new Transaction(wallet4.getPublicKey(), wallet3.getPublicKey(), 2, null);
        Transaction transaction5 = new Transaction(wallet3.getPublicKey(), wallet1.getPublicKey(), 1, null);
        Transaction transaction6 = new Transaction(wallet5.getPublicKey(), wallet2.getPublicKey(), 1, null);
        Transaction transaction7 = new Transaction(wallet1.getPublicKey(), wallet5.getPublicKey(), 3, null);
        Transaction transaction8 = new Transaction(wallet4.getPublicKey(), wallet2.getPublicKey(), 4, null);
        Transaction transaction9 = new Transaction(wallet3.getPublicKey(), wallet1.getPublicKey(), 9, null);
        Transaction transaction10 = new Transaction(wallet5.getPublicKey(), wallet2.getPublicKey(), 7, null);
        Transaction transaction11 = new Transaction(wallet1.getPublicKey(), wallet5.getPublicKey(), 1, null);
        Transaction transaction12 = new Transaction(wallet4.getPublicKey(), wallet2.getPublicKey(), 8, null);
        List<Transaction> transactions1 = new ArrayList<>(Arrays.asList(
                transaction1,
                transaction2,
                transaction3,
                transaction4));

        List<Transaction> transactions2 = new ArrayList<>(Arrays.asList(
                transaction5,
                transaction6,
                transaction7,
                transaction8));

        List<Transaction> transactions3 = new ArrayList<>(Arrays.asList(
                transaction9,
                transaction10,
                transaction11,
                transaction12));

        blockChain.add(new Block("0", transactions1));

        blockChain.add(new Block(blockChain.get(blockChain.size() - 1).getSpecialHash(),transactions2));

        blockChain.add(new Block(blockChain.get(blockChain.size() - 1).getSpecialHash(),transactions3));


        //System.out.println("\nBlockchain is Valid: " + isChainValid());


        System.out.println("\nThe block chain: ");
        System.out.println(blockChain);


    }
}
