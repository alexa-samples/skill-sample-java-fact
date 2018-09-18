package com.amazon.ask.airplanefacts.util;

public class Fact {
	
	private String id;
	private String primaryText;
	private String image;
	
	public Fact(String id, String primaryText, String image) {
		this.id = id;
		this.primaryText = primaryText;
		this.image = image;
	}
	
	public String getId() {
		return id;
	}
	
	public String getImage() {
		return image;
	}
	
	public String getPrimaryText() {
		return primaryText;
	}
}
