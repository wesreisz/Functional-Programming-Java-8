import java.util.*;
import java.util.function.*;

public class Iterations{
	public static void main(String... args){
		System.out.println("Chapter 2 Samples");
		simpleImperative();
		simpleImperative1();
		simpleDeclarative();
		simpleDeclarativeWithLambda();
		methodReference();
	}
	private static void simpleImperative(){
		final List<String> names = Arrays.asList("Wes", "Kimberly", "Leanne","Justin","Tyler");
		System.out.println("Printing First Example");

		//the self-inflicted wound pattern—it’s verbose and error prone. =)
		for(int i=0;i<names.size();i++){
			System.out.println(" - " + names.get(i));		
		}
	}
	private static void simpleImperative1(){
		final List<String> names = Arrays.asList("Wes", "Kimberly", "Leanne","Justin","Tyler");
		System.out.println("Printing Second Example");
		for(String name : names)
			System.out.println( " - " + name);
		
	}
	private static void simpleDeclarative(){
		final List<String> names = Arrays.asList("Wes", "Kimberly", "Leanne","Justin","Tyler");
		System.out.println("Printing Third Example");
		names.forEach(new Consumer<String>(){
			public void accept(final String name){
				System.out.println(" - " + name);
			}
		});
	}
	private static void simpleDeclarativeWithLambda(){
		final List<String> names = Arrays.asList("Wes", "Kimberly", "Leanne","Justin","Tyler");
		System.out.println("Printing Third Example");
		//names.forEach((final String name) -> System.out.println(name));
		names.forEach( name -> System.out.println(" - " + name)); //without type inference
		//NOTE: when using the type inference approach, we cannot mark the arguments as final
		//which is good practice. Be careful never to modify parameters in the implementation.
	}
	private static void methodReference(){
		final List<String> names = Arrays.asList("Wes", "Kimberly", "Leanne","Justin","Tyler");
		System.out.println("Printing Fourth Example with a methodReference");
		names.forEach(System.out::println);
	}
}