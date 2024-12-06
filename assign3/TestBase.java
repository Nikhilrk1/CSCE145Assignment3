// Copyright CSCE145H FA24
//


public class TestBase {
	protected static final int[] PRODUCT_IDS = {
			(2 << 13) + (2 << 19),
			(2 << 27) + (2 << 7),
			(2 << 12) + (2 << 28)
	};
	protected static final String[] PRODUCT_NAMES = {
			"Phone Charger",
			"Marshmallows",
			"Breath Mints"
	};
	protected static final double[] PRODUCT_PRICES = {
			7.99,
			17.50,
			1.25
	};
	
	
	/**
	 * Used to test:
	 *   Product.toString()
	 * For the arrays above
	 */
	protected static final String[] PRODUCT_TO_STRINGS = {
			"0001064960, \"Phone Charger\", $7.99",
			"0268435712, Marshmallows, $17.50",
			"0536879104, \"Breath Mints\", $1.25"
	};

	
	/**
	 * Used to test:
	 *   Order.completeOrder,
	 *   ShoppingCart.addProduct,
	 *   ShoppingCart.removeProduct, and
	 *   ShoppingCart.buildOrder
	 */
	protected static final int[] PRODUCT_COUNTS = { 7, 2, 1 };
	protected static final int[] PRODUCT_REMOVES = { 2, 1, 1 };
	protected static final int[] PRODUCT_DELETES = { 0, 1 };

	
	/**
	 * Used to test:
	 *   Order.completeOrder and
	 *   ShoppingCart.buildOrder
	 */
	protected static final double STATE_TAX = 0.03;
	protected static final double FEDERAL_TAX =  0.09;
	protected static final double SHIPPING = 12.75;
	protected static final String COMPLETE_ORDER = "Product List\n"
			+ "	0001064960, \"Phone Charger\", $7.99	7\n"
			+ "	0268435712, Marshmallows, $17.50	2\n"
			+ "	0536879104, \"Breath Mints\", $1.25	1\n"
			+ "Order Summary\n"
			+ "	Product Total:	$92.18\n"
			+ "	Shipping:	$0.00\n"
			+ "	Order Total:	$92.18";
	protected static final String COMPLETE_ORDER_STATE = "Product List\n"
			+ "	0001064960, \"Phone Charger\", $7.99	7\n"
			+ "	0268435712, Marshmallows, $17.50	2\n"
			+ "	0536879104, \"Breath Mints\", $1.25	1\n"
			+ "Order Summary\n"
			+ "	Product Total:	$92.18\n"
			+ "	State Tax:	$2.77\n"
			+ "	Shipping:	$0.00\n"
			+ "	Order Total:	$94.95";
	protected static final String COMPLETE_ORDER_FEDERAL = "Product List\n"
			+ "	0001064960, \"Phone Charger\", $7.99	7\n"
			+ "	0268435712, Marshmallows, $17.50	2\n"
			+ "	0536879104, \"Breath Mints\", $1.25	1\n"
			+ "Order Summary\n"
			+ "	Product Total:	$92.18\n"
			+ "	Federal Tax:	$8.30\n"
			+ "	Shipping:	$0.00\n"
			+ "	Order Total:	$100.48";
	protected static final String COMPLETE_ORDER_SHIPPING = "Product List\n"
			+ "	0001064960, \"Phone Charger\", $7.99	7\n"
			+ "	0268435712, Marshmallows, $17.50	2\n"
			+ "	0536879104, \"Breath Mints\", $1.25	1\n"
			+ "Order Summary\n"
			+ "	Product Total:	$92.18\n"
			+ "	Shipping:	$12.75\n"
			+ "	Order Total:	$104.93";
	protected static final String COMPLETE_ORDER_ALL = "Product List\n"
			+ "	0001064960, \"Phone Charger\", $7.99	7\n"
			+ "	0268435712, Marshmallows, $17.50	2\n"
			+ "	0536879104, \"Breath Mints\", $1.25	1\n"
			+ "Order Summary\n"
			+ "	Product Total:	$92.18\n"
			+ "	State Tax:	$2.77\n"
			+ "	Federal Tax:	$8.30\n"
			+ "	Shipping:	$12.75\n"
			+ "	Order Total:	$115.99";

	/**
	 * Used to test:
	 *   ShoppingCart.addProduct,
	 *   ShoppingCart.removeProduct, and
	 *   ShoppingCart.deleteProduct
	 */
	protected static final String[] ADD_PRODUCT_CONTENTS = {
			"0001064960 :    7",
			"0268435712 :    2",
			"0536879104 :    1"
	};
	protected static final String[] REMOVE_PRODUCT_CONTENTS = {
			"0001064960 :    5",
			"0268435712 :    1"
	};
	protected static final String[] DELETE_PRODUCT_CONTENTS = {
			"0536879104 :    1"
	};
	
	/**
	 * Used by all tests.
	 * 
	 * Builds an array of Products based on the arrays above.
	 * 
	 * @return An array of the Products in the corresponding arrays above.
	 */
	protected static Product[] buildProducts(boolean printProducts) {
		Product[] products = new Product[PRODUCT_IDS.length];
		
		for (int i = 0; i < PRODUCT_IDS.length; ++i) {
			if (printProducts) {
				System.out.print("  Constructing Product(");
				System.out.print(PRODUCT_IDS[i] + ", ");
				System.out.print(PRODUCT_NAMES[i] + ", ");
				System.out.println(PRODUCT_PRICES[i] + ")");
			}
			
			products[i] = new Product(PRODUCT_IDS[i], PRODUCT_NAMES[i], PRODUCT_PRICES[i]);
		}
		
		return products;
	}
	
	/**
	 * Used in testing:
	 *   Order.completeOrder and
	 *   ShoppingCart.buildOrder
	 * 
	 * @return An Order instance with Products and counts loaded.
	 */
	protected static Order buildOrder(boolean printProducts) {
		Product[] products = buildProducts(printProducts);
		Order order = new Order();
		
		for (int i = 0; i < products.length; ++i) {
			order.addProduct(products[i], PRODUCT_COUNTS[i]);
		}
		
		return order;
	}
}