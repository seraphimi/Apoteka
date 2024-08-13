package com.asss.apoteka;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class ApotekaController {
    private static double danasnjiPromet = 0.00;

    private final Magacin magacin = new Magacin();
    @FXML
    private TableView<Lek> tableView;
    @FXML
    private TableColumn<Lek, String> naziv;
    //  @FXML
    @FXML
    private TableColumn<Lek, String> tip;
    @FXML
    private TableColumn<Lek, Double> cena;
    @FXML
    private TableColumn<Lek, String> aktivneKomponente;
    @FXML
    private TableColumn<Lek, String> kolicina;
    @FXML
    private TextField komponentePrompt;
    @FXML
    private TextField cenaPrompt;
    @FXML
    private TextField nazivPrompt;
    @FXML
    private TextField kolicinaPrompt;
    @FXML
    private TextField kolicinaProdajePrompt;
    @FXML
    private Button dodajButton;
    @FXML
    private Button ukloniButton;
    @FXML
    private Button prodajButton;

    private ObservableList<Lek> lekObservableList = magacin.getLekObservableList();
    @FXML
    private ChoiceBox<String> izborPoreklaLeka;
    @FXML
    private ChoiceBox<String> izborTipaLeka;
    @FXML
    private Text danasnjiPrometText;


    public void initialize() throws OutOfStockException {




        naziv.setCellValueFactory(new PropertyValueFactory<Lek, String>("naziv"));
        cena.setCellValueFactory(new PropertyValueFactory<Lek, Double>("cena"));
        tip.setCellValueFactory(new PropertyValueFactory<>("tipLeka"));
        aktivneKomponente.setCellValueFactory(new PropertyValueFactory<Lek, String>("aktivneKomponente"));
        kolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));


        kolicina.setCellValueFactory(new PropertyValueFactory<Lek, String>("kolicina"));


        dodajButton.setOnAction(e -> magacin.dodajLek(nazivPrompt, cenaPrompt, komponentePrompt, kolicinaPrompt, izborTipaLeka, izborPoreklaLeka));
        ukloniButton.setOnAction(e -> magacin.ukloniLek(tableView));
        prodajButton.setOnAction(e -> {
            try {
                prodajLek(1);
            } catch (OutOfStockException ignored) {

            }
        });
        tableView.setItems(getLekObservableList());
        tableView.getColumns().setAll(naziv, cena, tip, aktivneKomponente, kolicina);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Pozdrav iz unutrasnjosti(niti)!");
                    alert.setTitle("Bu!");
                    alert.setContentText("JavaFX ne voli da se vrse manipulacije nad scenom iz drugih niti pa se mora koristiti metoda runLater() da bi se menjali elementi GUI-ja.");
                    alert.showAndWait();
                } );
            }
        },(int)(Math.random()*15000+10000));





    }


    public void prodajLek(int kolicina) throws OutOfStockException {

        if (kolicinaProdajePrompt.getText().isBlank()) {
            kolicinaProdajePrompt.setText("1");
        }
        kolicina = Integer.parseInt(kolicinaProdajePrompt.getText());

        if (tableView.getItems().isEmpty()) return;


        Lek selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem.getKolicina() < kolicina) throw new OutOfStockException("Nemate dovoljno leka na stanju!");
        if (selectedItem.getKolicina() - kolicina == 0) {
            danasnjiPromet += selectedItem.getCena() * kolicina;
            lekObservableList.remove(selectedItem);
        } else {


            danasnjiPromet += selectedItem.getCena() * kolicina;

            selectedItem.setKolicina(selectedItem.getKolicina() - kolicina);
            lekObservableList.set(lekObservableList.indexOf(selectedItem), selectedItem);


        }
        danasnjiPrometText.setText("Danasnji promet : " + danasnjiPromet);
        magacin.fileManager.saveFile(lekObservableList);






    }

    public ObservableList<Lek> getLekObservableList() {
        lekObservableList = magacin.getLekObservableList();
        return lekObservableList;
    }


}


