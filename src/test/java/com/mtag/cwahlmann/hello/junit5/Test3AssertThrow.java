package com.mtag.cwahlmann.hello.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Test3AssertThrow {

	@Test
	void test1() {
		IOException exception = assertThrows(IOException.class, () -> {
			throw new IOException("another message");
		});
		assertEquals("my message", exception.getMessage(), 
				"wrong IOException message");
	}

	@Test
	void test2() {
		assertThrows(IOException.class, () -> {
			throw new NullPointerException();
		}, () -> "wrong exception type");
	}

}
