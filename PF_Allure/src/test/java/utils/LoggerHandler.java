package utils;

import org.apache.log4j.Logger;

public class LoggerHandler {

	static Logger logger = Logger.getLogger(LoggerHandler.class);

	// debug
	public static void debug(String logMessage) {
		logger.debug(logMessage);
	}

	// info
	public static void info(String logMessage) {
		logger.info(logMessage);
	}

	// warn
	public static void warn(String logMessage) {
		logger.warn(logMessage);
	}

	// error
	public static void error(String logMessage) {
		logger.error(logMessage);
	}

	// fatal
	public static void fatal(String logMessage) {
		logger.fatal(logMessage);
	}

}
