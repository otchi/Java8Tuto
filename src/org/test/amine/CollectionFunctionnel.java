package org.test.amine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionFunctionnel {
	public static void main(String args[]){
		Collection<String> personnes = Arrays.asList("Marcel", "Augusta");
		personnes.forEach(System.out::println);
		personnes.forEach((String x)->{
			System.out.println(x+"_"+1);
		});
		ArrayList<String> personnes1=new ArrayList<String>();
		personnes1.add("amine");
		personnes1.add("amine1");
		personnes1.forEach(System.out::println);
		personnes1.removeIf((String x)->{
			return x.equals("amine");
		});
		personnes1.forEach(System.out::println);
		personnes1.replaceAll((String x)->{ return x+1;});
		personnes1.forEach(System.out::println);
		
	}

}
