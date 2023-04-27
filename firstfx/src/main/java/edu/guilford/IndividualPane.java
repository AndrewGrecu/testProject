package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class IndividualPane extends GridPane {

    private Individual individual;

    private TextField nameField;
    private TextField phoneField;
    private TextField emailField;
    private Button submitButton;
    private ImageView imageView;
    private Button rotateButton;
    private Slider slider;
    private CheckBox checkBox;

    public IndividualPane(Individual individual) {
        this.individual = individual;

        nameField = new TextField();
        phoneField = new TextField();
        emailField = new TextField();
        submitButton = new Button("Submit");
        rotateButton = new Button("Rotate");
        slider = new Slider(0, 100, 50);
        checkBox = new CheckBox("Check Me");

        File avatar = new File(this.getClass().getResource("instaLogo.jpg").getPath());

        imageView = new ImageView(avatar.toURI().toString());

        Label nameLabel = new Label("name: " + individual.getName());
        Label phoneLabel = new Label("phone: " + individual.getPhone());
        Label emailLabel = new Label("email: " + individual.getEmail());
        CheckBox hideFieldsCheckBox = new CheckBox("Hide Fields");

        this.add(nameLabel, 0, 0);
        this.add(phoneLabel, 0, 1);
        this.add(emailLabel, 0, 2);
        this.add(nameField, 1, 0);
        this.add(phoneField, 1, 1);
        this.add(emailField, 1, 2);
        this.add(submitButton, 1, 3);
        this.add(imageView, 2, 0, 1, 4);

        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        this.add(rotateButton, 3, 0);
        this.add(slider, 3, 1);

        this.add(hideFieldsCheckBox, 3, 3);

        this.setStyle("-fx-border-color: black;");
        this.setStyle("-fx-background-color: lightblue;");

        submitButton.setOnAction(e -> {
            individual.setName(nameField.getText());
            individual.setPhone(phoneField.getText());
            individual.setEmail(emailField.getText());
            nameLabel.setText("name: " + individual.getName());
            phoneLabel.setText("phone: " + individual.getPhone());
            emailLabel.setText("email: " + individual.getEmail());
            nameField.clear();
            phoneField.clear();
            emailField.clear();
        });

        rotateButton.setOnAction(e -> {
            imageView.setRotate(imageView.getRotate() + 45);
        });

        slider.setOnMouseDragged(e -> {
            double red = Math.random();
            double green = Math.random();
            double blue = Math.random();
            nameField.setStyle(
                    String.format("-fx-control-inner-background: rgb(%f,%f,%f);", red * 255, green * 255, blue * 255));
            phoneField.setStyle(
                    String.format("-fx-control-inner-background: rgb(%f,%f,%f);", red * 255, green * 255, blue * 255));
            emailField.setStyle(
                    String.format("-fx-control-inner-background: rgb(%f,%f,%f);", red * 255, green * 255, blue * 255));
        });

        hideFieldsCheckBox.setOnAction(e -> {
            if (hideFieldsCheckBox.isSelected()) {
                nameField.setVisible(false);
                nameField.setManaged(false);
                phoneField.setVisible(false);
                phoneField.setManaged(false);
                emailField.setVisible(false);
                emailField.setManaged(false);
            } else {
                nameField.setVisible(true);
                nameField.setManaged(true);
                phoneField.setVisible(true);
                phoneField.setManaged(true);
                emailField.setVisible(true);
                emailField.setManaged(true);
            }
        });
    }
}