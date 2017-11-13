package com.mtag.cwahlmann.hello.junit5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

public class Test04AssertAllVsDynamic {

	@Test
	void test1() {
		assertAll("lots of tests", //
				() -> assertEquals(1, 1), //
				() -> assertEquals("joe", "joe"), //
				() -> assertNotNull("Ich bin keine Null!", "null"), //
				() -> assertNotNull("Ich bin doch eine Null :(", null)//
		);
	}
	
	@TestFactory
	Stream<DynamicTest> test2() {
		return Arrays.stream(new DynamicTest[] { //
				dynamicTest("eins", () -> assertTrue(true)), //
				dynamicTest("zwei", () -> assertFalse(true)), //
				dynamicTest("drei", () -> assertNull(null)) //
		});
	}
}
