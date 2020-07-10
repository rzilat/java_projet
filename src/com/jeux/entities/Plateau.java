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
	
	//Un constructeur prenant en paramètre un nombre de lignes et un nombre de colonnes. 
	//Le plateau sera rempli de 0.
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
	
	//Une méthode retournant la case se trouvant aux coordonnées(x, y).x correspondant
	//au numéro de la colonne et y au numéro de la ligne.
	public Case getXY(int x, int y) {
		Case c = new Case();
		c = lignes.get(y).getX(x);
		return c;
	}

	//Une méthode permettant de savoir une colonne est pleine ou si un pion
	//peut y être déposé.
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

	//Une méthode prenant en parametres le numero de la colonne et du joueur,permettant 
	//l’ajout d’un pion dans une colonne.
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

	////une méthode qui retournera true si le pion joué permet de créer un alignement
	//vertical de 4 pions
	public boolean gagne() {
		int comparaison = 0;
		int content = 0;
		int content1 = 0;
		boolean victoire = false;
		for (int j = 0; j < this.lignes.get(0).getTaille(); j++) {
			for (int i = 0; i < this.lignes.size() - 1; i++) {
				content = this.getXY(j, i).getContenu();
				content1 = this.getXY(j, i + 1).getContenu();

				if (content != 0 && content == content1) {
					// System.out.println("("+content+","+content1+")");
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

	public boolean gagne2() {
		int comparaison = 0;
		int contentD = 0;
		int contentD1 = 0;
		int contentInversD = 0;
		int contentInversD2 = 0;
		boolean victoire = false;
		for (int i = 0; i < this.lignes.size() - 1; i++) {
			for (int j = 0; j < this.lignes.get(i).getTaille() - 1; j++) {

				contentD = this.getXY(j, i).getContenu();
				contentD1 = this.getXY(j + 1, i + 1).getContenu();
				// System.out.println("("+content+","+content1+")");
				if (contentD != 0 && contentD == contentD1) {
					comparaison = comparaison + 1;
					// System.out.println("aaaaaaaaa"+comparaison);
					if (comparaison == 3) {
						victoire = true;
						break;
					}
				} else if (contentD != 0 && contentD != contentD1) {
					comparaison = 0;
					// System.out.println("bbbbbbbbb"+comparaison);
				}

			}

		}

		return victoire;
	}

	public static int meilleurCoup(String plateau, int joueur) {
		int numColonne = 0;
		int colonneVide = 0;
		Plateau p = new Plateau(plateau);
		int nLigne = p.getLignes().size();
		int nColonne = p.getLignes().get(0).getTaille();
		for (int i = 0; i < nLigne; i++) {
			// p = new Plateau(plateau);
			for (int j = 0; j < nColonne; j++) {
				// System.out.print("//"+j);
				p = new Plateau(plateau);

				p.ajouPion(j, joueur);

				// System.out.print("#"+i+p.getLignes().get(i).gagne());
				if (p.getLignes().get(i).gagne() || p.gagne()) {
					numColonne = j;
					System.out.print("*******" + numColonne + "**" + i);
					break;
				}
				if (!p.colonnePleine(j)) {
					colonneVide = j;
				}
				/*
				 * if(p.gagne()) { numColonne=j; System.out.print("##"+j+"######"+i); break; }
				 */
			}
			if (numColonne != 0) {
				break;
			}
		}
		if (numColonne == 0) {
			numColonne = colonneVide;
		}
		System.out.print(p.toString());
		return numColonne;

	}

	//Une méthode String toString() retournant le plateau sous forme d’une chaine de
	//caractères.les lignes sont affichés dans le bon ordre. 
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

	//Une méthode retournant une chaine de caractères du constructeur 
	//Plateau(String chaine).
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
