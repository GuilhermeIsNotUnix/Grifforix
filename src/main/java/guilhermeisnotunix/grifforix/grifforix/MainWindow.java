package guilhermeisnotunix.grifforix.grifforix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static guilhermeisnotunix.grifforix.password.Password.*;

/** <p>This class represents the main grifforix window, in which JavaFX for the GUI is used.</p>
 * <p>Some procedures are specific and traditional implementations of JavaFX, such as the class inheritance presented below inheriting the Application class and the @Override of the start method (method in which the application's fxml is loaded and the main window is configured and displayed)...</p>
 * <p>Furthermore, inside the main method there is a simple command line interface, in case someone wants to run grifforix without exactly using graphical mode, also allowing to use some basic grifforix functionalities via the command line with arguments. If the application is started without arguments (clicking on a grifforix executable, a .exe on Windows or .rpm on Fedora Linux for example, also means starting it without arguments), it will automatically start in graphical mode with its JavaFX graphical interface. However, if the user runs grifforix from the command line with arguments, for example: ./grifforix -V, then the graphical interface will not be started, but rather the functionality will be executed directly via the command line.</p>
 * <p>For now there are only two commands possible to execute:</p>
 * <p>1. "./grifforix -V": Prints the griforix version.</p>
 * <p>2. "./grifforix -n": Generates a random password with a fixed length of 20 characters.</p>
 *
 * @author Guilherme Faura
 * @author <a href="https://guilhermeisnotunix.github.io">guilhermeisnotunix</a>
 * @author <a href="https://github.com/guilhermeisnotunix">GitHub</a>
 * @version 0.9.2-alpha
 */

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