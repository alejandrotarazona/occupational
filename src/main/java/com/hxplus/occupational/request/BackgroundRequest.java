package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Background;

public class BackgroundRequest {

	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Background toBackground() {
		Background background = new Background();
		background.setName(name);
		background.setDescription(description);

		return background;
	}

}
