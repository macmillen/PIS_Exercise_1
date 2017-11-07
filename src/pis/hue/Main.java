package pis.hue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("structure.fxml"));
        primaryStage.setTitle("Mr. Spy");
        Scene scene = new Scene(root, 350, 310);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("pis/hue/style.css");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
