package com.jeux.entities;

import java.util.ArrayList;

/**
 * @author redao
 *
 */
public class Plateau {
	private ArrayList<Ligne> lignes = new ArrayList<Ligne>();

	public Plateau() {
		this.lignes = new ArrayList<Ligne>();
		Ligne l = new Ligne();
		l.getX(0).setContenu(0);
		lignes.add(0, l);

	}

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

	public Plateau(Plateau p) {
		this.lignes = p.lignes;

	}

	public Plateau(String chaine) {

		int nombreLigne = Integer.valueOf(chaine.substring(0, chaine.indexOf('x')));
		int nombreColonne = Integer.valueOf(chaine.substring(chaine.indexOf('x') + 1, chaine.indexOf('-')));
		String caseValeur = chaine.substring(chaine.indexOf('-') + 1);

		this.lignes = new ArrayList<Ligne>(nombreLigne);
		for (int i = 0; i < caseValeur.length(); i = i + nombreColonne) {
			Ligne l = new Ligne(nombreColonne);
			l.setLigne(caseValeur.substring(i, i + nombreColonne));
			//System.out.println(caseValeur.substring(i, i + nombreColonne));
			lignes.add(l);
		}
	}

	public Case getXY(int x, int y) {
		Case c = new Case();
		c = lignes.get(y).getX(x);
		return c;
	}

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

	public void ajouPion(int numColonne, int numJoueur) {
		if (!colonnePleine(numColonne)) {
			for (int i = 0; i < lignes.size(); i++) {
				Case c = this.getXY(numColonne, i);
				if (c.getContenu() == 0) {
					c.setContenu(numJoueur);
					// this.lignes.get(i).gagne();
				}
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String chaine="";
		int nLigne = this.lignes.size();
		int nColonne = this.lignes.get(0).getTaille();
		for(int i=0;i<nLigne;i++) {
			for(int j=0;j<nColonne;j++) {
				chaine=chaine+this.getXY(j, i).getContenu();
				
				
			}
			chaine=chaine+"\n";
		}
		
		return chaine;
	}

	/**
	 * @return
	 */
	public String toStringPourIA() {
		String affichage="";
		int nLigne = this.lignes.size();
		int nColonne = this.lignes.get(0).getTaille();
		for(int i=0;i<nLigne;i++) {
			for(int j=0;j<nColonne;j++) {
				affichage=affichage+this.getXY(j, i).getContenu();
			}
		}

		return nLigne + "x" + nColonne + "-" + affichage;
	}

}
