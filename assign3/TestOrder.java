// Copyright CSCE145H FA24
//
import java.util.ArrayList;

public class TestOrder extends TestBase {
	
	public static void main(String[] args) {
		System.out.println("TESTING Order CLASS");
		final int TOTAL = 5;
		final boolean printOutcome = true;
		
		int count = 0;
		count += testCompleteOrder(printOutcome) ? 1 : 0;
		System.out.println();

		count += testCompleteOrderState(printOutcome) ? 1 : 0;
		System.out.println();

		count += testCompleteOrderFed(printOutcome) ? 1 : 0;
		System.out.println();

		count += testCompleteOrderShip(printOutcome) ? 1 : 0;
		System.out.println();

		count += testCompleteOrderAll(printOutcome) ? 1 : 0;
		System.out.println();
		
		System.out.printf("PASSED %d of %d TESTS.\n", count, TOTAL);
	}
	
	public static boolean testCompleteOrder(boolean printOutcome) {
		System.out.println("TEST 1: Order.completeOrder() METHOD");
		boolean passed = true;
		Order testOrder = buildOrder(printOutcome);
		String order = testOrder.completeOrder();
		
		if (printOutcome) {
			System.out.println("EXPECTED:");
			System.out.println(COMPLETE_ORDER);
			System.out.println("ACTUAL:");
			System.out.println(order);
		}
		
		if (order.equals(COMPLETE_ORDER)) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
			passed = false;
		}
		
		return passed;
	}
	
	public static boolean testCompleteOrderState(boolean printOutcome) {
		System.out.println("TEST 2: Order.completeOrder() METHOD WITH STATE TAX");
		boolean passed = true;
		Order testOrder = buildOrder(printOutcome);
		testOrder.setStateTax(STATE_TAX);
		String order = testOrder.completeOrder();
		
		if (printOutcome) {
			System.out.println("EXPECTED:");
			System.out.println(COMPLETE_ORDER_STATE);
			System.out.println("ACTUAL:");
			System.out.println(order);
		}
		
		if (order.equals(COMPLETE_ORDER_STATE)) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
			passed = false;
		}
		
		return passed;
	}
	
	public static boolean testCompleteOrderFed(boolean printOutcome) {
		System.out.println("TEST 3: Order.completeOrder() METHOD WITH FEDERAL TAX");
		boolean passed = true;
		Order testOrder = buildOrder(printOutcome);
		testOrder.setFederalTax(FEDERAL_TAX);
		String order = testOrder.completeOrder();
		
		if (printOutcome) {
			System.out.println("EXPECTED:");
			System.out.println(COMPLETE_ORDER_FEDERAL);
			System.out.println("ACTUAL:");
			System.out.println(order);
		}
		
		if (order.equals(COMPLETE_ORDER_FEDERAL)) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
			passed = false;
		}
		
		return passed;
	}
	
	public static boolean testCompleteOrderShip(boolean printOutcome) {
		System.out.println("TEST 4: Order.completeOrder() METHOD WITH SHIPPING");
		boolean passed = true;
		Order testOrder = buildOrder(printOutcome);
		testOrder.setShipping(SHIPPING);
		String order = testOrder.completeOrder();
		
		if (printOutcome) {
			System.out.println("EXPECTED:");
			System.out.println(COMPLETE_ORDER_SHIPPING);
			System.out.println("ACTUAL:");
			System.out.println(order);
		}
		
		if (order.equals(COMPLETE_ORDER_SHIPPING)) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
			passed = false;
		}
		
		return passed;
	}
	
	public static boolean testCompleteOrderAll(boolean printOutcome) {
		System.out.println("TEST 5: Order.completeOrder() METHOD WITH ALL FEES");
		boolean passed = true;
		Order testOrder = buildOrder(printOutcome);
		testOrder.setFederalTax(FEDERAL_TAX);
		testOrder.setShipping(SHIPPING);
		testOrder.setStateTax(STATE_TAX);
		String order = testOrder.completeOrder();
		
		if (printOutcome) {
			System.out.println("EXPECTED:");
			System.out.println(COMPLETE_ORDER_ALL);
			System.out.println("ACTUAL:");
			System.out.println(order);
		}
		
		if (order.equals(COMPLETE_ORDER_ALL)) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
			passed = false;
		}
		
		return passed;
	}
}
