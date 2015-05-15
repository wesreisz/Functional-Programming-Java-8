import java.util.*;
import java.util.function.*;

public class Transformations{
	private static final List<String> names = Arrays.asList("Wes", "Kim", "Leanne", "Justin", "Tyler");
	public static void main(String... args){
		//Let’s start by creating a new collection of uppercase names from the given collection.
		System.out.println("\nPrinting imperative Approach");
		imperativeApproach().forEach(System.out::println);
		//Let’s start by creating a new collection of uppercase names from the given collection.
		System.out.println("\nPrinting Declarative Approach");
		declarativeApproach().forEach(System.out::println);
		//Let’s start by creating a new collection of uppercase names from the given collection.
		System.out.println("\nPrinting Declarative Stream Approach");
		streamApproach();
		//print the letters in each name
		System.out.println("\nPrinting number of characters in each name Declaratively");
		printCharacterNumbers();
		//Let’s start by creating a new collection of uppercase names from the given collection.
		System.out.println("\nPrinting Declarative Stream Approach");
		streamApproach1();
	}

	private static List<String> imperativeApproach(){
		List<String>result = new ArrayList<String>();
		for(String name : names){
			result.add(name.toUpperCase());
		}
		return result;
	}

	private static List<String> declarativeApproach(){
		List<String>result = new ArrayList<String>();
		names.forEach(name -> result.add(name.toUpperCase()));
		return result;
	}

	private static void streamApproach(){
		names.stream()
			.map(name -> name.toUpperCase())
			.forEach(name -> System.out.println(name));
	}

	private static void printCharacterNumbers(){
		names.stream()
			.map(name -> name.length())
			.forEach(count -> System.out.print(count));
	}

	private static void streamApproach1(){
		names.stream()
			.map(String :: toUpperCase)
			.forEach(name -> System.out.println(name));
	}
}