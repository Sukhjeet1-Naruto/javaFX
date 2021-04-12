package application;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class AirlineController implements Initializable {
   @FXML
   private ListView<String> airlineDetail;
   @FXML
   private RadioButton radioAirlineName;
   @FXML
   private ToggleGroup selectOptions;
   @FXML
   private RadioButton radioAirlineNumber;
   @FXML
   private RadioButton radioAirlineDeparture;
   @FXML
   private RadioButton radioAirlineArrival;
   @FXML
   private ChoiceBox<String> choiceAirlineName;
   @FXML
   private ChoiceBox<String> choicAirlineByNumber;
   @FXML
   private ChoiceBox<String> choiceAirlineDeparture;
   @FXML
   private ChoiceBox<String> choicearrival;
   Path filePath = Paths.get("flightData.txt");
   ObservableList<Flight> data = FXCollections.observableArrayList();
   String rawInputEachLine;
   String splitter = ",";
   Scanner sc;
   String[] inputDetail;
   BufferedReader bReader;
   InputStream ipStream;
   Flight fObj;
   String head;

   public AirlineController() {
      this.sc = new Scanner(System.in);
      this.inputDetail = new String[4];
      this.head = "Airline \tAirlineNo \tDeparture \tArrival";
   }

   public void initialize(URL arg0, ResourceBundle arg1) {
      this.choiceAirlineName.setValue("Select Airline");
      this.choicAirlineByNumber.setValue("Select Airline Number");
      this.choiceAirlineDeparture.setValue("Select Departure Airport");
      this.choicearrival.setValue("Select Arrival Airport");
      this.airlineDetail.getItems().add(this.head);
   }

   @FXML
   void OnSearch(ActionEvent event) {
      try {
         this.ipStream = new BufferedInputStream(Files.newInputStream(this.filePath));
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      this.bReader = new BufferedReader(new InputStreamReader(this.ipStream));
      String choice;
      if (this.radioAirlineNumber.isSelected()) {
         choice = (String)this.choicAirlineByNumber.getSelectionModel().getSelectedItem();

         try {
            for(this.rawInputEachLine = this.bReader.readLine(); this.rawInputEachLine != null; this.rawInputEachLine = this.bReader.readLine()) {
               this.inputDetail = this.rawInputEachLine.split(this.splitter);
               if (choice.equals(this.inputDetail[1])) {
                  this.fObj = new Flight(this.inputDetail[0], this.inputDetail[1], this.inputDetail[2], this.inputDetail[3]);
                  this.airlineDetail.getItems().add(this.fObj.toString());
               }
            }

            this.bReader.close();
         } catch (IOException var8) {
            var8.printStackTrace();
         }
      } else if (this.radioAirlineDeparture.isSelected()) {
         choice = (String)this.choiceAirlineDeparture.getSelectionModel().getSelectedItem();

         try {
            for(this.rawInputEachLine = this.bReader.readLine(); this.rawInputEachLine != null; this.rawInputEachLine = this.bReader.readLine()) {
               this.inputDetail = this.rawInputEachLine.split(this.splitter);
               if (choice.equals(this.inputDetail[2])) {
                  this.fObj = new Flight(this.inputDetail[0], this.inputDetail[1], this.inputDetail[2], this.inputDetail[3]);
                  this.airlineDetail.getItems().add(this.fObj.toString());
               }
            }

            this.bReader.close();
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      } else if (this.radioAirlineArrival.isSelected()) {
         choice = (String)this.choicearrival.getSelectionModel().getSelectedItem();

         try {
            for(this.rawInputEachLine = this.bReader.readLine(); this.rawInputEachLine != null; this.rawInputEachLine = this.bReader.readLine()) {
               this.inputDetail = this.rawInputEachLine.split(this.splitter);
               if (choice.equals(this.inputDetail[3])) {
                  this.fObj = new Flight(this.inputDetail[0], this.inputDetail[1], this.inputDetail[2], this.inputDetail[3]);
                  this.airlineDetail.getItems().add(this.fObj.toString());
               }
            }

            this.bReader.close();
         } catch (IOException var6) {
            var6.printStackTrace();
         }
      } else {
         choice = (String)this.choiceAirlineName.getSelectionModel().getSelectedItem();

         try {
            for(this.rawInputEachLine = this.bReader.readLine(); this.rawInputEachLine != null; this.rawInputEachLine = this.bReader.readLine()) {
               this.inputDetail = this.rawInputEachLine.split(this.splitter);
               if (choice.equals(this.inputDetail[0])) {
                  this.fObj = new Flight(this.inputDetail[0], this.inputDetail[1], this.inputDetail[2], this.inputDetail[3]);
                  this.airlineDetail.getItems().add(this.fObj.toString());
               }
            }

            this.bReader.close();
         } catch (IOException var5) {
            var5.printStackTrace();
         }
      }

   }

   @FXML
   void populatearrival(MouseEvent event) {
      try {
         this.airlineDetail.getItems().clear();
         this.airlineDetail.getItems().add(this.head);
         this.ipStream = new BufferedInputStream(Files.newInputStream(this.filePath));
         this.bReader = new BufferedReader(new InputStreamReader(this.ipStream));
         this.rawInputEachLine = this.bReader.readLine();

         while(this.rawInputEachLine != null) {
            this.inputDetail = this.rawInputEachLine.split(this.splitter);
            this.rawInputEachLine = this.bReader.readLine();
            if (!this.choicearrival.getItems().contains(this.inputDetail[3])) {
               this.choicearrival.getItems().add(this.inputDetail[3]);
            }
         }

         this.bReader.close();
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      this.choicAirlineByNumber.setDisable(true);
      this.choiceAirlineDeparture.setDisable(true);
      this.choiceAirlineName.setDisable(true);
      this.choicearrival.setDisable(false);
   }

   @FXML
   void populatedeparture(MouseEvent event) {
      this.airlineDetail.getItems().clear();
      this.airlineDetail.getItems().add(this.head);

      try {
         this.ipStream = new BufferedInputStream(Files.newInputStream(this.filePath));
         this.bReader = new BufferedReader(new InputStreamReader(this.ipStream));
         this.rawInputEachLine = this.bReader.readLine();

         while(this.rawInputEachLine != null) {
            this.inputDetail = this.rawInputEachLine.split(this.splitter);
            this.rawInputEachLine = this.bReader.readLine();
            if (!this.choiceAirlineDeparture.getItems().contains(this.inputDetail[2])) {
               this.choiceAirlineDeparture.getItems().add(this.inputDetail[2]);
            }
         }

         this.bReader.close();
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      this.choicAirlineByNumber.setDisable(true);
      this.choicearrival.setDisable(true);
      this.choiceAirlineName.setDisable(true);
      this.choiceAirlineDeparture.setDisable(false);
   }

   @FXML
   void populatenumber(MouseEvent event) {
      this.airlineDetail.getItems().clear();
      this.airlineDetail.getItems().add(this.head);

      try {
         this.ipStream = new BufferedInputStream(Files.newInputStream(this.filePath));
         this.bReader = new BufferedReader(new InputStreamReader(this.ipStream));
         this.rawInputEachLine = this.bReader.readLine();

         while(this.rawInputEachLine != null) {
            this.inputDetail = this.rawInputEachLine.split(this.splitter);
            this.rawInputEachLine = this.bReader.readLine();
            if (!this.choicAirlineByNumber.getItems().contains(this.inputDetail[1])) {
               this.choicAirlineByNumber.getItems().add(this.inputDetail[1]);
            }
         }

         this.bReader.close();
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      this.choiceAirlineDeparture.setDisable(true);
      this.choicearrival.setDisable(true);
      this.choiceAirlineName.setDisable(true);
      this.choicAirlineByNumber.setDisable(false);
   }

   @FXML
   void OnClose(ActionEvent event) {
      Platform.exit();
   }

   @FXML
   void populateairline(MouseEvent event) {
      this.airlineDetail.getItems().clear();
      this.airlineDetail.getItems().add(this.head);

      try {
         this.ipStream = new BufferedInputStream(Files.newInputStream(this.filePath));
         this.bReader = new BufferedReader(new InputStreamReader(this.ipStream));
         this.rawInputEachLine = this.bReader.readLine();

         while(this.rawInputEachLine != null) {
            this.inputDetail = this.rawInputEachLine.split(this.splitter);
            this.rawInputEachLine = this.bReader.readLine();
            if (!this.choiceAirlineName.getItems().contains(this.inputDetail[0])) {
               this.choiceAirlineName.getItems().add(this.inputDetail[0]);
            }
         }

         this.bReader.close();
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      this.choicAirlineByNumber.setDisable(true);
      this.choiceAirlineDeparture.setDisable(true);
      this.choicearrival.setDisable(true);
      this.choiceAirlineName.setDisable(false);
   }

   @FXML
   void SelectAirline(ActionEvent event) {
   }

   @FXML
   void SelectArrival(ActionEvent event) {
   }

   @FXML
   void SelectDeparture(ActionEvent event) {
   }
}
