package pis.hue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Ein Programm zum Ver- und Entschlüsseln von Nachrichten.
 *
 * @author Milan Jaritz
 * @version 1.0
 */

public class Main extends Application {

    /**
     * Lade FXML-Struktur, Stylesheet und setze Scene.
     *
     * @param primaryStage Hauptfenster
     * @throws Exception -
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("structure.fxml"));
        primaryStage.setTitle("Mr. Spy");
        Scene scene = new Scene(root, 370, 320);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("pis/hue/style.css");
        primaryStage.show();
    }

    /**
     * Starte Application.
     *
     * @param args Kommandozeilenparameter
     */
    public static void main(String[] args) {
        launch(args);
    }
}
