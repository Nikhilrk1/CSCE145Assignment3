//Copyright Nikhil Krishna 2024
/**
 * Order class stores information about Products and how many are included in an
 * Order instance.
 */	
import java.util.ArrayList;

public class Order{

	private double stateTax;
	private double federalTax;
	private double shipping;
	private ArrayList <Product> productList;
	private ArrayList<Integer> countList;


	/**
	 * Default Order constructor
	 * 
	 * Initializes any arrays or ArrayLists required, as well as tax and shipping
	 * info. The ShoppingCart class is expected to build instances of Order, so there
	 * is no need to provide further constructors.
	 */
	public Order () {
		this.productList = new ArrayList<>();
		this.countList = new ArrayList<>();
	}
	/**
	 * The addProduct method is called once per Product instance. Expected to
	 * be used by ShoppingCart, it will not be called until the final Order
	 * instance is ready to be returned.
	 * 
	 * You do not need to check for previously existing instances of the Product.
	 * Assume ShoppingCart will ensure this is used correctly.
	 * 
	 * @param product Description of product(s) added to Order instance
	 * @param count  Number of products represented in instance.
	 */
	public void addProduct (Product product , int count) {
		productList.add(product);
		countList.add(count);
	}
	/**
	 * Mutator for state tax.
	 * 
	 * @param stateTax Must be greater than 0.
	 */
	public void setStateTax (double stateTax){
		this.stateTax = stateTax;
	}
	/**
	 * Mutator for federal tax.
	 * 
	 * @param federalTax Must be greater than 0.
	 */
	public void setFederalTax ( double federalTax) {
		this.federalTax = federalTax;
	}
	/**
	 * Mutator for shipping costs.
	 * 
	 * @param shipping Must be greater than 0.
	 */
	public void setShipping (double shipping) {
		this.shipping = shipping;
	}
	/**
	 * The completeOrder method returns a final order with all calculations as a
	 * string. An example is:
	 *
	 Product List
		0001064960, "Phone Charger", $7.99	7
		0268435712, Marshmallows, $17.50	2
		0536879104, "Breath Mints", $1.25	1
	 Order Summary
		Product Total:	$92.18
		State Tax: 	$2.77
		Federal Tax:	$8.55
		Shipping:	$12.75
		Order Total:	$116.24
	 *
	 * Note, that is the string
	 * "Product List"
	 * Then, one per line,
	 *   A tab character "\t", A Product, A tab character "\t", Product Count
	 *   without commas. Followed by the string
	 *   "Order Summary"
	 * 
	 * A tab character "\t", The string "Product Total:", A tab character "\t",
	 *   The product total as a floating point rounded to two decimal places and
	 *   a dollar sign "$"
	 * 
	 * A tab character "\t", The string "Shipping:", A tab character "\t", The
	 *   shipping information as a floating point rounded to two decimal places and
	 *   a dollar sign "$"
	 *   
	 * If they exist,
	 *   A tab character "\t", The tax string, A tab character "\t", The shipping
	 *     information as a floating point rounded to two decimal places and a dollar
	 *     sign "$"
	 * 
	 * A tab character "\t", The string "Order Total:", A tab character "\t",
	 *   The order total as a floating point rounded to two decimal places and
	 *   a dollar sign "$"
	 *   
	 * @return The string described above.
	 */
	public String completeOrder (){

		String order = "Product List\n";
		double preTaxTotal = 0.0;
		for (int i =0 ; i < productList.size(); ++i) {
			Product product = productList.get(i);
			int count = countList.get(i);
			double productTotal = product.price() * count;
			preTaxTotal = preTaxTotal + productTotal;

			order += "\t" + product + "\t" + count + "\n"; 
		}
		double appliedStateTax = preTaxTotal * this.stateTax;
		double appliedFederalTax = preTaxTotal * this.federalTax;
		double finalCost = preTaxTotal + appliedStateTax + appliedFederalTax + this.shipping;

		order += "Order Summary\n" + "\tProduct Total:\t" + "$" + String.format("%.2f",preTaxTotal);
		if (appliedStateTax > 0) {
			order += "\n\tState Tax:\t$" + String.format("%.2f",appliedStateTax);
		}
		if (appliedFederalTax > 0) {
			order += "\n\tFederal Tax:\t$" + String.format("%.2f",appliedFederalTax);
		}
		order += "\n\tShipping:\t$" + String.format("%.2f", this.shipping) + "\n\tOrder Total:\t$" + String.format("%.2f", finalCost);
		return order;
	}

}