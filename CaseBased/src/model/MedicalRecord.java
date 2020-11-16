package model;

import java.io.Serializable;

public class MedicalRecord implements Serializable {
	
	private String brKnjizice;
	private String imeOsiguranika;
	private String prezimeOsiguranika;
	private String jmbgOsiguranika;
	private int visina;
	private int tezina;
	private boolean zaposlen = false;
	private Gender pol;
	private String krvnaGrupa;
	private boolean pusenje = false;
	private boolean gojaznost = false;
	private boolean dijabetes = false;
	private boolean alkoholizam = false;
	private boolean nedovoljnaFizickaAktivnost = false;
	
	public MedicalRecord() {
		super();
	}

	public MedicalRecord(String brKnjizice, String imeOsiguranika, String prezimeOsiguranika, String jmbgOsiguranika,
			int visina, int tezina, boolean zaposlen, Gender pol, String krvnaGrupa, boolean pusenje, boolean gojaznost,
			boolean dijabetes, boolean alkoholizam, boolean nedovoljnaFizickaAktivnost) {
		super();
		this.brKnjizice = brKnjizice;
		this.imeOsiguranika = imeOsiguranika;
		this.prezimeOsiguranika = prezimeOsiguranika;
		this.jmbgOsiguranika = jmbgOsiguranika;
		this.visina = visina;
		this.tezina = tezina;
		this.zaposlen = zaposlen;
		this.pol = pol;
		this.krvnaGrupa = krvnaGrupa;
		this.pusenje = pusenje;
		this.gojaznost = gojaznost;
		this.dijabetes = dijabetes;
		this.alkoholizam = alkoholizam;
		this.nedovoljnaFizickaAktivnost = nedovoljnaFizickaAktivnost;
	}

	public String getBrKnjizice() {
		return brKnjizice;
	}

	public void setBrKnjizice(String brKnjizice) {
		this.brKnjizice = brKnjizice;
	}

	public String getImeOsiguranika() {
		return imeOsiguranika;
	}

	public void setImeOsiguranika(String imeOsiguranika) {
		this.imeOsiguranika = imeOsiguranika;
	}

	public String getPrezimeOsiguranika() {
		return prezimeOsiguranika;
	}

	public void setPrezimeOsiguranika(String prezimeOsiguranika) {
		this.prezimeOsiguranika = prezimeOsiguranika;
	}

	public String getJmbgOsiguranika() {
		return jmbgOsiguranika;
	}

	public void setJmbgOsiguranika(String jmbgOsiguranika) {
		this.jmbgOsiguranika = jmbgOsiguranika;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public int getTezina() {
		return tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}

	public boolean isZaposlen() {
		return zaposlen;
	}

	public void setZaposlen(boolean zaposlen) {
		this.zaposlen = zaposlen;
	}

	public Gender getPol() {
		return pol;
	}

	public void setPol(Gender pol) {
		this.pol = pol;
	}

	public String getKrvnaGrupa() {
		return krvnaGrupa;
	}

	public void setKrvnaGrupa(String krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}

	public boolean isPusenje() {
		return pusenje;
	}

	public void setPusenje(boolean pusenje) {
		this.pusenje = pusenje;
	}

	public boolean isGojaznost() {
		return gojaznost;
	}

	public void setGojaznost(boolean gojaznost) {
		this.gojaznost = gojaznost;
	}

	public boolean isDijabetes() {
		return dijabetes;
	}

	public void setDijabetes(boolean dijabetes) {
		this.dijabetes = dijabetes;
	}

	public boolean isAlkoholizam() {
		return alkoholizam;
	}

	public void setAlkoholizam(boolean alkoholizam) {
		this.alkoholizam = alkoholizam;
	}

	public boolean isNedovoljnaFizickaAktivnost() {
		return nedovoljnaFizickaAktivnost;
	}

	public void setNedovoljnaFizickaAktivnost(boolean nedovoljnaFizickaAktivnost) {
		this.nedovoljnaFizickaAktivnost = nedovoljnaFizickaAktivnost;
	}

	@Override
	public String toString() {
		return "MedicalRecord [brKnjizice=" + brKnjizice + ", imeOsiguranika=" + imeOsiguranika
				+ ", prezimeOsiguranika=" + prezimeOsiguranika + ", jmbgOsiguranika=" + jmbgOsiguranika + ", visina="
				+ visina + ", tezina=" + tezina + ", zaposlen=" + zaposlen + ", pol=" + pol + ", krvnaGrupa="
				+ krvnaGrupa + ", pusenje=" + pusenje + ", gojaznost=" + gojaznost + ", dijabetes=" + dijabetes
				+ ", alkoholizam=" + alkoholizam + ", nedovoljnaFizickaAktivnost=" + nedovoljnaFizickaAktivnost + "]";
	}
	
	
	
}
