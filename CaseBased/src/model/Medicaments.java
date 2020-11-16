package model;

import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;
import util.StringListMapper;

public class Medicaments implements CaseComponent{

	private String diagnose;
	private List<String> medicament;
		
	public Medicaments() {
		super();
	}
	
	public Medicaments(String diagnose, List<String> medicament) {
		super();
		this.diagnose = diagnose;
		this.medicament = medicament;
	}
	
	
	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public List<String> getMedicament() {
		return medicament;
	}

	public void setMedicament(List<String> medicament) {
		this.medicament = medicament;
	}

	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id",this.getClass());
	}

	  @Override
	    public String toString() {
	        String retVal = StringListMapper.toString(medicament);
	        if (diagnose != null && diagnose.length() > 0)
	            retVal += "=>" + diagnose;
	        return retVal;
	    }
	
	
	
}
