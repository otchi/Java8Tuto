package org.test.amine;

public class MethodesParDefaut2 {
	public static void main(String[] args) {

		A interfaceA = () -> {
		};
		B interfaceB = () -> {
		};
		C interfaceC = () -> {
		};
		D interfaceD = () -> {
		};
		System.out.println("--------------------------");
		interfaceA.afficher(); // A
		System.out.println("--------------------------");
		interfaceB.afficher(); // B
		System.out.println("--------------------------");
		interfaceB.afficherBis(); // A bis
		System.out.println("--------------------------");
		interfaceB.afficherSuper(); // A, A bis, A bis
		System.out.println("--------------------------");
		interfaceC.afficher(); // C
		System.out.println("--------------------------");
		interfaceD.afficher(); // D
		System.out.println("--------------------------");
		interfaceD.afficherSuper(); // B, C

		D classeConcrete = new D() {
			@Override
			public void rienFaire() {
			}

			@Override
			public void afficher() {
				System.out.println("classe concrete");
			}
		};

		classeConcrete.afficher(); // classe concrete

	}

	@FunctionalInterface
	public interface A {

		void rienFaire();

		default void afficher() {
			System.out.println("A");
		}

		default void afficherBis() {
			System.out.println("A bis");
		}
	}

	@FunctionalInterface
	public interface B extends A {

		default void afficher() {
			System.out.println("B");
		}

		default void afficherSuper() {
			A.super.afficher();
			A.super.afficherBis();
			afficherBis();
		}
	}

	@FunctionalInterface
	public interface C extends A {

		default void afficher() {
			System.out.println("C");
		}
	}

	@FunctionalInterface
	public interface D extends B, C {

		default void afficher() {
			System.out.println("D");
		}

		default void afficherSuper() {
			B.super.afficher();
			C.super.afficher();
		}
	}

}
