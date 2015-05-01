import java.util.*;

public class Cities{
	public static void main(String[] args){
		 List<String> cities = new ArrayList<String>();
		 cities.add("Louisville");
		 cities.add("Chicago");
		 cities.add("Orlando");
		 
		 boolean found = false;
		 for(String city:cities){
		 	if(city.equalsIgnoreCase("Chicago")){
		 		found = true;
		 	}
		 }

		System.out.println("Found chicago?:" + found);
	}
}