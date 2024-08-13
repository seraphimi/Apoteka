package com.asss.apoteka;

import javafx.scene.control.Alert;

import java.util.InputMismatchException;


public class UnsetParametersException extends InputMismatchException {

    public void showMessage(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setContentText(message);

        alert.showAndWait();
    }

    public UnsetParametersException(String s) {
        super(s);
        showMessage(s);
    }
}
