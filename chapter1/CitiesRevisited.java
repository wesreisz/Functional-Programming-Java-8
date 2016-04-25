//Task Declarative Approach to find if Chicago
//is in a given collection of cities.
public class CitiesRevisited{
	private static long startTime,endTime;

	public static void main(String[] args) throws Exception{
		//protect the input
		if(args==null || args.length<=0){
			throw new Exception("No values provided. Please pass a list of cities.");
		}

		startTime = System.nanoTime();
		//check the result
		boolean result = false;
		for(String city : args){
			if ("Chicago".equalsIgnoreCase(city)){
				result = true;
				break; //no reason to iterate the list if the city is found.
			}
		}
		endTime = System.nanoTime();

		//report
		if(result){
			System.out.println("Chicago was found");
		}else{
			System.out.println("Chicago was NOT found");
		}
		System.out.println("Running Time: " + (endTime - startTime));
	}
}