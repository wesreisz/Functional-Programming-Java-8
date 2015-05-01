import java.util.*;

public class Cities{
	public static void main(String[] args){
		 List<String> cities = new ArrayList<String>();
		 cities.add("Louisville");
		 cities.add("Chicago");
		 cities.add("Orlando");

		 // imperative style
		 // boolean found = false;
		 // for(String city:cities){
		 // 	if(city.equalsIgnoreCase("Chicago")){
		 // 		found = true;
		 // 	}
		 // }

		// declarative style	
		System.out.println("Found chicago?:" + cities.contains("chicago"));
	}
}