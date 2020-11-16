package cbr;

import java.util.Collection;
import java.util.List;

import connector.DiagnosisConnector;
import model.Diagnosis;
import similarity.ListTableSimilarity;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
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

public class DiagnosisApplication implements StandardCBRApplication{
			
		Connector _connector;  /** Connector object */
		CBRCaseBase _caseBase;  /** CaseBase object */

		NNConfig simConfig;  /** KNN configuration */
		
		public void configure() throws ExecutionException {
			_connector =  new DiagnosisConnector();
			
			_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
			
			simConfig = new NNConfig(); // KNN configuration
			simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
			
			// simConfig.addMapping(new Attribute("attribute", CaseDescription.class), new Interval(5));

			simConfig.addMapping(new Attribute("symptom", Diagnosis.class), new ListTableSimilarity());
		}

		public void cycle(CBRQuery query) throws ExecutionException {
			Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
			eval = SelectCases.selectTopKRR(eval, 5);
			MainFrame.getInstance().setRet2(eval);
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
			for (CBRCase c: cases) {
				
				System.out.println(c.getDescription());
			}
			return _caseBase;
		}
		
		

		public void run(List<String> symptoms) {
			DiagnosisApplication recommender = new DiagnosisApplication();
			try {
				recommender.configure();

				recommender.preCycle();

				CBRQuery query = new CBRQuery();

				Diagnosis d = new Diagnosis();

				d.setSymptom(symptoms);

				query.setDescription( d );

				recommender.cycle(query);

				recommender.postCycle();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}