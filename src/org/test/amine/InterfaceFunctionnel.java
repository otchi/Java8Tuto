package org.test.amine;

public class InterfaceFunctionnel {
	public static void main(String args[]){
		A a=(int x) -> { return x+1; };
		System.out.println(a.rienFaire(2));
	}
	//the functional interface
	 @FunctionalInterface
	    public interface A {
	 
	        int rienFaire(int i);
	 
	        default void afficher(){
	            System.out.println("A");
	        }
	    }
}
