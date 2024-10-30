package mail;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/demo.fxml"));
        try {
            Parent root = loader.load();
            stage.setTitle("Demo");
            stage.setScene(new Scene(root));
            stage.setFullScreen(true);
            stage.show();

        } catch (IOException e) {
            System.err.println("Can't load fxml.");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
