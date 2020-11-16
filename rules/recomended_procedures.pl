
ankle_dislocation(ankle_dislocation).
shoulder_dislocation(shoulder_dislocation).

arm_swelling(arm_swelling).
not_arm_swelling(not_arm_swelling).
leg_swelling(leg_swelling).
not_leg_swelling(not_leg_swelling).
shoulder_swelling(shoulder_swelling).
not_shoulder_swelling(not_shoulder_swelling).
finger_swelling(finger_swelling).


knee_pain(knee_pain).
not_knee_pain(not_knee_pain).
elbow_pain(elbow_pain).
not_elbow_pain(not_elbow_pain).
shoulder_pain(shoulder_pain).
not_shoulder_pain(not_shoulder_pain).
head_pain(head_pain).
finger_pain(finger_pain).

open_fracture(open_fracture).
closed_fracture(closed_fracture).
hand_fracture(hand_fracture).
not_hand_fracture(hand_fracture).
foot_fracture(foot_fracture).
not_foot_fracture(foot_fracture).
head_fracture(head_fracture).


big_deformitet(big_deformitet).
small_deformitet(small_deformitet).


x-ray(x-ray).
magnetic_resonance(magnetic_resonance).

recomended_procedures(SD, SW, SP, MR, operation) :- compare(=,SD,shoulder_dislocation), compare(=,SW,shoulder_swelling),compare(=,SP,shoulder_pain),compare(=,MR, magnetic_resonance),!.
recomended_procedures(HF, HP, MR, ct) :- compare(=, HF, head_fracture), compare(=, HP, head_pain), compare(=, MR, magnetic_resonance), !.
recomended_procedures(_CF, BD, XR, operation) :-  compare(=, BD, big_deformitet), compare(=,XR,x-ray),!.
recomended_procedures(_CF, SD, XR, gypsom) :- compare(=,SD,small_deformitet), compare(=,XR,x-ray),!.
recomended_procedures(KP, LS, magnetic_resonance) :- compare(=, KP, knee_pain), compare(=, LS,leg_swelling),!.
recomended_procedures(NKP, LS, x-ray) :- compare(=, NKP, not_knee_pain), compare(=, LS, leg_swelling),!.
recomended_procedures(FS,FP, x-ray) :- compare(=, FS, finger_swelling), compare(=, FP, finger_pain), !.
recomended_procedures(AD, XR, ankle_bandaging) :- compare(=, AD, ankle_dislocation), compare(=, XR, x-ray),!.





















