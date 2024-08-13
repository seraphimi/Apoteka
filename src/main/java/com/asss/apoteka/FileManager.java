package com.asss.apoteka;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileManager {

    public void saveFile(ObservableList<Lek> lista) {

        try (FileOutputStream fos = new FileOutputStream("Magacin.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(new ArrayList<>(lista));


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Lek> loadFile() {
        if (!Files.exists(Path.of("Magacin.ser"))) {
            return FXCollections.observableArrayList(new ArrayList<>());
        }

        try (FileInputStream fis = new FileInputStream("Magacin.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            ArrayList<Lek> lista = (ArrayList<Lek>) ois.readObject();


            return FXCollections.observableArrayList(lista);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
