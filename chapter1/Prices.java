import java.util.*;
import java.math.*;
//Tasks:
//Suppose we’re asked to total the prices greater than $20, discounted by 
//10%. Let’s do that in the habitual Java way first.
		

public class Prices{
	public static void main(String... args){
		final List<BigDecimal> prices = setPrices();
		BigDecimal total = getDiscountedTotal(prices);
		System.out.println("Discounted Total: " + total);

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
}