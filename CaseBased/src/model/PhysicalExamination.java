package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhysicalExamination implements Serializable {

	private int id;
	private String vidljivPrelom;
	private String vidljivOtok;
	private String mogucnostPokreta;
	private ArrayList<String> simptomi = new ArrayList<String>();
	private String procedura;
	private String dijagnoza;
	private String terapija;
	
	
	public PhysicalExamination() {
		super();
	}
	


	public PhysicalExamination(int id, String vidljivPrelom, String vidljivOtok, String mogucnostPokreta,
			ArrayList<String> simptomi) {
		super();
		this.id = id;
		this.vidljivPrelom = vidljivPrelom;
		this.vidljivOtok = vidljivOtok;
		this.mogucnostPokreta = mogucnostPokreta;
		this.simptomi = simptomi;
	}

	public PhysicalExamination(int id, String vidljivPrelom, String vidljivOtok, String mogucnostPokreta,
			ArrayList<String> simptomi, String procedura, String dijagnoza, String terapija) {
		super();
		this.id = id;
		this.vidljivPrelom = vidljivPrelom;
		this.vidljivOtok = vidljivOtok;
		this.mogucnostPokreta = mogucnostPokreta;
		this.simptomi = simptomi;
		this.procedura = procedura;
		this.dijagnoza = dijagnoza;
		this.terapija = terapija;
	}


	

	public String getProcedura() {
		return procedura;
	}



	public void setProcedura(String procedura) {
		this.procedura = procedura;
	}



	public String getDijagnoza() {
		return dijagnoza;
	}



	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}



	public String getTerapija() {
		return terapija;
	}



	public void setTerapija(String terapija) {
		this.terapija = terapija;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public ArrayList<String> getSimptomi() {
		return simptomi;
	}



	public void setSimptomi(ArrayList<String> simptomi) {
		this.simptomi = simptomi;
	}



	public String getVidljivPrelom() {
		return vidljivPrelom;
	}

	public void setVidljivPrelom(String vidljivPrelom) {
		this.vidljivPrelom = vidljivPrelom;
	}

	public String getVidljivOtok() {
		return vidljivOtok;
	}

	public void setVidljivOtok(String vidljivOtok) {
		this.vidljivOtok = vidljivOtok;
	}

	public String getMogucnostPokreta() {
		return mogucnostPokreta;
	}

	public void setMogucnostPokreta(String mogucnostPokreta) {
		this.mogucnostPokreta = mogucnostPokreta;
	}



	@Override
	public String toString() {
		return "PhysicalExamination [id=" + id + ", vidljivPrelom=" + vidljivPrelom + ", vidljivOtok=" + vidljivOtok
				+ ", mogucnostPokreta=" + mogucnostPokreta + ", simptomi=" + simptomi + ", procedura=" + procedura
				+ ", dijagnoza=" + dijagnoza + ", terapija=" + terapija + "]";
	}

		
	
}
