package com.jeux.jeu;

import java.util.Scanner;

import com.jeux.entities.Case;
import com.jeux.entities.Ligne;
import com.jeux.entities.Plateau;

public class Jeu {

	public static void main(String[] args) {
		/*Plateau p = new Plateau(6,7);
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
				
			
		}*/
		
		
		String chaine = "6x7-211222112211201112210121212000200000000000";
		
		Plateau p= new Plateau(chaine);
		System.out.println(p.toString());
		
		System.out.println(p.gagne());
		
		System.out.println("meilleur coup : "+p.meilleurCoup(chaine,2));
	//p.ajouPion(0, 2 );
		//System.out.print("#"+p.getLignes().get(5).gagne());
		
		
		
		
		
		//System.out.println(p.colonnePleine(0));
		/*Case c = new Case(1);
		System.out.println(c.toString());
		
		Ligne l = new Ligne(5);
		System.out.println(l.getCases().size());
		System.out.println(l.getTaille());
		System.out.println(l.toString());
		l.setLigne("12121");
		System.out.println(l.toString());
		System.out.println(l.getX(1));
		l.setX(0, 2);
		System.out.println(l.getX(0));*/
		
		
		

	}

}
