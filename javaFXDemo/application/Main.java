package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
   public void start(Stage primaryStage) {
      try {
         AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AirlineFX.fxml"));
         Scene scene = new Scene(root, 800.0D, 400.0D);
         scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.setTitle("Airline Information System");
         primaryStage.show();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public static void main(String[] args) {
      launch(args);
   }
}
