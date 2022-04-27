package collectorsexp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialStreamExercise {
	
	static void getSquaresOfThree() {
		System.out.println("generating a range of numbers from 20 to 50 inclusive,o/p square of odd multiples of 3:");
		 IntStream.range(20, 50).filter(x -> x%3==0 && x%2!=0).map(x->x*x).forEach(x -> System.out.println(x));
		 System.out.println("---------------------------");
	}
	static void getMultiplesOfFive() {
		System.out.println("Generating a infinite stream with multiples of 5 and collect the first 20 multiples:");
		IntStream.iterate(5,i->i+5).limit(20).forEach(System.out::println);
		System.out.println("---------------------------------");
	}

}
