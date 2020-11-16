package model;

import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;
import util.StringListMapper;

public class Diagnosis implements CaseComponent{

	private String diagnosis;
	private List<String> symptom;
	
	
	public Diagnosis() {
		super();
	}


	public Diagnosis(String diagnosis, List<String> symptom) {
		super();
		this.diagnosis = diagnosis;
		this.symptom = symptom;
	}


	public String getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}


	public List<String> getSymptom() {
		return symptom;
	}


	public void setSymptom(List<String> symptom) {
		this.symptom = symptom;
	}


	@Override
	public Attribute getIdAttribute() {
		return null;
}


	  @Override
	    public String toString() {
	        String retVal = StringListMapper.toString(symptom);
	        if (diagnosis != null && diagnosis.length() > 0)
	            retVal += "=>" + diagnosis;
	        return retVal;
	    }
	
	
	

	
}
