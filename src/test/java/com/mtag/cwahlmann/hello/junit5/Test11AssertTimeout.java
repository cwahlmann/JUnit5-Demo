package com.mtag.cwahlmann.hello.junit5;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Test11AssertTimeout {
	private static final Logger log = LoggerFactory.getLogger(Test11AssertTimeout.class);
	
	@Test
	void test1() {
		assertTimeout(Duration.ofMillis(500), () -> {
			log.info(() -> "execution within test1 started");
			Thread.sleep(1000);
			log.info(() -> "execution within test1 FINISHED");
		});
	}

	@Test
	void test2() {
		assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
			log.info(() -> "execution within test2 started");
			Thread.sleep(1000);
			// the thread will never reach this line
			log.info(() -> "execution within test2 FINISHED");
		});
	}
}
