find_medicament(ET, SH, DI, SA, FL, chronic_knee_pain ):- compare(=, ET, etodolac), compare(=, SH, sodium hyaluronate), compare(=, DI, diflunisal), compare(=, SA, salsalate), compare(=, FL, flurbiprofen),!.
find_medicament(DI, SA, HY, CH, chronic_knee_pain):- compare(=, DI, diflunisal), compare(=, SO, sodium), compare(=, HY, hyaluronate), compare(=, DI, diflunisal), compare(=, SA, salsalate), compare(=, SA, salsalate), compare(=, CH, choline),!.
find_medicament(SH, HY, FE, FZ, chronic_knee_pain):- compare(=, SO, sodium hyaluronate), compare(=, FE, febuxostat), compare(=, FZ, flurazepam),!.

find_medicament(CE, CO, ME, osteoarthritis):- compare(=, CE, celecoxib), compare(=, CO, cortisone), compare(=, ME, mepivacaine), !.
find_medicament(MX, CO, PX, osteoarthritis):- compare(=, MX, meloxicam), compare(=, CO, cortisone), compare(=, PX, piroxicam), !.
find_medicament(PX, CD, BU, osteoarthritis):- compaer(=, PX, piroxicam), compare(=, CD, chondroitin), compare(=, BU, bupivacaine), !.

find_medicament(CA, IX, DF, spinal_stenosis):- compare(=, CA, carisoprodol), compare(=, IX, iohexol), compare(=, DF, diclofencac topical product), !.
find_medicament(IX, IP, MO, CX, TR, spinal_stenosis):- compare(=, IX, iohexol), compare(=, IP, iopamidol), compare(=, MO, moexipril), compare(=, CX, chlorzoxazone), compare, TR, trimethadione) !.
find_medicament(IX, MO, spinal_stenosis):- compare(=, IX, iohexol), compare(=, MO, moexipril), !.

find_medicament(CY, MC, MT, sprain_or_strain_arm):- compare(=, CY, cyclobenzaprine), compare(=, MC, methocarbamol), compare(=, MT, metaxolone), !.
find_medicament(MT, DN, KE, OR, sprain_or_strain_arm):- compare(=, MT, metaxolone), compare(=, DN, diflunisal), compare(=, KE, ketoprofen), compare(=, OR, orphenadrine), !.
find_medicament(OR, DN, KE, sprain_or_strain_hand):- compare(=, OR, orphenadrine), compare(=, DN, diflunisal), compare(=, KE, ketoprofen), !.

find_medicament(CA, MT, PX, MQ, brachial_neuritis):- compare(=, CA, carisoprodol), compare(=, MT, metaxolone), compare(=, PX, piroxicam), compare(=, MQ, mefloquine), !.
find_medicament(OX, MQ, brachial_neuritis):- compare(=, OX, oxymorphone), compare(=, MQ, mefloquine), !.
find_medicament(MT, PX, MQ, brachial_neuritis):- compare(=, MT, metaxolone), compare(=, PX, piroxicam), compare(=, MQ, mefloquine), !.
find_medicament(QU, BE, FZ, brachial_neuritis):- compare(=, QU, quinine), compare(=, BE, bilberry extract), compare(=, FZ, flurazepam), !.

find_medicament(CO, ME, MH, DR, injury_to_the_shoulder):- compare(=, CO, cortisone), compare(=, ME, mepivacaine), compare(=, MH, methohexital), compare(=, DR, daunorubicin), !.
find_medicament(CT, DP, MA, fracture_of_the_hand):- compare(=, CT, carteolol), compare(=, DP, disopyramide), compare(=, MA, magnesium_amino_acid_chelate), !.

find_medicament(KE, FM, MH, CR, DX, FR, FP, PP,  fracture_of_the_arm):- compare(=, KE, ketamine), compare(=, FM, flumazenil), compare(=, MH, methohexital), compare(=, CR, carboprost), compare(=, DT, digitoxin), compare(=, FR, fluorides), compare(=, FP, fenoprofen), compare(=, PP, plasma_protein_fraction), !.
find_medicament(MH, CR, FR, FP, IM, fracture_of_the_arm):- compare(=, MH, methohexital), compare(=, CR, carboprost), compare(=, FR, fluorides), compare(=, FP, fenoprofen), compare(=, IM, imipenem), !.
find_medicament(FM, DX, NR, TT, fracture_of_the_arm):- compare(=, FM, flumazenil), compare(=, DT, digitoxin), compare(=, NR, nesiritide), compare(=, TT, tenecteplase), !.

find_medicament(PB FZ, BB, fracture_of_the_ankle):- compare(=, PB, potassium_bicarbonate), compare(=, FM, flumazenil), compare(=, BB, butalbital), !.

find_medicament(DC, GF, V1, DL, LS, FO, DO, PP, fracture_of_the_leg):- compare(=, DC, darifenacin), compare(=, GF, guanfacine), compare(=, V1, vitamin_k1), compare(=, DL, dalteparin), compare(=, LS, lvp_solution), compare(=, FO, fonaparinux), compare(=, DO, dronedarone), compare(=, PP, plasma_protein_fraction), !.
find_medicament(GF, V1, DR, AF, fracture_of_the_leg):- compare(=, GF, guanfacine), compare(=, V1, vitamin_k1), compare(=, DR, daunorubicin), compare(=, AF, alfentanil), !.

find_medicament(HD, DE, DT, OX, fracture_of_the_foot):- compare(=, HD, hyaluronidase), compare(=, DE, deferoxamine), compare(=, DT, diflorasone_topical), compare(=, OX, oxacilin), !.





