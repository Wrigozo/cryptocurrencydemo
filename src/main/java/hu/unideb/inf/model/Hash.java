package hu.unideb.inf.model;

import java.security.MessageDigest;

public class Hash {

    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            StringBuffer hexadecimalHash = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexadecimalHash.append('0');
                hexadecimalHash.append(hex);
            }
            return hexadecimalHash.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
