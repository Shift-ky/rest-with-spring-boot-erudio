package br.com.rp;

public class Greting {
	
	private final long id;
	private final String content;
	
	
	public Greting(long id, String content) {
		this.id = id;
		this.content = content;
	}


	public long getId() {
		return id;
	}


	public String getContent() {
		return content;
	}

}
