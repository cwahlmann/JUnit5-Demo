package com.mtag.cwahlmann.hello.junit5;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Test8ParameterizedMethodSource {

	// ------------------- with one parameter --
	
	static Stream<String> test1Provider() {
	    return Stream.of("foo", "bar");
	}

	@ParameterizedTest
	@MethodSource("test1Provider")
	void test1(String s) {
	    assertNotNull(s);
	}
	
	// ------------------- with two parameters --
	
	static Stream<Arguments> test2Provider() {
	    return Stream.of(Arguments.of("foo", 1), Arguments.of("bar", 2));
	}

	@ParameterizedTest
	@MethodSource("test2Provider")
	void test2(String first, int second) {
	    assertNotNull(first);
	    assertNotEquals(0, second);
	}

}