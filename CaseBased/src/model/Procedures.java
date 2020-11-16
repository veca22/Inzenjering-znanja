package model;

import java.util.ArrayList;
import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;
import util.StringListMapper;

public class Procedures implements CaseComponent {
	
	private List<String> symptoms;
	private String procedure;
	
	

	public Procedures() {
		super();
	}

	
	
	public Procedures(List<String> symptoms, String procedure) {
		super();
		this.symptoms = symptoms;
		this.procedure = procedure;
	}



	public List<String> getSymptoms() {
		return symptoms;
	}



	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}



	public String getProcedure() {
		return procedure;
	}



	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}



	@Override
    public String toString() {
        String retVal = StringListMapper.toString(symptoms);
        if (procedure != null && procedure.length() > 0)
            retVal += "=>" + procedure;

        return retVal;
    }



	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
