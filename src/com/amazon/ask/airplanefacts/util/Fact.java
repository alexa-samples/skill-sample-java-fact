package com.amazon.ask.airplanefacts.util;

import java.io.Serializable;

public class Fact implements Serializable {
	private static final long serialVersionUID = 3663336221511819807L;
	
	private String id;
	private String primaryText;
	private String image;
	
	public Fact() {
		
	}
	
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
