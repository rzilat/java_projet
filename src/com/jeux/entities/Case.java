package com.jeux.entities;

public class Case {
	private int contenu;
	
	
	//Un constructeur par défaut qui affectera 0 au contenu
	public Case() {
		this.contenu= 0;
	}
	
	//Un constructeur prenant un contenu en parametre qui va etre tester s'il vaut
	//la valeur d'une case vide ou un numero de joueur sinon un 0 sera affecté 
	public Case(int cont) {
		if ( cont >= 0 && cont <= 2 ) {
			this.contenu = cont;
		}
		else {
			this.contenu= 0;
		}
			
	}

	//un constructeur par copie
	public Case(Case c) {
		this.contenu = c.contenu;
		
	}


	

	//getter
	public int getContenu() {
		return contenu;
	}

	//setter
	public void setContenu(int contenu) {
		if ( contenu >= 0 && contenu <= 2 ) {
			this.contenu = contenu;
		}
		else {
			this.contenu= 0;
		}
	}

	//la methode toString qui retournera un espace pour une case vide, sinon le numéro
	//du joueur la contrôlant.
	@Override
	public String toString() {
		return "Case [contenu=" + contenu + "]";
	}
		

	
	

}
