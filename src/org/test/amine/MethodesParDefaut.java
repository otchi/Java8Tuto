package org.test.amine;

public class MethodesParDefaut {
	/***************************************/
	public static void main(String[] args) {

		A interfaceA = () -> {
			System.out.println("rien a fair");
		};

		interfaceA.afficher();// A
		interfaceA.rienFaire();
	}
	/****************************************/
	@FunctionalInterface
	public interface A {

		void rienFaire();

		default void afficher() {
			System.out.println("A");
		}
	}
	

}
