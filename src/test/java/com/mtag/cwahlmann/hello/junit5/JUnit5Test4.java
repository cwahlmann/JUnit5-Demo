package com.mtag.cwahlmann.hello.junit5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnit5Test4 {

	
	
	
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

	
	
	
	
	
	@ParameterizedTest
	@ValueSource(strings = {"ene", "mene", "muh"})
	void test3(String argument) {}

	
	
	
	
	
	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void test4(String argument) {}
	
	static class MyArgumentsProvider implements ArgumentsProvider {
		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
			return Stream.of("foo", "bar").map(Arguments::of);
		}
	}

	
	
	
	
	
	@ParameterizedTest
	@EnumSource(value = TimeUnit.class)
	void test5(TimeUnit timeUnit) {
	    assertTrue(EnumSet.allOf(TimeUnit.class).contains(timeUnit));
	}	

	
	
	
	
	
	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
	void test6(TimeUnit timeUnit) {
	    assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
	}	

	
	
	
	
	
	@ParameterizedTest
	@MethodSource("test7Provider")
	void test7(String argument) {
	    assertNotNull(argument);
	}

	static Stream<String> test7Provider() {
	    return Stream.of("foo", "bar");
	}

	
	
	
	
	
	@ParameterizedTest
	@MethodSource("test8Provider")
	void test8(String first, int second) {
	    assertNotNull(first);
	    assertNotEquals(0, second);
	}

	static Stream<Arguments> test8Provider() {
	    return Stream.of(Arguments.of("foo", 1), Arguments.of("bar", 2));
	}

	
	
	
	
	
	@ParameterizedTest
	@CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
	void test9(String first, int second) {
	    assertNotNull(first);
	    assertNotEquals(0, second);
	}

	
	
	
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "test10.csv")
	void test10(String first, int second) {
	    assertNotNull(first);
	    assertNotEquals(0, second);
	}
}
