package com.asss.apoteka;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.Serializable;

public class Magacin implements Serializable, ApotekaInterface {


    public FileManager fileManager = new FileManager();


    public ObservableList<Lek> getLekObservableList() {
        return lekObservableList;
    }

    private final ObservableList<Lek> lekObservableList = fileManager.loadFile();


    public void dodajLek(TextField nazivPrompt, TextField cenaPrompt, TextField komponentePrompt, TextField kolicinaPrompt, ChoiceBox<String> izborTipaLeka, ChoiceBox<String> izborPoreklaLeka) {
        Lek zaDodati = null;
        try {
            if
            (izborTipaLeka.getSelectionModel().isEmpty() || izborPoreklaLeka.getSelectionModel().isEmpty() || nazivPrompt.getText().isEmpty() || cenaPrompt.getText().isEmpty() || komponentePrompt.getText().isEmpty() || kolicinaPrompt.getText().isEmpty()) {
                throw new UnsetParametersException("Niste podesili sve parametre za dodavanje leka!");
            }
        } catch (UnsetParametersException e) {
            return;
        }


        String tipLeka = izborTipaLeka.getValue();
        String porekloLeka = izborPoreklaLeka.getValue();

        switch (porekloLeka) {
            case "Hemijski lek":
                zaDodati = new ChemicalLek();

                break;

            case "Prirodni lek":
                zaDodati = new NaturalLek();
                break;
        }

        switch (tipLeka) {

            case "Anestetik":
                zaDodati.setTipLeka(TipLeka.ANESTETIK);
                break;

            case "Antibiotik":
                zaDodati.setTipLeka(TipLeka.ANTIBIOTIK);
                break;

            case "Analgetik":
                zaDodati.setTipLeka(TipLeka.ANALGETIK);
                break;

        }
        //  if(nazivPrompt.getText().equals())
        zaDodati.setNaziv(nazivPrompt.getText());
        zaDodati.setCena(Double.parseDouble(cenaPrompt.getText()));
        zaDodati.setAktivneKomponente(komponentePrompt.getText());
        zaDodati.setKolicina(Integer.parseInt(kolicinaPrompt.getText()));

        boolean vecIma = false;
        Lek vecImaLek = null;
        for (Lek lek : lekObservableList) {

            if (lek.equals(zaDodati)) {
                vecImaLek = lek;

                vecIma = true;
                break;
            }
        }

        if (vecIma) {
            int index = lekObservableList.indexOf(vecImaLek);

            zaDodati.setKolicina(vecImaLek.getKolicina() + Integer.parseInt(kolicinaPrompt.getText()));
            lekObservableList.set(index, zaDodati);
        } else {
            lekObservableList.add(zaDodati);
        }


        fileManager.saveFile(lekObservableList);
        //  Thread nitCuvanja = new Thread(() -> fileManager.saveFile(magacin.getListaLekova()));
        // nitCuvanja.start();

        // tableView.setItems(lekObservableList);


    }

    @Override
    public void ukloniLek(TableView<Lek> tableView) {

        Lek lek = tableView.getSelectionModel().getSelectedItem();
        lekObservableList.remove(lek);

        fileManager.saveFile(lekObservableList);
    }


}

