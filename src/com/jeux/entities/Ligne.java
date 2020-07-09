package com.jeux.entities;

import java.util.ArrayList;

public class Ligne {
	private ArrayList<Case> cases;

	public Ligne() {
		this.cases = new ArrayList<Case>();
		this.cases.add(new Case());

	}
	
	public Ligne(int taille) {		
		cases = new ArrayList<Case>(taille);
		for(int i=0; i<taille; i++) {
			cases.add(i, new Case());					
		}
	}

	// only testing
	public Ligne(Ligne l) {

		this.cases = l.cases;
	}
	
	

	public ArrayList<Case> getCases() {
		return cases;
	}

	public void setCases(ArrayList<Case> cases) {
		this.cases = cases;
	}

	public Case getX(int i) {
		Case c = new Case();
		if (i >= 0) {
			c = this.cases.get(i);
		}
		return c;
	}

	public void setX(int i, int valeur) {
		this.cases.get(i).setContenu(valeur);

	}

	public void setLigne(String vallnit) {
		//System.out.print("test2 :"+  cases.size());
		//System.out.print("test3 :"+  vallnit.length());
		if (vallnit.length() == cases.size()) {
			for (int i = 0; i < vallnit.length(); i++) {
			  cases.get(i).setContenu(Integer.valueOf(vallnit.substring(i,i+1)));
			  //System.out.print("test4 :"+  vallnit.substring(i,i+1));
			}

		} else {
			System.out.print(
					"la longeur de la chaine de caractéres ne correspond pas à la longueur de la ligne ou le contenu n'est pas cohérent");
		}

	}

	public int getTaille() {
		return cases.size();

	}

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

	@Override
	public String toString() {
		return "Ligne [cases=" + cases + "]";
	}

}
