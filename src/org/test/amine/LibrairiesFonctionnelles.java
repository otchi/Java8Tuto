package org.test.amine;

import java.util.function.Consumer;

public class LibrairiesFonctionnelles {

	public static void main(String[] args) {
		
		Consumer<Personne> afficherAge = (Personne personne) -> {
			System.out.println("Age: " + personne.age);
		};

		Consumer<Personne> afficherNom = (Personne personne) -> {
			System.out.println("Nom: " + personne.nom);
		};

		Consumer<Personne> afficherIdentite = afficherNom.andThen(afficherAge);

		Personne augusta = new Personne("Augusta", 12);

		afficherIdentite.accept(augusta);
		// Nom: Augusta
		// Age: 12
	}

	static class Personne {

		String nom;
		int age;

		Personne(String nom, int age) {
			this.nom = nom;
			this.age = age;
		}
	}
}
