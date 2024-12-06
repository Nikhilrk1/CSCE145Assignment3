// Copyright CSCE145H FA24
//


public class TestShoppingCart extends TestBase {

	public static void main(String[] args) {
		System.out.println("TESTING ShoppingCart CLASS");
		final int TOTAL = 4;
		final boolean PRINT_OUTCOME = true;
		
		int count = 0;

		count += testAddProduct(PRINT_OUTCOME) ? 1 : 0;
		System.out.println();
		count += testBuildOrder(PRINT_OUTCOME) ? 1 : 0;
		System.out.println();
		count += testRemoveProduct(PRINT_OUTCOME) ? 1 : 0;
		System.out.println();
		count += testDeleteProduct(PRINT_OUTCOME) ? 1 : 0;
		System.out.println();
		
		System.out.printf("PASSED %d OF %d TESTS.\n", count, TOTAL);
	}
	
	
	private static boolean testAddProduct(boolean printOutcome) {
		ShoppingCart.reset(0.0, 0.0, 0.0);
		System.out.println("TEST 1: ShoppingCart.addProduct METHOD");
		boolean passed = true;
		Product[] products = buildProducts(printOutcome);
		
		for (int i = 0; i < products.length; ++i) {
			for (int ii = 0; ii < PRODUCT_COUNTS[i]; ++ii) {
				ShoppingCart.addProduct(products[i]);	
			}
		}
		
		String[] contents = ShoppingCart.getContents().split("\n");
		int found = 0;
		for (int i = 0; i < ADD_PRODUCT_CONTENTS.length; ++i) {
			for (int ii = 0; ii < contents.length; ++ii) {
				if (ADD_PRODUCT_CONTENTS[i].equals(contents[ii])) {
					++found;
					break;
				}
			}
			System.out.println("  ShoppingCart.getContents() CONTAINS "
					+ ADD_PRODUCT_CONTENTS[i]);
			System.out.println("  EXPECTED: true, ACTUAL: " + (found > i));
		}
		
		System.out.println(found == ADD_PRODUCT_CONTENTS.length ? "PASSED" : "FAILED");
		
		return passed;
	}


	private static boolean testRemoveProduct(boolean printOutcome) {
		ShoppingCart.reset(0.0, 0.0, 0.0);
		System.out.println("TEST 3: ShoppingCart.removeProduct METHOD");
		boolean passed = true;
		Product[] products = buildProducts(printOutcome);
		
		for (int i = 0; i < products.length; ++i) {
			for (int ii = 0; ii < PRODUCT_COUNTS[i]; ++ii) {
				ShoppingCart.addProduct(products[i]);	
			}
		}
		
		// remove contents from above
		for (int i = 0; i < products.length; ++i) {
			for (int ii = 0; ii < PRODUCT_REMOVES[i]; ++ii) {
				System.out.println("  REMOVING: " + products[i]);
				ShoppingCart.removeProduct(products[i]);	
			}
		}
		
		String[] contents = ShoppingCart.getContents().split("\n");
		int found = 0;
		for (int i = 0; i < REMOVE_PRODUCT_CONTENTS.length; ++i) {
			for (int ii = 0; ii < contents.length; ++ii) {
				if (REMOVE_PRODUCT_CONTENTS[i].equals(contents[ii])) {
					++found;
					break;
				}
			}
			System.out.println("  ShoppingCart.getContents() CONTAINS "
					+ REMOVE_PRODUCT_CONTENTS[i]);
			System.out.println("  EXPECTED: true, ACTUAL: " + (found > i));
		}
		
		System.out.println(found == REMOVE_PRODUCT_CONTENTS.length ? "PASSED" : "FAILED");
		
		return passed;
	}

	
	private static boolean testDeleteProduct(boolean printOutcome) {
		ShoppingCart.reset(0.0, 0.0, 0.0);
		System.out.println("TEST 4: ShoppingCart.deleteProduct METHOD");
		boolean passed = true;
		Product[] products = buildProducts(printOutcome);
		
		for (int i = 0; i < products.length; ++i) {
			for (int ii = 0; ii < PRODUCT_COUNTS[i]; ++ii) {
				ShoppingCart.addProduct(products[i]);	
			}
		}
		
		// remove contents from above
		for (int i = 0; i < PRODUCT_DELETES.length; ++i) {
			System.out.println("  DELETING: " + products[PRODUCT_DELETES[i]]);
			ShoppingCart.deleteProduct(products[PRODUCT_DELETES[i]]);	
		}
		
		String[] contents = ShoppingCart.getContents().split("\n");
		int found = 0;
		for (int i = 0; i < DELETE_PRODUCT_CONTENTS.length; ++i) {
			for (int ii = 0; ii < contents.length; ++ii) {
				if (DELETE_PRODUCT_CONTENTS[i].equals(contents[ii])) {
					++found;
					break;
				}
			}
			System.out.println("  ShoppingCart.getContents() CONTAINS "
					+ DELETE_PRODUCT_CONTENTS[i]);
			System.out.println("  EXPECTED: true, ACTUAL: " + (found > i));
		}
		
		System.out.println(found == DELETE_PRODUCT_CONTENTS.length ? "PASSED" : "FAILED");
		return passed;
	}


	private static boolean testBuildOrder(boolean printOutcome) {
		ShoppingCart.reset(SHIPPING, FEDERAL_TAX, STATE_TAX);
		System.out.println("TEST 2, ShoppingCart.build");
		boolean passed = true;
		
		Product[] products = buildProducts(printOutcome);		
		for (int i = 0; i < products.length; ++i) {
			for (int ii = 0; ii < PRODUCT_COUNTS[i]; ++ii) {
				ShoppingCart.addProduct(products[i]);	
			}
		}
		Order testOrder = ShoppingCart.buildOrder();
		
		System.out.println("EXPECTED:");
		System.out.println(COMPLETE_ORDER_ALL);
		System.out.println("ACTUAL:");
		System.out.println(testOrder.completeOrder());
		
		// okay. this is bad. in my defense, this was the last test I wrote and it was here
		// i realized exactly how annoying to test this would be, don't judge me!
		String[] expected = COMPLETE_ORDER_ALL.split("\n");
		String[] actual = testOrder.completeOrder().split("\n");
		boolean equals = true;
		for (String expected_line : expected) {
			boolean found = false;
			for (String actual_line : actual) {
				if (expected_line.equals(actual_line)) {
					found = true;
					break;
				}
			}
			if (!found) {
				equals = false;
				break;
			}
		}
		System.out.println(equals ? "  PASSED" : "  FAILED");
		
		return passed && equals;
	}
}
