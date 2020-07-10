package com.jeux.jeu;

import java.util.Scanner;

import com.jeux.entities.Case;
import com.jeux.entities.Ligne;
import com.jeux.entities.Plateau;

public class Jeu {
	
	//création d’un plateau de jeu et d’y jouer en mode terminal
	public static void main(String[] args) {
		Plateau p = new Plateau(6,7);
		Scanner sc = new Scanner(System.in);
		boolean ligneVictoire=false;
		int c=0;
		for(int i=0;i<42;i++) {
			System.out.print("entrez le numero de colonne dans laquelle vous voulez glisser un pion : ");
			 c= sc.nextInt();
			 if(p.colonnePleine(c)) {
				 System.out.print("cette colonne est pleine,choisissez une autre : ");
			 }
			 p.ajouPion(c, 1);
			 for(i=0;i<p.getLignes().size();i++) {
				 if(p.getLignes().get(i).gagne()) {
					 ligneVictoire=true;
				 }
			 }
			 if(p.gagne()|| ligneVictoire==true) {
			 
			 
				 System.out.print("le joueur 1 a gagné");
				 break;
			 }
			 System.out.println(p.toString());
				
			
		}
		
		
		
	
	}

}
