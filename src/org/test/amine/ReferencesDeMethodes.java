package org.test.amine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ReferencesDeMethodes {

	public static void main(String[] args) {

		Supplier<String> sup;

		// référence à une méthode statique
		System.out.println("-------------------------");
		sup = Personne::queSuisJe;
		System.out.println(sup.get()); // Je suis une personne!

		System.out.println("-------------------------");
		sup = Mammifere::queSuisJe;
		System.out.println(sup.get()); // Je suis un mammifère!

		// référence à une méthode d'une instance
		System.out.println("-------------------------");
		Personne richard = new Personne("Richard");
		sup = richard::quiSuisJe;
		System.out.println(sup.get()); // Je suis : Richard

		// référence à une méthode d'une classe parente
		System.out.println("-------------------------");
		sup = richard.superReferenceADN();
		System.out.println(sup.get()); // Mon ADN: 625452467

		// référence à un constructeur
		System.out.println("-------------------------");
		CreerPersonne persConstr = Personne::new;
		Personne regis = persConstr.creer("Régis");
		System.out.println(regis);

		// référence à un constructeur générique
		System.out.println("-------------------------");
		ListePersonnes persListeConstr = ArrayList<Personne>::new;
		List<Personne> listePers = persListeConstr.creer();
		System.out.println(listePers);
		// référence à un constructeur de tableau
		System.out.println("-------------------------");
		TableauPersonnes persTabConstr = Personne[]::new;
		Personne[] tableauPers = persTabConstr.creer(12);
		System.out.println(Arrays.asList(tableauPers));

	}

	/***************************************************/
	static class Mammifere {

		int seqADN;

		public static String queSuisJe() {
			return "Je suis un mammifère!";
		}

		public String getSequenceADN() {
			return "Mon ADN: " + seqADN;
		}

		Mammifere() {
			seqADN = new Random().nextInt();
		}

		@Override
		public String toString() {
			return "Mammifere [seqADN=" + seqADN + "]";
		}
		
	}

	/****************************************************/
	static class Personne extends Mammifere {

		String nom;

		Personne(String nom) {
			super();
			this.nom = nom;
		}

		public static String queSuisJe() {
			return "Je suis une personne!";
		}

		public Supplier<String> superReferenceADN() {
			return super::getSequenceADN;
		}

		public String quiSuisJe() {
			return "Je suis : " + nom;
		}

		@Override
		public String toString() {
			return "Personne [nom=" + nom + "]";
		}
		
	}

	/***************************************************/
	@FunctionalInterface
	public interface CreerPersonne {
		Personne creer(String nom);
	}

	/*************************************************/
	@FunctionalInterface
	public interface ListePersonnes {
		List<Personne> creer();
	}

	/**************************************************/
	@FunctionalInterface
	public interface TableauPersonnes {
		Personne[] creer(int taille);
	}

}
