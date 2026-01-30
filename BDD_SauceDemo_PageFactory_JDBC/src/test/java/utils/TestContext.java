package utils;

public class TestContext {

	private static String user;
	private static String orderId;

	public static void setUser(String username) {
		user = username;
	}

	public static String getUser() {
		return user;
	}

	public static void setOrderId(String id) {
		orderId = id;
	}

	public static String getOrderId() {
		return orderId;
	}
}
