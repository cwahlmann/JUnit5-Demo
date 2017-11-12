package com.mtag.cwahlmann.hello.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;

import com.mtag.cwahlmann.hello.junit5.extension.LoggingExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(LoggingExtension.class)
public class Test10Extension {
	private Logger logger = null;

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	@BeforeAll
	void setupAll() {
		logger.info(() -> "------------- SETUP FOR ALL TESTS --"); 
	}

	@BeforeEach
	void setupEach() {
		logger.info(() -> "------------- SETUP FOR EACH TEST --"); 
	}

	@Test public void test1() {};
	@Test public void test2() {};
	@Test public void test3() {};
	
	@AfterEach
	public void cleanupEach() {
		logger.info(() -> "------------- CLEANUP AFTER EACH TEST --" );
	}

	@AfterAll
	public void cleanupAll() {
		logger.info(() -> "------------- CLEANUP AFTER ALL TESTS --" );
	}
}
