package com.jeux.entities;

import java.util.ArrayList;

/**
 * @author redao
 *
 */
public class Plateau {
	private ArrayList<Ligne> lignes = new ArrayList<Ligne>();

	//Un constructeur par défaut créant un plateau d’une seule case qui sera remplie par 0
	public Plateau() {
		this.lignes = new ArrayList<Ligne>();
		Ligne l = new Ligne();
		l.getX(0).setContenu(0);
		lignes.add(0, l);

	}
	
	/*Un constructeur prenant en paramètre un nombre de lignes et un nombre de colonnes. 
	Le plateau sera rempli de 0.*/
	public Plateau(int nombreLigne, int nombreColonne) {

		this.lignes = new ArrayList<Ligne>(nombreLigne);
		for (int i = 0; i < nombreLigne; i++) {
			Ligne l = new Ligne(nombreColonne);
			for (int j = 0; j < nombreColonne; j++) {
				l.getX(j).setContenu(0);
			}
			lignes.add(i, l);
		}
	}
	
	//Un constructeur par copie.
	public Plateau(Plateau p) {
		this.lignes = p.lignes;
	}
	
	/*Un constructeur prenant en paramètre une chaine de caractères qui sera remplie
	de nombre des lignes et de colonnes suivi de l 'ensemble des valeurs sur
	les lignes.. La première ligne suivi de la seconde,de la troisième etc.*/
	public Plateau(String chaine) {

		int nombreLigne = Integer.valueOf(chaine.substring(0, chaine.indexOf('x')));
		int nombreColonne = Integer.valueOf(chaine.substring(chaine.indexOf('x') + 1, chaine.indexOf('-')));
		String caseValeur = chaine.substring(chaine.indexOf('-') + 1);

		this.lignes = new ArrayList<Ligne>(nombreLigne);
		for (int i = 0; i < caseValeur.length(); i = i + nombreColonne) {
			Ligne l = new Ligne(nombreColonne);
			l.setLigne(caseValeur.substring(i, i + nombreColonne));
			lignes.add(l);
		}
	}
	
	//getter
	public ArrayList<Ligne> getLignes() {
		return lignes;
	}
	
	//setter
	public void setLignes(ArrayList<Ligne> lignes) {
		this.lignes = lignes;
	}
	
	/*Une méthode retournant la case se trouvant aux coordonnées(x, y).x correspondant
	au numéro de la colonne et y au numéro de la ligne.*/
	public Case getXY(int x, int y) {
		Case c = new Case();
		c = lignes.get(y).getX(x);
		return c;
	}

	/*Une méthode permettant de savoir une colonne est pleine ou si un pion
	peut y être déposé.*/
	public boolean colonnePleine(int col) {
		boolean cp = true;
		for (int i = 0; i < lignes.size(); i++) {

			if (getXY(col, i).getContenu() == 0) {
				cp = false;
				break;
			}
		}
		return cp;
	}

	/*Une méthode prenant en parametres le numero de la colonne et du joueur,permettant 
	l’ajout d’un pion dans une colonne.*/
	public void ajouPion(int numColonne, int numJoueur) {
		if (!colonnePleine(numColonne)) {
			for (int i = 0; i < lignes.size(); i++) {
				Case c = this.getXY(numColonne, i);
				if (c.getContenu() == 0) {
					c.setContenu(numJoueur);
					break;

				}
			}

		}

	}

	/*une méthode qui retournera true si le pion joué permet de créer un alignement
	vertical de 4 pions.*/
	public boolean gagne() {
		int comparaison = 0;
		int content = 0;
		int content1 = 0;
		boolean victoire = false;
		for (int j = 0; j < this.getLignes().get(0).getTaille(); j++) {
			for (int i = 0; i < this.getLignes().size() - 1; i++) {
				content = this.getXY(j, i).getContenu();
				content1 = this.getXY(j, i + 1).getContenu();
				if (content != 0 && content == content1) {
					comparaison = comparaison + 1;
					if (comparaison == 3) {
						victoire = true;
						break;
					}
				} else if (content != 0 && content != content1) {
					comparaison = 0;
				}
			}
		}
		return victoire;
	}
	
