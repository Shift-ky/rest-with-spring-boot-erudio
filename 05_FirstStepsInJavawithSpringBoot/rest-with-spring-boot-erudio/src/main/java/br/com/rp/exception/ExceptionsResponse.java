package br.com.rp.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionsResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date tmestamp;
	private String messege;
	private String details;
	
	public ExceptionsResponse(Date tmestamp, String messege, String details) {
		this.tmestamp = tmestamp;
		this.messege = messege;
		this.details = details;
	}

	public Date getTmestamp() {
		return tmestamp;
	}

	public void setTmestamp(Date tmestamp) {
		this.tmestamp = tmestamp;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	

}
