package com.jeux.entities;

import java.util.ArrayList;

public class Ligne {
	private ArrayList<Case> cases;
	
	
	/*Un constructeur par défaut créant un tableau à une case dont le contenu sera fixé
	à 0*/
	public Ligne() {
		this.cases = new ArrayList<Case>();
		this.cases.add(new Case());

	}
	
	//Un constructeur prenant en paramètre la taille d’une ligne qui sera remplie de 0
	public Ligne(int taille) {		
		cases = new ArrayList<Case>(taille);
		for(int i=0; i<taille; i++) {
			cases.add(i, new Case());					
		}
	}

	//Un constructeur par copie
	public Ligne(Ligne l) {

		this.cases = l.cases;
	}
	
	
	//getter
	public ArrayList<Case> getCases() {
		return cases;
	}
	
	//setter
	public void setCases(ArrayList<Case> cases) {
		this.cases = cases;
	}
	
	//Une méthode retournant l’objet contenu dans la ieme case de la ligne
	public Case getX(int i) {
		Case c = new Case();
		if (i >= 0) {
			c = this.cases.get(i);
		}
		return c;
	}
	
	//Une méthode  permettant d’affecter la valeur à la ième case de la ligne.
	public void setX(int i, int valeur) {
		this.cases.get(i).setContenu(valeur);

	}

	/*Une méthode prenant en paramètre une chaîne de caractères contenant des chiffres
	représentant les joueurs ou les cases vides. Cette méthode initialise la ligne avec ces valeurs.
	si la longueur de valInit!= la longueur de la ligne ou au contenu,un message d erreur sera affiché.*/
	public void setLigne(String vallnit) {
		if (vallnit.length() == cases.size()) {
			for (int i = 0; i < vallnit.length(); i++) {
			  cases.get(i).setContenu(Integer.valueOf(vallnit.substring(i,i+1)));
			}
		} else {
			System.out.print(
					"la longeur de la chaine de caractéres ne correspond pas à la longueur de la ligne ou le contenu n'est pas cohérent");
		}
	}
	
	//Une méthode qui retourne la taille de la ligne.
	public int getTaille() {
		return cases.size();

	}
	
	/*une méthode qui retournera true si le pion joué permet de créer un alignement
	horizontal de 4 pions*/
	public boolean gagne() {
		int comparaison = 0;
		int content = 0;
		int content1 = 0;
		boolean victoire = false;
		for (int i = 0; i < this.getTaille()-1; i++) {

			content = this.cases.get(i).getContenu();
			content1 = this.cases.get(i + 1).getContenu();

			if (content !=0 && content == content1) {
				comparaison = comparaison + 1;
				if (comparaison == 3) {
					victoire = true;
					break;
				}
			} else {
				comparaison = 0;
			}

		}
		return victoire;
	}
	
	/*une méthode qui retournera true si le pion joué permet de créer un alignement
	horizontal de 3 pions*/
	public boolean preGagne() {
		int comparaison = 0;
		int content = 0;
		int content1 = 0;
		boolean preVictoire = false;
		for (int i = 0; i < this.getTaille()-1; i++) {

			content = this.cases.get(i).getContenu();
			content1 = this.cases.get(i + 1).getContenu();

			if (content !=0 && content == content1) {
				//System.out.println("*****"+i+"#####"+(i+1));
				comparaison = comparaison + 1;
				if (comparaison == 2) {
					preVictoire = true;
					break;
				}
			} else {
				comparaison = 0;
			}

		}
		
		return preVictoire;

	}

	/*La méthode toString() qui retournera une chaîne de caractères symbolisant 
	une ligne de cases.*/
	@Override
	public String toString() {
		return "Ligne [cases=" + cases + "]";
	}

}
