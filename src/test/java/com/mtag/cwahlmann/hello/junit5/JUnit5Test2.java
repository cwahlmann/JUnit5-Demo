package com.mtag.cwahlmann.hello.junit5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class JUnit5Test2 {
	
	@Test
	void test1() {}
	
	@Nested
	class Set1 {
		@Test void test1() {}
		@Test void test2() {}
		@Test void test3() {}
	}

	@Test
	void test2() {}

	@Nested
	class Set2 {
		@Test void test1() {}
		@Test void test2() {}
		@Test void test3() {}
	}
}
