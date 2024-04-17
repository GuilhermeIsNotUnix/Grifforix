package guilhermeisnotunix.grifforix.grifforix;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static guilhermeisnotunix.grifforix.password.Password.*;

public class MainWindowController {
    @FXML
    private Label passwordText;

    @FXML
    protected void onHelloButtonClick() {
        int passwordLength = 20;

        char[] newPassword = generateNewPassword(passwordLength);
        String newPasswordString = new String(newPassword);
        //System.out.println("Generating new password with " + passwordLength + " characters...");
        //System.out.println("Password: " + newPasswordString);

        //String hashedPassword = hashPassword(newPasswordString);
        //System.out.println("Password hash: " + hashedPassword);

        passwordText.setText("Password: " + newPasswordString);
    }
}