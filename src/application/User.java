package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private List<Album> albums;

	public User(String username) {
		this.username = username;
		albums = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void createAlbum(String name) {
		albums.add(new Album(name));
	}

	public void deleteAlbum(Album album) {
		albums.remove(album);
	}

	public List<Album> getAlbums() {
		return albums;
	}
	public boolean isStockUser(User user) {
	    return user != null && user.getUsername().equals("stock");
	}
}
