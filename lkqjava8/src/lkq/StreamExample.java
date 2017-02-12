package lkq;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);
		List<String> ls=new ArrayList<String>();
		for(int i=0;i<10;i++){
			ls.add("a "+i);
		}
		Stream<String> strStream=ls.stream().filter(p->p.contains("a 0"));
		strStream.forEach(p->System.out.println(p));
		

		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		// using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.distinct().filter(p->p>=99&&p%2==0);
		// using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

		Stream<Integer> highNumsSeq = sequentialStream.filter(p->p>=90 && p%2==0);
		highNumsSeq.forEach(p -> System.out
				.println("High Nums sequential=" + p));

	}
}
