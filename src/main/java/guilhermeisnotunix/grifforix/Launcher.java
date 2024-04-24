package guilhermeisnotunix.grifforix;

import guilhermeisnotunix.grifforix.grifforix.MainWindow;

/** <p>This class represents the responsible for launching the application. By convention, when using JavaFX, it is usual to separate the class that does the inheritance (and sets JavaFX configs) and a launcher class that actually starts the application. So, this is the actual first class on the project to run.</p>
 *
 * @author Guilherme Faura
 * @author <a href="https://guilhermeisnotunix.github.io">guilhermeisnotunix</a>
 * @author <a href="https://github.com/guilhermeisnotunix">GitHub</a>
 * @version 0.9.2-alpha
 */

public class Launcher {
    public static void main(String[] args) {
        MainWindow.main(args);
    }
}
