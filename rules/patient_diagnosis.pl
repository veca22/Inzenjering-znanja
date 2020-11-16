% osteoarthritis, cronic_knee_pain

knee_pain(knee_pain).
knee_swelling(knee_swelling).
leg_pain(leg_pain).
hip_pain(hip_pain).

leg_find_diagnose(KP, KS, LP, HP, chronic_knee_pain) :- compare(=, KP, knee_pain), compare(=, KS, knee_swelling), compare(=, LP, leg_pain), compare(=, HP, hip_pain),!.
leg_find_diagnose(KP, KS, LP, _HP, chronic_knee_pain) :- compare(=, KP, knee_pain), compare(=, KS, knee_swelling), compare(=, LP, leg_pain),!.
leg_find_diagnose(KP, KS, _LP, _HP, chronic_knee_pain) :- compare(=, KP, knee_pain), compare(=, KS, knee_swelling),!.
leg_find_diagnose(KP, _KS, _LP, _HP, osteoarthritis) :- compare(=, KP, knee_pain),!.
leg_find_diagnose(KP, _KS, LP, HP, osteoarthritis) :- compare(= , KP, knee_pain), compare(=, LP, leg_pain), compare(=, HP, hip_pain),!.

% injury of the shoulder, spinal stenosis, sprain_or_strain

shoulder_pain(shoulder_pain).
neck_pain(neck_pain).
back_pain(back_pain).
arm_pain(arm_pain).

shoulder_find_diagnose(SP, NP, BP, AP, spinal_stenosis) :- compare(=, SP, shoulder_pain), compare(=, NP, neck_pain), compare(=, BP, back_pain), compare(=, AP, arm_pain),!.
shoulder_find_diagnose(SP, NP, BP, _AP, sprain_or_strain) :- compare(=, SP, shoulder_pain), compare(=, NP, neck_pain), compare(=, BP, back_pain),!.
shoulder_find_diagnose(SP, NP, _BP, AP, brachial_neuritis) :- compare(=, SP, shoulder_pain), compare(=, NP, neck_pain), compare(=, NP, neck_pain), compare(=, AP, arm_pain),!.
shoulder_find_diagnose(SP, NP, _BP, _AP, sprain_or_strain) :- compare(=, SP, shoulder_pain), compare(=, NP, neck_pain),!.
shoulder_find_diagnose(SP, _NP, _BP, _AP, injury_of_the_shoulder) :- compare(=, SP, shoulder_pain),!.
shoulder_find_diagnose(_SP, _NP, _BP, AP, injury_of_the_shoulder) :- compare(=, AP, arm_pain),!.


% fracture of the hand, injury of the arm, sprain or strain

wrist_pain(wrist_pain).
hand_or_finger_pain(hand_or_finger_pain).
wrist_swelling(wrist_swelling).

arm_find(WP, HP, WS, fracture_of_the_hand) :- compare(=, WP, wrist_pain), compare(=, HP, hand_or_finger_pain), compare(=, WS, wrist_swelling),!.
arm_find(WP, _HP, WS, injury_to_the_arm) :- compare(=, WP, wrist_pain), compare(=, WS, wrist_swelling),!.
arms_find(WP, _HP, _WS, sprain_or_strain) :- compare(=, WP, wrist_pain),!.

