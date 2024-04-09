package application;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import controller.AlbumViewController;

public class Album implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String storeDir = "dat";
	public static final String storeFile = "users.dat";

	public String albumName;

	public ArrayList<Photo> photoslist;

	public int photoCount = 0;

	public Photo currentPhoto;

	/**
	 * Constructor for Album
	 * 
	 * @param albumName
	 */
	public Album(String albumName) {
		this.albumName = albumName;
		photoslist = new ArrayList<Photo>();
	}

	public void addPhoto(Photo photo) {
		photoslist.add(photo);
		photoCount++;
	}
}
