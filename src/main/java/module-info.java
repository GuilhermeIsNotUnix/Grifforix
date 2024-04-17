module guilhermeisnotunix.grifforix.grifforix {
    requires javafx.controls;
    requires javafx.fxml;


    opens guilhermeisnotunix.grifforix.grifforix to javafx.fxml;
    exports guilhermeisnotunix.grifforix.grifforix;
}