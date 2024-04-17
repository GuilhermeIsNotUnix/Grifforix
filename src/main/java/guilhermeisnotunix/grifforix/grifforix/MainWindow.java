package guilhermeisnotunix.grifforix.grifforix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static guilhermeisnotunix.grifforix.password.Password.*;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("main-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Grifforix " +getGrifforixVersion());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        if(args.length == 0) {
            launch();
        } else {
            for(String arg : args) {
                if(arg.equals("-n")) {
                    int passwordLength = 20;

                    char[] newPassword = generateNewPassword(passwordLength);
                    String newPasswordString = new String(newPassword);
                    System.out.println(newPasswordString);

                    //String hashedPassword = hashPassword(newPasswordString);
                    //System.out.println("Password hash: " + hashedPassword);

                    /* Simulation of password verification
                    String inputPassword = "password123";
                    if(checkPasswordHash(inputPassword, hashedPassword)) {
                        System.out.println("Correct password!");
                    } else {
                        System.out.println("Incorrect password!");
                    }*/
                }

                if(arg.equals("-V")) {
                    System.out.println(getGrifforixVersion());
                }
            }
        }
    }
}