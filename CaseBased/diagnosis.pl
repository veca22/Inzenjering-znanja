find_diagnose(HP, KP, KS, LP, chronic_knee_pain) :- compare(=, HP, hip_pain), compare(=, KP, knee_pain), compare(=, KS, knee_swelling), compare(=, LP, leg_pain),!.
find_diagnose(AP, BP, NP, SP, spinal_stenosis) :- compare(=, AP, arm_pain), compare(=, BP, back_pain), compare(=, NP, neck_pain), compare(=, SP, shoulder_pain),!.
find_diagnose(AP, AS, WP, WS, fracture_of_the_arm) :- compare(=, AP, arm_pain), compare(=, AS, arm_swelling), compare(=, WP, wrist_pain), compare(=, WS, wrist_swelling),!.
find_diagnose(AP, AS, FP, FS, fracture_of_the_ankle) :- compare(=, AP, ankle_pain), compare(=, AS, ankle_swelling), compare(=, FP, foot_or_toe_pain), compare(=, FS, foot_or_toe_swelling),!.
find_diagnose(AP, AS, AW, LP, fracture_of_the_ankle) :- compare(=, AP, ankle_pain), compare(=, AS, ankle_swelling), compare(=, AW, ankle_weakness), compare(=, LP, leg_pain),!.
find_diagnose(KP, KS, LP, LS, fracture_of_the_leg) :- compare(=, KP, knee_pain), compare(=, KS, knee_swelling), compare(=, LP, leg_pain), compare(=, LS, leg_swelling),!.
find_diagnose(HP, KP, KS, LP, fracture_of_the_leg) :- compare(=, HP, hip_pain), compare(=, KP, knee_pain), compare(=, KS, knee_swelling), compare(=, LP, leg_pain),!.

find_diagnose(KP, KS, LP, chronic_knee_pain) :- compare(=, KP, knee_pain), compare(=, KS, knee_swelling), compare(=, LP, leg_pain),!.
find_diagnose(HP, KP, LP, osteoarthritis) :- compare(=, HP, hip_pain), compare(=, KP, knee_pain), compare(=, LP, leg_pain),!.
find_diagnose(AS, FP, FS, fracture_of_the_foot) :- compare(=, AS, ankle_swelling), compare(=, FP, foot_or_toe_pain), compare(=, FS, foot_or_toe_swelling),!.
find_diagnose(BP, NP, SP, sprain_or_strain_arm) :- compare(=, BP, back_pain), compare(=, NP, neck_pain), compare(=, SP, shoulder_pain),!.
find_diagnose(AM, EP, EW, sprain_or_strain_arm) :- compare(=, AM, arm_pain), compare(=, EP, elbow_pain), compare(=, EW, elbow_weakness),!.
find_diagnose(AP, NP, SP, brachial_neuritis) :- compare(=, AP, arm_pain), compare(=, NP, neck_pain), compare(=, SP, shoulder_pain),!.
find_diagnose(HF, WP, WS, fracture_of_the_hand) :- compare(=, HF, hand_or_finger_pain), compare(=, WP, wrist_pain), compare(=, WS, wrist_swelling),!.
find_diagnose(HF, HS, WP, fracture_of_the_hand) :- compare(=, HF, hand_or_finger_pain), compare(=, HS, hand_or_finger_stiffness_or_tightness), compare(=, WP, wrist_pain),!.
find_diagnose(HF, HS, HW, fracture_of_the_hand) :- compare(=, HF, hand_or_finger_pain), compare(=, HS, hand_or_finger_stiffness_or_tightness), compare(=, HW, hand_or_finger_swelling),!.
find_diagnose(AP, WP, WS, fracture_of_the_hand) :- compare(=, AP, arm_pain), compare(=, WP, wrist_pain), compare(=, WS, wrist_swelling),!.
find_diagnose(WP, WS, WT, fracture_of_the_hand) :- compare(=, WP, wrist_pain), compare(=, WS, wrist_swelling), compare(=, WT, wrist_stifness_or_tightness),!.
find_diagnose(AP, WP, WS, fracture_of_the_arm) :- compare(=, AP, arm_pain), compare(=, WP, wrist_pain), compare(=, WS, wrist_swelling),!.
find_diagnose(AP, EP, WP, fracture_of_the_arm) :- compare(=, AP, arm_pain), compare(=, EP, elbow_pain), compare(=, WP, wrist_pain),!.
find_diagnose(EP, SP, SS, fracture_of_the_arm) :- compare(=, EP, elbow_pain), compare(=, SP, shoulder_pain), compare(=, SS, shoulder_stiffness_tightness),!.
find_diagnose(HP, KP, LP, fracture_of_the_leg) :- compare(=, HP, hip_pain), compare(=, KP, knee_pain), compare(=, LP, leg_pain),!.
find_diagnose(LP, LS, LW, fracture_of_the_leg) :- compare(=, LP, leg_pain), compare(=, LS, leg_swelling), compare(=, LW, leg_weakness),!.
find_diagnose(LP, LS, LT, fracture_of_the_leg) :- compare(=, LP, leg_pain), compare(=, LS, leg_swelling), compare(=, LT, leg_stiffness_or_tightness),!.
find_diagnose(AP, AS, FP, fracture_of_the_ankle) :- compare(=, AP, ankle_pain), compare(=, AS, ankle_swelling), compare(=, FP, foot_or_toe_pain),!.
find_diagnose(AP, FP, FS, fracture_of_the_ankle) :- compare(=, AP, ankle_pain), compare(=, FP, foot_or_toe_pain), compare(=, FS, foot_or_toe_swelling),!.
find_diagnose(AW, FP, FS, fracture_of_the_ankle) :- compare(=, AW, ankle_weakness), compare(=, FP, foot_or_toe_pain), compare(=, FS, foot_or_toe_swelling),!.


