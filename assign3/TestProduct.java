// Copyright CSCE145H FA24
//


public class TestProduct extends TestBase {

	public static void main(String[] args) {
		System.out.println("Testing Product Class");
		final int TOTAL = 3;
		
		int count = 0;
		System.out.println("Test 1");
		count += testConstructor() ? 1 : 0;
		System.out.println("\nTest 2");
		count += testEquals() ? 1 : 0;
		System.out.println("\nTest 3");
		count += testToString() ? 1 : 0;
		
		System.out.printf("\nPASSED %d of %d TESTS.\n", count, TOTAL);
	}


	public static boolean testConstructor() {
		boolean passed = true;
		
		for (int i = 0; i < PRODUCT_IDS.length; ++i) {
			System.out.print("Testing Product("
					+ PRODUCT_IDS[i] + ", "
					+ PRODUCT_NAMES[i] + ", "
					+ PRODUCT_PRICES[i] + ")");
			
			Product testProduct = new Product(PRODUCT_IDS[i], PRODUCT_NAMES[i], PRODUCT_PRICES[i]);
			System.out.printf("  Expected: %d, %s, %f\n",
					PRODUCT_IDS[i], PRODUCT_NAMES[i], PRODUCT_PRICES[i]);
			System.out.printf("  Actual: %d, %s, %f\n",
					testProduct.id(), testProduct.name(), testProduct.price());
			
			if (PRODUCT_IDS[i] == testProduct.id()
					&& PRODUCT_NAMES[i] == testProduct.name()
					&& PRODUCT_PRICES[i] == testProduct.price()) {
				System.out.println("    PASSED");
			} else {
				passed = false;
				System.out.println("    FAILED");
			}
		}
		
		return passed;
	}

	
	private static boolean testEquals() {
		boolean passed = true;
		
		System.out.print("TESTING Product(");
		System.out.print(PRODUCT_IDS[0] + ", ");
		System.out.print(PRODUCT_NAMES[0] + ", ");
		System.out.print(PRODUCT_PRICES[0] + ")");
		System.out.print(" == Product(");
		System.out.print(PRODUCT_IDS[1] + ", ");
		System.out.print(PRODUCT_NAMES[1] + ", ");
		System.out.println(PRODUCT_PRICES[1] + ")");
		
		Product testLeft = new Product(PRODUCT_IDS[0], PRODUCT_NAMES[0], PRODUCT_PRICES[0]);
		Product testRight = new Product(PRODUCT_IDS[1], PRODUCT_NAMES[1], PRODUCT_PRICES[1]);
		System.out.println("  Expected: false");
		System.out.println("  Actual: " + testLeft.equals(testRight));
		if (testLeft.equals(testRight)) {
			System.out.println("    FAILED");
			passed = false;
		} else {
			System.out.println("    PASSED");
		}
		
		System.out.print("Testing Product(");
		System.out.print(PRODUCT_IDS[0] + ", ");
		System.out.print(PRODUCT_NAMES[0] + ", ");
		System.out.print(PRODUCT_PRICES[0] + ")");
		System.out.print(" == Product(");
		System.out.print(PRODUCT_IDS[0] + ", ");
		System.out.print(PRODUCT_NAMES[1] + ", ");
		System.out.println(PRODUCT_PRICES[1] + ")");
		
		testRight = new Product(PRODUCT_IDS[0], PRODUCT_NAMES[1], PRODUCT_PRICES[1]);
		System.out.println("  Expected: true");
		System.out.println("  Actual: " + testLeft.equals(testRight));
		if (!testLeft.equals(testRight)) {
			System.out.println("    FAILED");
			passed = false;
		} else {
			System.out.println("    PASSED");
		}
		
		return passed;
	}


	public static boolean testToString() {
		boolean passed = true;
		
		for (int i = 0; i < PRODUCT_IDS.length; ++i) {
			System.out.print("Testing Product(");
			System.out.print(PRODUCT_IDS[i] + ", ");
			System.out.print(PRODUCT_NAMES[i] + ", ");
			System.out.println(PRODUCT_PRICES[i] + ").toString()");
			
			Product testProduct = new Product(PRODUCT_IDS[i], PRODUCT_NAMES[i], PRODUCT_PRICES[i]);
			System.out.println("  Expected: " + PRODUCT_TO_STRINGS[i]);
			System.out.println("  Actual: " + testProduct.toString());
			
			if (PRODUCT_TO_STRINGS[i].equals(testProduct.toString())) {
				System.out.println("    PASSED");
			} else {
				passed = false;
				System.out.println("    FAILED");
			}
		}
		
		return passed;
	}
}
