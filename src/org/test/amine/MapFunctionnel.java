package org.test.amine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.test.amine.ReferencesDeMethodes.Personne;

public class MapFunctionnel {
	public static void main(String args[]) {
		Map<Character, List<Personne>> carnetAdresses = new HashMap<>();

		carnetAdresses.computeIfAbsent('A', (key) -> {
			System.out.println(key + " a été initialisée.");
			return new LinkedList<Personne>();
		});
		System.out.println(carnetAdresses);
		carnetAdresses.putIfAbsent('B', new LinkedList<Personne>());
		System.out.println(carnetAdresses);

		carnetAdresses.compute('A', (key, value) -> {
			value.add(new Personne("Alfred2"));
			String msg = "Il y a " + value.size() + " entrée(s) à la lettre: " + key;
			System.out.println(msg); // Il y a 1 entrée(s) à la lettre: A
			return value;
		});

		List<Personne> personnes = Arrays.asList(new Personne("Arthur"), new Personne("André"));
		/// merges 
		carnetAdresses.merge('A', personnes, (x1, x2) -> {
			x1.addAll(x2);
			return x1;
		});
		System.out.println(carnetAdresses);
	}

}
