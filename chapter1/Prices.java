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
		BigDecimal total = new BigDecimal(0);
		final List<BigDecimal> prices = setPrices();

		startTime = System.nanoTime();
		//total = getDiscountedTotal(prices);
		endTime = System.nanoTime();
		System.out.println("Discounted Total: " + total);
		System.out.println("  Executed in: " + (endTime - startTime)/1e6);

		startTime = System.nanoTime();
		total = getDiscountedTotalFunctionally(prices);
		endTime = System.nanoTime();
		System.out.println("Discounted Total: " + total);
		System.out.println("  Executed in: " + (endTime - startTime)/1e6);

		startTime = System.nanoTime();
		//total = getDiscountedTotalFunctionallyAndParallized(prices);
		endTime = System.nanoTime();
		System.out.println("Discounted Total: " + total);
		System.out.println("  Executed in: " + (endTime - startTime)/1e6);

		System.out.println("\nTotal Array Size: " + prices.size());
		//System.out.println("Data: ");
		//prices.stream()
		//	.forEach(System.out::println);

	}
	private static List<BigDecimal> setPrices(){
		/*return Arrays.asList(
			new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
			new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
			new BigDecimal("45"), new BigDecimal("12"));
		*/
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		for(int i=0; i<25000000;i++){
			list.add(new BigDecimal((int)(Math.random() * 100)));
		}
		return list;
		
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
	private static BigDecimal getDiscountedTotalFunctionallyAndParallized(List<BigDecimal>prices){
		return prices.parallelStream()
				.filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
				.map(price -> price.multiply(BigDecimal.valueOf(0.9)))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}