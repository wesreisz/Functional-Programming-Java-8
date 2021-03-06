//Task Declarative Approach to find if Chicago
//is in a given collection of cities.
import java.util.*;

public class CitiesRevisited1{
	private static long startTime,endTime;

	public static void main(String[] args) throws Exception{
		//protect the input
		if(args==null || args.length<=0){
			throw new Exception("No values provided. Please pass a list of cities.");
		}
		startTime = System.nanoTime();
		System.out.println("Found Chicago: " + Arrays.asList(args).contains("Chicago"));
		endTime = System.nanoTime();

		System.out.println("Running Time: " + (endTime - startTime));
	}

}