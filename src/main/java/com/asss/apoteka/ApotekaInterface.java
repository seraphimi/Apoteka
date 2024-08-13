package com.asss.apoteka;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public interface ApotekaInterface {
    void dodajLek(TextField nazivPrompt, TextField cenaPrompt, TextField komponentePrompt, TextField kolicinaPrompt6, ChoiceBox<String> izborTipaLeka, ChoiceBox<String> izborPoreklaLeka);

    void ukloniLek(TableView<Lek> tableView);

}
