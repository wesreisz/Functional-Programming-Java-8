import java.util.*;
import java.math.*;
//Tasks:
//Suppose we’re asked to total the prices greater than $20, discounted by 
//10%. Let’s do that in the habitual Java way first.
// getDiscountedTotal: does this the traditional imperative way
// getDiscountedTotalFunctionally: does this example declaratively with lamdbas
//

//test process
//while [ true ]; do ps -eaf | grep -i java| grep -i sublime; echo "----"; sleep 1; done;

		

public class PricesRevisited{
	private static long startTime,endTime; 
	final static List<BigDecimal> prices = Arrays.asList(
			new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
			new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
			new BigDecimal("45"), new BigDecimal("12"));

	public static void main(String... args){
		oldway();
	}
	private static void oldway(){
		startTime = System.nanoTime();
		//Suppose we’re asked to total the prices greater than $20, discounted by 10%.
		BigDecimal targetPrice = new BigDecimal(20);
		BigDecimal totalOfDiscountedPrices = new BigDecimal(0);   
		for(BigDecimal price : prices){
			if(price.compareTo(targetPrice) > 0)
				totalOfDiscountedPrices =
					totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
		}
		endTime = System.nanoTime();

		System.out.println(String.format("The totalOfDiscountedPrices of prices greater than %d is %d",targetPrice.intValue(), totalOfDiscountedPrices.intValue()));	
		System.out.println("Running Time: " + (endTime - startTime));
	}
}