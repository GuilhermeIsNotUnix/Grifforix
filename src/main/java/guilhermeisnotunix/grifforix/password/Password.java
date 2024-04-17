package guilhermeisnotunix.grifforix.password;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.MessageDigest;

public class Password {
    final static String Lowercase = "abcdefghijklmnopqrstuvwxyz"; //length() == 26
    final static String Uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //length() == 26
    final static String Symbols = "\"'!@#$%&*()_-+={}[]~^`<>,.:;?/"; //length() == 30
    final static String Numbers = "0123456789"; //length() == 10
    static final String AllCharacters = Lowercase + Uppercase + Symbols + Numbers; //length() == 92

    static final int MinimumLength = 10;
    static final int MaximumLength = 256;
    final static String GrifforixVersion = "v.0.7.2-alpha";

    /*Returns the Grifforix software version. It's used on -V argument to show the version.*/
    public static String getGrifforixVersion() {
        return GrifforixVersion;
    }

    public static BigInteger generateRandomNumber(BigInteger max) {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("An error occurred while trying to obtain secure algorithm.", e);
        }

        BigInteger randomNumber;
        do {
            byte[] randomBytes = new byte[max.bitLength() / 8 + 1];
            secureRandom.nextBytes(randomBytes);
            randomNumber = new BigInteger(1, randomBytes);
        } while (randomNumber.compareTo(max) >= 0);

        return randomNumber;
    }

    public static char generateRandomCharacter() {
        int randomIndex = generateRandomNumber(BigInteger.valueOf(AllCharacters.length())).intValue();
        return AllCharacters.charAt(randomIndex);
    }

    public static char[] generateNewPassword(int len) {
        if (len < MinimumLength || len > MaximumLength) {
            throw new IllegalArgumentException("Error: Password must have minimum " + MinimumLength +
                    " characters and max " + MaximumLength + " characters.");
        }

        char[] password = new char[len];

        for (int i = 0; i < len; i++) {
            password[i] = generateRandomCharacter();
        }

        return password;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for(byte hashedByte : hashedBytes) {
                hexString.append(String.format("%02x", hashedByte));
            }

            return hexString.toString();
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while trying to obtain hash algorithm.", e);
        }
    }

    public static boolean checkPasswordHash(String password, String hashedPassword) {
        String newHashedPassword = hashPassword(password);
        return newHashedPassword.equals(hashedPassword);
    }
}
