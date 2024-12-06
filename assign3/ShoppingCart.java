//Copyright Nikhil Krishna 2024

import java.util.ArrayList;

/**
 * The ShoppingCart class is a purely static class with both static methods and
 * attributes. The class needs to store a collection of Products and corresponding
 * counts. I would recommend using two ArrayLists, one ArrayList<Product> and one
 * ArrayList<Integer>. Note that you can treat Integers and ints as nearly identical, e.g.
 * int i = new Integer(0);
 * Integer j = 0;
 */
public  class ShoppingCart{
	private static double stateTax;
	private static double federalTax;
	private static double shipping;
	private static ArrayList <Product> productList;
	private static ArrayList<Integer> countList;
	private Order order;
	/**
	 * The reset method initializes or clears any lists maintained and sets or
	 * resets any shipping or taxes. Assume this is always called once before building
	 * a new Order by adding/removing/deleting product instances.
	 * 
	 * @param shipping Value assigned as a shipping fees; must be >= 0.0
	 * @param federalTax Value assigned as any federal taxes; must be >= 0.0
	 * @param stateTax Value assigned as any state taxes; must be >= 0.0
	 */
	public static void reset (double shipping, double federalTax, double stateTax){
		productList = new ArrayList<>();
		countList = new ArrayList<>();
		ShoppingCart.shipping = shipping;
		ShoppingCart.stateTax = stateTax;
		ShoppingCart.federalTax = federalTax;

	}
	/**
	 * Method addProduct accepts a Product instance.
	 * 
	 * If the added Product instance does not yet exist in the shopping cart, method makes a copy of the
	 * instance and sets count to 1.
	 * 
	 * If the added Product instance exists, method increases count by 1.
	 * 
	 * @param product
	 */
	public static void addProduct (Product product){
		for (int i = 0 ; i < productList.size(); ++i) {
			if (productList.get(i).equals(product)) {
				countList.set(i, countList.get(i)+1);
				return;
			}				
		}
		productList.add(product);
		countList.add(1);
	}
	/**
	 * The buildOrder method creates an order from the present state of the
	 * ShoppingCart's lists.
	 * 
	 * This method creates a new Order instance, populates its attributes using
	 * the stored shipping and tax information, and adds all Products currently
	 * represented by the ShoppingCart's storage.
	 * 
	 * @return A complete Order instance, ready to be completed, presumably on
	 *         customer input.
	 */
	public static Order buildOrder(){
		Order order = new Order();
		order.setShipping(shipping);
		order.setStateTax(stateTax);
		order.setFederalTax(federalTax);
		for (int i =0 ; i < productList.size(); ++i){
			order.addProduct(productList.get(i),countList.get(i));
		}
		return order;
	}
	/**
	 * The getContents method is essentially a toString method for a static class
	 * 
	 * Build the string by creating a list of product ids and counts as follows:
	 * 
	 * <<product id>> : <<product count>>
	 * 
	 * In this string, product id is, again, a 10 digit number, left-padded with
	 * 0s if less than 10 digits. Product count is a 4 digit number without padding. The
	 * two values are separated by " : ". 
	 * 
	 * @return The string described above.
	 */
	public static String getContents() {
		String contents = "";
		for ( int i = 0; i < productList.size(); ++i) {
			if (i == productList.size() - 1 ) {
				contents += String.format("%010d", productList.get(i).id()) + " : " + String.format("%4d",countList.get(i));
			}
			else{
				contents += String.format("%010d", productList.get(i).id()) + " : " + String.format("%4d",countList.get(i)) + "\n";
			}
		}
		return contents;
	}
	/**
	 * The removeProduct method decrements the count of, or removes the
	 * Product parameter.
	 * 
	 * If the Product instance does not exist in the list, the method
	 * does nothing.
	 * 
	 * If the Product instance exists in the list and count is greater than
	 * 1, decrements count.
	 * 
	 * If the Product instance exists in the list and count is 1, removes
	 * the instance and count from lists.
	 * 
	 * @param product
	 */
	public static void removeProduct (Product product){
		for (int i = 0; i < productList.size(); ++i) {
			if (productList.get(i).equals(product)) {
				if (countList.get(i) > 1) {
					countList.set(i, countList.get(i)-1);
				}
				else {
					productList.remove(i);
					countList.remove(i);
				}
				return;
			}
		}
	}
	/**
	 * The deleteProduct method removes all instances of the product
	 * parameter.
	 * 
	 * If the product parameter is found in the list, it and its count
	 * are removed.
	 * 
	 * @param product
	 */
	public static void deleteProduct(Product product){
		for (int i = productList.size()-1; i >= 0; i--) {
			if (productList.get(i).equals(product)) {
				productList.remove(i);
				countList.remove(i);
			}
		}
	}
}
