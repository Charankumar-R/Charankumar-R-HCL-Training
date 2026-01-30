package utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

public class DBUtils {

	private static Connection connection;
	private static final Logger log = Logger.getLogger(DBUtils.class);

	public static void connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/automation_db";
			String user = "root";
			String password = "Charan@10";

			connection = DriverManager.getConnection(url, user, password);
			log.info("DB connected");
		} catch (Exception e) {
			throw new RuntimeException("DB Connection Failed", e);
		}
	}

	public static Map<String, String> getRowAsMap(String query) {
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

			if (rs.next()) {
				ResultSetMetaData meta = rs.getMetaData();
				Map<String, String> row = new HashMap<>();

				for (int i = 1; i <= meta.getColumnCount(); i++) {
					row.put(meta.getColumnName(i), rs.getString(i));
				}
				return row;
			}
		} catch (Exception e) {
			log.error("DB fetch failed", e);
		}
		return null;
	}

	public static void executeUpdate(String query) {
		try (Statement stmt = connection.createStatement()) {
			stmt.executeUpdate(query);
		} catch (Exception e) {
			throw new RuntimeException("DB Update Failed", e);
		}
	}

	public static void close() {
		try {
			if (connection != null)
				connection.close();
		} catch (Exception ignored) {
		}
	}

	public static String getSingleValue(String query, String column) {
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

			if (rs.next()) {
				return rs.getString(column);
			}
		} catch (Exception e) {
			Logger.getLogger(DBUtils.class).error("DB query failed", e);
		}
		return null;
	}

}
