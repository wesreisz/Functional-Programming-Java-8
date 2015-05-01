import java.util.*;
import java.math.*;
//Tasks:
//Suppose we’re asked to total the prices greater than $20, discounted by 
//10%. Let’s do that in the habitual Java way first.
// getDiscountedTotal: does this the traditional imperative way
// getDiscountedTotalFunctionally: does this example declaratively with lamdbas
		

public class Prices{
	public static void main(String... args){
		long startTime,endTime; 
		final List<BigDecimal> prices = setPrices();

		startTime = System.nanoTime();
		BigDecimal total1 = getDiscountedTotal(prices);
		endTime = System.nanoTime();
		System.out.println("Discounted Total: " + total1);
		System.out.println("Executed in: " + (endTime - startTime)/1e6);

		startTime = System.nanoTime();
		BigDecimal total2 = getDiscountedTotalFunctionally(prices);
		endTime = System.nanoTime();
		System.out.println("Discounted Total: " + total2);
		System.out.println("Executed in: " + (endTime - startTime)/1e6);

	}
	private static List<BigDecimal> setPrices(){
		return Arrays.asList(
			new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
			new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
			new BigDecimal("45"), new BigDecimal("12"));
	}
	private static BigDecimal getDiscountedTotal(List<BigDecimal> prices){
		BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
		for(BigDecimal price : prices) {
			if(price.compareTo(BigDecimal.valueOf(20)) > 0)
				totalOfDiscountedPrices =
					totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
		}
		return totalOfDiscountedPrices;
	}
	private static BigDecimal getDiscountedTotalFunctionally(List<BigDecimal>prices){
		return prices.stream()
				.filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
				.map(price -> price.multiply(BigDecimal.valueOf(0.9)))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}