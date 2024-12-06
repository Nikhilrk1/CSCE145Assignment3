//Copyright Nikhil Krishna 2024
/**
 * The Product class stores information about a purchasable item in an
 * online shopping application. It contains information identifying,
 * naming, and providing a price for some item.
 */
public class Product{
	private int id;
	private String name;
	private double price;

	/**
	 * 
	 * @param id : product id >= 0
	 * @param name : must not be empty
	 * @param price : must be > 0.0
	 */
	public Product (int id , String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;

	}
	/**
	 * id accessor
	 * 
	 * @return product id as integer
	 */
	public int id() {
		return this.id;
	}
	/**
	 * name accessor
	 * 
	 * @return product name as as String
	 */
	public String name() {
		return this.name;
	}
	/**
	 * price accessor
	 * 
	 * @return product price as double
	 */
	public double price() {
		return this.price;
	}
	/**
	 * Method equals(Product rhs), where equality is determined solely by
	 * equal ids. That is, if two products have different ids, they are 
	 * not equal.
	 * 
	 * @param rhs The right-hand-side of this == rhs
	 * @return True when the id of two products are equal.
	 */
	public boolean equals ( Product rhs) {
		return this.id == rhs.id;
	}
	/**
	 * When rendering a Product instance as a string, use the following rules:
	 *  1. If an instance name contains a space character, it must be surrounded by
	 *     double quotes, e.g. Cellphone charger -> "Cellphone charger"
	 *  2. Each attribute must be printed in order: id, name, price. They are delimited
	 *     by a single comma (,) followed by a space with nothing at the end.
	 *  3. The id must always be 10 characters wide and use 0s to left-pad if less than 10,
	 *     e.g., 1234 -> 0000001234
	 *  4. The price must be rounded to two decimal places, representing cents, and be
	 *     preceded by a dollar sign ($), e.g. 5.705 -> $5.71
	 */
	public String toString() {
		String finalName = this.name;
		String output ="";
		if (this.name.contains(" ")) {
			finalName = "\"" + this.name + "\"";
		}
		output = String.format("%010d", this.id) + ", " + finalName + ", $" + String.format("%.2f", Math.round(this.price *100.0)/100.0);
		return output;
	}

}