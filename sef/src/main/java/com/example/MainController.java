package com.example;

import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML private TableView<adatbetolt> tabletable;
    @FXML private TableColumn<adatbetolt, Integer> idcol;
    @FXML private TableColumn<adatbetolt, String> chefnamecol;
    @FXML private TableColumn<adatbetolt, LocalDate> datecol;
    @FXML private TableColumn<adatbetolt, String> categorycol;
    @FXML private TableColumn<adatbetolt, Integer> osszegcol;
    @FXML private TableColumn<adatbetolt, String> megjegyzescol;

    @FXML private TextField chefnameField;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> categoryBox;
    @FXML private TextField priceField;
    @FXML private TextField commentField;

    private final adatbeolvas ab = new adatbeolvas();

    @FXML
    public void initialize() {
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        chefnamecol.setCellValueFactory(new PropertyValueFactory<>("chefname"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        categorycol.setCellValueFactory(new PropertyValueFactory<>("category"));
        osszegcol.setCellValueFactory(new PropertyValueFactory<>("price"));
        megjegyzescol.setCellValueFactory(new PropertyValueFactory<>("comment"));

        categoryBox.setItems(FXCollections.observableArrayList("Travel", "Ingredients", "Accommodation", "Equipment", "Other"));

        List<adatbetolt> lista = ab.readFile("C:\\Users\\Diak\\Desktop\\vizsga\\chef_koltsegek_2024.csv");
        tabletable.setItems(FXCollections.observableArrayList(lista));
    }

    @FXML
    private void hozzaadKoltseg() {
        try {
            String chefname = chefnameField.getText();
            LocalDate date = datePicker.getValue();
            String category = categoryBox.getValue();
            int price = Integer.parseInt(priceField.getText());
            String comment = commentField.getText();

            int ujId = tabletable.getItems().stream()
                .mapToInt(adatbetolt::getId)
                .max()
                .orElse(0) + 1;

            adatbetolt ujAdat = new adatbetolt(ujId, chefname, date, category, price, comment);

            tabletable.getItems().add(ujAdat);
            ab.writeToFile(tabletable.getItems());

            chefnameField.clear();
            datePicker.setValue(null);
            categoryBox.setValue(null);
            priceField.clear();
            commentField.clear();
        } catch (Exception e) {
            System.err.println("Hiba a hozzáadás során: " + e.getMessage());
        }
    }
}
