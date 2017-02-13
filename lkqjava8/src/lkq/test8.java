package lkq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Arrays.asList( "p", "k", "u","f", "o", "r","k").forEach( e ->
		// System.out.println( e ) );

		List<String> ls = new ArrayList<String>();
		ls.add("LIKAIQIANG");
		ls.add("Steven");
		List<String> lowerCase = ls.stream().map(name -> name.toLowerCase())
				.collect(Collectors.toList());
		lowerCase.forEach(l -> System.out.println(l));

		List<Integer> numList = Arrays.asList(1, 2, 3, null, 3, 4);
		List<Integer> turnList = numList.stream()
				.filter(num -> num != null && num > 3).distinct()
				.collect(Collectors.toList());
		System.out.print(numList.stream().distinct().filter(num -> num != null)
				.reduce(0, (sum, item) -> sum |item));

	}
}
