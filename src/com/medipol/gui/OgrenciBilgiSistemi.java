package com.medipol.gui;
import com.medipol.School;
import com.medipol.Student;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class OgrenciBilgiSistemi extends Application {
	
	final School school = new School("Medipol", "kavacik","0216423423432");

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form JavaFX Application");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Ogrenci Kay�t Sistemi");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Adi : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        // Add Soyadi Label
        Label soyadiLabel = new Label("Soyadi : ");
        gridPane.add(soyadiLabel, 0, 2);

        // Add Soyadi Text Field
        TextField soyadiField = new TextField();
        soyadiField.setPrefHeight(40);
        gridPane.add(soyadiField, 1, 2);

        // Add Not Label
        Label notLabel = new Label("Not : ");
        gridPane.add(notLabel, 0, 3);

        // Add Not Field
        TextField notField = new TextField();
        notField.setPrefHeight(40);
        gridPane.add(notField, 1, 3);
        
        Label katilimLabel = new Label("Kat�l�m : ");
        gridPane.add(katilimLabel, 0, 4);

        // Add Not Field
        ComboBox katilimField = new ComboBox();
        katilimField.getItems().add(0, "KATILDI");
        katilimField.getItems().add(1, "KATILMADI");
        katilimField.setPromptText("KATILIM DURUMU");
        katilimField.setPrefHeight(40);
        gridPane.add(katilimField, 1, 4);

        // Add Submit Button
        ToggleButton submitButton = new ToggleButton("Giri� Yap");
        submitButton.setPrefHeight(40);
//        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 5, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if(soyadiField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                    return;
                }
                if(notField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }
                double not=0;
                try {
                	not = Double.valueOf(notField.getText());
                } catch (Exception e) {
                	e.printStackTrace();
                	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter valid grade (Number)");
                	return;
				}
                
               
                boolean katilimDurumu;
                if("KATILDI".equals(katilimField.getValue())) {
                	katilimDurumu = true;
                }else {
                	katilimDurumu = false;
                }
                Student student = new Student(nameField.getText(), soyadiField.getText(), "", katilimDurumu, not);
                school.addStudent(student);
                
               showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Kayit Ba�ar�l�", "Welcome " + nameField.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}