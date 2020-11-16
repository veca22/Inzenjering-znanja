recomended_procedures(P1, P2, P3, radiographic_imaging_procedure):- compare(=, P1, arm_pain), compare(=, P2, elbow_pain), compare(=, P3, arm_swelling), !.
recomended_procedures(P1, P2, electrocardiogram):- compare(=, P1, arm_pain), compare(=, P2, wrist_pain), !.
recomended_procedures(P1, plain_x-ray):- compare(=, P1, arm_pain), !.

recomended_procedures(P1, P2, P3, physical_therapy_exercises):- compare(=, P1, wrist_pain), compare(=, P2, hand_or_finger_pain), compare(=, P3, wrist_stiffnes_or_tightness), !.
recomended_procedures(P1, P2, magnetic_resonance_imaging):- compare(=, P1, wrist_pain), compare(=, P2, wrist_swelling), !.
recomended_procedures(P1, plain_x-ray):- compare(=, P1, wrist_pain), !.

recomended_procedures(P1, P2, radiographic_imaging_procedure):- compare(=, P1, shoulder_pain), compare(=, P2, shoulder_stiffness_or_tightness), !.
recomended_procedures(P1, physical_therapy_exercises):- compare(=, P1, shoulder_pain), !.

recomended_procedures(P1, P2, P3, plain_x-ray):- compare(=, P1, elbow_pain), compare(=, P2, elbow_swelling), compare(=, P3, elbow_stiffness_or_tightness), !.
recomended_procedures(P1, P2, physical_therapy_exercises):- compare(=, P1, elbow_swelling), compare(=, P2, elbow_stiffness_or_tightness), !.
recomended_procedures(P1, application_of_splint):- compare(=, P1, elbow_pain), !.

recomended_procedures(P1, P2, radiographic_imaging_procedure):- compare(=, P1, wrist_swelling), compare(=, P2,wrist_stiffnes_or_tightness), !.
recomended_procedures(P1, application_of_splint):- compare(=, P1, wrist_swelling), !.

recomended_procedures(P1, P2, P3, plain_x-ray):- compare(=, P1, arm_swelling), compare(=, P2, arm_pain), compare(=, P3, arm_stiffnes_or_tightness), !.
recomended_procedures(P1, complete_blood_count):- compare(=, P1, arm_swelling), !.

recomended_procedures(P1, P2, P3, radiographic_imaging_procedure):- compare(=, P1, elbow_swelling), compare(=, P2, elbow_pain), compare(=, P3, elbow_stiffness_or_tightness), !.
recomended_procedures(P1, plain_x-ray):- compare(=, P1, elbow_swelling), !.

recomended_procedures(P1, P2, physical_therapy_exercises):- compare(=, P1, arm_stiffnes_or_tightness), compare(=, P2, arm_pain), !.
recomended_procedures(P1, plain_x-ray):- compare(=, P1, arm_stiffnes_or_tightness), !.

recomended_procedures(P1, P2, physical_therapy_exercises):- compare(=, P1, wrist_stiffnes_or_tightness), compare(=, P2, wrist_pain), !.
recomended_procedures(P1, plain_x-ray):- compare(=, P1, wrist_stiffnes_or_tightness), !.

recomended_procedures(P1, P2, magnetic_resonance_imaging):- compare(=, P1, wrist_stiffnes_or_tightness), compare(=, P2, shoulder_pain), !.
recomended_procedures(P1, plain_x-ray):- compare(=, P1, shoulder_stiffness_or_tightness), !.

recomended_procedures(P1, P2, other_diagnostic_procedures):- compare(=, P1, elbow_stiffness_or_tightness), compare(=, P2, elbow_pain), !.
recomended_procedures(P1, radiographic_imaging_procedure):- compare(=, P1, elbow_stiffness_or_tightness), !.

recomended_procedures(P1, P2, plain_x-ray):- compare(=, P1, hand_or_finger_pain), compare(=, P2, hand_or_finger_swelling), !.
recomended_procedures(P1, radiographic_imaging_procedure):- compare(=, P1, hand_or_finger_pain), !.

recomended_procedures(P1, P2, physical_therapy_exercises):- compare(=, P1, hand_or_finger_swelling), compare(=, P2, hand_or_finger_pain), !.
recomended_procedures(P1, wound_care_managemente):- compare(=, P1, hand_or_finger_swelling), !.

recomended_procedures(P1, P2, physical_therapy_exercises):- compare(=, P1, hand_or_finger_stiffness_or_tightness), compare(=, P2, hand_or_finger_pain), !.
recomended_procedures(P1, radiographic_imaging_procedure):- compare(=, P1, hand_or_finger_stiffness_or_tightness), !.

recomended_procedures(P1, P2, orthopedic_casting):- compare(=, P1, ankle_pain), compare(=, P2, ankle_swelling), !.
recomended_procedures(P1, application_of_splint):- compare(=, P1, ankle_pain), !.

recomended_procedures(P1, P2, plain_x-ray):- compare(=, P1, ankle_swelling), compare(=, P2, ankle_pain), !.
recomended_procedures(P1, radiographic_imaging_procedure):- compare(=, P1, ankle_swelling), !.

recomended_procedures(P1, P2, plain_x-ray):- compare(=, P1, leg_pain), compare(=, P2, foot_or_toe), !.
recomended_procedures(P1, magnetic_resonance_imaging):- compare(=, P1, leg_pain), !.


recomended_procedures(P1, P2, radiographic_imaging_procedure):- compare(=, P1, foot_or_toe_pain), compare(=, P2, foot_or_toe_swelling), !.
recomended_procedures(P1, application_of_splint):- compare(=, P1, foot_or_toe_pain), !.

recomended_procedures(P1, P2, examination_of_foot):- compare(=, P1, foot_or_toe_swelling), compare(=, P2, foot_or_toe_pain), !.
recomended_procedures(P1, complete_blood_count):- compare(=, P1, foot_or_toe_swelling), !.

recomended_procedures(P1, P2, magnetic_resonance_imaging):- compare(=, P1, knee_weakness), compare(=, P2, knee_pain), !.
recomended_procedures(P1, plain_x-ray):- compare(=, P1, knee_weakness), !.

recomended_procedures(P1, P2, plain_x-ray):- compare(=, P1, knee_pain), compare(=, P2, leg_pain), !.
recomended_procedures(P1, radiographic_imaging_procedure):- compare(=, P1, knee_pain), !.

recomended_procedures(P1, P2, x-ray_computed_tomography):- compare(=, P1, hip_pain), compare(=, P2, leg_pain), !.
recomended_procedures(P1, plain_x-ray):- compare(=, P1, hip_pain), !.

recomended_procedures(P1, P2, physical_therapy_exercises):- compare(=, P1, problems_with_movement), compare(=, P2, ankle_swelling), !.
recomended_procedures(P1, radiographic_imaging_procedure):- compare(=, P1, problems_with_movement), !.
