package com.jeux.jeu;

import com.jeux.entities.Plateau;

public class IAZilat {
	
	/*: IA qui va vérifier si il peut gagner et jouer le coup. Sinon vérifier s’il
	peut aligner 3 pions et jouer le coup. Sinon aléatoire.*/
	public static int meilleurCoup(String plateau, int joueur) {
		int bestCoup=0;
		Plateau pl = new Plateau();
		if(pl.meilleurCoupGangnant(plateau,joueur)>=0) {
			bestCoup = pl.meilleurCoupGangnant(plateau,joueur);
			System.out.print("le meilleur coup gagnant est dans la colonne: "+bestCoup);
		}
		 if(pl.meilleurCoup3Piont(plateau, joueur)>=0) {
			bestCoup = pl.meilleurCoup3Piont(plateau, joueur);
			System.out.print("le coup pour 3 piont est dans la colonne: "+bestCoup);
		}
		else if(pl. meilleurCoupAliatoire(plateau, joueur)>=0) {
			bestCoup = pl. meilleurCoupAliatoire(plateau, joueur);
			System.out.print("le coup aliatoire est dans la colonne: "+bestCoup);
		}
		else {
			System.out.print("aucune case n'est disponible");
		}
		return bestCoup;
	}
	
	

}