	/*une méthode qui retournera true si le pion joué permet de créer un alignement
	vertical de 3 pions.*/
	public boolean preGagne() {
		int comparaison = 0;
		int content = 0;
		int content1 = 0;
		boolean preVictoire = false;
		for (int j = 0; j < this.getLignes().get(0).getTaille(); j++) {
			for (int i = 0; i < this.getLignes().size() - 1; i++) {
				content = this.getXY(j, i).getContenu();
				content1 = this.getXY(j, i + 1).getContenu();
				if (content != 0 && content == content1) {
					comparaison = comparaison + 1;
					if (comparaison == 2) {
						preVictoire = true;
						break;
					}
				} else if (content != 0 && content != content1) {
					comparaison = 0;
				}
			}
			if (preVictoire == true) {
				break;
			}
		}
		return preVictoire;
	}

	// IA qui va vérifier si il peut gagner et jouer le bon coup.
	public int meilleurCoupGangnant(String plateau, int joueur) {
		int numColonne = -1;
		Plateau pCG = new Plateau(plateau);
		int nLigne = pCG.getLignes().size();
		int nColonne = pCG.getLignes().get(0).getTaille();
		for (int i = 0; i < nLigne; i++) {
			 pCG = new Plateau(plateau);
			for (int j = 0; j < nColonne; j++) {
				pCG = new Plateau(plateau);
				pCG.ajouPion(j, joueur);
				if (pCG.getLignes().get(i).gagne() || pCG.gagne()) {
					numColonne = j;
					break;
				}
			}
			if (numColonne >= 0) {
				break;
			}
		}
		return numColonne;
	}
	
	//IA qui va vérifier s’il peut aligner 3 pions et jouer le coup.
	public int meilleurCoup3Piont(String plateau, int joueur) {
		int colonne3Piont = -1;
		Plateau pCP = new Plateau(plateau);
		int nLigne = pCP.getLignes().size();
		int nColonne = pCP.getLignes().get(0).getTaille();
		for (int i = 0; i < nLigne; i++) {
			 pCP = new Plateau(plateau);
			for (int j = 0; j < nColonne; j++) {
				// System.out.print("//"+j);
				pCP = new Plateau(plateau);
				pCP.ajouPion(j, joueur);
				if( pCP.preGagne() || pCP.getLignes().get(i).preGagne()) {
					//System.out.println("*****"+j+i);
					colonne3Piont = j;
					break;
				}
			}
			if (colonne3Piont >= 0) {
				break;
			}
		}
		return colonne3Piont;

	}
	
	// IA qui va choisir une colonne aléatoirement.
	public int meilleurCoupAliatoire(String plateau, int joueur) {
		int colonneVide = -1;
		Plateau pCA = new Plateau(plateau);
		int nLigne = pCA.getLignes().size();
		int nColonne = pCA.getLignes().get(0).getTaille();
		for (int i = 0; i < nLigne; i++) {
			 pCA = new Plateau(plateau);
			for (int j = 0; j < nColonne; j++) {
				// System.out.print("//"+j);
				pCA = new Plateau(plateau);
				pCA.ajouPion(j, joueur);
				
				if (!pCA.colonnePleine(j)) {
					colonneVide = j;
					break;
				}
			}
			if (colonneVide >= 0) {
				break;
			}
		}
		return colonneVide;

	}


	/*Une méthode String toString() retournant le plateau sous forme d’une chaine de
	caractères.les lignes sont affichés dans le bon ordre.*/ 
	@Override
	public String toString() {
		String chaine = "";
		int nLigne = this.lignes.size();
		int nColonne = this.lignes.get(0).getTaille();
		for (int i = nLigne - 1; i >= 0; i--) {
			for (int j = 0; j < nColonne; j++) {
				chaine = chaine + this.getXY(j, i).getContenu();

			}
			chaine = chaine + "\n";
		}

		return chaine;
	}

	/*Une méthode retournant une chaine de caractères du constructeur 
	Plateau(String chaine).*/
	public String toStringPourIA() {
		String affichage = "";
		int nLigne = this.lignes.size();
		int nColonne = this.lignes.get(0).getTaille();
		for (int i = 0; i < nLigne; i++) {
			for (int j = 0; j < nColonne; j++) {
				affichage = affichage + this.getXY(j, i).getContenu();
			}
		}

		return nLigne + "x" + nColonne + "-" + affichage;
	}

}
