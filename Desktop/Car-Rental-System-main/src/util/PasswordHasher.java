package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    // Hash Password Using SHA-256
    public static String hashPassword(String password) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = md.digest(password.getBytes());

            StringBuilder builder = new StringBuilder();

            for (byte b : hashBytes) {
                builder.append(String.format("%02x", b));
            }

            return builder.toString();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }

        return null;
    }

    // Check Password
    public static boolean checkPassword(String password, String hashedPassword) {

        String newHash = hashPassword(password);

        return newHash != null && newHash.equals(hashedPassword);
    }
}

