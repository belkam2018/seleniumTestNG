package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;


public class Log4jDemo {

	

	private static	Logger logger = LogManager.getLogger(Log4jDemo.class);
		

		public static void main(String[] args) {
			
			System.out.println("\n  Hello World...!   \n");
			
			logger.trace("This is the trace message");
			logger.info("This is information message");
			logger.error("This is an error message");
			logger.warn("This is an warning message");
			logger.fatal("This is an fatal message");

			System.out.println("\n  Completed");


		}
		
		
	}

