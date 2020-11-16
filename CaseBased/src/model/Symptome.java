package model;

import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;
import util.StringListMapper;

public class Symptome implements CaseComponent{
	
	private String symptome;
	private List<String> diagnose;

	public Symptome() {
		super();
	}

	public Symptome(String symptome, List<String> potential_diagnosis) {
		super();
		this.symptome = symptome;
		this.diagnose = potential_diagnosis;
	}

	public String getSymptome() {
		return symptome;
	}

	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}

	public List<String> getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(List<String> diagnose) {
		this.diagnose = diagnose;
	}

	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

	  @Override
	    public String toString() {
	        String retVal = StringListMapper.toString(diagnose);
	        if (symptome != null && symptome.length() > 0)
	            retVal += " -> " + symptome;
	        return retVal;
	    }

}
