youth_patient(Age) :- Age < 31.
middle_aged_patient(Age) :- Age > 30, Age < 51.
old_aged_patient(Age) :- Age > 50. 

% Licna anamneza pacijenta

patient_personal_anamnesis_diabetes(diabetes).
patient_personal_anamnesis_part_of_the_metal_in_the_body(part).

% Nasledjena anamneza, anomalies = urodjene anomalije(kriva kicma, ravni tabani, ...)

patient_family_anamnesis_anomalies(anomalie).

% Prethodne anamneze (prelom,uganuce,...)

patient_early_anamnesis_fracture(fracture).
patient_early_anamnesis_sprain(sprain).
patient_early_anamnesis_strain(strain).


% Vidljivo stanje (otok, vidljiv prelom, vidljivo uganuce, ...)

visible_state_swelling(swelling).
visible_state_bleeding(bleeding).
visible_state_visible_fracture(fracture).


% preventive_examination(Age,Db,Metal,Anom,Sw,Bl,Vf,Type)
% Age - broj godina pacijenta, Db - dijabetes, Metal - metalni deo ugradjen u telo(npr. metalni kuk), Anom - anomalije, Sw - otok, Bl - krvarenje, Vf - fraktura, Type - tip preventivnog pregleda



preventive_examination(_Age,_Db, Metal,_Anom,Sw,_Bl,Vf, ct_scan) :- compare(=,Sw,swelling), compare(=,Metal,part), compare(=,Vf,fracture),!.
preventive_examination(Age,_Db, _Metal,_Anom,Sw,_Bl,Vf, magnetic_resonance) :- compare(=,Sw,swelling), compare(=,Vf,fracture), compare(>,Age,50), !.
preventive_examination(_Age,_Db,_Metal,Anom,Sw,_Bl,_Vf, ct_scan) :- compare(=,Anom,anomalie), compare(=,Sw,swelling), !.
preventive_examination(_Age,_Db,_Metal,_Anom,Sw,_Bl,Vf, x_ray) :- compare(=,Vf,fracture), compare(=,Sw,swelling), !.
preventive_examination(_Age,_Db,_Metal,_Anom,_Sw,Bl,_Vf, suturing_of_wound) :- compare(=,Bl,bleeding), !.
preventive_examination(_Age,_Db,_Metal,_Anom,Sw,_Bl,_Vf, x_ray) :- compare(=,Sw,swelling), !.





