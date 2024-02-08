import java.math.BigInteger;
import static Password.Password.*;

public class Main {
    public static final String Version = "v0.6.0-alpha";

    public static void grifforixVersion() {
        System.out.println(Version);
    }

    public static void main(String[] args) {
        int passwordLength = 20;

        grifforixVersion();

        char[] newPassword = generateNewPassword(passwordLength);
        String newPasswordString = new String(newPassword);
        System.out.println("Generating new password with " + passwordLength + " characters...");
        System.out.println("Password: " + newPasswordString);

        String hashedPassword = hashPassword(newPasswordString);
        System.out.println("Password hash: " + hashedPassword);

        /* Simulation of password verification
        String inputPassword = "password123";
        if(checkPasswordHash(inputPassword, hashedPassword)) {
            System.out.println("Correct password!");
        } else {
            System.out.println("Incorrect password!");
        }*/
    }
}