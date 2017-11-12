package com.mtag.cwahlmann.hello.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Test5ParameterizedValueSource {
	
	@ParameterizedTest
	@ValueSource(strings = {"ene", "mene", "muh"})
	void test(String argument) {}
}
