package com.asss.apoteka;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OutOfStockException extends RuntimeException {
    public void showMessage(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();


    }

    public OutOfStockException(String message) {
        super(message);
        showMessage(message);
    }
}