find_diagnose(NP, SP, sprain_or_strain_arm) :- compare(=, NP, neck_pain), compare(=, SP, shoulder_pain),!.
find_diagnose(EW, SS, sprain_or_strain_arm) :- compare(=, EW, elbow_weakness), compare(=, SS, shoulder_stiffness_tightness),!.
find_diagnose(SP, SS, sprain_or_strain_arm) :- compare(=, SP, shoulder_pain), compare(=, SS, shoulder_stiffness_tightness),!.
find_diagnose(AP, WP, sprain_or_strain_hand) :- compare(=, AP, arm_pain), compare(=, WP, wrist_pain),!.
find_diagnose(HF, WP, fracture_of_the_hand) :- compare(=, HF, hand_or_finger_pain), compare(=, WP, wrist_pain),!.
find_diagnose(HF, HW, fracture_of_the_hand) :- compare(=, HF, hand_or_finger_pain), compare(=, HW, hand_or_finger_swelling),!.
find_diagnose(KP, LP, osteoarthritis) :- compare(=, KP, knee_pain), compare(=, LP, leg_pain),!.
find_diagnose(AP, FP, fracture_of_the_foot) :- compare(=, AP, ankle_pain), compare(=, FP, foot_or_toe_pain),!.
find_diagnose(FP, FS, fracture_of_the_foot) :- compare(=, FP, foot_or_toe_pain), compare(=, FS, foot_or_toe_swelling),!.
find_diagnose(AP, FP, fracture_of_the_foot) :- compare(=, AP, ankle_pain), compare(=, FP, foot_or_toe_pain),!.
find_diagnose(WP, WS, injury_to_the_arm) :- compare(=, WP, wrist_pain), compare(=, WS, wrist_swelling),!.
find_diagnose(AP, AS, fracture_of_the_ankle) :- compare(=, AP, ankle_pain), compare(=, AS, ankle_swelling),!.
find_diagnose(AP, AS, injury_to_the_arm) :- compare(=, AP, arm_pain), compare(=, AS, arm_stiffnes_or_tightness),!.

find_diagnose(AP, injury_to_the_leg) :- compare(=, AP, ankle_pain),!.
find_diagnose(FP, injury_to_the_leg) :- compare(=, FP, foot_or_toe_pain),!.
find_diagnose(LP, injury_to_the_leg) :- compare(=, LP, leg_pain),!.
find_diagnose(LS, injury_to_the_leg) :- compare(=, LS, leg_swelling),!.
find_diagnose(LW, injury_to_the_leg) :- compare(=, LW, leg_weakness),!.
find_diagnose(KP, injury_to_the_leg) :- compare(=, KP, knee_pain),!.
find_diagnose(KS, injury_to_the_leg) :- compare(=, KS, knee_swelling),!.
find_diagnose(LT, injury_to_the_leg) :- compare(=, LT, leg_stiffness_or_tightness),!.
find_diagnose(AW, injury_to_the_leg) :- compare(=, AW, ankle_weakness),!.
find_diagnose(AS, injury_to_the_leg) :- compare(=, AS, ankle_swelling),!.
find_diagnose(FP, injury_to_the_leg) :- compare(=, FP, foot_or_toe_pain),!.
find_diagnose(HF, sprain_or_strain_hand) :- compare(=, HF, hand_or_finger_pain),!.
find_diagnose(HS, sprain_or_strain_hand) :- compare(=, HS, hand_or_finger_stiffness_or_tightness),!.
find_diagnose(HW, sprain_or_strain_hand) :- compare(=, HW, hand_or_finger_swelling),!.
find_diagnose(KP, chronic_knee_pain) :- compare(=, KP, knee_pain),!.
find_diagnose(EP, sprain_or_strain_arm) :- compare(=, EP, elbow_pain),!.
find_diagnose(EW, sprain_or_strain_arm) :- compare(=, EW, elbow_weakness),!.
find_diagnose(SP, sprain_or_strain_arm) :- compare(=, SP, shoulder_pain),!.
find_diagnose(SS, sprain_or_strain_arm) :- compare(=, SS, shoulder_stiffness_tightness),!.
find_diagnose(WP, injury_to_the_arm) :- compare(=, WP, wrist_pain),!.
find_diagnose(WS, injury_to_the_arm) :- compare(=, WS, wrist_swelling),!.
find_diagnose(AP, injury_to_the_arm) :- compare(=, AP, arm_pain),!.
find_diagnose(EP, injury_to_the_arm) :- compare(=, EP, elbow_pain),!.