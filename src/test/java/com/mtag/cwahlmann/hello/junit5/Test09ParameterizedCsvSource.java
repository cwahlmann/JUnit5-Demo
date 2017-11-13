package com.mtag.cwahlmann.hello.junit5;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class Test09ParameterizedCsvSource {
	
	@ParameterizedTest
	@CsvSource({ "foo, 1", "bar, 2", "'grieve, good', 3" })
	void test1(String first, int second) {
	    assertNotNull(first);
	    assertNotEquals(0, second);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "testParameterized.csv")
	void test2(String first, int second) {
	    assertNotNull(first);
	    assertNotEquals(0, second);
	}
}
