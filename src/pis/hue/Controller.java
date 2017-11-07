package pis.hue;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller {

    public Button btnEncrypt, btnDecrypt;
    public RadioButton radioCube, radioCaesar;
    public TextField textFieldKlar, textFieldGeheim;
    public TextField losung1, losung2;

    private Codec wuerfel1 = new Wuerfel();
    private Codec wuerfel2 = new Wuerfel();
    private Codec caesar1 = new Caesar();
    private Codec caesar2 = new Caesar();

    public void buttonEncrypt() {
        textFieldKlar.setStyle("");
        if (radioCaesar.isSelected()) {
            caesar1.setzeLosung(losung1.getText());
            caesar2.setzeLosung(losung2.getText());
            textFieldGeheim.setText(caesar2.kodiere(caesar1.kodiere(textFieldKlar.getText())));
        } else {
            wuerfel1.setzeLosung(losung1.getText());
            wuerfel2.setzeLosung(losung2.getText());
            textFieldGeheim.setText(wuerfel2.kodiere(wuerfel1.kodiere(textFieldKlar.getText())));
        }
        textFieldGeheim.setStyle("-fx-text-fill: green; -fx-border-color: green; -fx-border-radius: 3px; -fx-border-width: 2px");
    }

    public void buttonDecrypt() {
        GridPane.setFillWidth(btnDecrypt, true);
        textFieldGeheim.setStyle("");

        if (radioCaesar.isSelected()) {
            caesar1.setzeLosung(losung1.getText());
            caesar2.setzeLosung(losung2.getText());
            textFieldKlar.setText(caesar1.dekodiere(caesar2.dekodiere(textFieldGeheim.getText())));
        } else {
            wuerfel1.setzeLosung(losung1.getText());
            wuerfel2.setzeLosung(losung2.getText());
            textFieldKlar.setText(wuerfel1.dekodiere(wuerfel2.dekodiere(textFieldGeheim.getText())));
        }
        textFieldKlar.setStyle("-fx-text-fill: green; -fx-border-color: green; -fx-border-radius: 3px; -fx-border-width: 2px");
    }
}
