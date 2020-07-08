package com.jeux.entities;

public class Case {
	private int contenu;
	

	public Case(int cont) {
		if ( cont >= 0 && cont <= 2 ) {
			this.contenu = cont;
		}
		else {
			this.contenu= 0;
		}
			
	}


	public Case(Case c) {
		this.contenu = c.contenu;
		
	}


	public Case() {
		this.contenu= 0;
	}


	public int getContenu() {
		return contenu;
	}


	public void setContenu(int contenu) {
		if ( contenu >= 0 && contenu <= 2 ) {
			this.contenu = contenu;
		}
		else {
			this.contenu= 0;
		}
	}


	@Override
	public String toString() {
		return "Case [contenu=" + contenu + "]";
	}
		

	
	

}
