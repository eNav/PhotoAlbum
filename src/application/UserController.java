package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import controller.AlbumViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class UserController {

	@FXML
	private ListView<String> albumListView;

	private List<String> albums = new ArrayList<>(); // Assume this list contains album names

	public void initialize() {
		// Load albums associated with the logged-in user
		// For example, you can fetch the albums from a database

		// Add album names to the list
		albums.add("Album 1");
		albums.add("Album 2");

		// Populate the ListView with album names
		albumListView.getItems().addAll(albums);
	}
	
	

	public void createAlbum() {
		// Prompt the user to enter the name of the new album
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Create Album");
		dialog.setHeaderText(null);
		dialog.setContentText("Enter the name of the new album:");

		Optional<String> result = dialog.showAndWait();
		result.ifPresent(albumName -> {
			// Add the new album name to the list
			albums.add(albumName);

			// Refresh the ListView
			albumListView.getItems().clear();
			albumListView.getItems().addAll(albums);
		});
	}

	public void logout() {
		Stage currentStage = (Stage) albumListView.getScene().getWindow();
		currentStage.close();
	}

	public void deleteAlbum() {
		int selectedIndex = albumListView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			// Remove the selected album from the list
			albums.remove(selectedIndex);

			// Refresh the ListView
			refreshAlbumList();
		} else {
			// No album is selected, show an error message
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select an album to delete.");
			alert.showAndWait();
		}
	}

	private void refreshAlbumList() {
		// Clear and re-populate the ListView with the updated list of albums
		albumListView.getItems().clear();
		albumListView.getItems().addAll(albums);
	}

	public void openAlbum() {
		int selectedIndex = albumListView.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			String selectedAlbum = albumListView.getSelectionModel().getSelectedItem();
			try {
				// Load the FXML file for the album view
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Album.fxml"));
				Scene scene = new Scene(loader.load());

				// Set the album name as a parameter to the controller
				AlbumViewController albumViewController = loader.getController();
				albumViewController.setAlbumName(selectedAlbum);

				// Create a new stage for the album view
				Stage albumStage = new Stage();
				albumStage.setScene(scene);
				albumStage.setTitle(selectedAlbum);
				albumStage.show();
			} catch (IOException e) {
				e.printStackTrace();
				// Show an error message if loading fails
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Failed to open album.");
				alert.showAndWait();
			}
		} else {
			// No album is selected, show an error message
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select an album to open.");
			alert.showAndWait();
		}
	}
}
