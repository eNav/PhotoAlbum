package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AdminController {

	@FXML
	private ListView<String> userList;

	@FXML
	private TextField newUserField;

	private ArrayList<String> users = new ArrayList<>();

	public void listUsers() {
		// Populate userList with user names
	}

	public void createUser() {
		String newUser = newUserField.getText().trim();
		if (!newUser.isEmpty() && !users.contains(newUser)) {
			users.add(newUser);
			newUserField.clear();
			refreshUserList();
		} else {
			// Alert the user that the username already exists
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Username Exists");
			alert.setHeaderText(null);
			alert.setContentText("The username already exists. Please choose a different username.");
			alert.showAndWait();
		}
	}

	private void refreshUserList() {
		// Clear the existing items in the ListView
		userList.getItems().clear();

		// Add users to the ListView
		userList.getItems().addAll(users);
	}

	public void deleteUser() {
		// Get the selected user from the ListView
		String selectedUser = userList.getSelectionModel().getSelectedItem();
		if (selectedUser != null) {
			// Remove the selected user from the list of users
			users.remove(selectedUser);
			refreshUserList();
		}
	}

	public void logout() {
		Stage stage = (Stage) userList.getScene().getWindow();
		stage.close();
	}
}
