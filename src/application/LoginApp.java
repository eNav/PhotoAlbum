package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginApp {

	@FXML
	private TextField usernameField;

	public void login() {
        String username = usernameField.getText().trim();

        if (username.equalsIgnoreCase("admin")) {
            // Load Admin screen
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 500, 500));
                stage.setTitle("Admin");
                stage.show();

                // Close the current login window
                Stage currentStage = (Stage) usernameField.getScene().getWindow();
                currentStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (username.equalsIgnoreCase("stock")) {
            // Load stock user's album
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("StockAlbum.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 500, 500));
                stage.setTitle("Stock Album");
                stage.show();

                // Close the current login window
                Stage currentStage = (Stage) usernameField.getScene().getWindow();
                currentStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // For normal users
            // Perform regular user login actions
            // For example, load the user screen
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("User.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 500, 500));
                stage.setTitle("Photo Album Application");
                stage.show();

                // Close the current login window
                Stage currentStage = (Stage) usernameField.getScene().getWindow();
                currentStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}


