package cbr;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import connector.DiagnosisConnector;
import connector.MedicamentConnector;
import model.Diagnosis;
import model.Medicaments;
import similarity.ListTableSimilarity;
import similarity.TableSimilarity;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;
import view.MainFrame;

public class MedicamentApplication {
	
	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public void configure() throws ExecutionException {
		_connector =  new MedicamentConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
		
		// simConfig.addMapping(new Attribute("attribute", CaseDescription.class), new Interval(5));

		TableSimilarity table = new TableSimilarity((Arrays.asList(new String[] {"fracture_of_the_arm","fracture_of_the_leg","sprain_or_strain_arm"})));
		table.setSimilarity("fracture_of_the_arm", "sprain_or_strain_arm", .8);
		table.setSimilarity("sprain_or_strain_arm", "fracture_of_the_leg", .2);
		table.setSimilarity("fracture_of_the_leg", "sprain_or_strain_arm", .2);
		simConfig.addMapping(new Attribute("diagnose", Medicaments.class), table);	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		MainFrame.getInstance().setRet3(eval);
		System.out.println("\nRetrieved cases:\n");
		for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
	}

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		Collection<CBRCase> cases = _caseBase.getCases();
		System.out.println("\n");
		for (CBRCase c: cases)
			System.out.println(c.getDescription());
		return _caseBase;
	}
	
	

	public void run(String diagnose) {
		MedicamentApplication recommender = new MedicamentApplication();
		try {
			recommender.configure();

			recommender.preCycle();

			CBRQuery query = new CBRQuery();

			Medicaments m = new Medicaments();
			
			m.setDiagnose(diagnose);

			query.setDescription( m );

			recommender.cycle(query);

			recommender.postCycle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
