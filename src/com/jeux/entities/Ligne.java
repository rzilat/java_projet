package com.jeux.entities;

import java.util.ArrayList;

public class Ligne {
	private ArrayList<Case> cases;

	public Ligne(int taille) {

		this.cases = new ArrayList<Case>(taille);
		for (Case temp : cases) {
			temp.setContenu(0);
		}
	}

	public Ligne() {

		this.cases = new ArrayList<Case>();
		this.cases.add(new Case());

	}

	// only testing
	public Ligne(Ligne l) {

		this.cases = l.cases;
	}
	
	public Case getX(int i) {
		Case c = new Case();
		if(i>=0) {
			c=this.cases.get(i);
		}
		return c;
	}
	
	public void setX(int i,int valeur) {
		this.cases.get(i).setContenu(valeur);
	
		
	}
	
	public void setLigne(String vallnit) {
		if(vallnit.length()==cases.size()) {
			for(int i=0;i<=vallnit.length();i++) {
				this.cases.get(i).setContenu(vallnit.indexOf(i));	
			}
			
		}else {
			System.out.print("la longeur de la chaine de caractéres ne correspond pas à la longueur de la ligne ou le contenu n'est pas cohérent");
		}
		
			
	}
	
	public int getTaille() {
		return cases.size();
		
	}

	@Override
	public String toString() {
		return "Ligne [cases=" + cases + "]";
	}
	
	
	

}
