import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.UIManager;

import cbr.DiagnosisApplication;
import cbr.MedicamentApplication;
import cbr.ProceduresCbrApplication;
import cbr.SymptomeApplication;
import model.Diagnosis;
import model.Patient;
import model.Table.PatientBase;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
    	
    	try { 
			  
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel"); 
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel not set"); 
        }
        
    	// DiagnosisApplication diagnosisApplication = new DiagnosisApplication();
       	// diagnosisApplication.run(Arrays.asList("arm_pain","wrist_swelling", "arm_stiffness_or_tightness","arm_swelling","hand_or_finger_stiffness_or_tigtness","wrist_stiffnes_or_tightness"));
        // MedicamentApplication medicamentApplication = new MedicamentApplication();
        // medicamentApplication.run(Arrays.asList("ketamine","flumazenil","fluorides","fenoprofen","plasma_protein_fraction"));
//        ProceduresCbrApplication pca = new ProceduresCbrApplication();
//        System.out.println(PatientBase.getInstance().getDiagnosis_list().toString());
		// pca.run(Arrays.asList("shoulder_pain","arm_pain","arm_swelling"));
		// pca.run(Arrays.asList("shoulder_pain"));
		// pca.run(Arrays.asList("wrist_pain"));
        // SymptomeApplication symptomeApplication = new SymptomeApplication();
        // symptomeApplication.run(Arrays.asList("bruise","sprain_or_strain","fracture_of_the_arm","injury_to_the_shoulder","spinal_stenosis","brachial_neuritis","pyogenic_skin_infection","carpal_tunel_syndrome"));
        
        MainFrame.getInstance().setVisible(true);
    	
//    	MedicamentApplication m = new MedicamentApplication();
//    	m.run("sprain_or_strain_arm");
    }

}



