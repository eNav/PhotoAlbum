package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import application.Photo;
import application.Album;

public class AlbumViewController {
	@FXML
	private Label albumNameLabel;

	@FXML
	private ListView<Photo> photoListView;

	@FXML
	public ImageView displayArea;
	private Image image;

	public void setAlbumName(String albumName) {
		albumNameLabel.setText(albumName);
	}

	public static ArrayList<Photo> photolist = new ArrayList<>();

	public Album album;

	

	@FXML
	private void addPhotoButtonClicked() {
		// Create a file chooser
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Photo");

		// Set file filter (optional)
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg",
				"*.jpeg", "*.gif");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File selectedFile = fileChooser.showOpenDialog(new Stage());

		// Check if a file was selected
		if (selectedFile != null) {
			// Create a Photo object with the selected file path and an empty caption
			Photo photo = new Photo(selectedFile.getAbsolutePath(), "");

			// Add the photo to the album
			// Assuming 'album' is an instance of your Album class
			album.addPhoto(photo);
			System.out.println("Successful Photo Creation");

			// Display the thumbnail of the added photo in your UI
			// You need to implement this part based on your UI structure
			displayThumbnail();
		} else {
			// User canceled the file selection
			System.out.println("No file selected.");
		}
	}

	public void displayThumbnail() {
		Photo photo = photoListView.getSelectionModel().getSelectedItem();
		File file;
		if (photo != null) {
			// Get the file associated with the selected photo
			file = photo.getPic();

			// Load the image from the file
			Image image = new Image(file.toURI().toString());
			displayArea.setImage(image);
		} else {
			// If no photo is selected, clear the display area
			displayArea.setImage(null);
		}
	}

}
