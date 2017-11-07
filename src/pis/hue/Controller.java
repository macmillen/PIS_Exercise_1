package pis.hue;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    public Button btnEncrypt, btnDecrypt;
    public RadioButton radioCube, radioCaesar;
    public TextArea textAreaKlar, textAreaGeheim;
    public TextField losung1, losung2;

    private Codec wuerfel1 = new Wuerfel();
    private Codec wuerfel2 = new Wuerfel();
    private Codec caesar1 = new Caesar();
    private Codec caesar2 = new Caesar();


    public void buttonEncrypt() {
        if (radioCaesar.isSelected()) {
            caesar1.setzeLosung(losung1.getText());
            caesar2.setzeLosung(losung2.getText());
            textAreaGeheim.setText(caesar2.kodiere(caesar1.kodiere(textAreaKlar.getText())));
        } else {
            wuerfel1.setzeLosung(losung1.getText());
            wuerfel2.setzeLosung(losung2.getText());
            textAreaGeheim.setText(wuerfel2.kodiere(wuerfel1.kodiere(textAreaKlar.getText())));
        }
    }

    public void buttonDecrypt() {
        if (radioCaesar.isSelected()) {
            caesar1.setzeLosung(losung1.getText());
            caesar2.setzeLosung(losung2.getText());
            textAreaKlar.setText(caesar2.dekodiere(caesar1.dekodiere(textAreaGeheim.getText())));
        } else {
            wuerfel1.setzeLosung(losung1.getText());
            wuerfel2.setzeLosung(losung2.getText());
            textAreaKlar.setText(wuerfel1.dekodiere(wuerfel2.dekodiere(textAreaGeheim.getText())));
        }
    }
}
