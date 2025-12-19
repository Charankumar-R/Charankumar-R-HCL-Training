package LogDemo;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoggingTest {
	static Logger log = Logger.getLogger(LoggingTest.class);
  @Test
  public void testLogs() {
	  int empNo = 100321;
	  log.debug("The value of empNo: " + empNo);
	  log.info("Menu is clicked");
	  log.warn("First name field is showing warning");
	  log.error("Login failure for invalid crendentials");
	  log.fatal("Internal Server Error, Website is not Displayed");
  }
}
