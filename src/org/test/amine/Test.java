package org.test.amine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Test {
	   @FunctionalInterface
	    public interface A {
	 
	        void rienFaire();
	 
	        default void afficher(){
	            System.out.println("A");
	        }
	    }
	public static void main(String args[]){
		//Arrays.asList(1,2,3).forEach(System.out::println);
		Arrays.asList(1,2,3).forEach(Test::T);
		   List<Integer> personnes = new ArrayList<Integer>();
		   
	        personnes.add(new Integer(8));
	        personnes.add(new Integer(4));
	        personnes.add(new Integer(9));
	        System.out.println(personnes);
	        Collections.sort(personnes,
	                        (Integer o1, Integer o2) -> {
	                              return (o1> o2) ?1 :-1 ;
	                         } );
	        System.out.println(personnes);
	        //-----------------------------------------------------------------------
	        A interfaceA = () -> { } ;
	        interfaceA.afficher();
	        
		
	}
	

	public static Integer T(int i){
		System.out.println(i+1);
		return i+1;
	}
	
	public List<Integer> concatLists4(@SuppressWarnings("unchecked") List<Integer>... lists) {
	    return Stream.of(lists)
	    		.reduce(new ArrayList<>(), 
	    				fluentize(List::addAll));
	}
	
	public static <T> BinaryOperator<T> fluentize(BiFunction<T, T, ?> op) {
	    return (t1, t2) -> {
	        op.apply(t1, t2); // drop result
	        return t1;
	    };
	}

}
