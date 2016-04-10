package ua.com.univerpulse.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

<<<<<<< HEAD
=======
/**
 * Created by svivanov on 05.04.16.
 */
>>>>>>> 287e58700abc6d8c58f69a7e56e090314014f39d
public class HashValue {

    public static String generate(String string) {
        StringBuilder hexString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(string.getBytes("UTF-8"));

            byte byteData[] = md.digest();

            hexString = new StringBuilder();
            for (int i=0; i < byteData.length; i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return hexString.toString();
    }

    private HashValue() {

    }
}
