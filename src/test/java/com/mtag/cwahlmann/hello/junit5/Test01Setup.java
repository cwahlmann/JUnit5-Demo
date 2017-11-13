package com.mtag.cwahlmann.hello.junit5;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

@TestInstance(Lifecycle.PER_CLASS)
class Test01Setup {
	private final static Logger log = LoggerFactory.getLogger(Test01Setup.class);

	Pojo pojo;
	Pojo pojo2;

	@BeforeAll
	void setupClass() {
		pojo = new Pojo(0);
		pojo2 = new Pojo(200);
	}

	@BeforeEach
	void setupTest() {
		pojo.setValue(100);
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 2 })
	public void test(int argument) {
		assertEquals(100, pojo.getValue(), "pojo must be 100");
		assertEquals(200 + argument, pojo2.getValue(), 
				"pojo2 must be " + (200 + argument));
		pojo.inc();
		pojo2.inc();
	}

	@Disabled
	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 2 })
	public void ignoredTest(int argument) {
		fail("This test should be disabled." );
	}

	@AfterAll
	public void cleanup() {
		log.info(() -> "Cleanup after all tests have run." );
		pojo = null;
		pojo2 = null;
	}
}
