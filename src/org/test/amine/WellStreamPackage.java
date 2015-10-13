package org.test.amine;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class WellStreamPackage {
	   interface MathOperation {
		      int operation(int a, int b);
		   }
			


	public static void main(String[] args) {
//		boolean x1=true;
//		assert x1==false ;
		
		String pong = "PONG";
		String ping = "PING";
		  MathOperation subtraction = (a, b) -> a - b;
		  System.out.println(subtraction.operation(50, 10));
		/**
		 * génération à partir d'une collection
		 */
		List<String> pingPongCollection = Arrays.asList(pong, ping);

		Stream<String> streamSequentielle = pingPongCollection.stream();
		System.out.println(streamSequentielle);
		Stream<String> streamParallele = pingPongCollection.parallelStream();
		System.out.println(streamParallele);
		/**
		 * Streams construites
		 */

		// générateur aléatoire de ping pong
		Supplier<String> randomPingPongSupplier = () -> {
			return (new Random().nextInt(2) == 0) ? pong : ping;
		};

		// générateur alternatif de ping pong
		UnaryOperator<String> alternatePingPongConstructor = (i) -> (i.equals(pong) ? ping : pong);
		System.out.println(alternatePingPongConstructor);
		Stream.generate(randomPingPongSupplier).limit(10);

		// construction en extension
		Stream.of(pong, pong, ping);
		//--------------------------------------------------------
		// construction en compréhension
		//--------------------------------------------------------
		//--------------------------------------------------------
		//--------------------------------------------------------
		Stream.Builder<String> pingPongBuilder = Stream.builder();
		 
		pingPongBuilder.add(ping);
		pingPongBuilder.add(pong);
		pingPongBuilder.add(pong);
		 
		
		Stream<String> finalStream = pingPongBuilder.build();
		System.out.println(finalStream);
		try{
		    // pingPongBuilder.add(ping); //impossible
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			System.out.println(pingPongBuilder);
		}
		//--------------------------------------------------------
		//--------------------------------------------------------
		//---------- foreatch ------------------------------------
		Personne fred = new Personne("Fred", 1500);
		Personne alfred = new Personne("Alfred", 500);
		Personne al = new Personne("Al", 700);
		 
		Stream.of(fred, alfred, al).forEach((x) -> {
		    System.out.println(x.nom + " possède " + x.richesse );
		});
		
		System.out.println(Arrays.asList(
									Stream.of(fred, alfred, al)
										.filter((x) -> x.richesse > 600)
									.toArray()));
		// transformation or mapping
		System.out.println(
		Arrays.asList(
				Stream.of(fred, alfred, al).map( (x) -> x.richesse )
						.toArray()));
		// reduce or aggregate
		Stream<Integer> richesses =
                Stream.of(fred, alfred, al).map( (x) -> x.richesse );

		System.out.println(richesses.reduce( (g,d) -> g + d));
		

	}
	static class Personne {

		String nom;
		int richesse;

		Personne(String nom, int richesse) {
			this.nom = nom;
			this.richesse = richesse;
		}

		@Override
		public String toString() {
			return "Personne [nom=" + nom + ", richesse=" + richesse + "]";
		}
		
	}
}
