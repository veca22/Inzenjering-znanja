package connector;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.Diagnosis;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;
import util.StringListMapper;

public class DiagnosisConnector implements Connector {

	public Collection<CBRCase> retrieveAllCases() {
		 LinkedList<CBRCase> cases = new LinkedList<>();
		//List<Diagnosis> symptomDescriptions = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/Diagnosis.csv")));
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(";");

				CBRCase cbrCase = new CBRCase();

				Diagnosis diagnosis = new Diagnosis();
				
				diagnosis.setDiagnosis(values[0]);
				diagnosis.setSymptom(StringListMapper.toList(values[1]));
				
				cbrCase.setDescription(diagnosis);
				cases.add(cbrCase);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
         
     

     return cases;
 
	}
 @Override
 public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
     return null;
 }

 @Override
 public void storeCases(Collection<CBRCase> arg0) {
 }

 @Override
 public void close() {
 }

 @Override
 public void deleteCases(Collection<CBRCase> arg0) {
 }

 @Override
 public void initFromXMLfile(URL arg0) throws InitializingException {
 }
}
