package org.test.amine;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class FonctionnellePredicate {
	//exemple impl
/*	@FunctionalInterface
	public interface Predicate<T> {
	    //...
	    default Predicate<T> and(Predicate<? super T> other) {
	        Objects.requireNonNull(other);
	        return (t) -> test(t) && other.test(t);
	    }
	    default Predicate<T> negate() {
	        return (t) -> !test(t);
	    }
	    default Predicate<T> or(Predicate<? super T> other) {
	        Objects.requireNonNull(other);
	        return (t) -> test(t) || other.test(t);
	    }
	    //...
	}*/
	public static void main(String[] args) {

		/**
		 * prédicats de base
		 */
		Predicate<Personne> etreBeau = (Personne x) -> {
			return x.beaute > 5 ? true : false;
		};

		Predicate<Personne> etreRiche = (Personne x) -> {
			return x.richesse > 5 ? true : false;
		};

		/**
		 * prédicats dérivés
		 */
		// unaire
		Predicate<Personne> etreRicheETMoche = etreRiche.and(etreBeau.negate());

		// unaire
		Predicate<Personne> etreRicheOUBeau = etreRiche.or(etreBeau);

		// binaire
		BiPredicate<Personne, Personne> peuventSeMarier = (Personne x, Personne y) -> {
			return etreRicheOUBeau.test(x) && etreRicheOUBeau.test(y);
		};

		Personne johnny = new Personne("Johnny", 9, 3);
		Personne laetitia = new Personne("Laetitia", 2, 7);
		Personne burns = new Personne("Mr Burns", 10, 1);
		Personne homer = new Personne("Homer Simpson", 2, 1);
		Personne liliane = new Personne("Liliane B.", 10, 0);

		System.out.println(etreRiche.test(burns)); // true
		System.out.println(etreBeau.test(burns)); // false
		System.out.println(etreRicheETMoche.test(burns)); // true

		System.out.println(peuventSeMarier.test(laetitia, johnny)); // true
		System.out.println(peuventSeMarier.test(burns, laetitia)); // true
		System.out.println(peuventSeMarier.test(liliane, johnny)); // true
		System.out.println(peuventSeMarier.test(homer, laetitia)); // false
		System.out.println(peuventSeMarier.test(homer, liliane)); // false

	}

	static class Personne {

		String nom;
		int richesse;
		int beaute;

		Personne(String nom, int richesse, int beaute) {
			this.nom = nom;
			this.richesse = richesse;
			this.beaute = beaute;
		}
	}

}
