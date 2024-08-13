module com.asss.apoteka {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.asss.apoteka to javafx.fxml;
    exports com.asss.apoteka;
}