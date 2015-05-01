public class Sample{
	public static void main(String[] args){
		String[] cities = new String[]{"Louisville", "Chicago", "Orlando"};
		boolean found = false;
		for(String city:cities){
			if(city.equalsIgnoreCase("Chicago")){
				found = true;
			}
		}

		System.out.println("Found Chicago? " + found);
	}	
}