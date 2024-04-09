package application;

import java.io.File;
import java.io.Serializable;

public class Photo implements Serializable {

	private String thumbnailPath;
	private String caption;

	public File picture;

	// Constructor
	public Photo(String thumbnailPath, String caption) {
		this.thumbnailPath = thumbnailPath;
		this.caption = caption;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public String getCaption() {
		return caption;
	}

	public void setPic(File picture) {
		this.picture = picture;
	}

	public File getPic() {
		return this.picture;
	}
}
