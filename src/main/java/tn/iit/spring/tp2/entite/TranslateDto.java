package tn.iit.spring.tp2.entite;

import java.io.Serializable;

public class TranslateDto implements Serializable {
	private String motIn;
	private String motOut;
	private String LangueIn;
	private String LangueOut;
	public String getMotIn() {
		return motIn;
	}
	public void setMotIn(String motIn) {
		this.motIn = motIn;
	}
	public String getMotOut() {
		return motOut;
	}
	public void setMotOut(String motOut) {
		this.motOut = motOut;
	}
	
	public TranslateDto(String motIn, String motOut, String idLangueIn, String idLangueOut) {
		super();
		this.motIn = motIn;
		this.motOut = motOut;
		this.LangueIn = LangueIn;
		this.LangueOut = LangueOut;
	}
	public String getLangueIn() {
		return LangueIn;
	}
	public void setLangueIn(String langueIn) {
		LangueIn = langueIn;
	}
	public String getLangueOut() {
		return LangueOut;
	}
	public void setLangueOut(String langueOut) {
		LangueOut = langueOut;
	}
	
	
	

}
