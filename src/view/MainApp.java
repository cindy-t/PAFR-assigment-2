package view;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

// https://examples.javacodegeeks.com/desktop-java/javafx/fxml/javafx-fxml-controller-example/
public class MainApp extends Application {



    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Richrail");

        initRootLayout();

        //showConsoleOverview();
    }

    public void initRootLayout() {
        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/richrail.fxml"));
            String fxmlDocPath = "richrail.fxml";
            FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
            VBox rootLayout = (VBox) loader.load(fxmlStream);

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            scene.setRoot(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void showConsoleOverview() {
        try {
            // Load console overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("tab/richrail_anchor_console.fxml"));
            AnchorPane consoleOverview = (AnchorPane) loader.load();

            // Set console overview into the center of root layout.
            rootLayout.setCenter(consoleOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    // return the main stage
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
