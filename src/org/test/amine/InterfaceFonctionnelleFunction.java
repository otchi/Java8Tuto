package org.test.amine;

import java.util.function.Function;

public class InterfaceFonctionnelleFunction {

	public static void main(String[] args) {

		Function<Integer, Long> integerToLong = Integer::longValue;
		Function<Long, String> longToBinaryString = Long::toBinaryString;
		Function<Integer, String> integerToBinaryString = integerToLong.andThen(longToBinaryString);

		System.out.println(integerToBinaryString.apply(125)); // 1111101
	}
}
